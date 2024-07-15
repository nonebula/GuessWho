class Questions {
  def handleQuestion(attribute: String, value: Either[String, Boolean]): Unit = {
    attribute match {
      case "name" =>
        value match {
          case Left(value) =>
            if (selectedCharacter.name == value) {
              remainingCharacters.filter(_.name == value) // game end here!
              endGame()
            } else {
              remainingCharacters = remainingCharacters.filterNot(_.name == value)
            }
          case _ => println("Invalid name value added. Try again")
        }
      case "gender" =>
        value match {
          case Left(value) =>
            if (selectedCharacter.gender == value) {
              remainingCharacters.filter(_.gender == value)
            } else {
              remainingCharacters = remainingCharacters.filterNot(_.gender == value)
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
              remainingCharacters = remainingCharacters.filterNot(_.hairColor == value)
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
              remainingCharacters = remainingCharacters.filterNot(_.eyeColor == value)
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
              remainingCharacters = remainingCharacters.filterNot(_.wearsGlasses == value)
            }
          case _ => println("Invalid glasses value added. Try again")
        }
      case "hasFacialHair" =>
        value match {
          case Right(value) =>
            if (selectedCharacter.hasFacialHair == value) {
              remainingCharacters.filter(_.hasFacialHair == value)
            }
            else {
              remainingCharacters = remainingCharacters.filterNot(_.hasFacialHair == value)
            }
          case _ => println("Invalid facial hair value added. Try again")
        }

    }
  }
}