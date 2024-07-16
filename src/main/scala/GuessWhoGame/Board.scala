package GuessWhoGame

import scala.util.Random

case class Board(characters: List[Character]) {
  def printCharacterNames(): Unit = {
    characters.foreach(Character => println(Character.name))
  }

  val selectedCharacter: Character = selectRandomCharacter(characters)
  var remainingCharacters: List[Character] = characters

  def printRemainingCharacters(): Unit = {
    remainingCharacters.foreach(Character => println(Character.name))
  }

  def selectRandomCharacter(characters: List[Character]): Character = {
    characters(Random.nextInt(characters.size))
  }

  //Testing purposes
  def getSelectedCharacter: Character = selectedCharacter

  def printSelectedCharacter(): Unit = {
    println(selectedCharacter.name)
  }

  def getRemainingCharacters: List[Character] = remainingCharacters

  def checkWinCondition: Boolean = getRemainingCharacters.size == 1

  //Future development
  //  def resetBoard(): Unit = {
  //    remainingCharacters = characters
  //  }

  //  def eliminateCharacter(character: Character): Unit = {
  //    var remainingCharacters = characters.filterNot(_ == character)
  //  }

  def handleQuestion(attribute: String, value: Either[String, Boolean]): Unit = {
    remainingCharacters = attribute match {
      case "name" =>
        value match {
          case Left(value) =>
            if (selectedCharacter.name == value) {
              remainingCharacters.filter(_.name == value)
            } else {
              remainingCharacters.filterNot(_.name == value)
            }
          case _ => println("Invalid name value added. Try again")
            remainingCharacters
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
            remainingCharacters
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
            remainingCharacters
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
            remainingCharacters
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
            remainingCharacters
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
            remainingCharacters
        }
    }
  }
}