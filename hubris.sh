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