package lectures.part2oop

object Objects extends App {

  object Person {
    val N_EYES = 2
    def canFly: Boolean = false

    // Factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  } // Companion object
  class Person(val name: String) {

  } // Companion class

  println(Person.N_EYES)

  // Scala object = Singleton Instance
  val mary = Person
  val john = Person
  println(mary == john)

  val person1 = new Person("Mary")
  val person2 = new Person("John")
  println(person1 == person2)

  val bobby = Person(person1, person2)

  // Scala applications = Scala object + main method
}
