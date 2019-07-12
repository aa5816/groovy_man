println "mappy maps map attack"
 
 def mymap =[a:1,b:2,c:3]
 assert mymap instanceof LinkedHashMap
 assert mymap.size () ==3
 assert mymap['a'] ==1
 
 def emp=[:]
 assert emp.size () ==0
 
 def exp =new TreeMap ()
 exp.putAll (mymap)
 assert exp['a'] == 1
 
 def comp = [x:'y',*:mymap]  //spread operator
 assert comp == [x:'y',a:1,b:2,c:3]
 
 def x = 'a' 
 assert ['x':1] == [x:1] 
 assert ['a':1] == [(x):1]
 
 assert mymap.a ==1
 assert mymap.get ('a') == 1
 assert mymap.get ('a',0) ==1
 
 assert mymap.get ('d',0) == 0
 assert mymap.d == 0
 mymap.d =1
 assert mymap.d ==1
 
 mymap =['a.b':1]
 assert mymap.'a.b' ==1
 
 mymap =['a':1,'b':2,'c':3]
 def oth = ['b':2,'c':3,'a':1]
 assert mymap == oth
 assert mymap.containsKey('a')
 assert mymap.containsValue (1)
 assert mymap.entrySet () instanceof Collection
 
 assert mymap.any {it.value>2}
 assert mymap.every {it.key <'d'}
 assert mymap.keySet () == ['a','b','c'] as Set
 assert mymap.values ().toList () == [1,2,3]
 
//Map’s each method uses closures in two ways: passing one parameter into the closure means that 
//it’s an entry, and passing two parameters means it’s a key and a value
 def store =''
 mymap.each {store+=it.key;store+=it.value}
 assert store == 'a1b2c3'
 store =''
 mymap.each {key,value->store+=key;store+=value}
 assert store == 'a1b2c3'
 
 store =''
 for (key in mymap.keySet ()){
 store+=key}
 assert store== "abc"
 
 store =''
 for (value in mymap.values ()){
 store+=value }
 assert store == '123'
 
 mymap.clear ()
 assert mymap.isEmpty ()
 
 mymap = [a:1,b:2,c:3]
 mymap.remove('a')
 assert mymap.size () ==2
 assert [a:1]+[b:2] == [a:1,b:2]
 
 mymap = [a:1,b:2,c:3]
 def abmap = mymap.subMap (['a','b'])
 assert abmap == [a:1,b:2]
 
abmap = mymap.findAll { it.value<3}
assert abmap == [a:1,b:2]

def dou = mymap.collect {it.value *2}
assert dou instanceof List
assert dou.every {it%2==0}

def addto =[]
mymap.collect(addto) {it.value *2}
assert addto instanceof List
assert addto.every {it%2==0}


//text frequency calculator 
def text = 
"""
everytime you die there is nothing insiide
everytime i cry the world comes to life
everytime i want i try to hide
everytime i decide there is something i don't try
"""

def words =text.tokenize ()  //break it down 
def freq =[:]

//for every word it checks if it exists and 
//adds 1 to the value of irts frequency
words.each { w -> freq[w] = freq.get(w,0) +1}  

def wl = freq.keySet ().toList ()
wl.sort {freq [it]} //sorts it by frequency

def stats ="\n"
wl[-1..-5].each { w -> stats += w.padLeft(12)+ ':'  //just for looks
                       stats+= freq[w] +"\n"}     //just the top 5 frequencies displayed
assert stats == """
           i:5
   everytime:4
         try:2
          to:2
          is:2
"""     