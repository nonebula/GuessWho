package GuessWhoGame

import org.scalatest.flatspec.FlatSpec
import org.scalatest.matchers.should.Matchers._

class CharacterSpec extends FlatSpec {
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

  "Character" should "initialise with 20 characters on the board" in {
    val game = new GuessWhoGame(characters)
    game.getRemainingCharacters.size shouldEqual 20
  }

  "GuessWhoGame" should "eliminate characters correctly based on questions" in {
    val game = new GuessWhoGame(characters)
    game.askQuestion(_.gender == "male")
    game.getRemainingCharacters.forall(_.gender == "male") shouldBe true
  }

  it should "check win condition correctly" in {
    val game = new GuessWhoGame(characters)
    while (game.getRemainingCharacters.size > 1) {
      game.askQuestion(_.gender == "male") // adjust questions as needed
    }
    game.checkWinCondition shouldBe true
  }
}
