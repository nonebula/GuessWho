package GuessWhoGame

case class Board (Characters: List[Character]) {
  def printCharacterNames(): Unit = {
    Characters.foreach(Character => println(Character.name))
  }
}