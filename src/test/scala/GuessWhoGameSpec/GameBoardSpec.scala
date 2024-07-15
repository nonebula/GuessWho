package GuessWhoGameSpec

import GuessWhoGame._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class GameBoardSpec extends AnyFlatSpec {

  val characters = List(
    Character("joe", "male", "brown", "blue", wearsGlasses = false, facialHair = false),
    Character("muhammad", "male", "black", "brown", wearsGlasses = true, facialHair = true),
    Character("bobbiana", "female", "brown", "blue", wearsGlasses = true, facialHair = false)
  )

  "GameBoard" should "initialize with the provided characters" in {
    val gameBoard = new GameBoard(characters)
    gameBoard.getRemainingCharacters shouldEqual characters
  }

  it should "eliminate a character correctly" in {
    val gameBoard = new GameBoard(characters)
    val characterToEliminate = characters.head
    gameBoard.eliminateCharacter(characterToEliminate)
    gameBoard.getRemainingCharacters should not contain characterToEliminate
    gameBoard.getRemainingCharacters.size shouldEqual (characters.size - 1)
  }

  it should "reset the board correctly" in {
    val gameBoard = new GameBoard(characters)
    val characterToEliminate = characters.head
    gameBoard.eliminateCharacter(characterToEliminate)
    gameBoard.resetBoard()
    gameBoard.getRemainingCharacters shouldEqual characters
  }

  it should "return an empty list if all characters are eliminated" in {
    val gameBoard = new GameBoard(characters)
    characters.foreach(gameBoard.eliminateCharacter)
    gameBoard.getRemainingCharacters shouldBe empty
  }
}
