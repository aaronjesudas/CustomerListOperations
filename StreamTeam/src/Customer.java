
public class Customer {

	private String accountId;
	private String customerId;
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public Customer(String customerId, String accountId) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
	}
}
