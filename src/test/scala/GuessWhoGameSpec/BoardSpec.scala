package GuessWhoGameSpec

import GuessWhoGame._
import GuessWhoGame.character.{CharacterManager, Character, EyeColor, Gender, HairColor, PersonWithFacialHair, PersonWithGlasses}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class BoardSpec extends AnyFlatSpec {

  // Sample characters for testing
  val characters: List[Character] = CharacterManager.createCharacters()

  // Initializes the board with the provided characters
  "Board" should "initialize with the provided characters" in {
    val gameBoard = new Board(characters)
    gameBoard.getRemainingCharacters shouldEqual characters
  }

  // Selects a character
  it should "select a random character at the start of the game and keep this character in the list" in {
    val gameBoard = new Board(characters)
    characters should contain(gameBoard.getSelectedCharacter)
  }

  // Checks the win condition
  it should "check win condition correctly" in {
    val gameBoard = new Board(characters)
    if (characters.size <= 1) {
      assert(gameBoard.checkWinCondition())
    } else {
      assert(!gameBoard.checkWinCondition())
    }
  }

  // Handles questions and eliminates characters based on attributes
  it should "eliminate characters correctly based on gender questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.getRemainingCharacters.size
    gameBoard.handleQuestion("gender", Left("male"))
    val newSize = gameBoard.getRemainingCharacters.size
    newSize should be < initialSize
  }

  it should "eliminate characters correctly based on name questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.getRemainingCharacters.size
    gameBoard.handleQuestion("name", Left("muhammad"))
    val newSize = gameBoard.getRemainingCharacters.size
    newSize should be < initialSize
  }

  it should "eliminate characters correctly based on hair color questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.getRemainingCharacters.size
    gameBoard.handleQuestion("hairColor", Left("blonde"))
    val newSize = gameBoard.getRemainingCharacters.size
    newSize should be < initialSize
  }

  it should "eliminate characters correctly based on eye color questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.getRemainingCharacters.size
    gameBoard.handleQuestion("eyeColor", Left("blue"))
    val newSize = gameBoard.getRemainingCharacters.size
    newSize should be < initialSize
  }

  it should "eliminate characters correctly based on wears glasses questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.getRemainingCharacters.size
    gameBoard.handleQuestion("wearsGlasses", Right(true))
    val newSize = gameBoard.getRemainingCharacters.size
    newSize should be < initialSize
  }

  it should "eliminate characters correctly based on facial hair questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.getRemainingCharacters.size
    gameBoard.handleQuestion("hasFacialHair", Right(true))
    val newSize = gameBoard.getRemainingCharacters.size
    newSize should be < initialSize
  }

  // Handles incorrect attribute values cleanly
  it should "handle incorrect attribute values cleanly" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.getRemainingCharacters.size
    gameBoard.handleQuestion("gender", Left("nonexistent gender"))
    val newSize = gameBoard.getRemainingCharacters.size
    newSize shouldEqual initialSize
  }

  // Handles edge case where all characters have the same attribute
  it should "handle edge case where all characters have the same attribute" in {
    val sameGenderCharacters = List(
      Character("john", Gender.Male, HairColor.Brown, EyeColor.Blue, Some(PersonWithGlasses(false)), Some(PersonWithFacialHair(false))),
      Character("paul", Gender.Male, HairColor.Black, EyeColor.Green, Some(PersonWithGlasses(true)), Some(PersonWithFacialHair(true)))
    )
    val gameBoard = new Board(sameGenderCharacters)
    gameBoard.handleQuestion("gender", Left("male"))
    gameBoard.getRemainingCharacters.size shouldEqual 2
  }

  // Prints character names
  it should "print character names" in {
    val gameBoard = new Board(characters)
    val characterNames = gameBoard.printCharacterNames()
    characterNames.length should be(20)
    characterNames should contain(characters.head.name)
  }

  // Handles hair color question correctly
  it should "handle hair color question correctly" in {
    val gameBoard = new Board(characters)
    val remainingCharacters = gameBoard.handleQuestion("hairColor", Left("brown"))
    remainingCharacters shouldBe a[List[_]]
    all(remainingCharacters.map(_.hairColor)) shouldEqual HairColor.Brown
  }

  // Handles eye color question correctly
  it should "handle eye color question correctly" in {
    val gameBoard = new Board(characters)
    val remainingCharacters = gameBoard.handleQuestion("eyeColor", Left("blue"))
    remainingCharacters shouldBe a[List[_]]
    all(remainingCharacters.map(_.eyeColor)) shouldEqual EyeColor.Blue
  }

  // Handles gender question correctly
  it should "handle gender question correctly" in {
    val gameBoard = new Board(characters)
    val remainingCharacters = gameBoard.handleQuestion("gender", Left("male"))
    remainingCharacters shouldBe a[List[_]]
    all(remainingCharacters.map(_.gender)) shouldEqual Gender.Male
  }

  // Handles wears glasses question correctly
  it should "handle wears glasses question correctly" in {
    val gameBoard = new Board(characters)
    val remainingCharacters = gameBoard.handleQuestion("wearsGlasses", Right(true))
    remainingCharacters shouldBe a[List[_]]
    all(remainingCharacters.flatMap(_.wearsGlasses)) shouldEqual PersonWithGlasses(true)
  }

  // Handles facial hair question correctly
  it should "handle facial hair question correctly" in {
    val gameBoard = new Board(characters)
    val remainingCharacters = gameBoard.handleQuestion("hasFacialHair", Right(true))
    remainingCharacters shouldBe a[List[_]]
    all(remainingCharacters.flatMap(_.facialHair)) shouldEqual PersonWithFacialHair(true)
  }

  // Handles name guess correctly
  it should "handle name guess correctly" in {
    val selectedCharacter = characters.head
    val gameBoard = new Board(characters, selectedCharacter)
    val remainingCharacters = gameBoard.handleQuestion("name", Left(selectedCharacter.name.toLowerCase()))
    gameBoard.checkWinCondition(remainingCharacters) should be(true)
  }
}
