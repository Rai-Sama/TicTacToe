import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
    //Initializing
    String player = "", opponent = "", current_player = "";
    int playerScore = 0, computerScore = 0, tie, mode, win,scoreX = 0, scoreO = 0;
    Frame human_comp, newFrame, human_human;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonX, buttonO, buttonClr, buttonExit, newGame;
    Button HvH, HvC, exitGame;
    Button button11, button12, button13, button14, button15, button16, button17, button18, button19, buttonClr2, buttonExit2, newGame2;
    Panel panel1, panel2, playMode;
    TextField field, choice, field1;
    GridLayout grid, gridNew;

    TicTacToe()/*This constructor initializes all of the game's components*/{
        human_comp = new Frame("Tic Tac Toe"); //Frame for human vs computer game
        panel1 = new Panel(); //Panel for buttons in human vs computer game
        human_comp.setLayout(new FlowLayout()); //FlowLayout centrally aligns everything
        //9 buttons for 3x3 game play
        button1 = new Button("");
        button1.addActionListener(this);
        button2 = new Button("");
        button2.addActionListener(this);
        button3 = new Button("");
        button3.addActionListener(this);
        button4 = new Button("");
        button4.addActionListener(this);
        button5 = new Button("");
        button5.addActionListener(this);
        button6 = new Button("");
        button6.addActionListener(this);
        button7 = new Button("");
        button7.addActionListener(this);
        button8 = new Button("");
        button8.addActionListener(this);
        button9 = new Button("");
        button9.addActionListener(this);
        //Buttons for choosing X or O at the start of the game against the computer
        buttonX = new Button("Choose X");
        buttonX.addActionListener(this);
        buttonO = new Button("Choose O");
        buttonO.addActionListener(this);
        //Command buttons
        buttonClr = new Button("Clear");
        buttonClr.addActionListener(this);
        buttonExit = new Button("Exit");
        buttonExit.addActionListener(this);
        newGame = new Button("New Game");
        newGame.addActionListener(this);
        //Text field for displaying the score
        field = new TextField(20);
        human_comp.add(field);
        grid = new GridLayout(5,3,50,50); //3 columns for keeping it 3x3
        panel1.setLayout(grid);
        //Adding the buttons to the panel for human vs computer game
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(button6);
        panel1.add(button7);
        panel1.add(button8);
        panel1.add(button9);
        panel1.add(buttonX);
        panel1.add(buttonO);
        panel1.add(buttonClr);
        panel1.add(newGame);
        panel1.add(buttonExit);
        human_comp.add(panel1);
        human_comp.setSize(400,400);
        human_comp.setVisible(false); //Frame shouldn't be visible till the human vs computer mode is chosen
        //Buttons for human vs human game
        button11 = new Button("");
        button11.addActionListener(this);
        button12 = new Button("");
        button12.addActionListener(this);
        button13 = new Button("");
        button13.addActionListener(this);
        button14 = new Button("");
        button14.addActionListener(this);
        button15 = new Button("");
        button15.addActionListener(this);
        button16 = new Button("");
        button16.addActionListener(this);
        button17 = new Button("");
        button17.addActionListener(this);
        button18 = new Button("");
        button18.addActionListener(this);
        button19 = new Button("");
        button19.addActionListener(this);
        //Command buttons
        buttonClr2 = new Button("Clear");
        buttonClr2.addActionListener(this);
        buttonExit2 = new Button("Exit");
        buttonExit2.addActionListener(this);
        newGame2 = new Button("New Game");
        newGame2.addActionListener(this);

        human_human = new Frame("Tic Tac Toe"); //Frame for human vs human game
        panel2 = new Panel(); //Panel for the buttons of human vs human game frame
        human_human.setLayout(new FlowLayout()); //Centrally aligning everything
        field1 = new TextField(20); //Text field for displaying score of both the players
        human_human.add(field1);
        panel2.setLayout(grid); //Grid layout of the buttons
        //Adding buttons to the panel
        panel2.add(button11);
        panel2.add(button12);
        panel2.add(button13);
        panel2.add(button14);
        panel2.add(button15);
        panel2.add(button16);
        panel2.add(button17);
        panel2.add(button18);
        panel2.add(button19);
        panel2.add(buttonClr2);
        panel2.add(newGame2);
        panel2.add(buttonExit2);
        human_human.add(panel2);
        human_human.setSize(400,400);
        human_human.setVisible(false); //Frame shouldn't be visible till the human vs human mode is chosen
        //New game frame i.e. main menu
        HvH = new Button("Human VS Human");
        HvH.addActionListener(this);
        HvC = new Button("Human VS Computer");
        HvC.addActionListener(this);
        exitGame = new Button("Exit");
        exitGame.addActionListener(this);

        choice= new TextField(20);
        newFrame = new Frame("Tic Tac Toe");
        newFrame.setLayout(new FlowLayout());
        playMode = new Panel();
        newFrame.add(choice);
        gridNew = new GridLayout(4,1,50,50); //3 columns for keeping it 3x3
        playMode.setLayout(gridNew);

        playMode.add(HvH);
        playMode.add(HvC);
        playMode.add(exitGame);
        newFrame.add(playMode);
        choice.setText("Choose game mode...");
        newFrame.setSize(400,400);
        newFrame.setVisible(true); //Main menu frame should be visible till the game mode is chosen

        if(mode == 0){ //Human vs Computer mode i.e. human must choose X or O to play with
            field.setText("Choose X or O");
        }
        if(mode == 1){ //Human vs human
            field1.setText("X: " + "     O:");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == HvC){

            mode = 0; //game started
            //Choosing X or O
            newFrame.setVisible(false);
            human_human.setVisible(false);
            human_comp.setVisible(true);
        }
        if(e.getSource() == HvH){
            mode = 1;
            current_player = "X";
            newFrame.setVisible(false);
            human_comp.setVisible(false);
            human_human.setVisible(true);
        }
        if(e.getSource() == exitGame)
            System.exit(0);
        if(human_comp.isVisible()) { //Game play for human vs computer
            if (e.getSource() == buttonX && buttonX.getLabel() == "Choose X") {
                player = "X";
                opponent = "O";
                buttonX.setLabel("");
                buttonO.setLabel("");
                field.setText("Player: " + playerScore + "   Computer:   " + computerScore);
            }
            if (e.getSource() == buttonO && buttonO.getLabel() == "Choose O") {
                player = "O";
                opponent = "X";
                buttonO.setLabel("");
                buttonX.setLabel("");
                field.setText("Player: " + playerScore + "   Computer:   " + computerScore);
                computer(opponent);
            }
            //Game play
            if (e.getSource() == button1 && button1.getLabel() == "") {
                button1.setLabel(player);
                //Checking for winning combinations and tie every after every move
                win = win();
                tie = tie();
                if (tie == 0 && win == 0) {
                    computer(opponent); //Computer's move if the game has not ended
                    //checking after computer's move as well
                    win();
                    tie();
                }
            } else if (e.getSource() == button2 && button2.getLabel() == "") {
                button2.setLabel(player);
                win = win();
                tie = tie();
                if (tie == 0 && win == 0) {
                    computer(opponent);
                    win();
                    tie();
                }
            } else if (e.getSource() == button3 && button3.getLabel() == "") {
                button3.setLabel(player);
                win = win();
                tie = tie();
                if (tie == 0 && win == 0) {
                    computer(opponent);
                    win();
                    tie();
                }
            } else if (e.getSource() == button4 && button4.getLabel() == "") {
                button4.setLabel(player);
                win = win();
                tie = tie();
                if (tie == 0 && win == 0) {
                    computer(opponent);
                    win();
                    tie();
                }
            }
            if (e.getSource() == button5 && button5.getLabel() == "") {
                button5.setLabel(player);
                win = win();
                tie = tie();
                if (tie == 0 && win == 0) {
                    computer(opponent);
                    win();
                    tie();
                }
            } else if (e.getSource() == button6 && button6.getLabel() == "") {
                button6.setLabel(player);
                win = win();
                tie = tie();
                if (tie == 0 && win == 0) {
                    computer(opponent);
                    win();
                    tie();
                }
            } else if (e.getSource() == button7 && button7.getLabel() == "") {
                button7.setLabel(player);
                win = win();
                tie = tie();
                if (tie == 0 && win == 0) {
                    computer(opponent);
                    win();
                    tie();
                }
            } else if (e.getSource() == button8 && button8.getLabel() == "") {
                button8.setLabel(player);
                win = win();
                tie = tie();
                if (tie == 0 && win == 0) {
                    computer(opponent);
                    win();
                    tie();
                }
            } else if (e.getSource() == button9 && button9.getLabel() == "") {
                button9.setLabel(player);
                win = win();
                tie = tie();
                if (tie == 0 && win == 0) {
                    computer(opponent);
                    win();
                    tie();
                }
            } else if (e.getSource() == buttonClr)
                clearButtons();
            else if (e.getSource() == buttonExit)
                System.exit(0);
            else if(e.getSource() == newGame){
                clearButtons();
                human_comp.setVisible(false); //If new game is being started then the gmae frame mustn't be visible
                newFrame.setVisible(true); //Main menu should now be visible
            }
        }
        else if(human_human.isVisible()){ //Game play for human vs human game
                if(current_player == "O") //Deciding which player's move it is
                    current_player = "X";
                else
                    current_player = "O";
                if(e.getSource() == button11 && button11.getLabel() == "") {
                    button11.setLabel(current_player);
                    win = win(); //Checking if one of the player's has won
                    if(win == 0) //Checking for a tie if someone hasn't won yet
                        tie();
                }
                else if(e.getSource() == button12 && button12.getLabel() == "") {
                    button12.setLabel(current_player);
                    win = win();
                    if(win == 0)
                        tie();
                }
                else if(e.getSource() == button13 && button13.getLabel() == "") {
                    button13.setLabel(current_player);
                    win = win();
                    if(win == 0)
                        tie();
                }
                else if(e.getSource() == button14 && button14.getLabel() == "") {
                    button14.setLabel(current_player);
                    win = win();
                    if(win == 0)
                        tie();
                }
                else if(e.getSource() == button15 && button15.getLabel() == "") {
                    button15.setLabel(current_player);
                    win = win();
                    if(win == 0)
                        tie();
                }
                else if(e.getSource() == button16 && button16.getLabel() == "") {
                    button16.setLabel(current_player);
                    win = win();
                    if(win == 0)
                        tie();
                }
                else if(e.getSource() == button17 && button17.getLabel() == "") {
                    button17.setLabel(current_player);
                    win = win();
                    if(win == 0)
                        tie();
                }
                else if(e.getSource() == button18 && button18.getLabel() == "") {
                    button18.setLabel(current_player);
                    win = win();
                    if(win == 0)
                        tie();
                }
                else if(e.getSource() == button19 && button19.getLabel() == "") {
                    button19.setLabel(current_player);
                    win = win();
                    if(win == 0)
                        tie();
                }
                else if(e.getSource() == buttonClr2){ //Clear button
                    clearButtons();
                }
                else if(e.getSource() == buttonExit2) //Exit button
                    System.exit(0);
                else if(e.getSource() == newGame2){ //Button for completely new game
                    clearButtons();
                    human_human.setVisible(false); //Game frame shouldn't be visible
                    newFrame.setVisible(true); //Main menu should pop up now
                }
        }
    }
    void clearButtons() /* Clears the game buttons and resets the score (called by clear & new game buttons)*/{
        if(human_comp.isVisible()) { //Clearing human vs computer frame
            button1.setLabel("");
            button2.setLabel("");
            button3.setLabel("");
            button4.setLabel("");
            button5.setLabel("");
            button6.setLabel("");
            button7.setLabel("");
            button8.setLabel("");
            button9.setLabel("");
            player = "";
            playerScore = computerScore = 0;
            buttonX.setLabel("Choose X");
            buttonO.setLabel("Choose O");
            field.setText("Choose X or O");
        }
        else if(human_human.isVisible()){ //Clearing human vs human frame
            button11.setLabel("");
            button12.setLabel("");
            button13.setLabel("");
            button14.setLabel("");
            button15.setLabel("");
            button16.setLabel("");
            button17.setLabel("");
            button18.setLabel("");
            button19.setLabel("");
            current_player = "O";
            scoreX = scoreO = 0;
            field1.setText("X: " + String.valueOf(scoreX) + "    O: " + String.valueOf(scoreO));
        }
    }
    void clearButtons(int methodOverloader) /*Clears the buttons but not the score(when a game ends but set continues)*/{
        if(human_comp.isVisible()) { //Restarting game between human & computer
            button1.setLabel("");
            button2.setLabel("");
            button3.setLabel("");
            button4.setLabel("");
            button5.setLabel("");
            button6.setLabel("");
            button7.setLabel("");
            button8.setLabel("");
            button9.setLabel("");
            if (player == "O")
                computer(opponent);
        }
        else if(human_human.isVisible()){ //Retsarting game between two humans
            button11.setLabel("");
            button12.setLabel("");
            button13.setLabel("");
            button14.setLabel("");
            button15.setLabel("");
            button16.setLabel("");
            button17.setLabel("");
            button18.setLabel("");
            button19.setLabel("");
            current_player = "O";
        }
    }

    int win()/*Checking for all winning combinations and ending the game if one is found with score incrementation*/{
        //Horizontal combinations
        if(human_comp.isVisible()) {
            if (button1.getLabel().equals(button2.getLabel()) && button2.getLabel().equals(button3.getLabel()) && button1.getLabel() != "") {
                if (button1.getLabel().equals(player))
                    playerScore++;
                else
                    computerScore++;
                field.setText("Player: " + playerScore + "     Computer: " + computerScore);
                clearButtons(0);
                return 1;
            }
            if (button4.getLabel().equals(button5.getLabel()) && button5.getLabel().equals(button6.getLabel()) && button4.getLabel() != "") {
                if (button4.getLabel().equals(player))
                    playerScore++;
                else
                    computerScore++;
                field.setText("Player: " + playerScore + "     Computer: " + computerScore);
                clearButtons(0);
                return 1;
            }
            if (button7.getLabel().equals(button8.getLabel()) && button8.getLabel().equals(button9.getLabel()) && button7.getLabel() != "") {
                if (button7.getLabel().equals(player))
                    playerScore++;
                else
                    computerScore++;
                field.setText("Player: " + playerScore + "     Computer: " + computerScore);
                clearButtons(0);
                return 1;
            }
            //Vertical combinations
            if (button1.getLabel().equals(button4.getLabel()) && button4.getLabel().equals(button7.getLabel()) && button1.getLabel() != "") {
                if (button1.getLabel().equals(player))
                    playerScore++;
                else
                    computerScore++;
                field.setText("Player: " + playerScore + "     Computer: " + computerScore);
                clearButtons(0);
                return 1;
            }
            if (button2.getLabel().equals(button5.getLabel()) && button5.getLabel().equals(button8.getLabel()) && button2.getLabel() != "") {
                if (button2.getLabel().equals(player))
                    playerScore++;
                else
                    computerScore++;
                field.setText("Player: " + playerScore + "     Computer: " + computerScore);
                clearButtons(0);
                return 1;
            }
            if (button3.getLabel().equals(button6.getLabel()) && button6.getLabel().equals(button9.getLabel()) && button3.getLabel() != "") {
                if (button3.getLabel().equals(player))
                    playerScore++;
                else
                    computerScore++;
                field.setText("Player: " + playerScore + "     Computer: " + computerScore);
                clearButtons(0);
                return 1;
            }
            //Diagonal combinations
            if (button1.getLabel().equals(button5.getLabel()) && button5.getLabel().equals(button9.getLabel()) && button1.getLabel() != "") {
                if (button1.getLabel().equals(player))
                    playerScore++;
                else
                    computerScore++;
                field.setText("Player: " + playerScore + "     Computer: " + computerScore);
                clearButtons(0);
                return 1;
            }
            if (button3.getLabel().equals(button5.getLabel()) && button5.getLabel().equals(button7.getLabel()) && button3.getLabel() != "") {
                if (button3.getLabel().equals(player))
                    playerScore++;
                else
                    computerScore++;
                field.setText("Player: " + playerScore + "     Computer: " + computerScore);
                clearButtons(0);
                return 1;
            }
            return 0;
        }
        else if(human_human.isVisible()){
            //Horizontal combinations
            if (button11.getLabel().equals(button12.getLabel()) && button12.getLabel().equals(button13.getLabel()) && button11.getLabel() != "") {
                if (button11.getLabel() == "X")
                    scoreX++;
                else
                    scoreO++;
                field1.setText("X: " + scoreX + "     O: " + scoreO);
                clearButtons(0);
                return 1;
            }
            if (button14.getLabel().equals(button15.getLabel()) && button15.getLabel().equals(button16.getLabel()) && button14.getLabel() != "") {
                if (button14.getLabel() == "X")
                    scoreX++;
                else
                    scoreO++;
                field1.setText("X: " + scoreX + "     O: " + scoreO);
                clearButtons(0);
                return 1;
            }
            if (button17.getLabel().equals(button18.getLabel()) && button18.getLabel().equals(button19.getLabel()) && button17.getLabel() != "") {
                if (button17.getLabel() == "X")
                    scoreX++;
                else
                    scoreO++;
                field1.setText("X: " + scoreX + "     O: " + scoreO);
                clearButtons(0);
                return 1;
            }
            //Vertical combinations
            if (button11.getLabel().equals(button14.getLabel()) && button14.getLabel().equals(button17.getLabel()) && button11.getLabel() != "") {
                if (button11.getLabel() == "X")
                    scoreX++;
                else
                    scoreO++;
                field1.setText("X: " + scoreX + "     O: " + scoreO);
                clearButtons(0);
                return 1;
            }
            if (button12.getLabel().equals(button15.getLabel()) && button15.getLabel().equals(button18.getLabel()) && button12.getLabel() != "") {
                if (button12.getLabel() == "X")
                    scoreX++;
                else
                    scoreO++;
                field1.setText("X: " + scoreX + "     O: " + scoreO);
                clearButtons(0);
                return 1;
            }
            if (button13.getLabel().equals(button16.getLabel()) && button16.getLabel().equals(button19.getLabel()) && button13.getLabel() != "") {
                if (button13.getLabel() == "X")
                    scoreX++;
                else
                    scoreO++;
                field1.setText("X: " + scoreX + "     O: " + scoreO);
                clearButtons(0);
                return 1;
            }
            //Diagonal combinations
            if (button11.getLabel().equals(button15.getLabel()) && button15.getLabel().equals(button19.getLabel()) && button11.getLabel() != "") {
                if (button11.getLabel() == "X")
                    scoreX++;
                else
                    scoreO++;
                field1.setText("X: " + scoreX + "     O: " + scoreO);
                clearButtons(0);
                return 1;
            }
            if (button13.getLabel().equals(button15.getLabel()) && button15.getLabel().equals(button17.getLabel()) && button13.getLabel() != "") {
                if (button13.getLabel() == "X")
                    scoreX++;
                else
                    scoreO++;
                field1.setText("X: " + scoreX + "     O: " + scoreO);
                clearButtons(0);
                return 1;
            }
            return 0;
        }
        return 0;
    }
    //Method for the algorithm of computer's play
    void computer(String opponent) {
        Random random = new Random();
        int played = 0, play;
        //Checking for any winning combinations available for the computer since this has higher priority than blocking
        if (button1.getLabel() == button2.getLabel() && button1.getLabel() != "" && button3.getLabel() == "" && button1.getLabel().equals(opponent)) {
            button3.setLabel(opponent);
        } else if (button2.getLabel() == button3.getLabel() && button2.getLabel() != "" && button1.getLabel() == "" && button2.getLabel().equals(opponent)) {
            button1.setLabel(opponent);
        } else if (button1.getLabel() == button3.getLabel() && button1.getLabel() != "" && button2.getLabel() == "" && button1.getLabel().equals(opponent)) {
            button2.setLabel(opponent);
        } else if (button4.getLabel() == button5.getLabel() && button4.getLabel() != "" && button6.getLabel() == "" && button4.getLabel().equals(opponent)) {
            button6.setLabel(opponent);
        } else if (button5.getLabel() == button6.getLabel() && button5.getLabel() != "" && button4.getLabel() == "" && button5.getLabel().equals(opponent)) {
            button4.setLabel(opponent);
        } else if (button4.getLabel() == button6.getLabel() && button4.getLabel() != "" && button5.getLabel() == "" && button4.getLabel().equals(opponent)) {
            button5.setLabel(opponent);
        } else if (button7.getLabel() == button8.getLabel() && button7.getLabel() != "" && button9.getLabel() == "" && button7.getLabel().equals(opponent)) {
            button9.setLabel(opponent);
        } else if (button8.getLabel() == button9.getLabel() && button8.getLabel() != "" && button7.getLabel() == "" && button8.getLabel().equals(opponent)) {
            button7.setLabel(opponent);
        } else if (button7.getLabel() == button9.getLabel() && button7.getLabel() != "" && button8.getLabel() == "" && button7.getLabel().equals(opponent)) {
            button8.setLabel(opponent);
        } else if (button1.getLabel() == button5.getLabel() && button1.getLabel() != "" && button9.getLabel() == "" && button1.getLabel().equals(opponent)) {
            button9.setLabel(opponent);
        } else if (button5.getLabel() == button9.getLabel() && button5.getLabel() != "" && button1.getLabel() == "" && button5.getLabel().equals(opponent)) {
            button1.setLabel(opponent);
        } else if (button1.getLabel() == button9.getLabel() && button1.getLabel() != "" && button5.getLabel() == "" && button1.getLabel().equals(opponent)) {
            button5.setLabel(opponent);
        } else if (button3.getLabel() == button5.getLabel() && button3.getLabel() != "" && button7.getLabel() == "" && button3.getLabel().equals(opponent)) {
            button7.setLabel(opponent);
        } else if (button5.getLabel() == button7.getLabel() && button5.getLabel() != "" && button3.getLabel() == "" && button5.getLabel().equals(opponent)) {
            button3.setLabel(opponent);
        } else if (button3.getLabel() == button7.getLabel() && button3.getLabel() != "" && button5.getLabel() == "" && button3.getLabel().equals(opponent)) {
            button5.setLabel(opponent);
        } else if (button1.getLabel() == button4.getLabel() && button1.getLabel() != "" && button7.getLabel() == "" && button1.getLabel().equals(opponent)) {
            button7.setLabel(opponent);
        } else if (button4.getLabel() == button7.getLabel() && button4.getLabel() != "" && button1.getLabel() == "" && button4.getLabel().equals(opponent)) {
            button1.setLabel(opponent);
        } else if (button1.getLabel() == button7.getLabel() && button1.getLabel() != "" && button4.getLabel() == "" && button1.getLabel().equals(opponent)) {
            button4.setLabel(opponent);
        } else if (button2.getLabel() == button5.getLabel() && button2.getLabel() != "" && button8.getLabel() == "" && button2.getLabel().equals(opponent)) {
            button8.setLabel(opponent);
        } else if (button5.getLabel() == button8.getLabel() && button5.getLabel() != "" && button2.getLabel() == "" && button5.getLabel().equals(opponent)) {
            button2.setLabel(opponent);
        } else if (button2.getLabel() == button8.getLabel() && button2.getLabel() != "" && button5.getLabel() == "" && button2.getLabel().equals(opponent)) {
            button5.setLabel(opponent);
        } else if (button3.getLabel() == button9.getLabel() && button3.getLabel() != "" && button6.getLabel() == "" && button3.getLabel().equals(opponent)) {
            button6.setLabel(opponent);
        } else if (button6.getLabel() == button9.getLabel() && button6.getLabel() != "" && button3.getLabel() == "" && button6.getLabel().equals(opponent)) {
            button3.setLabel(opponent);
        } else if (button3.getLabel() == button6.getLabel() && button3.getLabel() != "" && button9.getLabel() == "" && button3.getLabel().equals(opponent)) {
            button9.setLabel(opponent);
        }
        //Blocking the player's winning combinations
        else
        if (button1.getLabel() == button2.getLabel() && button1.getLabel() != "" && button3.getLabel() == "")  {
            button3.setLabel(opponent);
        } else if (button2.getLabel() == button3.getLabel() && button2.getLabel() != "" && button1.getLabel() == "") {
            button1.setLabel(opponent);
        } else if (button1.getLabel() == button3.getLabel() && button1.getLabel() != "" && button2.getLabel() == "")  {
            button2.setLabel(opponent);
        } else if (button4.getLabel() == button5.getLabel() && button4.getLabel() != "" && button6.getLabel() == "")  {
            button6.setLabel(opponent);
        } else if (button5.getLabel() == button6.getLabel() && button5.getLabel() != "" && button4.getLabel() == "")  {
            button4.setLabel(opponent);
        } else if (button4.getLabel() == button6.getLabel() && button4.getLabel() != "" && button5.getLabel() == "")  {
            button5.setLabel(opponent);
        } else if (button7.getLabel() == button8.getLabel() && button7.getLabel() != "" && button9.getLabel() == "")  {
            button9.setLabel(opponent);
        } else if (button8.getLabel() == button9.getLabel() && button8.getLabel() != "" && button7.getLabel() == "")  {
            button7.setLabel(opponent);
        } else if (button7.getLabel() == button9.getLabel() && button7.getLabel() != "" && button8.getLabel() == "")  {
            button8.setLabel(opponent);
        } else if (button1.getLabel() == button5.getLabel() && button1.getLabel() != "" && button9.getLabel() == "")  {
            button9.setLabel(opponent);
        } else if (button5.getLabel() == button9.getLabel() && button5.getLabel() != "" && button1.getLabel() == "")  {
            button1.setLabel(opponent);
        } else if (button1.getLabel() == button9.getLabel() && button1.getLabel() != "" && button5.getLabel() == "")  {
            button5.setLabel(opponent);
        } else if (button3.getLabel() == button5.getLabel() && button3.getLabel() != "" && button7.getLabel() == "")  {
            button7.setLabel(opponent);
        } else if (button5.getLabel() == button7.getLabel() && button5.getLabel() != "" && button3.getLabel() == "")  {
            button3.setLabel(opponent);
        } else if (button3.getLabel() == button7.getLabel() && button3.getLabel() != "" && button5.getLabel() == "")  {
            button5.setLabel(opponent);
        } else if (button1.getLabel() == button4.getLabel() && button1.getLabel() != "" && button7.getLabel() == "")  {
            button7.setLabel(opponent);
        } else if (button4.getLabel() == button7.getLabel() && button4.getLabel() != "" && button1.getLabel() == "")  {
            button1.setLabel(opponent);
        } else if (button1.getLabel() == button7.getLabel() && button1.getLabel() != "" && button4.getLabel() == "")  {
            button4.setLabel(opponent);
        } else if (button2.getLabel() == button5.getLabel() && button2.getLabel() != "" && button8.getLabel() == "")  {
            button8.setLabel(opponent);
        } else if (button5.getLabel() == button8.getLabel() && button5.getLabel() != "" && button2.getLabel() == "")  {
            button2.setLabel(opponent);
        } else if (button2.getLabel() == button8.getLabel() && button2.getLabel() != "" && button5.getLabel() == "")  {
            button5.setLabel(opponent);
        } else if (button3.getLabel() == button9.getLabel() && button3.getLabel() != "" && button6.getLabel() == "")  {
            button6.setLabel(opponent);
        } else if (button6.getLabel() == button9.getLabel() && button6.getLabel() != "" && button3.getLabel() == "")  {
            button3.setLabel(opponent);
        } else if (button3.getLabel() == button6.getLabel() && button3.getLabel() != "" && button9.getLabel() == "")   {
            button9.setLabel(opponent);
        }
        else {
            while (played == 0) { //Checking for available squares to play in til one is found
                play = random.nextInt(10);
                switch (play) {
                    case 1:
                        if (button1.getLabel() == "") {
                            button1.setLabel(opponent);
                            played = 1;
                        } else
                            played = 0;
                        break;
                    case 2:
                        if (button2.getLabel() == "") {
                            button2.setLabel(opponent);
                            played = 1;
                        } else
                            played = 0;
                        break;
                    case 3:
                        if (button3.getLabel() == "") {
                            button3.setLabel(opponent);
                            played = 1;
                        } else
                            played = 0;
                        break;
                    case 4:
                        if (button4.getLabel() == "") {
                            button4.setLabel(opponent);
                            played = 1;
                        } else
                            played = 0;
                        break;
                    case 5:
                        if (button5.getLabel() == "") {
                            button5.setLabel(opponent);
                            played = 1;
                        } else
                            played = 0;
                        break;
                    case 6:
                        if (button6.getLabel() == "") {
                            button6.setLabel(opponent);
                            played = 1;
                        } else
                            played = 0;
                        break;
                    case 7:
                        if (button7.getLabel() == "") {
                            button7.setLabel(opponent);
                            played = 1;
                        } else
                            played = 0;
                        break;
                    case 8:
                        if (button8.getLabel() == "") {
                            button8.setLabel(opponent);
                            played = 1;
                        } else
                            played = 0;
                        break;
                    case 9:
                        if (button9.getLabel() == "") {
                            button9.setLabel(opponent);
                            played = 1;
                        } else
                            played = 0;
                        break;
                    case 0:
                        played = 0;
                }
            }
        }
    }

    int tie()/*Checking if there's a tie*/ {
        if(human_comp.isVisible()) { //For human vs computer frame
            if (button1.getLabel() != "" && button2.getLabel() != "" && button3.getLabel() != "" && button4.getLabel() != "" && button5.getLabel() != "" && button6.getLabel() != "" && button7.getLabel() != "" && button8.getLabel() != "" && button9.getLabel() != "") {
                button1.setLabel("");
                button2.setLabel("");
                button3.setLabel("");
                button4.setLabel("");
                button5.setLabel("");
                button6.setLabel("");
                button7.setLabel("");
                button8.setLabel("");
                button9.setLabel("");
                if (player == "O")
                    computer(opponent);
                return 1; //1 means there's a tie and the game will restart
            }
            return 0; //0 means there's not a tie and the game continues
        }
        else if(human_human.isVisible()) { //for human vs human frame
            if (button11.getLabel() != "" && button12.getLabel() != "" && button13.getLabel() != "" && button14.getLabel() != "" && button15.getLabel() != "" && button16.getLabel() != "" && button17.getLabel() != "" && button18.getLabel() != "" && button19.getLabel() != "") {
                button11.setLabel("");
                button12.setLabel("");
                button13.setLabel("");
                button14.setLabel("");
                button15.setLabel("");
                button16.setLabel("");
                button17.setLabel("");
                button18.setLabel("");
                button19.setLabel("");
                current_player = "O";
                return 1; //1 means there's a tie and the game restarts
            }
            return 0; //0 means there's not a tie and the game can continue
        }
    return 0;
    }
}