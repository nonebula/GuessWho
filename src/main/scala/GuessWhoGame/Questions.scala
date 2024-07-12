class Questions {
  def askQuestion(attribute: String, value: Either[String, Boolean]): Unit = {
    attribute match {
      case "name" =>
        if (selectedCharacter.name == value) remainingCharacters.filter(_.name == value) // game end here!
        else remainingCharacters = remainingCharacters.filterNot(_.name == value)
        //trigger game end
      case "gender" =>
        if (selectedCharacter.gender == value) remainingCharacters.filter(_.gender == value)
        else remainingCharacters = remainingCharacters.filterNot(_.gender == value)
      case "hairColor" =>
        if (selectedCharacter.hairColor == value) remainingCharacters.filter(_.hairColor == value)
        else remainingCharacters = remainingCharacters.filterNot(_.hairColor == value)
      case "eyeColor" =>
        if (selectedCharacter.eyeColor == value) remainingCharacters.filter(_.eyeColor == value)
        else remainingCharacters = remainingCharacters.filterNot(_.eyeColor == value)
      case "wearsGlasses" =>
        if (selectedCharacter.wearsGlasses == value) remainingCharacters.filter(_.wearsGlasses == value)
        else remainingCharacters = remainingCharacters.filterNot(_.wearsGlasses == value)
      case "hasFacialHair" =>
        if (selectedCharacter.hasFacialHair == value) remainingCharacters.filter(_.hasFacialHair == value)
        else remainingCharacters = remainingCharacters.filterNot(_.hasFacialHair == value)

      //need for an error case here??
    }
  }
}
