package GuessWhoGameSpec

import GuessWhoGame._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class GuessWhoGameSpec extends AnyFlatSpec {

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
    Character("john", "male", "black", "brown", wearsGlasses = true, facialHair = false),
    Character("kate", "female", "blonde", "green", wearsGlasses = false, facialHair = true),
    Character("mike", "male", "brown", "blue", wearsGlasses = true, facialHair = true),
    Character("lucy", "female", "black", "brown", wearsGlasses = false, facialHair = false)
  )

  "GuessWhoGame" should "initialize with the correct number of characters" in {
    val game = new GuessWhoGame(characters)
    game.getRemainingCharacters.size shouldEqual characters.size
  }

  it should "select a random character at the start of the game" in {
    val game = new GuessWhoGame(characters)
    val selectedCharacter = game.getSelectedCharacter
    characters should contain(selectedCharacter)
  }

  it should "eliminate characters correctly based on questions" in {
    val game = new GuessWhoGame(characters)
    val initialSize = game.getRemainingCharacters.size
    game.askQuestion(character => character.gender == "male")
    val newSize = game.getRemainingCharacters.size
    newSize should be < initialSize
    game.getRemainingCharacters.forall(_.gender == "male") shouldBe true
  }

  it should "check win condition correctly" in {
    val game = new GuessWhoGame(characters)
    while (game.getRemainingCharacters.size > 1) {
      game.askQuestion(character => character.gender == "male")
    }
    game.checkWinCondition shouldBe true
  }

  it should "reset the game board correctly" in {
    val game = new GuessWhoGame(characters)
    game.askQuestion(character => character.gender == "male")
    game.getRemainingCharacters.size should be < characters.size
    game.resetBoard()
    game.getRemainingCharacters.size shouldEqual characters.size
  }
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
