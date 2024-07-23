package GuessWhoGame.character

object CharacterManager {

  import GuessWhoGame.character._

  def createCharacters(): List[Character] = {
    List(
      Character("Joe", Gender.Male, HairColor.Brown, EyeColor.Blue, None, None),
      Character("Muhammad", Gender.Male, HairColor.Black, EyeColor.Blue, Some(PersonWithGlasses(true)), Some(PersonWithFacialHair(true))),
      Character("April", Gender.Female, HairColor.Blonde, EyeColor.Blue, Some(PersonWithGlasses(true)), None),
      Character("Sally", Gender.Female, HairColor.Blue, EyeColor.Green, Some(PersonWithGlasses(true)), Some(PersonWithFacialHair(true))),
      Character("Spencer", Gender.Male, HairColor.Blue, EyeColor.Blue, None, Some(PersonWithFacialHair(true))),
      Character("Gemma", Gender.Female, HairColor.Red, EyeColor.Blue, Some(PersonWithGlasses(true)), None),
      Character("Jamie", Gender.Male, HairColor.None, EyeColor.Green, Some(PersonWithGlasses(true)), Some(PersonWithFacialHair(true))),
      Character("Jessica", Gender.Female, HairColor.Green, EyeColor.Green, None, None),
      Character("Bilal", Gender.Male, HairColor.Blue, EyeColor.Green, None, Some(PersonWithFacialHair(true))),
      Character("Lisa", Gender.Female, HairColor.Black, EyeColor.Blue, Some(PersonWithGlasses(true)), None),
      Character("Tom", Gender.Male, HairColor.Blue, EyeColor.Blue, Some(PersonWithGlasses(true)), None),
      Character("Cheryl", Gender.Female, HairColor.Blonde, EyeColor.Green, None, None),
      Character("Arei", Gender.Male, HairColor.Blue, EyeColor.Blue, None, Some(PersonWithFacialHair(true))),
      Character("Kelly", Gender.Female, HairColor.None, EyeColor.Green, None, None),
      Character("Tayamul", Gender.Male, HairColor.Blue, EyeColor.Blue, None, None),
      Character("Elaine", Gender.Female, HairColor.Red, EyeColor.Blue, None, Some(PersonWithFacialHair(true))),
      Character("Roshan", Gender.Male, HairColor.Blue, EyeColor.Blue, Some(PersonWithGlasses(true)), None),
      Character("Patricia", Gender.Female, HairColor.Purple, EyeColor.Yellow, None, None),
      Character("Dave", Gender.Male, HairColor.None, EyeColor.Yellow, None, None),
      Character("Bobbiana", Gender.Female, HairColor.Blue, EyeColor.Blue, Some(PersonWithGlasses(true)), None)
    )
  }

}
