package GuessWhoGame

import scala.util.Random
import GuessWhoGame.character._

class Board(val characters: List[Character], val selectedCharacter: Character) {
  def printCharacterNames(): List[String] = {
    characters.map(_.name)
  }

  def printRemainingCharacters(remainingCharacters: List[Character]): List[String] = {
    remainingCharacters.map(_.name)
  }

  def getRemainingCharacters(remainingCharacters: List[Character]): List[Character] = remainingCharacters

  def checkWinCondition(remainingCharacters: List[Character]): Boolean = remainingCharacters.size == 1

  def handleQuestion(attribute: String, value: Either[String, Boolean], remainingCharacters: List[Character]): List[Character] = {
    attribute match {
      case "name" => filterByName(value, remainingCharacters)
      case "gender" => filterByGender(value, remainingCharacters)
      case "haircolor" => filterByHairColor(value, remainingCharacters)
      case "eyecolor" => filterByEyeColor(value, remainingCharacters)
      case "wearsglasses" => filterByWearGlasses(value, remainingCharacters)
      case "hasfacialhair" => filterByFacialHair(value, remainingCharacters)
      case _ =>
        println("Invalid attribute. Try again.")
        remainingCharacters
    }
  }

  def filterByName(value: Either[String, Boolean], remainingCharacters: List[Character]): List[Character] = {
    value match {
      case Left(name) => remainingCharacters.filter(_.name.equalsIgnoreCase(name))
      case _ => remainingCharacters
    }
  }

  def filterByGender(value: Either[String, Boolean], remainingCharacters: List[Character]): List[Character] = {
    value match {
      case Left(gender) => remainingCharacters.filter(_.gender.toString.equalsIgnoreCase(gender))
      case _ => remainingCharacters
    }
  }

  def filterByHairColor(value: Either[String, Boolean], remainingCharacters: List[Character]): List[Character] = {
    value match {
      case Left(hairColor) => remainingCharacters.filter(_.hairColor.toString.equalsIgnoreCase(hairColor))
      case _ => remainingCharacters
    }
  }

  def filterByEyeColor(value: Either[String, Boolean], remainingCharacters: List[Character]): List[Character] = {
    value match {
      case Left(eyeColor) => remainingCharacters.filter(_.eyeColor.toString.equalsIgnoreCase(eyeColor))
      case _ => remainingCharacters
    }
  }

  def filterByWearGlasses(value: Either[String, Boolean], remainingCharacters: List[Character]): List[Character] = {
    value match {
      case Right(wearsGlasses) => remainingCharacters.filter(_.wearsGlasses.exists(_.value == wearsGlasses))
      case _ => remainingCharacters
    }
  }

  def filterByFacialHair(value: Either[String, Boolean], remainingCharacters: List[Character]): List[Character] = {
    value match {
      case Right(facialHair) => remainingCharacters.filter(_.facialHair.exists(_.value == facialHair))
      case _ => remainingCharacters
    }
  }
}