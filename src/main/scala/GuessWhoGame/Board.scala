package GuessWhoGame

import scala.util.Random
import GuessWhoGame.character._

//values could be more domain specific, name/selecting could be within character case class, then able to test separately
class Board(val characters: List[Character], val selectedCharacter: Character) {
  def printCharacterNames(): List[String] = {
    //    characters.foreach(Character => println(Character.name))
    characters.map(_.name)
  }

  //  val selectedCharacter: Character = selectRandomCharacter(characters)
  //  var remainingCharacters: List[Character] = characters

  def printRemainingCharacters(remainingCharacters: List[Character]): Unit = {
    //    remainingCharacters.foreach(Character => println(Character.name))
    remainingCharacters.map(_.name)
  }

  def getRemainingCharacters(remainingCharacters: List[Character]): List[Character] = remainingCharacters

  def checkWinCondition(remainingCharacters: List[Character]): Boolean = remainingCharacters.size == 1

  def selectRandomCharacter(characters: List[Character]): Character = {
    characters(Random.nextInt(characters.size))
  }

  //  //Testing purposes
  //  def getSelectedCharacter: Character = selectedCharacter
  //
  //  def printSelectedCharacter(): Unit = {
  //    println(selectedCharacter.name)
  //  }


  //Future development
  //  def resetBoard(): Unit = {
  //    remainingCharacters = characters
  //  }

  //  def eliminateCharacter(character: Character): Unit = {
  //    var remainingCharacters = characters.filterNot(_ == character)
  //  }

  def handleQuestion(attribute: String, value: Either[String, Boolean], remainingCharacters: List[Character]): List[Character] = {
    attribute match {
      case "name" => filterByName(value, remainingCharacters)
      case "gender" => filterByGender(value, remainingCharacters)
      case "hairColor" => filterByHairColor(value, remainingCharacters)
      case "eyeColor" => filterByEyeColor(value, remainingCharacters)
      case "wearsGlasses" => filterByWearGlasses(value, remainingCharacters)
      case "hasFacialHair" => filterByFacialHair(value, remainingCharacters)
      case _ =>
        println("Invalid attribute. Try again.")
        remainingCharacters
    }
  }

  private def filterByName(value: Either[String, Boolean], remainingCharacters: List[Character]): List[Character] = {
    value match {
      case Left(name) => remainingCharacters.filter(_.name == name)
      case _ =>
        println("Invalid name value added. Try again.")
        remainingCharacters
    }
  }

  private def filterByGender(value: Either[String, Boolean], remainingCharacters: List[Character]): List[Character] = {
    value match {
      case Left(gender) => remainingCharacters.filter(_.gender.toString == gender)
      case _ =>
        println("Invalid gender value added. Try again.")
        remainingCharacters
    }
  }

  private def filterByHairColor(value: Either[String, Boolean], remainingCharacters: List[Character]): List[Character] = {
    value match {
      case Left(hairColor) => remainingCharacters.filter(_.hairColor.toString == hairColor)
      case _ =>
        println("Invalid hair color value added. Try again.")
        remainingCharacters
    }
  }

  private def filterByEyeColor(value: Either[String, Boolean], remainingCharacters: List[Character]): List[Character] = {
    value match {
      case Left(eyeColor) => remainingCharacters.filter(_.eyeColor.toString == eyeColor)
      case _ =>
        println("Invalid eye color value added. Try again.")
        remainingCharacters
    }
  }

  private def filterByWearGlasses(value: Either[String, Boolean], remainingCharacters: List[Character]): List[Character] = {
    value match {
      case Right(wearsGlasses) => remainingCharacters.filter(_.wearsGlasses.exists(_.value == wearsGlasses))
      case _ =>
        println("Invalid glasses value added. Try again.")
        remainingCharacters
    }
  }

  private def filterByFacialHair(value: Either[String, Boolean], remainingCharacters: List[Character]): List[Character] = {
    value match {
      case Right(facialHair) => remainingCharacters.filter(_.facialHair.exists(_.value == facialHair))
      case _ =>
        println("Invalid facial hair value added. Try again.")
        remainingCharacters
    }
  }

}