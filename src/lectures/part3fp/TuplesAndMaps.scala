package lectures.part3fp

object TuplesAndMaps extends App {
  // Maps - key -> value
  val aMap: Map[String, Int] = Map()

  val phonebook = Map("Jim" -> 555, "Daniel" -> 789).withDefaultValue(-1) // return def value when accessing key that doesn't exist
  // a -> b is eq to tuple(a, b)
  println(phonebook)

  // Map ops
  println(phonebook.contains("Jim"))
  println(phonebook("Jim"))
  println(phonebook("Mary"))

  // Add pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  // Functions on maps
//  println(phonebook.map(t => (t._1, t._2)))
  println(phonebook.view.filterKeys(_.startsWith("J")).toMap)
  println(phonebook.view.mapValues("0245-" + _).toMap)

  // Conversions to other collections
  println(phonebook.toList)
  val names = List("Bob", "James", "Angela")
  println(names.groupBy(name => name.charAt(0)))
}
