import groovy.transform.Immutable

@Immutable class FixedBook {
String title
}

//Positional constructor.
def gina= new FixedBook('Groovy in Action')

//Named-arg constructor.
def regina = new FixedBook(title:'Groovy in Action')

assert gina.title == 'Groovy in Action'
assert gina == regina

//Standard equals().Not allowed!
try {
gina.title = "Oops!"
assert false, "should not reach here"
} catch (ReadOnlyPropertyException expected) {
println "Expected Error: '$expected.message'"
}
