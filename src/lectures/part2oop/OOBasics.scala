package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.age)
  person.greet("Bob")
  person.greet()
}

class Person(val name: String, val age: Int = 0) {
  // fields
  val x = 2

  // overloading
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")

  /*
    Novel and Writer class
    Writer: firstName, lastName, birthYear:
      - fullname = fname + lname
    Novel: name, releaseYear, author:
      - authorAge: age of auth and release year
      - isWrittenByAuthor(author)
      - copy(new year of release): new instance of Novel with new year of release
   */

  /*
    Counter class
      - receives int value
      - currentCount
      - increment by 1: new Counter
      - decrement by 1: new Counter
      - overload inc/dec with param: new Counter
   */
}

class Writer(val firstName: String, val lastName: String, val birthYear: Int) {
  def getFullname: String = s"$firstName $lastName"
}

class Novel(val name: String, val releaseYear: Int, val author: Writer) {
  def getAuthorAgeAtRelease: Int = releaseYear - author.birthYear
  def isWrittenByAuthor(someAuthor: Writer): Boolean = someAuthor == author
  def copy(newReleaseYear: Int): Novel = new Novel(name, newReleaseYear, author)
}

class Counter(val count: Int) {
  def currentCount: Int = count
  def increment: Counter = new Counter(currentCount + 1)
  def decrement: Counter = new Counter(currentCount - 1)
  def increment(valueToAdd: Int): Counter = new Counter(currentCount + valueToAdd)
  def decrement(valueToSubtract: Int): Counter = new Counter(currentCount - valueToSubtract)
}
