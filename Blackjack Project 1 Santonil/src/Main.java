import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        int userPoints = playerCards();   // the user is given a card, resulting in a point value from 1-10

        System.out.println("Your hand is: " + userPoints);

        playerMenu();

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
