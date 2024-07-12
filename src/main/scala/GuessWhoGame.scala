import scala.util.Random

case class Character(
                      name: String,
                      gender: String,
                      hairColor: String,
                      eyeColor: String,
                      wearsGlasses: Boolean,
                      facialHair: Boolean
                    )

class GameBoard(val characters: List[Character]) {
  private var remainingCharacters: List[Character] = characters

  def getRemainingCharacters: List[Character] = remainingCharacters

  def eliminateCharacter(character: Character): Unit = {
    remainingCharacters = remainingCharacters.filterNot(_ == character)
  }

  def resetBoard(): Unit = {
    remainingCharacters = characters
  }
}

class GuessWhoGame(characters: List[Character]) {
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
