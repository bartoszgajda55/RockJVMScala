package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. Class params are fields
  val jim = Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  println(jim.toString)
  println(jim) // automatic call to the toString method

  // 3. equals and hash code implemented OOTB
  val jim2 = Person("Jim", 34)
  println(jim == jim2)

  // 4. Case classes have copy methods
  val jim3 = jim.copy(age = 45)

  // 5. Case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 20)

  // 6. Case classes are serializable

  // 7. Case classes have extractor patterns - can be used in Pattern Matching

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
}
