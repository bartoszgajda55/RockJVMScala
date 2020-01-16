package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def +(person: Person): String = s"${this.name} is hanging with ${person.name}"
    def unary_! : String = s"$name, what the hell?"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name"
    def apply(times: Int): String = s"$name watched $favouriteMovie $times times"
    def +(filmName: String): Person = new Person(name, filmName, age)
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)

    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala = this learns "Scala"
  }

  val mary = new Person("Mary", "Inception", 20)
  println(mary.likes("Inception"))
  println(mary likes "Inception") // Infix notation

  val tom = new Person("Tom", "Fight Club", 20)
  println(mary + tom)
  println(mary.+(tom)) // Same as above - all operators are methods

  // Prefix notation
  val x = -1
  val y = 1.unary_-

  println(!mary)
  print(mary.unary_!) // Same as above

  // Postfix notation
  println(mary.isAlive)
  println(mary isAlive) // Save as above

  // Apply
  println(mary.apply())
  println(mary()) // Same as above

  print(+mary)
  println(mary learnsScala)
}

/*
  1. Overload the + operator
     mary + "the rockstar" => new Person Mary, the rockstar

  2. Add an age to the Person class
     Add unary operator + => new person with age + 1
     +mary => maru with the age incrementer

  3. Add a "learns" method in the Person class => "Mary learns Scala"
     Add a learnScala method, calls learns method with "Scala"
     Use it in postfix notation

  4. Overload the apply method
     mary.apply(2) => "Mary watched Inception 2 times
 */
