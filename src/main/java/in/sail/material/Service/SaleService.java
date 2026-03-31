package in.sail.material.Service;

import java.lang.System.Logger;
import java.util.List;
import java.util.function.LongToDoubleFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sail.material.Entity.Inventory;
import in.sail.material.Entity.Product;
import in.sail.material.Entity.Sale;
import in.sail.material.Repository.InventoryRepository;
import in.sail.material.Repository.ProductRepository;
import in.sail.material.Repository.SaleRepository;
import in.sail.material.dto.SaleRequest;
import jakarta.transaction.Transactional;

@Service
public class SaleService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private SaleRepository saleRepository;

	@Transactional
	public Sale sellProducts(SaleRequest request) {
		
		Long productId =request.getProductId();
		int qty = request.getQty();
		String party = request.getPartyName();
		
		Product product = productRepository.findById(productId).orElseThrow();
		List<Inventory> inventories = inventoryRepository.findByProduct(product);
		int remaining = qty;
		
		for (Inventory inventory : inventories) {
			if (remaining <= 0) break;
			int stock = inventory.getQty();
			if (stock>=remaining) {
				inventory.setQty(stock - remaining);
				remaining =0;
				
			}
			else {
				remaining = remaining -stock;
				inventory.setQty(0);
			}
			inventoryRepository.save(inventory);
		}
		product.setTotalQty(product.getTotalQty()- qty);
		productRepository.save(product);
		
		Sale sale = new Sale();
		sale.setPartyName(party);
		sale.setProduct(product);
		sale.setQty(qty);
		sale.setTotalValue(qty * product.getRate());
		return saleRepository.save(sale);

	}

	public List<Sale> getAllSales() {
		return saleRepository.findAll();
		
	}

}
