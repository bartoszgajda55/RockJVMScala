package lectures.part3fp

object Options extends App {
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  // Unsafe APIs
  def unsafeMethod(): String = null
  val resultWrong = Some(unsafeMethod()) // wrong - method can return null
  val result = Option(unsafeMethod()) // correct - gets Some or None, not null

  // Good practice of working with unsafe APIs
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // Functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // Unsafe - don't use this
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(_ % 2 == 0))
}
