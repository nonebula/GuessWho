package GuessWhoGame

import scala.util.Random

class GuessWhoGame(characters: List[Character]) {
  private val board = new GameBoard(characters)
  private val selectedCharacter = selectRandomCharacter(characters)

  private def selectRandomCharacter(characters: List[Character]): Character = {
    characters(Random.nextInt(characters.size))
  }


  def getSelectedCharacter: Character = selectedCharacter

  //Testing only, delete once game running clearly
  def printSelectedCharacter(): Unit = {
    println(selectedCharacter.name)
  }
  //ABOVE = TESTING ONLY







  //Not touched yet
    def askQuestion(question: Character => Boolean): Boolean = {
      val answer = question(selectedCharacter)
      board.getRemainingCharacters.foreach { character =>
        if (question(character) != answer) board.eliminateCharacter(character)
      }
      answer

  // The askQuestion method should take a function as a parameter
  def askQuestion(question: Character => Boolean): Boolean = {
    val answer = question(selectedCharacter)
    board.getRemainingCharacters.foreach { character =>
      if (question(character) != answer) board.eliminateCharacter(character)

    }
    answer
  }

  def checkWinCondition: Boolean = board.getRemainingCharacters.size == 1

  def getSelectedCharacter: Character = selectedCharacter

  def getRemainingCharacters: List[Character] = board.getRemainingCharacters
}
