import static java.util.Calendar.*

def me = 'Tarzan'
def you = 'Jane'
def line = "me $me - you $you"    //Abbreviated dollar syntax
assert line == 'me Tarzan - you Jane'
assert line instanceof GString

TimeZone.default = TimeZone.getTimeZone('GMT')
def date = new Date(0)
def dateMap = [y:date[YEAR]-1900, m:date[MONTH], d:date[DAY_OF_MONTH]]
def out = "Year $dateMap.y Month $dateMap.m Day $dateMap.d"  //Extended dot syntax
assert out == 'Year 70 Month 0 Day 1'

def tz = TimeZone.getTimeZone('GMT')
def format = 'd MMM YYYY HH:mm:SS z'
out = "Date is ${date.format(format, tz)} !" //full syntax with braces
assert out == 'Date is 1 Jan 1970 00:00:00 GMT !'

//Multiline GStrings
def sql = """       
SELECT FROM MyTable
WHERE Year = $dateMap.y
"""
println sql

out = "my 0.02\$"  // Escaped dollar sign
assert out == 'my 0.02$'