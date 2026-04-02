package in.sail.material.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sail.material.Entity.Sale;
import in.sail.material.Service.SaleService;
import in.sail.material.dto.SaleRequest;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/sales")
@Tag(name = "Sales", description = "Endpoints for managing product sales and stock reduction")

public class SaleController {
	@Autowired
	private SaleService saleService;
	@GetMapping
public List<Sale> getAllSales(){
	return saleService.getAllSales();
}
	@PostMapping
	@Operation(summary = "Sell a product", description = "Deducts quantity from inventory bays and creates a sale record")
	public String sellProduct(@Valid @RequestBody SaleRequest request) {
	     saleService.sellProducts(request);
	     return "Product sold Successfully";
	}
}
