package in.sail.material.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;


@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String locationBayString;
	private int qty;
	@ManyToOne
	private Product product;
	
	public Inventory() {}
	public Inventory(Long id, String locationBayString, int qty, Product product) {
		super();
		this.id = id;
		this.locationBayString = locationBayString;
		this.qty = qty;
		this.product = product;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocationBayString() {
		return locationBayString;
	}
	public void setLocationBayString(String locationBayString) {
		this.locationBayString = locationBayString;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	

}
