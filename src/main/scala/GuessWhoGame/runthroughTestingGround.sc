import scala.util.Random

case class Character(val name: String, val gender: String, val hairColor: String, val eyeColor: String, val wearsGlasses: Boolean, val facialHair: Boolean)

case class Board (characters: List[Character]) {
  def printCharacterNames(): Unit = {
    characters.foreach(Character => println(Character.name))
  }
}

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

//working so far

class GameLogic (board: Board) {
  private val selectedCharacter: Character = selectRandomCharacter(board.characters)
  private var remainingCharacters: List[Character] = board.characters

  private def selectRandomCharacter(characters: List[Character]): Character = {
    characters(Random.nextInt(characters.size))
  }

  def getSelectedCharacter: Character = selectedCharacter

  //Testing only, delete once game running clearly
  def printSelectedCharacter(): Unit = {
    println(selectedCharacter.name)
  }
  //ABOVE = TESTING ONLY

  def handleQuestion(attribute: String, value: Either[String, Boolean]): Unit = {
    attribute match {
      case "name" =>
        value match {
          case Left(value) =>
            if (selectedCharacter.name == value) {
              remainingCharacters.filter(_.name == value)
              //endGame()
            } else {
              remainingCharacters.filterNot(_.name == value)
            }
          case _ => println("Invalid name value added. Try again")
        }
      case "gender" =>
        value match {
          case Left(value) =>
            if (selectedCharacter.gender == value) {
              remainingCharacters.filter(_.gender == value)
            } else {
              remainingCharacters.filterNot(_.gender == value)
            }
          case _ => println("Invalid gender value added. Try again")
        }
      case "hairColor" =>
        value match {
          case Left(value) =>
            if (selectedCharacter.hairColor == value) {
              remainingCharacters.filter(_.hairColor == value)
            }
            else {
              remainingCharacters.filterNot(_.hairColor == value)
            }
          case _ => println("Invalid hair colour value added. Try again")
        }
      case "eyeColor" =>
        value match {
          case Left(value) =>
            if (selectedCharacter.eyeColor == value) {
              remainingCharacters.filter(_.eyeColor == value)
            }
            else {
              remainingCharacters.filterNot(_.eyeColor == value)
            }
          case _ => println("Invalid eye colour value added. Try again")
        }
      case "wearsGlasses" =>
        value match {
          case Right(value) =>
            if (selectedCharacter.wearsGlasses == value) {
              remainingCharacters.filter(_.wearsGlasses == value)
            }
            else {
              remainingCharacters.filterNot(_.wearsGlasses == value)
            }
          case _ => println("Invalid glasses value added. Try again")
        }
      case "hasFacialHair" =>
        value match {
          case Right(value) =>
            if (selectedCharacter.facialHair == value) {
              remainingCharacters.filter(_.facialHair == value)
            }
            else {
              remainingCharacters.filterNot(_.facialHair == value)
            }
          case _ => println("Invalid facial hair value added. Try again")
        }
        handleQuestion("hairColor", Left("brown"))
        handleQuestion("wearsGlasses", Right(true))
        handleQuestion("name", Left("joe"))
    }
  }

}

//TESTING IN RUNTHROUGH ONLY
val gameLogic = new GameLogic(gameBoard)
gameLogic.printSelectedCharacter()
//DON'T ADD TO CLASS //ADD TO GAME WITHOUT PRINTSELECTEDCHARACTER

