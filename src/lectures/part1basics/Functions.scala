package lectures.part1basics

object Functions extends App {
  def aFunctions(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunctions("hello", 3))
  def aParameterlessFunction: Int = 42
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  } // use recursion instead of loops
  println(aRepeatedFunction("hello", 3))

  def aFunctionWithSideEffects(aString: String): Unit = {
    println(aString)
  }

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int) = a + b // auxiliary functions
    aSmallerFunction(n, n - 1)
  }

  def aGreeting(name: String, age: Int): String = {
    s"Hi my name is $name and I am $age years old"
  }

  def aFactorial(number: Int): Int = {
    if (number <= 0) 1
    else number * aFactorial(number - 1)
  }

  def fibonacci(number: Int): Int = {
    if (number == 1 || number == 2) 1
    else fibonacci(number - 1) + fibonacci(number - 2)
  }

  def isPrime(number: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else number % t != 0 && isPrimeUntil(t - 1)
    }
    isPrimeUntil(number / 2)
  }
}
