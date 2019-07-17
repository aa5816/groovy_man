println "we maybe classes apart"

//basic stuff
class Counter 
{ public count = 0
} 
def counter = new Counter()
counter.count = 1 
assert counter.count == 1 
def fieldName = 'count'
counter[fieldName] = 2 
assert counter['count'] == 2
//////////////////////////////////////////////////////////////////////////////////////////
//overriding get and set methods
class PretendFieldCounter 
{ public count = 0

Object get (String name) //does something if a non existent variable is called upon 
{ return 'pretend value'
}
void set (String name, Object value) //does something if a non existent variables value is set
{ count++
} 
} 
def pretender = new PretendFieldCounter()
assert pretender.isNoField == 'pretend value' //get called
assert pretender.count == 0 
pretender.isNoFieldEither = 'just to increase counter' //set called
assert pretender.count == 1
//overriding the get method means to override the dot-fieldname operator 
//overriding the set method overrides the field-assignment operator

//////////////////////////////////////////////////////////////////////////////////////////

//methods and parameters
class ClassWithUntypedMethods {
static void main (args) { //public is omitted because its default, viod can also be omitted
def some = new ClassWithUntypedMethods ()
some.publicVoidMethod ()
assert 'hi' == some.publicUntypedMehod ()
assert 'huka hi' == some.publicTypedMethod ()
combinedMethod ()
}
void publicVoidMethod () {}
def publicUntypedMethod () {return 'hi' }
String publicTypedMethod () { return 'huka hi' }
private static final void combinedMethod () {}
} 
//////////////////////////////////////////////////////////////////////////////////////////////

//missing parameters type
class ClassWithBoth {
static main(args) {
assert 'unt' == method (1)
assert 'ty' == method ('waht')
assert 'two args' == method(1,2)
}
static method (arg) {
return 'unt' }

static method (String arg) {
return 'ty' }

static method (arg1, Number arg2) { //both explicit and omitted parameter types
return 'two args' }
}
//////////////////////////////////////////////////////////////////////////////////////////////

//advanced parameter usage
class Summer 
{ 
def sumWithDefaults(a, b, c=0) //Explicit arguments b and default value
{ return a + b + c}
 
def sumWithList(List args)
{ return args.inject(0){sum,i -> sum += i} //Defines arguments as list
}

def SumWithOptionals (a,b,Object[] optionals)  //Optional arguments as an array
{ return (a+b+ sumWithList (optionals.toList ()))
}

def SumNamed (Map args) { //defines arguments as a map
['a','b','c'].each {aegs.get (it,0)}
return args.a +args.b +args.c }
}

def summer = new Summer ()

assert 2 == summer.sumWithDefaults(1,1)  //limited by number of arguments
assert 3 == summer.sumWithDefaults(1,1,1)

assert 2 == summer.sumWithList([1,1])  //limited to the case when arguments with same 
assert 3 == summer.sumWithList([1,1,1]) //meaning will be used

//assert 2 == summer.sumWithOptionals(1,1) 
//assert 3 == summer.sumWithOptionals(1,1,1)

//assert 2 == summer.sumNamed([a:1, b:1]) //better way than the rest and even gives default 
//assert 3 == summer.sumNamed([a:1, b:1, c:1]) //values to arguments with no value 
//assert 1 == summer.sumNamed([c:1])
/////////////////////////////////////////////////////////////////////////////////////////////

//safe dreferencing

def map = [a:[b:[c:1]]] 
assert map.a.b.c == 1
if (map && map.a && map.a.x) //protects with if , short-circuit evaluation
{ assert map.a.x.c == null
} 
try 
{ assert map.a.x.c == null  //protects with try-catch 
} catch (NullPointerException ignore){ }

assert map?.a?.x?.c == null //safe dereferncing with ?. operator does job of if and try
                            // in one line
///////////////////////////////////////////////////////////////////////////////////////////

//explicit constructors with positional parameters
class VendorWithCtor 
{ String name, product
VendorWithCtor(name,product) 
{ this.name = name 
this.product = product
} 
}
def first = new VendorWithCtor('Canoo','ULC') //normal use 
def second = ['Canoo','ULC'] as VendorWithCtor //forced type coercion
VendorWithCtor third = ['Canoo','ULC'] //implicit type coercion
///////////////////////////////////////////////////////////////////////////////////////////
 
//implicit constructors with named parameters
class SimpleVendor 
{ String name, product
}
new SimpleVendor() 
new SimpleVendor(name: 'Canoo') 
new SimpleVendor(product: 'ULC') 
new SimpleVendor(name: 'Canoo', product: 'ULC')
def vendor = new SimpleVendor(name: 'Canoo') 
assert 'Canoo' == vendor.name
///////////////////////////////////////////////////////////////////////////////////////////