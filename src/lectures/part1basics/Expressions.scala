package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>>

  println(1 == x)
  // == !+ > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3
  // += -= *= /=
  println(aVariable)

  // Instruction vs Expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // if expression, not statement
  println(aConditionedValue)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  } // avoid imperative code in Scala

  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)
  // expression returning Unit - side effect

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }
}
