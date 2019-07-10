import groovy.transform.Immutable

@Immutable class Money { //every immutable object automatically gets a value-based implementation of equals   

int amount         //data memebers
String currency

Money plus (Money other) {     //implementing the plus method (+ operator)
if (null == other) return this
if (other.currency != currency) {
throw new IllegalArgumentException("cannot add $other.currency to $currency")
}
return new Money(amount + other.amount, currency)
}
}

Money buck = new Money(1, 'USD')
assert buck
assert buck == new Money(1, 'USD') //Uses overridden ==
assert buck + buck == new Money(2, 'USD') //asserts that our operator is implemented
Money cash = new Money (2, 'INR')
// buck + cash ,this will through an IllegalArgumentException with the message can't add INR TO USD 