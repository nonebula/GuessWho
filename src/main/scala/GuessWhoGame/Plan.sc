/**
   1. Classes, Case Classes, Traits

  Classes and Case Classes for character representation
  (name: String, gender: String, hairColour: String (hasHair - potential trait), eyeColour: String, wearing Glasses: Boolean,
   facialHair: Boolean)
  Attributes of each character - gender, hairColour etc

   // Define GuessWhoGame.Character class
   case class GuessWhoGame.Character(name: String, gender: String, hairColor: String, eyeColor: String)

   // Define Game class
   class GuessWhoGame(characters: List[GuessWhoGame.Character]) {

  2. Trait for game logic - random character selection
 Method for random selection - private val

  3. Questions and Answers
  Method for Yes/No questions - boolean
  Use List to show characters - after each question characters are removed

  if correct character guessed = end the game (endGameMethod)
  if not correct character = new list is generated and game continues

  4. TDD
  - Write tests for each part of the logic
  - Test character creation with attributes
  - Test random selection
  - Test Yes/No Questions
  - Test state changes of the board after each questions
  - Test conditions in which the game ends


  Game will end when the correct character is guessed

  FIND THE LESSON WHERE EXTENSION WAS TALKING TO THE TERMINAL

  Last Step - ReadMe file

 //Game end method?
 //  def gameEnd: Boolean = remainingCharacters.size == 1

 //Reveal secret character (only to support testing)
 //  def revealSecretCharacter: GuessWhoGame.Character = selectedCharacter



 //First thing Monday:
 //Make sure the selected character is being selected
 //Make sure the selected character is still represented on the game board
 //Take input questions
 //Amend list based on input questions
 //Triggering end result

 //4. TDD
 //- Write tests for each part of the logic
 //- Test character creation with attributes
 //- Test random selection
 //- Test Yes/No Questions
 //- Test state changes of the board after each questions
 //- Test conditions in which the game ends

