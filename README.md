# CustomerListOperations
From a list of customers, finding out set of customers holding same set of accounts

## Logic used
### Transformation Logic
The given list of customer objects are transformed first to a different data structure as follows
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
To avoid this, a dynamic filter is used to filter out customers which are already used.
During every cycle, this list is updated and the filter is applied on the current processing element in the list.

### Logic To Find set of customers sharing same set of accounts
For each object in the above mapping, the entire list is scanned to identify customers using same set of accounts
Here also there is a possibility of multiple cycles processing the same set of customers in different order
A dynamic filter is applied here as well to avoid duplicate processing.
