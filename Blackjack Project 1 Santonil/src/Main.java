import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {

        Scanner scnr = new Scanner(System.in);
        int playerChoice;
        int userHand = 0;
        int getPlayerHand;
        int dealerHand;
        int getDealerHand;
        int playerWins = 0;
        int dealerWins = 0;
        int numberTies = 0;
        int totalGamesPlayed;
        int percentGamesWon;
        int gameNumber = 1;

        boolean gameLoop = true;    // boolean value to keep game loop going (enabling consecutive games)

        while(gameLoop)
        {
            System.out.println("START GAME #" + gameNumber);
            userHand = initPlayerCards();   // the user is given a card, resulting in a point value from 1-10
            getPlayerHand = userHand;
            System.out.println("Your hand is: " + getPlayerHand);

            boolean menuLoop = true;    // used to keep the menu option looping

            while(menuLoop)
            {
                playerMenu();
                playerChoice = scnr.nextInt();

                while(playerChoice == 1)
                {
                    userHand = initPlayerCards();
                    getPlayerHand = getPlayerHand + userHand;
                    System.out.println("Your hand is " + getPlayerHand);
                    break;
                }

                while(playerChoice == 2)
                {
                    dealerHand = dealerCards();
                    getDealerHand = dealerHand;
                    break;
                }

                while(playerChoice == 3)
                {
                    System.out.println("Number of Player wins: " + playerWins);
                    System.out.println("Number of Dealer wins: " + dealerWins);
                    System.out.println("Number of tie games: " + numberTies);
                    System.out.println("Total # of games played is: " + gameNumber);
                    percentGamesWon = (playerWins / gameNumber);
                    System.out.println("Percentage of Player wins: " + (double)percentGamesWon);
                    break;
                }

                while(playerChoice == 4)
                {
                    gameLoop = false;
                    menuLoop = false;
                    break;
                }
            }
            gameNumber++;
        }
        System.out.println("Thanks for playing!");
    }

    static int initPlayerCards ()
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

    static int dealerCards()
    {
        Random dealerGen = new Random();

        int masterHand = 0;
        int dealerDealt = dealerGen.nextInt(11) + 16;

        System.out.println("Dealer's hand: " + dealerDealt);
        dealerDealt = masterHand;

        return(masterHand);
    }
}
