package GuessWhoGame

import scala.util.Random
import scala.io.StdIn
import GuessWhoGame.character._
import scala.annotation.tailrec

object Game extends App {

  def createGameBoard(): Board = {
    val characters = CharacterManager.createCharacters()
    val selectedCharacter = CharacterManager.selectRandomCharacter(characters)
    new Board(characters, selectedCharacter)
  }

  def startGame(board: Board): Unit = {
    println("Welcome to the Guess Who game!")
    println("Try to guess the character by asking some questions...")
    println("Available characters:")
    board.printCharacterNames().foreach(println)

    @tailrec
    def playGame(remainingCharacters: List[Character]): Unit = {
      if (board.checkWinCondition(remainingCharacters)) {
        println(s"\nCongratulations, You guessed correctly. The character was ${board.selectedCharacter.name}.")
      } else {
        println("\nRemaining Characters:")
        board.printRemainingCharacters(remainingCharacters).foreach(println)

        val newRemainingCharacters = askQuestion(remainingCharacters)
        playGame(newRemainingCharacters)
      }
    }

    def askQuestion(remainingCharacters: List[Character]): List[Character] = {
      println("\nEnter an attribute (hairColor, eyeColor, gender, wearsGlasses, hasFacialHair) to guess or 'name' to guess the character:")
      val attribute = StdIn.readLine().toLowerCase()
      attribute match {
        case "haircolor" =>
          println("Enter the hair color:")
          val hairColor = StdIn.readLine().toLowerCase()
          board.handleQuestion(attribute, Left(hairColor), remainingCharacters)
        case "eyecolor" =>
          println("Enter the eye color:")
          val eyeColor = StdIn.readLine().toLowerCase()
          board.handleQuestion(attribute, Left(eyeColor), remainingCharacters)
        case "gender" =>
          println("Enter the gender (male/female):")
          val gender = StdIn.readLine().toLowerCase()
          board.handleQuestion(attribute, Left(gender), remainingCharacters)
        case "wearsglasses" =>
          println("Does the character wear glasses? (true/false):")
          val wearsGlasses = StdIn.readLine().toLowerCase().toBoolean
          board.handleQuestion(attribute, Right(wearsGlasses), remainingCharacters)
        case "hasfacialhair" =>
          println("Does the character have facial hair? (true/false):")
          val hasFacialHair = StdIn.readLine().toLowerCase().toBoolean
          board.handleQuestion(attribute, Right(hasFacialHair), remainingCharacters)
        case "name" =>
          println("Enter the name of the character:")
          val name = StdIn.readLine().toLowerCase()
          val newRemainingCharacters = board.handleQuestion(attribute, Left(name), remainingCharacters)
          if (board.checkWinCondition(newRemainingCharacters) && board.selectedCharacter.name.equalsIgnoreCase(name)) {
            println(s"\nCongratulations, You guessed correctly. The character was ${board.selectedCharacter.name}.")
          } else {
            println(s"\nGame over, you guessed incorrectly. The character was ${board.selectedCharacter.name}.")
          }
          newRemainingCharacters
        case _ =>
          println("Invalid attribute. Try again.")
          remainingCharacters
      }
    }

    @tailrec
    def replayOrExit(): Unit = {
      println("\nDo you want to play again? (yes/no)")
      val playAgain = StdIn.readLine().toLowerCase()
      playAgain match {
        case "yes" | "y" =>
          println("Starting a new game...")
          val newBoard = createGameBoard()
          startGame(newBoard)
        case "no" | "n" =>
          println("Thanks for playing Guess Who!")
        case _ =>
          println("Invalid response. Please type 'yes' or 'no'.")
          replayOrExit()
      }
    }

    playGame(board.characters)
    replayOrExit()
  }

  val initialBoard = createGameBoard()
  startGame(initialBoard)
}
