import java.util.List;

public class CustomerAccMapping {
	String customerId;
	List<String> accountIds;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public List<String> getAccountIds() {
		return accountIds;
	}
	public void setAccountIds(List<String> accountIds) {
		this.accountIds = accountIds;
	}
	public CustomerAccMapping(String customerId, List<String> accountIds) {
		super();
		this.customerId = customerId;
		this.accountIds = accountIds;
	}
}
