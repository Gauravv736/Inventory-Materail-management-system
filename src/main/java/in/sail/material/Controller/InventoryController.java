package in.sail.material.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.sail.material.Entity.Inventory;
import in.sail.material.Repository.InventoryRepository;
import in.sail.material.Service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;
@GetMapping
public List<Inventory> getAllInventory(){
	return inventoryService.getAllInventory();

			
}
@GetMapping("/bay/{prodBay}")
public List<Inventory> getInventoryById(@PathVariable String prodBay) {
	return inventoryService.getInventoryById(prodBay);
}

@GetMapping("/search")
public List<Inventory> getInventoryByProductAndLocaiton(@RequestParam String productName,@RequestParam String bay) {
    return inventoryService.getInventoryByProductAndLocation(productName,bay);
}

}
