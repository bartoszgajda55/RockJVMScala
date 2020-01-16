package lectures.part2oop

object Inheritance extends App {
  sealed class Animal {
    val creatureType: String = "wild"
    def eat(): Unit = println("Yummy")
  }

  class Cat extends Animal {
    def crunch(): Unit = {
      eat()
      println("Crunch")
    }
  }

  val cat = new Cat
  cat.crunch()

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // Overriding
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType: String = "domestic"
    override def eat(): Unit = {
      super.eat()
    }
  }
  val dog = new Dog("domestic")
  dog.eat()
  println(dog.creatureType)

  // Type substitution - polymorphism
  val unknownAnimal: Animal = new Dog("doggo")

  // Super
  unknownAnimal.eat()

  // Prevent overrides
  // 1. use final on method or class
  // 2. seal the class - extend class in THIS file only, but not in other
}
