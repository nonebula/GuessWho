# Guess Who? Game
Remember the children’s game Guess Who?

You select a character, and your opponent tries to guess who it is
using yes or no questions only. They eliminate characters, until only
one remains.

Well, this is a basic backend implementation of the "Guess Who?" game in Scala.

## How to Run
1. Clone the repository.
2. Navigate to the project directory.
3. Run `sbt test` to execute the tests.

## How to Play
- The computer randomly selects a character at the start of the game.
- Ask yes/no questions about character attributes to eliminate characters. The options for this are:
      - name is ____
      - gender is [male/female]
      - hair color is [black, brown, grey, white, blue, green, blonde, none]
      - eye color is [blue, brown, green, grey, yellow]
      - wears glasses / does not wear glasses
      - has facial hair / does not have facial hair
- The game ends when only one character remains.

## Author
Joe Higgs & Muhammad Mulla

## License
This project is licensed under the MIT License.
