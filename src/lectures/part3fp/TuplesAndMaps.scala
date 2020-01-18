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

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }
  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }
  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }
  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }
    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  def nFriends(network: Map[String, Seq[String]], person: String): Int = {
    if (!network.contains(person)) 0
    else network(person).size
  }

  def mostFriends(network: Map[String, Seq[String]]): String = {
    network.maxBy(pair => pair._2.size)._1
  }

  def nPeopleWithNoFriends(network: Map[String, Seq[String]]): Int = {
    network.count(_._2.isEmpty)
  }
}
