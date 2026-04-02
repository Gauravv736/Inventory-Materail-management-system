package in.sail.material.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class AuditLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String activity;
	private String productName;
	private String locationBay;
	private int quantityChanged;
    private int stockAfterAction;
    @CreationTimestamp
    private LocalDateTime timeStamp;
    public AuditLog() {}
	public AuditLog( String activity, String productName, String locationBay, int quantityChanged,
			int stockAfterAction) {
		this.activity = activity;
		this.productName = productName;
		this.locationBay = locationBay;
		this.quantityChanged = quantityChanged;
		this.stockAfterAction = stockAfterAction;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getLocationBay() {
		return locationBay;
	}
	public void setLocationBay(String locationBay) {
		this.locationBay = locationBay;
	}
	public int getQuantityChanged() {
		return quantityChanged;
	}
	public void setQuantityChanged(int quantityChanged) {
		this.quantityChanged = quantityChanged;
	}
	public int getStockAfterAction() {
		return stockAfterAction;
	}
	public void setStockAfterAction(int stockAfterAction) {
		this.stockAfterAction = stockAfterAction;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

}
