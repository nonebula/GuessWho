package GuessWhoGameSpec

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._
import GuessWhoGame.character._

class CharacterManagerSpec extends AnyFlatSpec {

  "createCharacters" should "return a list of 20 characters" in {
    val characters = CharacterManager.createCharacters()
    characters should have size 20
  }

  "createCharacters" should "return characters with unique names" in {
    val characters = CharacterManager.createCharacters()
    val names = characters.map(_.name)
    names.distinct shouldEqual names
  }

  "createCharacters" should "return characters with correct attributes" in {
    val characters = CharacterManager.createCharacters()

    characters.find(_.name == "Muhammad") shouldBe defined
    characters.find(_.name == "Muhammad").get.gender shouldEqual Gender.Male
    characters.find(_.name == "Muhammad").get.hairColor shouldEqual HairColor.Black
    characters.find(_.name == "Muhammad").get.eyeColor shouldEqual EyeColor.Blue
    characters.find(_.name == "Muhammad").get.wearsGlasses shouldEqual Some(PersonWithGlasses(true))
    characters.find(_.name == "Muhammad").get.facialHair shouldEqual Some(PersonWithFacialHair(true))
  }

  "selectRandomCharacter" should "return a character from the list" in {
    val characters = CharacterManager.createCharacters()
    val selectedCharacter = CharacterManager.selectRandomCharacter(characters)
    characters should contain(selectedCharacter)
  }

  "selectRandomCharacter" should "return a different character on multiple calls" in {
    val characters = CharacterManager.createCharacters()
    val selectedCharacter1 = CharacterManager.selectRandomCharacter(characters)
    val selectedCharacter2 = CharacterManager.selectRandomCharacter(characters)
    selectedCharacter1 should not equal selectedCharacter2
  }

  "selectRandomCharacter" should "throw an exception if the list is empty" in {
    val emptyList = List.empty[Character]
    assertThrows[NoSuchElementException] {
      CharacterManager.selectRandomCharacter(emptyList)
    }
  }
}