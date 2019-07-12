def manbun = (1..100)
def s=0
for (i in manbun)
s+=i
assert s == 50*101
print "lists man, they irritate me"

def mylist = [1,2,3]
assert mylist.size () == 3
assert mylist[0] == 1
assert mylist instanceof ArrayList

def emp = []
assert emp.size () == 0

def longs = (0..1000).toList ()
assert longs[555] == 555

def expl = new ArrayList ()
expl.addAll (mylist)
assert expl.size () == 3
expl[0] = 10
assert expl[0] == 10

mylist = "abcdef".toList ()
assert mylist[0..2] == ['a','b','c']
assert mylist[0,2,4] == ['a','c','e']

mylist[0..2] = ['x','y','z']
assert mylist == "xyzdef".toList ()
mylist[3..5] = []
assert mylist == "xyz".toList ()
mylist[1..1] = [1,2,3]
assert mylist == ['x',1,2,3,'z']

mylist = []
mylist += 'a'
assert mylist == ['a']

mylist += ['b','v']
assert mylist == ['a','b','v']

mylist = []
mylist << 'a' << 'b'
assert mylist == ['a','b']

assert mylist - ['b'] == ['a']
assert mylist *2 == ['a','b','a','b']

mylist = "abc".toList ()
assert mylist.isCase ('a')
assert 'b' in mylist

def can= 'c'
switch (can)
{ case mylist : assert true; break
   default : assert false 
  }
assert ['x','a','z'].grep(mylist) == ['a']

mylist = []
if (mylist) assert false

def expr=''
for (i in [1,'*',5]) {
expr +=i}
assert expr == '1*5'