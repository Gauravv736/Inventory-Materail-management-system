package in.sail.material.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sail.material.Entity.Inventory;
import in.sail.material.Repository.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	private InventoryRepository inventoryRepository;

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

}
