package GuessWhoGameSpec
import org.scalatest.flatspec
import org.scalatest.flatspec.AnyFlatSpec

class GameLogicSpec extends AnyFlatSpec {

}


//class GameLogic (characters: List[Character]) {
//  private val board = new GameBoard(characters)
//  private val selectedCharacter = selectRandomCharacter(characters)
//
//  private def selectRandomCharacter(characters: List[Character]): Character = {
//    characters(Random.nextInt(characters.size))
//  }
//
//  def askQuestion(question: Character => Boolean): Boolean = {
//    val answer = question(selectedCharacter)
//    board.getRemainingCharacters.foreach { character =>
//      if (question(character) != answer) board.eliminateCharacter(character)
//    }
//    answer
//  }
//
//  def checkWinCondition: Boolean = board.getRemainingCharacters.size == 1
//
//  def getSelectedCharacter: Character = selectedCharacter
//
//  def getRemainingCharacters: List[Character] = board.getRemainingCharacters
//}
