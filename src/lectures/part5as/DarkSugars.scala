package lectures.part5as

import scala.util.Try

object DarkSugars extends App {
  // 1 - methods with single params
  def singleArgMethod(arg: Int): String = s"$arg little ducks..."

  val description = singleArgMethod {
    // Do some code
    42
  }
  val aTryInstance = Try {
    throw new RuntimeException
  }
  List(1, 2, 3).map { x => x + 1 }

  // 2 - the :: and #:: methods are special
  val prependedLust = 2 :: List(3, 4)
  // 2.::(List(3, 4)) - that's wrong
  // List(3, 4).::(2) - that's what it compiles to
  1 :: 2 :: List(3, 4)
  List(3, 4).::(2).::(1)

  // 3 - multi word method naming
  class Girl(name: String) {
    def `and then said`(gossip: String) = println(s"$name said $gossip")
  }

  val lilly = new Girl("Lilly")
  lilly `and then said` "Scala is so sweet"

  // 4 - infix types
  class Composite[A, B]
  val composite: Int Composite String = ???

  // 5 - update method
  val anArray = Array(1, 2, 3)
  anArray(2) = 7 // anArray.update(2, 7): Unit
  // used in mutable collections

  // 6 - setters for mutable containers
  class Mutable {
    private var internalMember: Int = 0
    def member: Int = internalMember // "getter"
    def member_=(value: Int): Unit = internalMember = value // "setter"
  }

  val aMutableContainer = new Mutable
  aMutableContainer.member = 42 // aMutableContainer.member_=(42)
}
