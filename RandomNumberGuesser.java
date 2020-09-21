package RandomNumberGuesser;

import java.util.Scanner;

public class RandomNumberGuesser {
	private static int guess, count, number, lowNumber=0, highNumber=99;
	private static boolean value, firstrestart = true, secondrestart=true;
	private static String again = "y", answer;
	
	public static void main(String[] args) {
		
	while(firstrestart) {
		number = RNG.rand();  //This obtains the number the user is trying to guess			
		Scanner s = new Scanner(System.in);
		System.out.println("Random Number Guesser");  //Title
		System.out.println("Enter your first guess (0-99): "); //Ask the user for their first guess
		guess = s.nextInt();  //save their guess into a variable
		RNG.addCount(); //add guess count
		count = RNG.getCount();   //obtain the guess number
		value = RNG.inputValidation(count, lowNumber, highNumber);  //Checks to see if the guess is in the range
		if(!value) {  //If it's not in the range, than this if-statement will ask the user to make another guess
			System.out.println("Your guess must be in the range of "+lowNumber +"-"+highNumber);
			System.out.println("Enter your next guess between "+lowNumber+"-"+highNumber); //The range changed depending on their guess
			guess = s.nextInt();
			RNG.addCount(); //the guess amount is increased again
			count = RNG.getCount();
			System.out.println("Number of guesses is " + count);
		}
		if(number < guess) {  //If this guess is too high, this will notify the user asking them to try again
			System.out.println("Your guess is too high");
			highNumber=guess;
			System.out.println("Enter your next guess between "+lowNumber+"-"+ highNumber); //The range changed as a result of their guesses.
			guess = s.nextInt();
			count = RNG.getCount();
			System.out.println("Number of guesses is " + count);
		}
		else if(guess < number) { //If the guess is too low, this will notify the user asking them to make another guess
			System.out.println("Your guess is too low");
			lowNumber = guess;
			System.out.println("Enter your next guess between "+lowNumber+"-"+ highNumber);
			guess = s.nextInt();
			count = RNG.getCount();
			System.out.println("Number of guesses is " + count);
		}
		else { //If they guessed the number first try, then this will display a Congrats statement
			System.out.println("Congradulations, you guessed correctly");
			System.out.println("Do you want to try again? (y or n)");
			answer = s.nextLine();
		
		if(answer.equalsIgnoreCase(again)) { //If the user decides to go again, than this will reset some of the crucial variables so the program
				//can perform as if it just started again.
				RNG.resetCount();
				count = RNG.getCount();
				guess=0;
				lowNumber=0;
				highNumber=99;
				break;
				}
		
		else {
				System.out.println("Thanks for playing....");
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("Programmer: Nathan Assefa");			
				System.exit(1);
				}
						
		}
	

	while(secondrestart) {  //If the user doesn't get the number first try, this while loop will repeat most of the steps above.
		value = RNG.inputValidation(guess, lowNumber, highNumber);
		if(!value) {
			System.out.println("Enter your next guess between "+lowNumber+"-"+highNumber);//the range changes again
			guess = s.nextInt();
			RNG.addCount(); 
			count = RNG.getCount();
			System.out.println("Number of guesses is " + count);   //The number of guesses that were stored are outputed from the second guess and onward
		}
		if(number < guess) {
			System.out.println("Your guess is too high");
			highNumber=guess;
			System.out.println("Enter your next guess between "+lowNumber+"-"+ highNumber);
			guess = s.nextInt();
			count = RNG.getCount();
			System.out.println("Number of guesses is " + count);
			}
		else if(guess < number) {
			System.out.println("Your guess is too low");
			lowNumber = guess;
			System.out.println("Enter your next guess between "+lowNumber+"-"+ highNumber);
			guess = s.nextInt();
			count = RNG.getCount();
			System.out.println("Number of guesses is " + count);
			}
		else if(guess==number) {
			System.out.println("Congradulations, you guessed correctly");
			System.out.println("Do you want to try again? (y or n)");
			s.nextLine();
			answer = s.nextLine();
				
		if(answer.equalsIgnoreCase(again)) { //If the user decides to go again, than this will reset some of the crucial variables so the program
			//can perform as if it just started again.
			RNG.resetCount();
			count = RNG.getCount();
			guess=0;
			lowNumber=0;
			highNumber=99;
			break;
			}
		else {
			System.out.println("Thanks for playing....");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("Programmer: Nathan Assefa");			
			System.exit(1);
			}
					
		}
	}
		
	}
	}
}
