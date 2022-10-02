package drive;

import java.util.Scanner;

public class RandomNumberGuesser {
	
    public static Scanner scan;
    public static int randNum;
    public static int nextGuess, highGuess, lowGuess;
    public static RNG rand;
    public static void main(String[] args) {
        rand = new RNG();
        String tryAgain = "yes";
        while ( tryAgain.equals("yes")) {
            initializeGame();
            playGame();
            System.out.println("Try again? (yes or no)");
            tryAgain = scan.next();
            System.out.println("");
        }
        System.out.println("Thanks for playing...");
    }

    public static void initializeGame() {
        lowGuess = 0;
        highGuess = 100;
        randNum = RNG.rand();
        RNG.resetCount();
    }
    
    public static void playGame() {
        scan = new Scanner(System.in);
        System.out.println("Enter your first guess");
        nextGuess = scan.nextInt();

        	while(nextGuess != randNum)
        	{
        		if (RNG.getCount() >= 7)
        		{
        			System.out.println("You have exceeded the maximum number of guesses, 7.  Try again");
        			break;
        		}
        		
        		if (!RNG.inputValidation(nextGuess, lowGuess, highGuess)) 
        		{
        			nextGuess = scan.nextInt();
        			continue;
        		}

        		System.out.println("Number of guesses is " + RNG.getCount());
        		if (nextGuess > randNum) 
        		{
        			highGuess = nextGuess;
        			System.out.println("Your guess is too high");
                
        		} else 
        			{
        				lowGuess = nextGuess;
        				System.out.println("Your guess is too low");
        			}
        		System.out.println("Enter your next guess between "+ lowGuess + " and " + highGuess);
        		nextGuess = scan.nextInt();
        	}
        	
        	if (nextGuess == randNum) 
        	{
        		System.out.println("Number of guesses is: "+(RNG.getCount()+1));
                System.out.println("Congratulations, you guessed correctly");	
        	}
        	
        
        
        
    }
}