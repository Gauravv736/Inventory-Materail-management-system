package in.sail.material.dto;

public class InventoryRequest {

	private long productId;
	private String locationBay;
	private int qty;
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getLocationBay() {
		return locationBay;
	}
	public void setLocationBay(String locationBay) {
		this.locationBay = locationBay;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
}
