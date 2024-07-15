package GuessWhoGameSpec

import GuessWhoGame._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class BoardSpec extends AnyFlatSpec {

  val characters = List(
    Character("joe", "male", "brown", "blue", wearsGlasses = false, facialHair = false),
    Character("muhammad", "male", "black", "brown", wearsGlasses = true, facialHair = true),
    Character("bobbiana", "female", "brown", "blue", wearsGlasses = true, facialHair = false)
  )

  //prints out characters onto the board
   "GameBoard" should "initialise with the provided characters" in {
   val gameBoard = new Board(characters)
   gameBoard.getRemainingCharacters shouldEqual characters
   }

  // Selects a character

//  it should "select a random character at the start of the game" in {
//    val game = new Board(characters)
//    val selectedCharacter = getSelectedCharacter
//  }
//
//  it should "keep the character in the list" in {
//    val game = new Board(characters)
//    val selectedCharacter = gameLogic.getSelectedCharacter
//    characters should contain(selectedCharacter)
//  }

  // Stores remaining characters

   //Watches for the win condition

//  it should "check win condition correctly" in {
//    val game = new Board(characters)
//    while (game.getRemainingCharacters.size > 1) {
//      gameLogic.askQuestion(_.gender == "male")
//    }
//    game.checkWinCondition shouldBe true
//  }

   //Handles questions, rerenders based on question result

//  it should "eliminate characters correctly based on questions" in {
//    val game = new Board(characters)
//    val initialSize = game.getRemainingCharacters.size
//    gameLogic.handleQuestion(character => character.gender == "male")
//    val newSize = game.getRemainingCharacters.size
//    newSize should be < initialSize
//    game.getRemainingCharacters.forall(_.gender == "male") shouldBe true
//  }
//
//  it should "eliminate characters correctly based on questions" in {
//    val game = new Board(characters)
//    gameLogic.handleQuestion(_.gender == "male")
//    board.getRemainingCharacters.forall(_.gender == "male") shouldBe true
//  }

  // Updates based on filters applied to questions

   //Resets board
//  it should "reset the game board correctly" in {
//    val game = new Board(characters)
//    gameLogic.handleQuestion(character => character.gender == "male")
//    game.getRemainingCharacters.size should be < characters.size
//    game.resetBoard()
//    game.getRemainingCharacters.size shouldEqual characters.size
//  }
//
//  // to revisit if needed
//  it should "eliminate a character correctly" in {
//    val gameBoard = new Board(characters)
//    val characterToEliminate = characters.head
//    gameBoard.eliminateCharacter(characterToEliminate)
//    gameBoard.getRemainingCharacters should not contain characterToEliminate
//    gameBoard.getRemainingCharacters.size shouldEqual (characters.size - 1)
//  }
//
//  it should "return an empty list if all characters are eliminated" in {
//    val gameBoard = Board(characters)
//    characters.foreach(gameBoard.eliminateCharacter)
//    gameBoard.getRemainingCharacters shouldBe empty
//  }
}
