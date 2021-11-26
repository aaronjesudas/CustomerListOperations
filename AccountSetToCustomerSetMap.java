import java.util.List;

public class AccountSetToCustomerSetMap {

	private List<String> accountSet;
	private List<String> customerSet;
	public List<String> getAccountSet() {
		return accountSet;
	}
	public void setAccountSet(List<String> accountSet) {
		this.accountSet = accountSet;
	}
	public List<String> getCustomerSet() {
		return customerSet;
	}
	public void setCustomerSet(List<String> customerSet) {
		this.customerSet = customerSet;
	}
	public AccountSetToCustomerSetMap(List<String> accountSet, List<String> customerSet) {
		super();
		this.accountSet = accountSet;
		this.customerSet = customerSet;
	}
}
