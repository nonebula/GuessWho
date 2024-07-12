import org.scalatest.FlatSpec

class CharacterSpec extends FlatSpec {
  "GuessWhoGame.Character" should "initialise with 20 characters on the board" in {
    val totalChars = Characters.size
    assert(GuessWhoGame.gameBoard.size == 20)
  }
}
