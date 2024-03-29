# TicTacToe

I made this game as a project for the "Java lab" course in semester-3 of B.E.

## About
This a GUI-based tic tac toe game with the layout of traditional tic tac toe i.e. a 3x3 grid.
* It is based on the java.awt library. 
* It ends when either of the players gets 3 X’s or O’s in a row or no boxes are left empty.
* The players alternatively get to go first.
* It keeps track of the scores of both the players, till a player chooses to clear the game.
* The clear button resets the game and the scores.
* The exit button exits the application.

## Playing modes
* Human v/s Human
* Human v/s Bot - a tic tac toe stockfish, if you will

## Playing strategy
* For the human vs bot mode, I painstakingly created an algorithm for the bot to play the winnning move, if any, and if not, then block the human's winning move, if any, and if not that either, then play a random legal move. 
* Because it plays a random move in case there's no direct win for either players, this gives you an opportunity to set up winning traps when you get the first turn
* Note that the bot's strategy will always work when it goes first and so you can at best draw in those games.

## Theory

* Java AWT (Abstract Window Toolkit) is an API to develop GUI or window-based applications in java.
* Java AWT components are platform-dependent i.e. components are  displayed according to the view of operating system. AWT is  heavyweight i.e. its components are using the resources of OS.
* The java.awt package provides classes for AWT API such as TextField, Label, TextArea,  RadioButton, CheckBox, Choice, List etc.
### Java AWT Hierarchy
![image](https://www.javatpoint.com/images/awthierarchy.jpg)

### Container
The Container is a component in AWT that can contain another  components like buttons, textfields, labels etc. The classes that extends Container class are known as container such as Frame, Dialog and Panel.
### Window
The window is the container that have no borders and menu bars. You must use frame, dialog or another window for creating a window.
### Panel
The Panel is the container that doesn't contain title bar and menu bars. It can have other components like button, textfield etc.
### Frame
The Frame is the container that contain title bar and can have menu bars. It can have other components like button, textfield etc.
