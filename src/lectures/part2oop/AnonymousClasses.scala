package lectures.part2oop

object AnonymousClasses extends App {
  abstract class Animal {
    def eat(): Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat(): Unit = println("heh")
  }
  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi(): Unit = println("Hey, hi, hello")
  }

  val jim = new Person("Jim") {
    override def sayHi(): Unit = println("I'm Jim")
  }
}
