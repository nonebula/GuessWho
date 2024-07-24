package GuessWhoGameSpec

import GuessWhoGame._
import GuessWhoGame.character.{CharacterManager, EyeColor, Gender, HairColor, PersonWithFacialHair, PersonWithGlasses}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class BoardSpec extends AnyFlatSpec {
  
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

  //Handles questions, re-renders based on question result && Stores remaining characters
  it should "eliminate characters correctly based on gender questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.remainingCharacters.size
    gameBoard.handleQuestion("gender", Left("male"))
    val newSize = gameBoard.remainingCharacters.size
    newSize should be < initialSize
    //Future testcases
    //      gameBoard.getRemainingCharacters.forall(_.gender == "male") shouldBe false
  }

  it should "eliminate characters correctly based on name questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.remainingCharacters.size
    gameBoard.handleQuestion("name", Left("muhammad"))
    val newSize = gameBoard.remainingCharacters.size
    newSize should be < initialSize
  }

  it should "eliminate characters correctly based on hairColor questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.remainingCharacters.size
    gameBoard.handleQuestion("hairColor", Left("blonde"))
    val newSize = gameBoard.remainingCharacters.size
    newSize should be < initialSize
  }

  it should "eliminate characters correctly based on eyeColor questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.remainingCharacters.size
    gameBoard.handleQuestion("eyeColor", Left("blue"))
    val newSize = gameBoard.remainingCharacters.size
    newSize should be < initialSize
  }

  it should "eliminate characters correctly based on wearsGlasses questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.remainingCharacters.size
    gameBoard.handleQuestion("wearsGlasses", Right(false))
    val newSize = gameBoard.remainingCharacters.size
    newSize should be < initialSize
  }

  it should "eliminate characters correctly based on HasFacialHair questions" in {
    val gameBoard = new Board(characters)
    val initialSize = gameBoard.remainingCharacters.size
    gameBoard.handleQuestion("hasFacialHair", Right(false))
    val newSize = gameBoard.remainingCharacters.size
    newSize should be < initialSize
  }

  it should "handle incorrect attribute values cleanly" in {
    val gameBoard = Board(characters)
    val initialSize = gameBoard.getRemainingCharacters.size
    gameBoard.handleQuestion("gender", Left("nonexistent gender"))
    val newSize = gameBoard.getRemainingCharacters.size

    newSize shouldEqual initialSize
  }

  it should "handle edge case where all characters have the same attribute" in {
    val sameGenderCharacters = List(
      Character("john", "male", "brown", "blue", wearsGlasses = false, facialHair = false),
      Character("paul", "male", "black", "green", wearsGlasses = true, facialHair = true)
    )
    val gameBoard = Board(sameGenderCharacters)
    gameBoard.handleQuestion("gender", Left("male"))
    gameBoard.getRemainingCharacters.size shouldEqual 2
  }

  it should "fail to eliminate characters with incorrect gender" in {
    val gameBoard = Board(characters)
    gameBoard.handleQuestion("gender", Left("female"))
    gameBoard.getRemainingCharacters.forall(_.gender == "male") shouldBe true
  }
}



// future development
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

"Board" should "print character names" in {
  val characters = CharacterManager.createCharacters()
  val board = new Board(characters, characters.head)
  val characterNames = board.printCharacterNames()
  characterNames.length should be(20)
  characterNames should contain(characters.head.name)
}

"Board" should "handle hair color question correctly" in {
  val characters = CharacterManager.createCharacters()
  val board = new Board(characters, characters.head)
  val remainingCharacters = board.handleQuestion("haircolor", Left("brown"), characters)
  remainingCharacters shouldBe a[List[_]]
  all(remainingCharacters.map(_.hairColor)) shouldBe HairColor.Brown
}

"Board" should "handle eye color question correctly" in {
  val characters = CharacterManager.createCharacters()
  val board = new Board(characters, characters.head)
  val remainingCharacters = board.handleQuestion("eyecolor", Left("blue"), characters)
  remainingCharacters shouldBe a[List[_]]
  all(remainingCharacters.map(_.eyeColor)) shouldBe EyeColor.Blue
}

"Board" should "handle gender question correctly" in {
  val characters = CharacterManager.createCharacters()
  val board = new Board(characters, characters.head)
  val remainingCharacters = board.handleQuestion("gender", Left("male"), characters)
  remainingCharacters shouldBe a[List[_]]
  all(remainingCharacters.map(_.gender)) shouldBe Gender.Male
}

"Board" should "handle wears glasses question correctly" in {
  val characters = CharacterManager.createCharacters()
  val board = new Board(characters, characters.head)
  val remainingCharacters = board.handleQuestion("wearsglasses", Right(true), characters)
  remainingCharacters shouldBe a[List[_]]
  all(remainingCharacters.flatMap(_.wearsGlasses)) shouldBe PersonWithGlasses(true)
}

"Board" should "handle facial hair question correctly" in {
  val characters = CharacterManager.createCharacters()
  val board = new Board(characters, characters.head)
  val remainingCharacters = board.handleQuestion("hasfacialhair", Right(true), characters)
  remainingCharacters shouldBe a[List[_]]
  all(remainingCharacters.flatMap(_.facialHair)) shouldBe PersonWithFacialHair(true)
}

"Board" should "handle name guess correctly" in {
  val characters = CharacterManager.createCharacters()
  val selectedCharacter = characters.head
  val board = new Board(characters, selectedCharacter)
  val remainingCharacters = board.handleQuestion("name", Left(selectedCharacter.name.toLowerCase()), characters)
  board.checkWinCondition(remainingCharacters) should be(true)
}