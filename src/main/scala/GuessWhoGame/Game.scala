package GuessWhoGame

import scala.util.Random
import scala.io.StdIn

object Game extends App {
  //stored cases for all different types are allowed - certain restricted numbers of colours etc that could be stored and matched
  object Characters extends Enumeration

  //would remain the same throughout
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

