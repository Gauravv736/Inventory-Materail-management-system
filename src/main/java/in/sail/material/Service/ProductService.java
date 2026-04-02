package in.sail.material.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sail.material.Entity.Product;
import in.sail.material.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	 //Product product;

	public List<Product> getAllproducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
		
	}

	public Optional<Product> getProductById(Long proId) {
		// TODO Auto-generated method stub
		return productRepository.findById(proId);
	}

	public Product updateProduct(long proId, Product updateProduct) {
		Product product  = productRepository.findById(proId).orElseThrow();
		product.setProductName(updateProduct.getProductName());
		product.setRate(updateProduct.getRate());
		product.setTotalQty(updateProduct.getTotalQty());
		product.setTotalValue(updateProduct.getTotalValue());
		return productRepository.save(product);
	}

}
