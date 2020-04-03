package lectures.part4pm

import exercises.{Cons, Empty, MyList}

object AllThePatterns extends App {
  // 1- constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "a string"
    case true => "a boolean"
    case AllThePatterns => "an object"
  }

  // 2 - match anything
  // 2.1 - wildcard
  val matchAnything = x match {
    case _ => Some
  }
  // 2.2 - variable
  val matchVariable = x match {
    case something => s"its $something"
  }

  // 3 - tuples
  val aTuple = (1, 2)
  val matchTuple = aTuple match {
    case (a, b) => s"$a + $b"
    case (something, 2) => s"$something + 2"
  }

  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (a, (b, c)) => s"$a + $b + $c"
  }

  // 4 - case classes (constructor pattern)
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty =>
    case Cons(h, t) =>
    case _ =>
  }

  // 5 - list patterns
  val aStandardList = List(1, 2, 3, 42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => "extractor"
    case List(1, _*) => "list of arbitrary length"
    case 1 :: List(_) => "infix pattern"
    case List(1, 2, 3) :+ 42 => "also infix pattern"
  }

  // 6 - type specifiers
//  val unknown: Any = 2
//  val unknownMatch = unknownMatch match {
//    case list: List[Int] => "explicit type specifier"
//    case _ =>
//  }

  // 7 - name binding
  val nameBindingMatch = aList match {
    case nonEmpty @ Cons(_, _) => s"name binding, like variable - $nonEmpty"
    case Cons(1, rest @ Cons(2, _)) => s"name binding inside nested patterns - $rest"
  }

  // 8 - multi-patterns
  val multiPattern = aList match {
    case Empty | Cons(0, _) => "compound pattern (multi-pattern)"
  }

  // 9 - if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 => "pattern with guard"
  }
}


















