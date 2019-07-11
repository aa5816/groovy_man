println "this day must not be forgotten"

assert "abc" == /abc/
assert "\\d" == /\d/
def ref = "something a miss"
assert ref== /$ref/

def patm = "she sells sea shells at the sea shore of seychelles"
assert patm =~ /s.a/  //dot means any character between s and a

def finder = (patm =~ /s.a/)     //you can put a pattern inside a bracket
assert finder instanceof java.util.regex.Matcher

assert patm ==~ /(\w+ \w+)*/  //ensuring pattern only contains words delimited by a space

def word = /\w+/
def mat = (patm ==~ /($word $word)*/)
assert mat instanceof java.lang.Boolean

assert !(patm ==~ /s.e/) //match matches the whole string unlike find

def patmx = patm.replaceAll(word,'x')
assert patmx == "x x x x x x x x x x"

def words = patm.split(/ /) //splits the string at every occurrence of space
assert words.size() == 10
assert words[0] == "she"

def rym = "The rain in Spain stays mainly in the plain!"

def worde = /\w*ain/
def rhy = /\b$worde\b/
def found =""
rym.eachMatch(rhy) {match -> found+= match + " "}
assert found == "rain Spain plain "

found =""
(rym =~ rhy).each {match -> found+= match + " "}
assert found == "rain Spain plain "

def bl = rym.replaceAll(rhy) {it-"ain"+"___"}
assert  bl == "The r___ in Sp___ stays mainly in the pl___!"
//println bl

def (a,b,c) = "a b c" =~ /\S/
assert a== "a"
assert b == "b"
assert c == "c"

def matcher = "a:1 b:2 c:3" =~ /(\S+):(\S+)/
/*for (i in 0..2){
    for (j in 0..2)
    {print (matcher[i][j]+" ")}
    println (" ") }
*/
assert matcher[0] == ["a:1","a","1"]
matcher.each { full, key, value ->
    assert full.size() == 3
    assert key.size() == 1 // a,b,c
    assert value.size() == 1 // 1,2,3
}

def regex= /\b(\w)\w*\1\b/
def many = 100*1000
start = System.nanoTime()
many.times {patm =~ regex}        // ~string --> pattern operator is faster than normal matches
timei = System.nanoTime() - start
start = System.nanoTime()
patter = ~regex
many.times {patter.matcher (patm)}
timep = System.nanoTime() - start
assert timei > (timep *2)

def fours = ~/\w{4}/
assert fours.isCase("into")
assert "word" in fours
switch ("hola")
{
    case fours: assert true; break
    default: assert false
}
beasts =["bear","tiger","duck"]
assert beasts.grep(fours) == ["bear","duck"]