package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length)

  // Throwing exceptions
  // val aWeirdValue = throw new NullPointerException

  // Catching exceptions
  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("No Int")
    else 42

  val potentialFail = try {
    getInt(false)
  } catch {
    case e: NullPointerException => 43
  } finally {
    println("finally")
  }
  println(potentialFail)

  // Define own exceptions
  class MyException extends Exception
  val exception = new MyException
  throw exception

  val array = Array.ofDim(Int.MaxValue) // Throws exception
}
