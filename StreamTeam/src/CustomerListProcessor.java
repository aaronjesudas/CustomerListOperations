import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerListProcessor {
	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<Customer>();		
		customers.add(new Customer("1", "101"));
		customers.add(new Customer("2", "103"));
		customers.add(new Customer("3", "106"));
		customers.add(new Customer("2", "101"));
		customers.add(new Customer("1", "103"));
		customers.add(new Customer("5", "105"));
		customers.add(new Customer("7", "106")); 
		customers.add(new Customer("9", "106"));
		
		//added a few more to test all scenarios
		customers.add(new Customer("10", "200"));
		customers.add(new Customer("10", "201"));
		customers.add(new Customer("10", "202"));
		
		//customer account map is a class which holds the customer ID and a list of all accounts held by that customer
		List<CustomerAccMapping> customerAccountMap  = new ArrayList<CustomerAccMapping>();
		
		//Dynamic filter to avoid double comparison A -> B and B -> A, the filter will dynamically remove already processed items in each cycle
		List<String> alreadyCheckedCustomers = new ArrayList<String>();
		customers.stream().filter( x -> (!alreadyCheckedCustomers.contains(x.getCustomerId())))
					.forEach(customer -> {  //filter is dynamically updated here
											alreadyCheckedCustomers.add(customer.getCustomerId());
											customerAccountMap.add(new CustomerAccMapping(
					
																	customer.getCustomerId(), 
																	(customers.stream()
																			.filter(x -> x.getCustomerId().equals(customer.getCustomerId()))
																			.map(y -> y.getAccountId())
																			.collect(Collectors.toList()))
																	));
					});
		//at this point we have the transformed data structure
		/*
		 * 1 -> {101, 103}, 2 -> {103, 101}, 3 -> {106}, 5 -> {105}, 7 -> {106}, 9 -> {106}
		 */
		
		//Final data structure which will show the mapping between a set of account number and set of customers who are using those set of accounts
		List<AccountSetToCustomerSetMap> accSetToCusSetMap = new ArrayList<AccountSetToCustomerSetMap>();
		
		//Dynamic filter to avoid double comparison A -> B and B -> A, the filter will dynamically remove already processed items in each cycle
		List<String> alreadyCheckedAccounts = new ArrayList<String>();
		
		customerAccountMap.stream().filter( x -> (!alreadyCheckedAccounts.contains(x.customerId)))
							.forEach(cusMap -> {  List<String> listOfMatchingCustomers = customerAccountMap.stream()
																	.filter(x -> x.getAccountIds().containsAll(cusMap.getAccountIds()))
																	.map(z -> z.getCustomerId())
																	.collect(Collectors.toList());
													//Filter is dynamically updated here
													alreadyCheckedAccounts.addAll(listOfMatchingCustomers);
													accSetToCusSetMap.add(new AccountSetToCustomerSetMap(cusMap.getAccountIds(), listOfMatchingCustomers));
												}
								);
		
		//Eliminating the entries with only one customer to one account mapping.
		accSetToCusSetMap.stream().filter(x -> x.getCustomerSet().size() > 1).forEach( y -> System.out.println("These customers : "+y.getCustomerSet()+", share these accounts : "+y.getAccountSet()));
		return;
	}
}
