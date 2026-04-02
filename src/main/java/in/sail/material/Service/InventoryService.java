package in.sail.material.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.sail.material.Entity.AuditLog;
import in.sail.material.Entity.Inventory;
import in.sail.material.Entity.Product;
import in.sail.material.Repository.AuditLogRepositiory;
import in.sail.material.Repository.InventoryRepository;
import in.sail.material.Repository.ProductRepository;
import jakarta.transaction.Transactional;

@Service
public class InventoryService {
	@Autowired
	private InventoryRepository inventoryRepository;
	private ProductRepository productRepository;
	private AuditLogRepositiory auditLogRepositiory;

	public List<Inventory> getAllInventory() {
		// TODO Auto-generated method stub
		return inventoryRepository.findAll();
	}

	public List<Inventory> getInventoryById(String prodBay) {
		// TODO
		return inventoryRepository.findByLocationBayString(prodBay);
	}

	public List<Inventory> getInventoryByProductAndLocation(String productName, String bay) {
		// TODO Auto-generated method stub
		return inventoryRepository.findByProductProductNameAndLocationBayString(productName, bay);
	}
	@Transactional
	public Inventory addStock(long productId, String locationBay,int qty) {
		
		
		Product product =productRepository.findById(productId).orElseThrow(()-> new RuntimeException("product not found with the ID "+productId));
		List<Inventory> existInventories = inventoryRepository.findByProductAndLocationBayString(product, locationBay);
		Inventory inventory;
		if (!existInventories.isEmpty()) {
			inventory = existInventories.get(0);
			inventory.setQty(inventory.getQty() + qty);
		} else {
		
			inventory = new Inventory();
			inventory.setProduct(product);
			inventory.setLocationBayString(locationBay);
			inventory.setQty(qty);
		}

		inventory.setArrivalDate(null);
		
		product.setTotalQty(product.getTotalQty() + qty);
		product.setTotalValue(product.getTotalQty() * product.getRate()); 

		inventoryRepository.save(inventory);
		productRepository.save(product);
	 AuditLog auditLog = new AuditLog("STOCK_ADDED",product.getProductName(),locationBay,qty,inventory.getQty());
	 auditLogRepositiory.save(auditLog);
	 
		

		return inventory;
	 
}
}