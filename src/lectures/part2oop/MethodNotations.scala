package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def +(person: Person): String = s"${this.name} is hanging with ${person.name}"
    def unary_! : String = s"$name, what the hell?"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // Infix notation

  val tom = new Person("Tom", "Fight Club")
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
}
