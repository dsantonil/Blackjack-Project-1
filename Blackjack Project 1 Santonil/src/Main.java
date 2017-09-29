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
        int dealerHand;
        int getDealerHand = 0;
        int playerWins = 0;
        int dealerWins = 0;
        int numberTies = 0;
        double percentGamesWon;
        int gameNumber = 1;

        boolean gameLoop = true;    // boolean value to keep game loop going (enabling consecutive games)

        while(gameLoop)
        {
            System.out.println("START GAME #" + gameNumber);
            userHand = playerCards();   // the user is given a card, resulting in a point value from 1-10
            getPlayerHand = userHand;
            System.out.println("Your hand is: " + getPlayerHand);

            boolean menuLoop = true;    // used to keep the menu option looping

            while(menuLoop)
            {
                System.out.println(" ");
                playerMenu();
                playerChoice = scnr.nextInt();
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

                    if(getDealerHand == 21)
                    {
                        System.out.println("Dealer has BLACKJACK! You lose :(");
                        System.out.println(" ");
                        dealerWins = dealerWins + 1;
                        menuLoop = false;
                    }

                    else if(getDealerHand > 21)
                    {
                        System.out.println("Dealer bust! You win!");
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
                    System.out.println("Number of Player wins: " + playerWins);
                    System.out.println("Number of Dealer wins: " + dealerWins);
                    System.out.println("Number of tie games: " + numberTies);
                    System.out.println("Total # of games played is: " + --gameNumber);

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
                    gameNumber++;
                    break;
                }

                while(playerChoice == 4)
                {
                    gameLoop = false;
                    menuLoop = false;
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
            getDealerHand = 0;
            getPlayerHand = 0;
            gameNumber++;
        }
        System.out.println("Thanks for playing!");
    }

    static int playerCards ()
    {

        //  following code determines what card the player is initially dealt and the point value assigned to it

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
