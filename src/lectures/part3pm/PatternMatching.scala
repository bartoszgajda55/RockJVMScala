package lectures.part3pm

import scala.util.Random

object PatternMatching extends App {

  // Switch on steroids
  val random = new Random()
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "One"
    case 2 => "Double or Nothing"
    case 3 => "Third one"
    case _ => "Something else" // wildcard
  }
  println(x)
  println(description)

  // 1. Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"$n - $a" // case with guard
    case Person(n, a) => s"$n - $a"
    case _ => s"No match"
  }
  println(greeting)

  // PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Labrador")
  animal match { // match not exhaustive - doesn't cover the Parrot case of Animal class
    case Dog(someBreed) => println(s"Dog of $someBreed")
    case _ => println("")
  }

  // Match overengineering
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => {
      def maybeShowParentheses(exp: Expr) = exp match {
        case Prod(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }
      maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)
    }
  }
  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
}
