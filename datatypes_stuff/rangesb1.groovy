class Weekday implements Comparable {
static final DAYS = [
'Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'
]
private int index = 0

Weekday(String day) {       //Allows all values
index = DAYS.indexOf(day)
}

Weekday next() {
return new Weekday(DAYS[(index + 1) % DAYS.size()])
}
Weekday previous() {            //Range bound methods
return new Weekday(DAYS[index - 1]) 
}

int compareTo(Object other) {
return this.index <=> other.index
}
String toString() {
return DAYS[index]
}
}

def mon = new Weekday('Mon')
def fri = new Weekday('Fri')

def worklog = ''                //Working through the week
for (day in mon..fri) {
worklog += day.toString() + ' '
}
assert worklog == 'Mon Tue Wed Thu Fri '