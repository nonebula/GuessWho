package GuessWhoGameSpec

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import GuessWhoGame.character._
import GuessWhoGame._

class GameSpec extends AnyFlatSpec with Matchers {

  "A Character" should "have correct attributes" in {
    val char = Character("Joe", Gender.Male, HairColor.Brown, EyeColor.Blue, None, None)
    char.name should be("Joe")
    char.gender should be(Gender.Male)
    char.hairColor should be(HairColor.Brown)
    char.eyeColor should be(EyeColor.Blue)
    char.wearsGlasses shouldBe None
    char.facialHair shouldBe None
  }

  "CharacterManager" should "create a list of characters" in {
    val characters = CharacterManager.createCharacters()
    characters should have size 20
  }

  "CharacterManager" should "select a random character from the list" in {
    val characters = CharacterManager.createCharacters()
    val selectedCharacter = CharacterManager.selectRandomCharacter(characters)
    characters should contain(selectedCharacter)
  }

  "Game" should "create a game board" in {
    val board = Game.createGameBoard()
    board.characters should have size 20
    board.selectedCharacter should not be null
  }

  "Game" should "start and play the game" in {
    noException should be thrownBy {
      val board = Game.createGameBoard()
      Game.startGame(board)
    }
  }
}