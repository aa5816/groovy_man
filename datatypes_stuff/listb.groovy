List myList = [1, 2, 3]
assert myList.size() == 3
assert myList[0] == 1
assert myList instanceof ArrayList
List emptyList = []
assert emptyList.size() == 0
List longList = (0..1000).toList()
assert longList[555] == 555

List explicitList = new ArrayList()
explicitList.addAll(myList)                     //Fills from myList
assert explicitList.size() == 3
explicitList[0] = 10
assert explicitList[0] == 10

explicitList = new LinkedList(myList)
assert explicitList.size() == 3
explicitList[0] = 10
assert explicitList[0] == 10

myList = ['a','b','c','d','e','f']
assert myList[0..2] == ['a','b','c']   //getAt(Range)

assert myList[0,2,4] == ['a','c','e'] //getAt(collection of indexes)

myList[0..2] = ['x','y','z'] //putAt(Range)
assert myList == ['x','y','z','d','e','f']


myList[3..5] = []        //Removing elements
assert myList == ['x','y','z']

myList[1..1] = [0, 1, 2]   //Adding elements
assert myList == ['x', 0, 1, 2, 'z']

myList = []

myList += 'a'   //plus(Object)
assert myList == ['a']

myList += ['b','c']  //plus(Collection)
assert myList == ['a','b','c']

myList = []
myList << 'a' << 'b'  //leftShift is like append
assert myList == ['a','b']

assert myList - ['b'] == ['a']   //minus(Collection)

assert myList * 2 == ['a','b','a','b']  //Multiply

myList = ['a', 'b', 'c']

assert myList.isCase('a')
assert 'b' in myList

def candidate = 'c'
switch(candidate){
case myList : assert true; break  //Classifies by containment
default: assert false
}

assert ['x','a','z'].grep(myList) == ['a']     //Intersection filter

myList = []          //Empty lists are false
if (myList) assert false
// Lists can be iterated with a 'for' loop
def expr = ''

for (i in [1,'*',5]){  //Iterates over a list
expr += i
} 
assert expr == '1*5'

