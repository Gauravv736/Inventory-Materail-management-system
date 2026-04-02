package in.sail.material.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sail.material.Entity.Product;
import in.sail.material.Service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/products")
@Tag(name = "Products", description = "Master Product Catalog Management")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Operation(summary = "Get all products in the catalog")
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllproducts();
	}

	@PostMapping
	@Operation(summary = "Create a new master product")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@GetMapping("/{proId}")
	public Optional<Product> getProductById(@PathVariable Long proId) {
		return productService.getProductById(proId);
	}

	@PutMapping("/{proId}")

	public Product updateProduct(@PathVariable Long proId, @RequestBody Product updateProduct) {
		return productService.updateProduct(proId, updateProduct);
	}

}
