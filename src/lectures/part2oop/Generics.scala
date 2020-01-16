package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Dog = Animal
     */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. Use more derived type - COVARIANT
  class CovariantList[+A]
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // 2. Use only original type - INVARIANT
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Use less derived type - CONTRAVARIANT
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // Bounded types

  // Upper bounded type: <:
  // Lowe bounded type: >:
  class Cage[A <: Animal](animal: A)
  val cage = new Cage[Dog](new Dog)

  class Car
//  val newCage = new Cage(new Car) // doesn't compile, type not in bounds
}
