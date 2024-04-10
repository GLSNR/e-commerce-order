Use Case:
=>Placing Order on Ecommerce Website and testing with postman
* Consider we are having order entity(orderTracking, shoppingCart, totalQuantity, totalPrice, dateCreated, updatedDate)and Payment entity(type, cardNumber, cardName, 
  expiryMonth, expiryYear, Cvv).
* Now, Whenever we place the order the order details and payment details will store in the database.
* Due to some reasons(like: bank server issue, incorrect card details..) the payment may fail for this order. For this order details are saved in the database but the 
  payment details will not store in the in the database.
* Even though the payment is failed but we are sotring the data in the database well it does not make sens for keeping the data in the database. which is data 
  inconsistency.
  Note: We have to store the order and payment details in the database. If any operation fails, then we have to revert all the order data from the database. Inorder to 
  deal with the issue we have to use Transaction.
  With the help of transaction we can manage data inconsistency.

==========================================================================

  Example JSON Format to test:
  {
    "order": {
	    "totalQuantity":1,
	    "totalPrice":1000,
        "shoppingCartId":3
    },
    "payment":{
        "type":"DEBIT",
	    "cardName":"Nagaraju",
	    "cardNumber":"1234 5678 8907",
	    "expYear":2030,
	    "cvv":111
    }
}

=============================================================================
