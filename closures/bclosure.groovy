println "no closure for me in life but a lot of openings"

def log=''
(1..10).each {log+=it}    
//if only one parameter is passed to the closure we don't need to 
//declare it, we can use the implicit parameter 'it'
assert log == '12345678910'
log = ''
(1..10).each({ log += it }) //the closure is the parameter of the method
assert log == '12345678910'

//second way of declaring closures 
//Whenever you see the braces of a closure, think: new Closure(){}
// you can make a method return a closure object
def Closure getp () {
def pri = {line -> println line}
return pri}

//third way of declaring closure is using previously existing methods with
//the help of &. operator
class SizeIn {
int limit
Boolean sizeIt (String val) { return (val.size () <= limit) }
}
SizeIn size6 = new SizeIn(limit:6) //groovy bean constructor calls
SizeIn size5 = new SizeIn(limit:5) 

Closure s6 = size6.&sizeIt

def w = ['willit','long string','panic','iota not']
assert 'willit' == w.find (s6)
assert 'panic' == w.find (size5.&sizeIt)

//though method closure are limited to instance methods
//they provide a feature- runtime overload resolution
//also called multimethods
class MM 
{
int lM (String val) {
return val.size () }

int lM (List l) {
return l.size () }

int lM (int a,int b) {
return a+b }
}
MM ob =new MM()
Closure mult = ob.&lM

assert 10 == mult ('iwantitall')
assert 3 == mult ([1,2,3])
assert 7 == mult (2,5)
