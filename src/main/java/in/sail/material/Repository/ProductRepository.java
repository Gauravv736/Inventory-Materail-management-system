package in.sail.material.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sail.material.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
