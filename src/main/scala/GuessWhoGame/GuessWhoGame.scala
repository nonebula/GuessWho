import scala.util.Random

case class Character(
                      name: String,
                      gender: String,
                      hairColor: String,
                      eyeColor: String,
                      wearsGlasses: Boolean,
                      facialHair: Boolean
                    )

class GameBoard(val characters: List[GuessWhoGame.Character]) {
  private var remainingCharacters: List[GuessWhoGame.Character] = characters

  def getRemainingCharacters: List[GuessWhoGame.Character] = remainingCharacters

  def eliminateCharacter(character: GuessWhoGame.Character): Unit = {
    remainingCharacters = remainingCharacters.filterNot(_ == character)
  }

  def resetBoard(): Unit = {
    remainingCharacters = characters
  }
}

class GuessWhoGame(characters: List[GuessWhoGame.Character]) {
  private val board = new GameBoard(characters)
  private val selectedCharacter = selectRandomCharacter(characters)

  private def selectRandomCharacter(characters: List[GuessWhoGame.Character]): GuessWhoGame.Character = {
    characters(Random.nextInt(characters.size))
  }

  def askQuestion(question: GuessWhoGame.Character => Boolean): Boolean = {
    val answer = question(selectedCharacter)
    board.getRemainingCharacters.foreach { character =>
      if (question(character) != answer) board.eliminateCharacter(character)
    }
    answer
  }

  def checkWinCondition: Boolean = board.getRemainingCharacters.size == 1

  def getSelectedCharacter: GuessWhoGame.Character = selectedCharacter

  def getRemainingCharacters: List[GuessWhoGame.Character] = board.getRemainingCharacters
}
