package in.sail.material.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.sail.material.Entity.Sale;
import in.sail.material.Service.SaleService;
import in.sail.material.dto.SaleRequest;

@RestController
@RequestMapping("/sales")
public class SaleController {
	@Autowired
	private SaleService saleService;
	@GetMapping
public List<Sale> getAllSales(){
	return saleService.getAllSales();
}
	@PostMapping
	public String sellProduct(@RequestBody SaleRequest request) {
	     saleService.sellProducts(request);
	     return "Product sold Successfully";
	}
}
