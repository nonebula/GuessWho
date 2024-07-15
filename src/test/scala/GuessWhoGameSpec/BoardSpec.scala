package GuessWhoGameSpec

import GuessWhoGame._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class BoardSpec extends AnyFlatSpec {

  val characters = List(
    Character("joe", "male", "brown", "blue", wearsGlasses = false, facialHair = false),
    Character("muhammad", "male", "black", "brown", wearsGlasses = true, facialHair = true),
    Character("april", "female", "blonde", "blue", wearsGlasses = true, facialHair = false),
    Character("sally", "female", "blue", "green", wearsGlasses = true, facialHair = true),
    Character("spencer", "male", "brown", "brown", wearsGlasses = false, facialHair = true),
    Character("gemma", "female", "ginger", "blue", wearsGlasses = true, facialHair = false),
    Character("jamie", "male", "none", "green", wearsGlasses = true, facialHair = true),
    Character("jessica", "female", "green", "green", wearsGlasses = false, facialHair = false),
    Character("bilal", "male", "brown", "green", wearsGlasses = false, facialHair = true),
    Character("lisa", "female", "black", "brown", wearsGlasses = true, facialHair = false),
    Character("tom", "male", "brown", "blue", wearsGlasses = true, facialHair = false),
    Character("cheryl", "female", "blonde", "green", wearsGlasses = false, facialHair = false),
    Character("arei", "male", "brown", "brown", wearsGlasses = false, facialHair = true),
    Character("kelly", "female", "none", "green", wearsGlasses = false, facialHair = false),
    Character("tayamul", "male", "brown", "blue", wearsGlasses = false, facialHair = false),
    Character("elaine", "female", "ginger", "blue", wearsGlasses = false, facialHair = true),
    Character("roshan", "male", "brown", "blue", wearsGlasses = true, facialHair = false),
    Character("patricia", "female", "purple", "yellow", wearsGlasses = false, facialHair = false),
    Character("dave", "male", "none", "yellow", wearsGlasses = false, facialHair = false),
    Character("bobbiana", "female", "brown", "blue", wearsGlasses = true, facialHair = false)
  )

  //prints out characters onto the board
  "gameBoard" should "initialise with the provided characters" in {
    val gameBoard = new Board(characters)
    gameBoard.getRemainingCharacters shouldEqual characters
  }

  // Selects a character

  it should "select a random character at the start of the game and keeps this character in the list" in {
    val gameBoard = new Board(characters)
    characters should contain(gameBoard.getSelectedCharacter)
    gameBoard.getSelectedCharacter shouldEqual (gameBoard.selectedCharacter)
    //assert(gameBoard.selectRandomCharacter(characters: List[Character]) == gameBoard.selectedCharacter)
  }

  //Watches for the win condition

  it should "check win condition correctly" in {
    val gameBoard = new Board(characters)
    if (characters.size <= 1) {
      assert(gameBoard.checkWinCondition)
    } else {
      assert(!gameBoard.checkWinCondition)
    }
  }

  //Handles questions, rerenders based on question result ||  Stores remaining characters

    it should "eliminate characters correctly based on gender questions" in {
      val gameBoard = new Board(characters)
      val initialSize = gameBoard.remainingCharacters.size
      gameBoard.handleQuestion("gender", Left("male"))
      val newSize = gameBoard.remainingCharacters.size
      newSize should be < initialSize
      //gameBoard.getRemainingCharacters.forall(_.gender == "male") shouldBe true
    }

  it should "eliminate characters correctly based on name questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.remainingCharacters.size
    gameBoard.handleQuestion("name", Left("muhammad"))
    val newSize = gameBoard.remainingCharacters.size
    newSize should be < initialSize
    //gameBoard.getRemainingCharacters.forall(_.gender == "male") shouldBe true
  }

  it should "eliminate characters correctly based on hairColor questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.remainingCharacters.size
    gameBoard.handleQuestion("hairColor", Left("blonde"))
    val newSize = gameBoard.remainingCharacters.size
    newSize should be < initialSize
    //gameBoard.getRemainingCharacters.forall(_.gender == "male") shouldBe true
  }

  it should "eliminate characters correctly based on eyeColor questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.remainingCharacters.size
    gameBoard.handleQuestion("eyeColor", Left("blue"))
    val newSize = gameBoard.remainingCharacters.size
    newSize should be < initialSize
    //gameBoard.getRemainingCharacters.forall(_.gender == "male") shouldBe true
  }

  it should "eliminate characters correctly based on wearsGlasses questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.remainingCharacters.size
    gameBoard.handleQuestion("wearsGlasses", Right(false))
    val newSize = gameBoard.remainingCharacters.size
    newSize should be < initialSize
    //gameBoard.getRemainingCharacters.forall(_.gender == "male") shouldBe true
  }

  it should "eliminate characters correctly based on HasFacialHair questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.remainingCharacters.size
    gameBoard.handleQuestion("hasFacialHair", Right(false))
    val newSize = gameBoard.remainingCharacters.size
    newSize should be < initialSize
    //gameBoard.getRemainingCharacters.forall(_.gender == "male") shouldBe true
  }

//    it should "eliminate characters correctly based on questions" in {
//      val game = new Board(characters)
//      gameLogic.handleQuestion(_.gender == "male")
//      board.getRemainingCharacters.forall(_.gender == "male") shouldBe true
//    }

  // Updates based on filters applied to questions

  //Resets board
//    it should "reset the game board correctly" in {
//      val gameBoard = new Board(characters)
//      gameBoard.handleQuestion(character => character.gender == "male")
//      gameBoard.getRemainingCharacters.size should be < characters.size
//      gameBoard.resetBoard()
//      gameBoard.getRemainingCharacters.size shouldEqual characters.size
//    }
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
