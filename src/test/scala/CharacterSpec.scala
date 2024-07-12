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


class CharacterSpec extends FlatSpec{
  "Character" should "contain correct types" in {
    Character
//    Character ("joe", "male", "brown", "blue", wearsGlasses = false, facialHair = false)
  }
}
