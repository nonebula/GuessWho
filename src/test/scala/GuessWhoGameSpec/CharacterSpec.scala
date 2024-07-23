import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._
import GuessWhoGame.character._
import GuessWhoGame.Board

class CharacterSpec extends AnyFlatSpec {

  // Test data for individual characters
  val Joe = Character("Joe", Gender.Male, HairColor.Brown, EyeColor.Blue, None, None)
  val Muhammad = Character("Muhammad", Gender.Male, HairColor.Black, EyeColor.Brown, Some(PersonWithGlasses(true)), Some(PersonWithFacialHair(true)))
  val April = Character("April", Gender.Female, HairColor.Blonde, EyeColor.Blue, Some(PersonWithGlasses(true)), None)
  val Sally = Character("Sally", Gender.Female, HairColor.Blue, EyeColor.Green, Some(PersonWithGlasses(true)), Some(PersonWithFacialHair(true)))
  val Gemma = Character("Gemma", Gender.Female, HairColor.Red, EyeColor.Blue, Some(PersonWithGlasses(true)), None)

  "Board" should "initialise correctly with Joe" in {
    val board = new Board(List(Joe), Joe)
    board.characters should contain theSameElementsAs List(Joe)
    board.selectedCharacter shouldBe Joe
  }

  "Board" should "initialise correctly with Muhammad" in {
    val board = new Board(List(Muhammad), Muhammad)
    board.characters should contain theSameElementsAs List(Muhammad)
    board.selectedCharacter shouldBe Muhammad
  }

  "Board" should "initialise correctly with April" in {
    val board = new Board(List(April), April)
    board.characters should contain theSameElementsAs List(April)
    board.selectedCharacter shouldBe April
  }

  "Board" should "initialise correctly with Sally" in {
    val board = new Board(List(Sally), Sally)
    board.characters should contain theSameElementsAs List(Sally)
    board.selectedCharacter shouldBe Sally
  }

  "Board" should "initialise correctly with Gemma" in {
    val board = new Board(List(Gemma), Gemma)
    board.characters should contain theSameElementsAs List(Gemma)
    board.selectedCharacter shouldBe Gemma
  }
}