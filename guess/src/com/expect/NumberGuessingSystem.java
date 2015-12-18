package com.expect;

public class NumberGuessingSystem {

	   public static void main(String args[]) {
		   System.out.println("Guess Your Number ");
		   GuessNumber guessNumber =  new GuessNumber(0, 1000);
		   guessNumber.GuessUserNumber();
	        
	    }
}