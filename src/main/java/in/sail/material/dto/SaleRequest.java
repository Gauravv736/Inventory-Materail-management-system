package in.sail.material.dto;

import jakarta.validation.constraints.*;


public class SaleRequest {
	@NotNull(message = "Product ID cannot be null")
private Long productId;
@Min(value = 1, message = "Quantity must be at least 1")
private int qty;
@NotBlank(message = "Party name is required")
private String partyName;
public SaleRequest() {
	
}

public Long getProductId() {
	return productId;
}
public void setProductId(Long productId) {
	this.productId = productId;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public String getPartyName() {
	return partyName;
}
public void setPartyName(String partyName) {
	this.partyName = partyName;
}


}
