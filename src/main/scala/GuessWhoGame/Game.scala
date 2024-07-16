package GuessWhoGame

import scala.util.Random
import scala.io.StdIn

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

  def startGame(): Unit = {
    gameBoard.printCharacterNames()

    //Building out game to terminal
    println("Welcome to the Guess Who game!")
    println("Try to guess the character by asking some questions...")

    playGame()

    println("\nDo you want to play again? (yes/no)")
    val playAgain = scala.io.StdIn.readLine().toLowerCase()
    if (playAgain == "yes" || playAgain == "y") {
      gameBoard = Board(List(char1, char2, char3, char4, char5, char6, char7, char8, char9, char10, char11, char12, char13, char14, char15, char16, char17, char18, char19, char20))
      startGame()
    } else {
      println("Thanks for playing Guess Who!")
    }
  }

  //Game loop
  def playGame(): Unit = {
    while (!gameBoard.checkWinCondition) {
      println("\nRemaining characters:")
      gameBoard.printRemainingCharacters()

      println("\nEnter a hair colour that you want to guess:")
      val hairInput = scala.io.StdIn.readLine().toLowerCase()
      gameBoard.handleQuestion("hairColor", Left(hairInput))

      println("\nRemaining characters:")
      gameBoard.printRemainingCharacters()

      println("\nEnter an eye colour that you want to guess:")
      val eyeInput = scala.io.StdIn.readLine().toLowerCase()
      gameBoard.handleQuestion("eyeColor", Left(eyeInput))

      println("\nRemaining characters:")
      gameBoard.printRemainingCharacters()

      println("\nEnter a gender that you want to guess (male/female):")
      val genderInput = scala.io.StdIn.readLine().toLowerCase()
      gameBoard.handleQuestion("gender", Left(genderInput))

      println("\nRemaining characters:")
      gameBoard.printRemainingCharacters()

      if (!gameBoard.checkWinCondition) {
        println("\nEnter a name that you want to guess:")
        val nameInput = scala.io.StdIn.readLine().toLowerCase()
        gameBoard.handleQuestion("name", Left(nameInput))

        if (gameBoard.checkWinCondition && gameBoard.getSelectedCharacter.name == (nameInput)) {
          println(s"\nCongratulations, You guessed correctly. The character was ${gameBoard.getSelectedCharacter.name}.")
        } else {
          println(s"\nGame over, you guessed incorrectly. The character was ${gameBoard.getSelectedCharacter.name}.")
        }
      }
    }
  }

  startGame()
}

