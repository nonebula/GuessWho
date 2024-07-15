package GuessWhoGame
import scala.util.Random

object Game extends App {

  val char1: Character = Character("joe", "male", "brown", "blue", wearsGlasses = false, facialHair = false)
  val char2: Character = Character("muhammad", "male", "black", "brown", wearsGlasses = true, facialHair = true)
  val char3: Character = Character("april", "female", "blonde", "blue", wearsGlasses = true, facialHair = false)
  val char4: Character = Character("sally", "female", "blue", "green", wearsGlasses = true, facialHair = true)
  val char5: Character = Character("spencer", "male", "brown", "brown", wearsGlasses = false, facialHair = true)
  val char6: Character = Character("gemma", "female", "ginger", "Blue", wearsGlasses = true, facialHair = false)
  val char7: Character = Character("jamie", "male", "none", "green", wearsGlasses = true, facialHair = true)
  val char8: Character = Character("jessica", "female", "green", "green", wearsGlasses = false, facialHair = false)
  val char9: Character = Character("bilal", "male", "brown", "green", wearsGlasses = false, facialHair = true)
  val char10: Character = Character("lisa", "female", "black", "brown", wearsGlasses = true, facialHair = false)
  val char11: Character = Character("tom", "male", "brown", "blue", wearsGlasses = true, facialHair = false)
  val char12: Character = Character("cheryl", "female", "blonde", "green", wearsGlasses = false, facialHair = false)
  val char13: Character = Character("arei", "male", "brown", "brown", wearsGlasses = false, facialHair = true)
  val char14: Character = Character("kelly", "female", "none", "green", wearsGlasses = false, facialHair = false)
  val char15: Character = Character("tayamul", "male", "brown", "blue", wearsGlasses = false, facialHair = false)
  val char16: Character = Character("elaine", "female", "ginger", "blue", wearsGlasses = false, facialHair = true)
  val char17: Character = Character("roshan", "male", "brown", "blue", wearsGlasses = true, facialHair = false)
  val char18: Character = Character("patricia", "female", "purple", "yellow", wearsGlasses = false, facialHair = false)
  val char19: Character = Character("dave", "male", "none", "yellow", wearsGlasses = false, facialHair = false)
  val char20: Character = Character("bobbiana", "female", "Brown", "Blue", wearsGlasses = true, facialHair = false)

  var gameBoard = Board(List(char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13, char14, char15, char16, char17, char18, char19, char20))

  gameBoard.printCharacterNames()




  //Run example of the game
  //Call methods

  /** game start - random character selected (private), characterlist printed to screen
   * yes / no question asked
   * list filtered based on fulfilment of criteria
   * list reprinted to screen
   * loop through all options, filtering and reprinting each time
   * trigger game end when length of list is 1 ------- could end anytime, defined/earlier in code
   * */



//  case class GuessWhoGame.Character(
//                        name: String,
//                        gender: String,
//                        hairColor: String,
//                        eyeColor: String,
//                        wearsGlasses: Boolean,
//                        facialHair: Boolean
//                      )









}




//package Week2.Monday.AfternoonTaskSolution
//
//object Sanctuary extends App {
//
//  def feedAnimal(animal: Animal) = println(s"You fed ${animal.name} some ${animal.dietType.eats}!")
//
//  val hedwigTheSnowyOwl = new Owl("Hedwig", "Snowy Owl", 8, 2, "White", 150)
//  val pumbaTheWarthog  = new Warthog("Pumbaa", "Common Warthog", 4, "Brown", true)
//  val jeffTheDragonfly  = new Dragonfly("Jeff", "Blue Eyed Darner", 1, 12, 10, 1)
//
//  feedAnimal(hedwigTheSnowyOwl)
//
//}

