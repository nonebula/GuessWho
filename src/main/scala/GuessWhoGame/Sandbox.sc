
//package GuessWhoGame

class GameBoard(val characters: List[Character]) {
  private var remainingCharacters: List[Character] = characters

  def getRemainingCharacters: List[Character] = remainingCharacters

  def printGameBoard(): Unit = {
    println("Remaining Characters:")
    characters.foreach(character => println(character.name))
  }

  def eliminateCharacter(character: Character): Unit = {
    remainingCharacters = remainingCharacters.filterNot(_ == character)
  }

  def resetBoard(): Unit = {
    remainingCharacters = characters
  }
}
