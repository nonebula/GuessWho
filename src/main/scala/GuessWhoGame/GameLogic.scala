package GuessWhoGame

import scala.util.Random

class GameLogic (board: Board) {

}



//Not touched yet
//  def askQuestion(question: Character => Boolean): Boolean = {
//    val answer = question(selectedCharacter)
//    board.getRemainingCharacters.foreach { character =>
//      if (question(character) != answer) board.eliminateCharacter(character)
//    }
//    answer
//
//    // The askQuestion method should take a function as a parameter
//    def askQuestion(question: Character => Boolean): Boolean = {
//      val answer = question(selectedCharacter)
//      board.getRemainingCharacters.foreach { character =>
//        if (question(character) != answer) board.eliminateCharacter(character)
//
//      }
//      answer
//    }