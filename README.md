[![Build Status](https://travis-ci.org/andreafey/tictactoe.svg)](https://travis-ci.org/andreafey/tictactoe)

# Tic-Tac-Toe

This is a single-player interactive console Tic-Tac-Toe game which I wrote in Java for my Hacker School application. While fairly unsophisticated, it uses several strategies in combination to avoid loss and take a win when presented the opportunity. It is not likely to win against a player with 
knowledge of tic-tac-toe strategy, but who is? Requires Java 7.

## Usage

    user$ cd tictactoe
    tictactoe$ ant compile
    tictactoe$ java -cp lib/*:bin tictactoe.TicTacToe

Play a move by entering <ROW> <COL>.

## Sample Game Play
```
tictactoe [master *%] $ java -cp lib/*:bin tictactoe.TicTacToe
Welcome to TicTacToe
Tic Tac Toe

   |   |
____________
   | X |
____________
   |   |

Enter row (space) column:
0 0
Tic Tac Toe

 O |   | X
____________
   | X |
____________
   |   |

Enter row (space) column:
0 2
Not a valid move
Enter row (space) column:
2 0
Tic Tac Toe

 O |   | X
____________
 X | X |
____________
 O |   |

Enter row (space) column:
1 2
Tic Tac Toe

 O |   | X
____________
 X | X | O
____________
 O |   | X

Enter row (space) column:
0 1
Tic Tac Toe

 O | O | X
____________
 X | X | O
____________
 O | X | X

It's a draw.
Do you want to play again [y/n]?
n
See ya!
```
## Notes on SimpleTicTacToe

During my Hacker School pairing interview, I created a simple tic-tac-toe game from scratch with Mary Rose Cook. I refined the code a bit to fix bugs after the interview, but this is pretty much the code we came up with during that half hour. It can be executed with `java -cp lib/*:bin tictactoe.SimpleTicTacToe`.
