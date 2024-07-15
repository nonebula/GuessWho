package GuessWhoGame

case class Board (characters: List[Character]) {
  def printCharacterNames(): Unit = {
    characters.foreach(Character => println(Character.name))
  }

  def eliminateCharacter(character: Character): Unit = {
    var remainingCharacters = characters.filterNot(_ == character)
  }

}