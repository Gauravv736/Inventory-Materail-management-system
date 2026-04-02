package in.sail.material.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String productName;
private double rate;
private int totalQty;
private double totalValue;

private LocalDate arrivalDate;


public Product() {
	super();
	// TODO Auto-generated constructor stub
}
public Product(Long id, String productName, double rate, int totalQty, double totalValue) {
	super();
	this.id = id;
	this.productName = productName;
	this.rate = rate;
	this.totalQty = totalQty;
	this.totalValue = totalValue;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public double getRate() {
	return rate;
}
public void setRate(double rate) {
	this.rate = rate;
}
public int getTotalQty() {
	return totalQty;
}
public void setTotalQty(int totalQty) {
	this.totalQty = totalQty;
}
public double getTotalValue() {
	return totalValue;
}
public void setTotalValue(double totalValue) {
	this.totalValue = totalValue;
}

}
