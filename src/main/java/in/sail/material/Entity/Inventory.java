package in.sail.material.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String locationBayString;
	private int qty;
	private LocalDateTime arrivalDate;
	@ManyToOne
	private Product product;
	
	
	public Inventory() {
		// TODO Auto-generated constructor stub
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
	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", locationBayString=" + locationBayString + ", qty=" + qty + ", arrivalDate="
				+ arrivalDate + ", product=" + product + "]";
	}
}
	