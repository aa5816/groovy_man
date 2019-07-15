println "The world needs more closures "

def add = {x,y -> return x+y}
def sub = {x=6,y -> return x-y} //using default value for the parameters
assert add(4,3) == 7
assert add.call (5,2) == 7  //calling closures with .call ()
assert sub(4,3) ==1
assert sub(3) ==3

//passing closures as method arguments
def int bench (int t,Closure guy)
{ def start = System.nanoTime ()
  t.times {guy (it)}
  def stop = System.nanoTime ()
  return stop-start
 }
def slow = bench (10000) {(int) it/2 } 
def fast = bench (10000,{it.intdiv (2)}) //calling the method with different closures
assert fast*2 <= slow  //it works most of the time

//using other methods provided by groovy.lang.Closure
def numb (Closure cl)
{ cl.getMaximumNumberOfParameters () } //gives the number of parameters passed to the closure
def typein (Closure cl)
{ cl.getParameterTypes ()} //gives the type of the parameters passed to the closure

assert numb {one ->} ==1
assert numb {one,two ->} ==2
assert typein {String s ->} == [String]
assert typein {int a,Date d ->} ==[int,Date]

// do you have curry ?
def multi = {x,y -> return x*y}
def tmult = multi.curry(2) //fixing x to 2
assert tmult (5) == 10

// one curry to rule them all
def conf = { form,filt,line -> filt(line) ? form(line) : null }
def app = {config,append,line -> def out= config (line)
                                 if (out) append(out) }

def dateit = {line -> "${new Date ()}: $line" }
def debch = {line -> line.contains ("debug") }
def appco = {line -> println line}

myconf = conf.curry (dateit,debch)
mylog = app.curry (myconf,appco)

mylog ("why put debug in a line")
mylog ("why can we not print this")

// some maths nostalgia in calling inner closures from outer closures
def twoTimes=tmult
def fourTimes = twoTimes >> twoTimes
def eightTimes = twoTimes << fourTimes 
assert eightTimes(1) == twoTimes(fourTimes(1))

//caching your results with memoize ()
def fib //you cant use fib without defining it first
fib = {it<2 ? 1 : fib (it -1) + fib(it-2) }
fib = fib.memoize ()  //without this statement fib will take 20 sec to compute
assert fib(40) == 165_580_141

//avoiding stack overflows with trampolines
def last 
last = { it.size() == 1 ? it.head() : last.trampoline(it.tail()) } 
last = last.trampoline() 
//Without trampoline, the code goes into a stack overflow before 2,000 iterations. 
assert last(0..10_000) == 10_000

//closure objects and isCase method
def odd = {it %2 ==1}
assert [1,2,3].grep (odd) == [1,3]
switch (10)
{ case odd : assert false }
if (2 in odd) assert false
