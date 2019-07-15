println "loop it from infinity to beyond!"

def store = '' 
for (String s in 'a'..'c') 
store += s 
assert store == 'abc'

store = '' 
for (i in [1, 2, 3]) 
{ store += i
} 
assert store == '123'

def myString = 'Old school Java' 
store = '' 
for (int i=0; i < myString.size(); i++) 
{ store += myString[i]
} 
assert store == myString

myString = 'Java range index' 
store = '' 
for (int i : 0 ..< myString.size()) 
{ store += myString[i]
} 
assert store == myString

myString = 'Groovy range index' 
store = '' 
for (i in 0 ..< myString.size()) 
{ store += myString[i]
} 
assert store == myString

myString = 'Java string Iterable' 
store = '' 
for (String s : myString) 
{ store += s
} 
assert store == myString

myString = 'Groovy iterator' 
store = '' 
for (s in myString) 
{ store += s
} 
assert store == myString
