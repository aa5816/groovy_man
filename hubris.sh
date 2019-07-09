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