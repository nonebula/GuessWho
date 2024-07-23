package GuessWhoGameSpec

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import GuessWhoGame.character._
import GuessWhoGame._
import scala.util.Random

class GameSpec extends AnyFlatSpec with Matchers {

  "A Character" should "have correct attributes" in {
    val char = Character("joe", Male, Brown, BlueEye, PersonWithGlasses(false), PersonWithFacialHair(false))
    char.name should be ("joe")
    char.gender should be (Male)
    char.hairColor should be (Brown)
    char.eyeColor should be (BlueEye)
    char.wearsGlasses.value should be (false)
    char.facialHair.value should be (false)
  }

  "CharacterManager" should "create a list of characters" in {
    val characters = CharacterManager.createCharacters()
    characters should have size 20
  }

  it should "select a random character from the list" in {
    val characters = CharacterManager.createCharacters()
    val selectedCharacter = CharacterManager.selectRandomCharacter(characters)
    characters should contain (selectedCharacter)
  }

  "Board" should "print character names" in {
    val characters = CharacterManager.createCharacters()
    val board = new Board(characters, characters.head)
    board.printCharacterNames().length should be (20)
  }

  it should "handle hair color question correctly" in {
    val characters = CharacterManager.createCharacters()
    val board = new Board(characters, characters.head)
    val remainingCharacters = board.handleQuestion("hairColor", Left("brown"), characters)
    remainingCharacters shouldBe a [List[_]]
  }

  it should "handle eye color question correctly" in {
    val characters = CharacterManager.createCharacters()
    val board = new Board(characters, characters.head)
    val remainingCharacters = board.handleQuestion("eyeColor", Left("blue"), characters)
    remainingCharacters shouldBe a [List[_]]
  }

  it should "handle gender question correctly" in {
    val characters = CharacterManager.createCharacters()
    val board = new Board(characters, characters.head)
    val remainingCharacters = board.handleQuestion("gender", Left("male"), characters)
    remainingCharacters shouldBe a [List[_]]
  }

  it should "handle wears glasses question correctly" in {
    val characters = CharacterManager.createCharacters()
    val board = new Board(characters, characters.head)
    val remainingCharacters = board.handleQuestion("wearsGlasses", Right(true), characters)
    remainingCharacters shouldBe a [List[_]]
  }

  it should "handle facial hair question correctly" in {
    val characters = CharacterManager.createCharacters()
    val board = new Board(characters, characters.head)
    val remainingCharacters = board.handleQuestion("hasFacialHair", Right(true), characters)
    remainingCharacters shouldBe a [List[_]]
  }

  it should "handle name guess correctly" in {
    val characters = CharacterManager.createCharacters()
    val selectedCharacter = characters.head
    val board = new Board(characters, selectedCharacter)
    val remainingCharacters = board.handleQuestion("name", Left(selectedCharacter.name.toLowerCase()), characters)
    board.checkWinCondition(remainingCharacters) should be (true)
  }

  "Game" should "create a game board" in {
    val board = Game.createGameBoard()
    board.characters should have size 20
    board.selectedCharacter should not be null
  }

  it should "start and play the game" in {
    noException should be thrownBy {
      val board = Game.createGameBoard()
      Game.startGame(board)
    }
  }
}
