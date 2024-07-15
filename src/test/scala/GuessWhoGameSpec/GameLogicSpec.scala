package GuessWhoGameSpec

import GuessWhoGame._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class GuessWhoGameSpec extends AnyFlatSpec {

  val characters = List(
    Character("joe", "male", "brown", "blue", wearsGlasses = false, facialHair = false),
    Character("muhammad", "male", "black", "brown", wearsGlasses = true, facialHair = true),
    Character("april", "female", "blonde", "blue", wearsGlasses = true, facialHair = false)
  )
}




