package GuessWhoGame

import scala.util.Random

//start game (select character)
//ask question
//end game/win condition

class GameLogic (board: Board) {
  private val selectedCharacter = selectRandomCharacter(board.Characters)

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
    }

  def checkWinCondition: Boolean = board.getRemainingCharacters.size == 1


  def getRemainingCharacters: List[Character] = board.getRemainingCharacters
}
