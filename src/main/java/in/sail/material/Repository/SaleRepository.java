package in.sail.material.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sail.material.Entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
