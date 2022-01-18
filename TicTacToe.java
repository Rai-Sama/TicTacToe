import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
    //Initializing
    String player = "", opponent = "";
    int playerScore = 0, computerScore = 0, tie, start = 0, win;
    Frame frame;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonX, buttonO, buttonClr, buttonExit;
    Panel panel;
    TextField field;
    GridLayout grid;

    TicTacToe()/*Main Gameplay occurs in this constructor*/{
        frame = new Frame("Tic Tac Toe"); //Frame for the game
        panel = new Panel(); //Panel for buttons
        frame.setLayout(new FlowLayout()); //FlowLayout centrally aligns everything
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
        //Buttons for choosing X or O at the start of the game
        buttonX = new Button("Choose X");
        buttonX.addActionListener(this);
        buttonO = new Button("Choose O");
        buttonO.addActionListener(this);
        //Command buttons
        buttonClr = new Button("Clear");
        buttonClr.addActionListener(this);
        buttonExit = new Button("Exit");
        buttonExit.addActionListener(this);
        //Text field for displaying the score
        field = new TextField(20);
        frame.add(field);
        grid = new GridLayout(5,3,50,50); //3 columns for keeping it 3x3
        panel.setLayout(grid);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonX);
        panel.add(buttonO);
        panel.add(buttonClr);
        panel.add(buttonExit);
        frame.add(panel);
        frame.setSize(500,500);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setVisible(true);
        if(start == 0) //Start of a new game set
            field.setText("Choose X or O");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        start = 1; //game started
        //Choosing X or O
        if(e.getSource() == buttonX && buttonX.getLabel() == "Choose X"){
            player = "X";
            opponent = "O";
            buttonX.setLabel("");
            buttonO.setLabel("");
            field.setText("Player: " + playerScore  + "   Computer:   " + computerScore);
        }
        if(e.getSource() == buttonO && buttonO.getLabel() == "Choose O") {
            player = "O";
            opponent = "X";
            buttonO.setLabel("");
            buttonX.setLabel("");
            field.setText("Player: " + playerScore  + "   Computer:   " + computerScore);
            computer(opponent);
        }
        //Game play
        if(e.getSource() == button1 && button1.getLabel() == "") {
            button1.setLabel(player);
            //Checking for winning combinations and tie every after every move
            win = win();
            tie = tie();
            if(tie == 0 && win == 0) {
                computer(opponent); //Computer's move if the game has not ended
                //checking after computer's move
                win();
                tie();
            }
        }
        else
        if(e.getSource() == button2 && button2.getLabel() == "") {
            button2.setLabel(player);
            win = win();
            tie = tie();
            if(tie == 0 && win == 0) {
                computer(opponent);
                win();
                tie();
            }
        }
        else
        if(e.getSource() == button3 && button3.getLabel() == "") {
            button3.setLabel(player);
            win = win();
            tie = tie();
            if(tie == 0 && win == 0) {
                computer(opponent);
                win();
                tie();
            }
        }
        else
        if(e.getSource() == button4 && button4.getLabel() == "") {
            button4.setLabel(player);
            win = win();
            tie = tie();
            if(tie == 0 && win == 0) {
                computer(opponent);
                win();
                tie();
            }
        }
        if(e.getSource() == button5 && button5.getLabel() == "") {
            button5.setLabel(player);
            win = win();
            tie = tie();
            if(tie == 0 && win == 0) {
                computer(opponent);
                win();
                tie();
            }
        }
        else
        if(e.getSource() == button6 && button6.getLabel() == "") {
            button6.setLabel(player);
            win = win();
            tie = tie();
            if(tie == 0 && win == 0) {
                computer(opponent);
                win();
                tie();
            }
        }
        else
        if(e.getSource() == button7 && button7.getLabel() == "") {
            button7.setLabel(player);
            win = win();
            tie = tie();
            if(tie == 0 && win == 0) {
                computer(opponent);
                win();
                tie();
            }
        }
        else
        if(e.getSource() == button8 && button8.getLabel() == "") {
            button8.setLabel(player);
            win = win();
            tie = tie();
            if(tie == 0 && win == 0) {
                computer(opponent);
                win();
                tie();
            }
        }
        else
        if(e.getSource() == button9 && button9.getLabel() == "") {
            button9.setLabel(player);
            win = win();
            tie = tie();
            if(tie == 0 && win == 0) {
                computer(opponent);
                win();
                tie();
            }
        }
        else
        if(e.getSource() == buttonClr)
            clearButtons();
        else
        if(e.getSource() == buttonExit)
            System.exit(0);

    }
    void clearButtons() /* Clears the game buttons and resets the score (called by clear button)*/{
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
    void clearButtons(int methodOverloader) /*Clears the buttons but not the score(when a game ends but set continues)*/{
        button1.setLabel("");
        button2.setLabel("");
        button3.setLabel("");
        button4.setLabel("");
        button5.setLabel("");
        button6.setLabel("");
        button7.setLabel("");
        button8.setLabel("");
        button9.setLabel("");
        if(player == "O")
            computer(opponent);
    }

    int win()/*Checking for all winning combinations and ending the game if one is found with score incrementation*/{
        //Horizontal combinations
        if(button1.getLabel().equals(button2.getLabel()) && button2.getLabel().equals(button3.getLabel()) && button1.getLabel() != "") {
            if(button1.getLabel().equals(player))
                playerScore++;
            else
                computerScore++;
            field.setText("Player: " + playerScore +"     Computer: " + computerScore);
            clearButtons(0);
            return 1;
        }
        if(button4.getLabel().equals(button5.getLabel()) && button5.getLabel().equals(button6.getLabel()) && button4.getLabel() != "") {
            if(button4.getLabel().equals(player))
                playerScore++;
            else
                computerScore++;
            field.setText("Player: " + playerScore +"     Computer: " + computerScore);
            clearButtons(0);
            return 1;
        }
        if(button7.getLabel().equals(button8.getLabel()) && button8.getLabel().equals(button9.getLabel()) && button7.getLabel() != "") {
            if(button7.getLabel().equals(player))
                playerScore++;
            else
                computerScore++;
            field.setText("Player: " + playerScore +"     Computer: " + computerScore);
            clearButtons(0);
            return 1;
        }
        //Vertical combinations
        if(button1.getLabel().equals(button4.getLabel()) && button4.getLabel().equals(button7.getLabel()) && button1.getLabel() != "") {
            if(button1.getLabel().equals(player))
                playerScore++;
            else
                computerScore++;
            field.setText("Player: " + playerScore +"     Computer: " + computerScore);
            clearButtons(0);
            return 1;
        }
        if(button2.getLabel().equals(button5.getLabel()) && button5.getLabel().equals(button8.getLabel()) && button2.getLabel() != "") {
            if(button2.getLabel().equals(player))
                playerScore++;
            else
                computerScore++;
            field.setText("Player: " + playerScore +"     Computer: " + computerScore);
            clearButtons(0);
            return 1;
        }
        if(button3.getLabel().equals(button6.getLabel()) && button6.getLabel().equals(button9.getLabel()) && button3.getLabel() != "") {
            if(button3.getLabel().equals(player))
                playerScore++;
            else
                computerScore++;
            field.setText("Player: " + playerScore +"     Computer: " + computerScore);
            clearButtons(0);
            return 1;
        }
        //Diagonal combinations
        if(button1.getLabel().equals(button5.getLabel()) && button5.getLabel().equals(button9.getLabel()) && button1.getLabel() != "") {
            if(button1.getLabel().equals(player))
                playerScore++;
            else
                computerScore++;
            field.setText("Player: " + playerScore +"     Computer: " + computerScore);
            clearButtons(0);
            return 1;
        }
        if(button3.getLabel().equals(button5.getLabel()) && button5.getLabel().equals(button7.getLabel()) && button3.getLabel() != "") {
            if(button3.getLabel().equals(player))
                playerScore++;
            else
                computerScore++;
            field.setText("Player: " + playerScore +"     Computer: " + computerScore);
            clearButtons(0);
            return 1;
        }
        return 0;
    }

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
            while (played == 0) {
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

    int tie()/*Checking if there's a tie*/{
        if(button1.getLabel() != "" && button2.getLabel() != "" && button3.getLabel() != "" && button4.getLabel() != "" && button5.getLabel() != "" && button6.getLabel() != "" && button7.getLabel() != "" && button8.getLabel() != "" && button9.getLabel() != "")
        {
            button1.setLabel("");
            button2.setLabel("");
            button3.setLabel("");
            button4.setLabel("");
            button5.setLabel("");
            button6.setLabel("");
            button7.setLabel("");
            button8.setLabel("");
            button9.setLabel("");
            if(player == "O")
                computer(opponent);
            return 1; //1 means there's a tie and the game restarts
        }
        return 0; //0 means there's not a tie and the game can continue
    }

}