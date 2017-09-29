import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {

        Scanner scnr = new Scanner(System.in);
        int playerChoice;
        int userHand;   // value of points from the playerCards method
        int getPlayerHand;  // total amount of points the player has
        int getDealerHand = 0;  // total amount of points the dealer has
        int playerWins = 0;
        int dealerWins = 0;
        int numberTies = 0;
        double percentGamesWon;
        int gameNumber = 1;

        boolean gameLoop = true;    // boolean value to keep game loop going (enabling consecutive games)

        // code for game

        while(gameLoop)
        {
            System.out.println("START GAME #" + gameNumber);
            System.out.println(" ");
            userHand = playerCards();   // the user is given a card, resulting in a point value from 1-10
            getPlayerHand = userHand;
            System.out.println("Your hand is: " + getPlayerHand);

            boolean menuLoop = true;    // used to keep the menu option looping

            while(menuLoop)
            {
                System.out.println(" ");
                playerMenu();

                // error catching code to allow program to accept any integer input

                try
                {
                    playerChoice = scnr.nextInt();

                    if(playerChoice <= 0)
                    {
                        throw new Exception("Invalid input!");
                    }

                    else if(playerChoice >= 5)
                    {
                        throw new Exception("Invalid input!");
                    }

                    System.out.println(" ");

                    // loops for player choices

                    while(playerChoice == 1)
                    {
                        userHand = playerCards();
                        getPlayerHand = getPlayerHand + userHand;
                        System.out.println("Your hand is " + getPlayerHand);
                        break;
                    }

                    while(playerChoice == 2)
                    {
                        Random dealerGen = new Random();

                        int dealerDealt = dealerGen.nextInt(11) + 16;
                        getDealerHand = dealerDealt;
                        System.out.println("Dealer's hand is " + getDealerHand);
                        System.out.println("Your hand is " + getPlayerHand);

                        // conditions to end/start new game once player chooses option #2

                        if(getDealerHand == 21)
                        {
                            System.out.println("Dealer wins!");
                            System.out.println(" ");
                            dealerWins = dealerWins + 1;
                            menuLoop = false;
                        }

                        else if(getDealerHand > 21)
                        {
                            System.out.println("You win!");
                            System.out.println(" ");
                            playerWins = playerWins + 1;
                            menuLoop = false;
                        }

                        else if(getDealerHand == getPlayerHand)
                        {
                            System.out.println("It's a tie! No one wins!");
                            System.out.println(" ");
                            numberTies = numberTies + 1;
                            menuLoop = false;
                        }

                        else if(getDealerHand > getPlayerHand)
                        {
                            System.out.println("Dealer wins!");
                            System.out.println(" ");
                            dealerWins = dealerWins + 1;
                            menuLoop = false;
                        }

                        else if(getPlayerHand > getDealerHand)
                        {
                            System.out.println("You win!");
                            System.out.println(" ");
                            playerWins = playerWins + 1;
                            menuLoop = false;
                        }
                        break;
                    }

                    while(playerChoice == 3)
                    {

                        // code for statistics menu choice

                        System.out.println("Number of Player wins: " + playerWins);
                        System.out.println("Number of Dealer wins: " + dealerWins);
                        System.out.println("Number of tie games: " + numberTies);
                        System.out.println("Total # of games played is: " + --gameNumber);
                        // decreased game number to account for games completed, not just games played/being played

                        // exception for when the player tries to access percentage before finishing the first game
                        try
                        {
                            if(gameNumber == 0)
                            {
                                throw new Exception("Insufficient data!");
                            }
                        }
                        catch (Exception excpt)
                        {
                            System.out.println(excpt.getMessage());
                            System.out.println("Percentage of player wins unavailable until first game is complete!");
                            gameNumber++;
                            break;
                        }
                        percentGamesWon = ((double)playerWins / (double)gameNumber) * 100;
                        System.out.println("Percentage of Player wins: " + percentGamesWon + "%");
                        gameNumber++;   // added 1 back to game number to account for the subtraction done previously
                        break;
                    }

                    while(playerChoice == 4)
                    {
                        gameLoop = false;   // breaks the game loop, thus stopping the game
                        menuLoop = false;

                        // setting both boolean values to false at this point enables the game to stop

                        break;
                    }

                    // conditions to end/start next game if player has not picked option #2

                    if(getPlayerHand == 21)
                    {
                        System.out.println("BLACKJACK! You win!");
                        System.out.println(" ");
                        playerWins = playerWins + 1;
                        menuLoop = false;
                    }

                    else if(getPlayerHand > 21)
                    {
                        System.out.println("You exceeded 21! You lose :(");
                        System.out.println(" ");
                        dealerWins = dealerWins + 1;
                        menuLoop = false;
                    }

                }

                catch (java.util.InputMismatchException UHH_OH)
                {

                    // following catch block allows program to accept any input besides integers

                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                    scnr.nextLine();
                }

                catch (Exception excpt)
                {

                    // catch block for thrown exceptions regarding invalid integer inputs

                    System.out.println(excpt.getMessage());
                    System.out.println("Please enter an integer value between 1 and 4.");
                    scnr.nextLine();
                }

            }

            gameNumber++;   // adds 1 to the game number, allowing for consecutive games to be titled
        }
        System.out.println("Thanks for playing!");
    }

    static int playerCards ()
    {

        //  following code determines what card the player is dealt and the point value assigned to it

        Random randGen = new Random();

        int playerHand = 0;   // initial value of the player's hand
        int cardDealt = randGen.nextInt(13) + 1;    // generates numbers between 1 and 13

        // following code sets values to the corresponding special cards within a deck

        switch (cardDealt)
        {
            case 1:
                System.out.println("Your card is an ACE!");
                playerHand = 1;
                break;

            case 11:
                System.out.println("Your card is a JACK!");
                playerHand = 10;
                break;

            case 12:
                System.out.println("Your card is a QUEEN!");
                playerHand = 10;
                break;

            case 13:
                System.out.println("Your card is a KING!");
                playerHand = 10;
                break;

            default:
                System.out.println("Your card is a " + cardDealt + "!");
                playerHand = cardDealt;
                break;
        }
        return(playerHand);
    }

    static void playerMenu()
    {

        //  following code establishes the player menu

        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");

    }

}
