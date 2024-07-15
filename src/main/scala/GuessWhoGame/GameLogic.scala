package GuessWhoGame

import scala.util.Random

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



//Not touched yet
  def askQuestion(question: Character => Boolean): Boolean = {
    val answer = question(selectedCharacter)
    board.getRemainingCharacters.foreach { character =>
      if (question(character) != answer) board.eliminateCharacter(character)
    }
    answer

    // The askQuestion method should take a function as a parameter
    def askQuestion(question: Character => Boolean): Boolean = {
      val answer = question(selectedCharacter)
      board.getRemainingCharacters.foreach { character =>
        if (question(character) != answer) board.eliminateCharacter(character)

      }
      answer
    }

    def checkWinCondition: Boolean = board.getRemainingCharacters.size == 1

    def getSelectedCharacter: Character = selectedCharacter

    def getRemainingCharacters: List[Character] = board.getRemainingCharacters
  }
}