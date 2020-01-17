package lectures.part3fp

object AnonymousFunctions extends App {
  // Anonymous function - lambda
  val doubler = (x: Int) => x * 2
  val doubler2: Int => Int = x => x * 2

  // Multi params in lambdas
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // No params
  val doSomething: () => Int = () => 3

  println(doSomething) // returns function reference
  println(doSomething()) // returns actual function value

  val stringToInt = { (str: String) =>
    str.toInt
  }

  val niceInrementer: Int => Int = _ + 1
  val niceAdder: (Int, Int) => Int = _ + _

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))
}
