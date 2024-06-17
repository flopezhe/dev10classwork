## Assessment 2 
## Requirements
### JUNIT testing
- No new tests are required but should pass all current tests
### One class beyond App is required
- theSetUp folder(Maybe Controller name?)
  - ControlGomoku class(bad name??)
    - Will input the set up here importing learn.gomoku package
    - Will call the other classes in here
    - Set up methods for scanner input on selection (option 1 or option 2 below)
    - Set up methods for implementation of actual game and selections/result 
### You may not change existing classes except for App
- All rules are modeled inside the Gomoku class. You may not modify Gomoku, Player, HumanPlayer, RandomPlayer, Stone, or Result.
### A win or a tie must happen
- 5 in a row == win, can never win with more than 5(ex 6 in a row)Win ==false but not lose(game continues)

### Can Set Up two players
- Print 2 options, Scanner input required for user to select from options
- Can be a mix of any of the 2 options. Ex(option 1, option 2)(option 1, option 1)(option 2, option2)??
  - Option 1, human player. This allows user(s) to input their own moves.
    - Use Human Player Class in players package?folder?
    - Human player scanner input name (String first, String last)
    - Can fail
      - Reprompt user(s) their move until valid
    - Use players name to ask questions??
      - Does this mean "Name's turn, what row and column?"
    
  - Option 2, random player. AI player as I understand it? Computer generated moves
    - Use RandomPlayer Class in players package
      - Can fail
        - Retries until placement is valid
      - Randomly generated name
      - Inputs should be displayed same as players
        - Ex if row == 1, column ==1, UI displayed inputs and result (Error if not valid, or board placement if valid)

### Display Result 
- Winner name announced 
  - print Name+ "wins!"

### Option to play again
- print y/n to playing again
- Reloop through game prompts and regenerate names etc. 
- 
        