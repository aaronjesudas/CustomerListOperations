# CustomerListOperations
From a list of customers, finding out set of customers holding same set of accounts

## Logic used
### Transformation Logic
The given list of customer objects are transformed first to a different data structure as follows to prep for further processing.
A seperate datastructure is defined and used to hold this data (CustomerAccMapping.java)
```json
[
  { 1, [ 101, 103 ] }, 
  { 2, [ 103, 101 ] },
  { 3, [ 106 ] },
  { 5, [ 105 ] },
  { 7, [ 106 ] },
  { 9, [ 106 ] }
]
```

Since the customer Ids appear more than onces in the list, there will be multiple cycles processing same customer.
To avoid this, a dynamic filter is used to filter out customers which are already processed.
During every cycle, this list is updated and this dynamic filter is applied on the current processing element in the list.

### Logic To Find set of customers sharing same set of accounts
For each object in the above mapping, the entire list is scanned to identify customers using same set of accounts
Here also there is a possibility of multiple cycles processing the same set of customers in different order
A dynamic filter is applied here as well to avoid duplicate processing.

To hold the above data, another data structure is defined and used (AccountSetToCustomerSetMap.java)
This will present the data in the following format
```json
[
  { [ 1, 2 ], [ 101, 103 ] },
  { [ 3, 7, 9 ], [ 106 ] },
  { [ 105 ], [ 5 ] },
  { [ 10 ], [ 201, 201, 202 ] }
]
```
### Cleansing and Printing
The above data strucutre holds a few objects which with accounts which are not shared by customers.
The last 2 entries have only one customer in the set and hence is not required in the final output data.
These entries are filtered out using count of customers in the customer set inside each object. Any entry with less than 2 customers in the set is eliminated.

## Final Output

The final output is as follows

```
These customers : [1, 2], share these accounts : [101, 103]
These customers : [3, 7, 9], share these accounts : [106]
```
