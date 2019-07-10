assert (0..10).contains(0)               //Inclusive ranges 
assert (0..10).contains(5)
assert (0..10).contains(10)
assert (0..10).contains(-1) == false
assert (0..10).contains(11) == false

assert (0..<10).contains(9)                //Half-exclusive ranges
assert (0..<10).contains(10) == false

def a = 0..10                          //References to ranges
assert a instanceof Range
assert a.contains(5)

a = new IntRange(0,10)           //Explicit construction
assert a.contains(5)

assert (0.0..1.0).contains(1.0)      //Bounds checking
assert (0.0..1.0).containsWithinBounds(0.5)

def today = new Date()               //Date ranges
def yesterday = today - 1
assert (yesterday..today).size() == 2

assert ('a'..'c').contains('b')  //String ranges


def log = ''                    //for-in-range loop
for (element in 5..9){
log += element
}
assert log == '56789'


log = ''                       //Loop with reverse range
for (element in 9..5){
log += element
}
assert log == '98765'


log = ''                        //Half-exclusive, reverse, each with closure
(9..<5).each { element ->
log += element
}
assert log == '9876'