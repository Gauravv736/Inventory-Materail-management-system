package in.sail.material.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.sail.material.Entity.Inventory;
import in.sail.material.Service.InventoryService;
import in.sail.material.dto.InventoryRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/inventory")
@Tag(name = "Inventory", description = "Stock management across different bays")
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;

	@GetMapping
	public List<Inventory> getAllInventory() {
		return inventoryService.getAllInventory();

	}

	@GetMapping("/bay/{prodBay}")
	public List<Inventory> getInventoryById(@PathVariable String prodBay) {
		return inventoryService.getInventoryById(prodBay);
	}

	@GetMapping("/search")
	public List<Inventory> getInventoryByProductAndLocaiton(@RequestParam String productName,
			@RequestParam String bay) {
		return inventoryService.getInventoryByProductAndLocation(productName, bay);
	}

	@Operation(summary = "Add stock to a bay")
	@PostMapping("/add")
	public Inventory addInventory(@RequestBody InventoryRequest request) {
		if (request.getQty() <= 0) {
			throw new IllegalArgumentException("Quantity to add must be greater than zero.");
		}

		return inventoryService.addStock(request.getProductId(), request.getLocationBay(), request.getQty());

	}
}
