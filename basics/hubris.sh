#!/usr/bin/env groovy

//groovy is a scripting language but not just that
 println "  "
 println "are you trying to break me"

assert(true)
assert 1 == 1
def x = 1
assert x == 1
def y = 1; assert y == 1

// << means texttexttexthello

assert ('text'*3 << 'hello').size () == 4 * 3 + 5 

assert '12345' =~ /\d+/ //asserts if they are didgits

assert 'xxxxx' == '12345'.replaceAll(/\d/, 'x') //makes all digits x and sserts it

 x = 1
 y = 2
assert x + y == 3
assert x.plus(y) == 3
assert x instanceof Integer //numbers are not primitive types in groovy but objects of java.lang.Integer

def roman = ['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII'] //creating a list
assert roman[4] == 'IV'
roman[8] = 'VIII' //dynamically increase the size of list
assert roman.size() == 9

def http = [
100 : 'CONTINUE',
200 : 'OK',
400 : 'BAD REQUEST'
]
assert http[200] == 'OK'
http[500] = 'INTERNAL SERVER ERROR'
assert http.size() == 4

def o = 1..10
assert o.contains(5)
assert !o.contains(15)
assert o.size() == 10
assert o.from == 1
assert o.to == 10
assert o.reverse() == 10..1
assert o.contains (10)

[1, 2, 3].each { entry -> println entry } //prints all the elements of the list

//find the number of clinks if a party with 100 guests and everyone clinks glasses with everybody else
def totalClinks = 0
def partyPeople = 100
1.upto(partyPeople) { guestNumber -> clinksWithGuest = guestNumber-1
totalClinks += clinksWithGuest
}
assert totalClinks == (partyPeople * (partyPeople-1)) / 2

//control structures in groovy === basic examples
if (false) assert false //The if as one-liner

if (null)  //null is false, Blocks may start on new line
{
assert false
}
else
{
assert true
}

def i = 0
while (i < 10) {  //Classic while
i++
}
assert i == 10

def clinks = 0 //The for in range
for (remainingGuests in 0..9) {
clinks += remainingGuests
}
assert clinks == (10*9)/2

def list = [0, 1, 2, 3]  //The for in list
for (j in list) {
assert j == list[j]
}

list.each() { item ->    //The each method with a closure
assert item == list[item]
}

switch(3) {                  // basic switch
case 1 : assert false; break
case 3 : assert true; break
default: assert false
}