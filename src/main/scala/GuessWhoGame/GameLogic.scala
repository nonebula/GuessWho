package GuessWhoGame

import scala.util.Random

//start game (select character)
//ask question
//end game/win condition

class GameLogic (characters: List[Character]) {
    private val board = new GameBoard(characters)
    private val selectedCharacter = selectRandomCharacter(characters)

    private def selectRandomCharacter(characters: List[Character]): Character = {
      characters(Random.nextInt(characters.size))
    }

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
