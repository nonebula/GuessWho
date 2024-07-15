package GuessWhoGame

//full list of characters
//printed to user
//calling the list filter function
//reprinting to adaptations

class GameBoard(val characters: List[Character]) {
  private var remainingCharacters: List[Character] = characters

  def getRemainingCharacters: List[Character] = remainingCharacters



  def resetBoard(): Unit = {
    remainingCharacters = characters
  }
}