package com.expect;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessNumber {

	
	private int min;
	private int max;
	private static final String REAADY = "ready";
	private static final String HIGHER = "higher";
	private static final String LOWER = "lower";
	private static final String EQUAL = "equal";
	private static final double _0_5 = 0.5;
	private static List<String>  inputList = new ArrayList<String>();
	private int guessnumber = 0;
	    //Total guesses taken
	private int guessestaken = 0;
	
	
	//static block to intialize the valid inputs
	static{
		inputList.add(REAADY);
		inputList.add(HIGHER);
		inputList.add(LOWER);
		inputList.add(EQUAL);
	}
	
	public GuessNumber(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}
	
	public void GuessUserNumber() {
		System.out.println("say ready when you are ready");
		String ready = getUserInput();
		if(ready.equalsIgnoreCase(REAADY)){
			//Assign a new random number to guessnumber
			guessnumber = generateNewNumber();
			String userInputString = null;
			do {
				guessestaken++;
				// Get the user input whilst guess is wrong
				System.out.println("is your nuber " + guessnumber);
				userInputString = getUserInput();
				if(userInputString.equalsIgnoreCase(HIGHER)){
					min = guessnumber;
					//guessnumber = generateNewNumber();
				}else if(userInputString.equalsIgnoreCase(LOWER)){
					max = guessnumber;
					//guessnumber = generateNewNumber();
				}
				guessnumber = generateNewNumber();
				//Check user input
			} while (!userInputString.equals(EQUAL));
			System.out.println("congrats, we guessed your number in "+guessestaken +" attempts , and your number is " + guessnumber);
		}else{
			GuessUserNumber(); //recursive call to make sure user enters ready
		}
	}
    // Gets an integer value from user
	private String getUserInput() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String userinput = input.nextLine();
		if (inputList.contains(userinput)) {
			return userinput;
		} else {
			System.out.println("you have entered invalid input enter again");
			return getUserInput();// recursive call to make sure user enters the valid input
		}

	}

    //Generate a new value between MIN and MAX
    private int generateNewNumber() {
        return (int) ((_0_5 * (this.max - this.min)) + this.min);
    }
	
	
}
