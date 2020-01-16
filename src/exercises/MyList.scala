package exercises

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = s"[$printElements]"
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  val listOfStrings: MyList[String] = new Cons[String]("Hello", new Cons[String]("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}
