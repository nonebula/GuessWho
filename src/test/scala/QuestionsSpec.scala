import org.scalatest.FlatSpec

/**
 //naming convention: same as file with spec at the end
 class TwoNumbersSpec extends FlatSpec{
 "add" should "add numbers" in {         //method name and expected functionality
 val nums = new TwoNumbers(1,2)
 assert(nums.add==3)                   //block of code that performs the test, assert is keyword (this and line above)
 }                                       //assert gives Boolean value, must evaluate 'true' for test to pass,
 }                                         //however sometimes we want it to fail.
 */

class QuestionsSpec extends FlatSpec{

}



//class Questions {
//  def askQuestion(attribute: String, value: Either[String, Boolean]): Unit = {
//    attribute match {
//      case "name" =>
//        if (selectedCharacter.name == value) remainingCharacters.filter(_.name == value) // game end here!
//        else remainingCharacters = remainingCharacters.filterNot(_.name == value)
//      //trigger game end
//      case "gender" =>
//        if (selectedCharacter.gender == value) remainingCharacters.filter(_.gender == value)
//        else remainingCharacters = remainingCharacters.filterNot(_.gender == value)
//      case "hairColor" =>
//        if (selectedCharacter.hairColor == value) remainingCharacters.filter(_.hairColor == value)
//        else remainingCharacters = remainingCharacters.filterNot(_.hairColor == value)
//      case "eyeColor" =>
//        if (selectedCharacter.eyeColor == value) remainingCharacters.filter(_.eyeColor == value)
//        else remainingCharacters = remainingCharacters.filterNot(_.eyeColor == value)
//      case "wearsGlasses" =>
//        if (selectedCharacter.wearsGlasses == value) remainingCharacters.filter(_.wearsGlasses == value)
//        else remainingCharacters = remainingCharacters.filterNot(_.wearsGlasses == value)
//      case "hasFacialHair" =>
//        if (selectedCharacter.hasFacialHair == value) remainingCharacters.filter(_.hasFacialHair == value)
//        else remainingCharacters = remainingCharacters.filterNot(_.hasFacialHair == value)
//
//      //need for an error case here??
//    }
//  }
//}
