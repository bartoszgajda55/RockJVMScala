package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }
  println(factorial(10))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator) // tail recursion - use recursive call as the last expression

    factorialHelper(n, 1)
  }
  println(anotherFactorial(10))

  def concatTailRec(a: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatTailRec(a, n - 1, a + accumulator)
  }

  def isPrime(n: Int, accumulator: BigInt): Boolean = {
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }
    isPrimeTailRec(n / 2, true)
  }

  def fibonacci(n: Int): Int = {
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fiboTailRec(i + 1, last + nextToLast, last)
    }
    if (n <= 2) 1
    else fiboTailRec(2, 1, 1)
  }
}
