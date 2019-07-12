assert [1,[2,3]].flatten () == [1,2,3] //dissolves sublists
assert [1,2,3].intersect ([4,3,1]) == [3,1]
assert [1,2,3].disjoint ([4,5,6]) //the intersection of these lists will give an empty list

def list = (1..3).toList ()  //somehow [1..3] doesnot work
assert [1,2,3] ==list
popped = list.pop ()
assert popped == 1
assert list ==[2,3]

assert [1,2].reverse () == [2,1]
assert [3,1,2].sort () == [1,2,3]

list = [ [1,0],[0,1,2]]
list =list.sort {a,b -> a[0] <=> b[0]}
assert list == [[0,1,2],[1,0]]

list = list.sort { item -> item.size ()}
assert list ==  [ [1,0],[0,1,2]]

list = 'abc'.toList ()
list.remove (2)
assert list == "ab".toList ()
list.remove ('b')
assert list == ['a']

list = 'abbc'.toList ()
list.removeAll (['b','c'])
assert list == ['a']

def dou = [1,2,3].collect {item -> item*2}  //thou shall not pass without being multiplied by 2
assert dou == [2,4,6]
def odd = [1,2,3].findAll {item -> item%2==1}
assert odd == [1,3]

def l = (1..7).toList ()
assert l.first () == 1
assert l.head () == 1
assert l.tail () ==[2,3,4,5,6,7]

assert l.last () == 7
assert l.count (3) == 1
assert l.max () == 7
assert l.min () ==1 

def eve = l.find {it%2 ==0}
assert eve == 2

assert l.every {it <8}
assert l.any {it >6}

def store =''
l.each {store+= it}
assert store == '1234567'

store =''
l.eachWithIndex { ite,ind ->store+= "$ind-->$ite "}
assert store == "0-->1 1-->2 2-->3 3-->4 4-->5 5-->6 6-->7 "

assert l.join ('no') == "1no2no3no4no5no6no7"

result = l.inject (0) { c,g -> c+g}
assert result == 0+1+2+3+4+5+6+7  //which is 28
assert l.sum () == 28

fact = l.inject (1) { p,n -> p*n }
assert fact == 1*1*2*3*4*5*6*7 //== 5040

//here's sorting

def qs (l) {
if (l.size () < 2) return l
def pivot = l[l.size().intdiv(2)]
def left = l.findAll {it <pivot}
def middle = l.findAll {it==pivot}
def right = l.findAll {it >pivot}
return qs(left) + middle +qs (right)
}

assert qs ([]) == []
assert qs ([1]) == [1]
assert qs ([1,2]) ==[1,2]
assert qs ([2,1]) == [1,2]
assert qs ([3,1,2,2]) == [1,2,2,3]
assert qs ([1.0f,'a',10,null]) == [null,1.0f,10,'a']
assert qs ('bca') == 'abc'.toList ()

// its url time

def urls = [ new URL('http','myshop.com',80,'index.html'),
             new URL('https','myshop.com',443,'buynow.html'),
             new URL('ftp','myshop.com',21,'downloads') ]

assert urls
      .findAll {it.port <99}
      .collect {it.file.toUpperCase ()}
      .sort ()
      .join (', ') == 'DOWNLOADS, INDEX.HTML'
