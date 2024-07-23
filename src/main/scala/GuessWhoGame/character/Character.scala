package GuessWhoGame.character

import GuessWhoGame.character.Gender._
import GuessWhoGame.character.HairColor._
import GuessWhoGame.character.EyeColor._
import GuessWhoGame.character.PersonWithGlasses._
import GuessWhoGame.character.PersonWithFacialHair._


case class Character(name: String, gender: Gender, hairColor: HairColor, eyeColor: EyeColor, wearsGlasses: Option[PersonWithGlasses], facialHair: Option[PersonWithFacialHair])

