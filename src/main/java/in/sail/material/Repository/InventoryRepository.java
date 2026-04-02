package in.sail.material.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sail.material.Entity.Inventory;
import in.sail.material.Entity.Product;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{


	List<Inventory> findByProduct(Product product);
	List<Inventory> findByLocationBayString(String locationBay);
	List<Inventory> findByProductProductNameAndLocationBayString(String productName, String Bay);
	List<Inventory> findByProductAndLocationBayString(Product product, String locationBay);

}
