package lectures.part2oop

object AbstractDataTypes extends App {
  // Abstract members
  abstract class Animal {
    val creatureType: String
    def eat(): Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "domestic"
    override def eat(): Unit = println("Bark")
  }

  // Traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }
  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    override def eat(): Unit = println("nom")
    override def eat(animal: Animal): Unit = println(s"I am a croc")
  }

  // Traits vs Abstract Types
  // 1. Traits don't have constructors params
  // 2. Multiple traits can be inherited and only one abstract class
  // 3. Traits - behaviour , Abstract Class - a thing
}
