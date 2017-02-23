package WarmUpProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	
	public static void main(String[] args){
		String enc; 
		String dec;
		try{
			BufferedReader readIn = new BufferedReader(new FileReader("Cryptography Text File.txt")); // reads in the crypto text file 
			String line = readIn.readLine(); // stores the text file in a string called line
			while (line != null){ // if the text file is empty then end otherwise read
				if(line.charAt(0)=='E'){ //if the first line begins with E store in enc and read next line
					enc=line; // store line in enc
					Encrypt(enc); // send the enc string into Encrypt function
					line = readIn.readLine(); // read next line
				} else{ // otherwise store in dec and read next line
					dec=line; // store next line in dec
					Decrypt(dec); // send the dec string into Decrypt function
					line = readIn.readLine(); // read next line
				}
			}
			readIn.close(); // close the buffer reader
			
		} catch(IOException i){
			System.out.print("Problems..."); // throw a file exception error if there is a problem with the text file reader
		}
		
	}
	public static void Encrypt(String encode) throws FileNotFoundException {
		PrintWriter EnOut = new PrintWriter("Encode.txt"); // creates a text file called Encode
		int numCol=Character.getNumericValue(encode.charAt(1)); // gets the numeric value of the second character in the string
		encode = encode.substring(2, encode.length()-1); // skips to the second characters in the string
		int count=0;
		char inArray[][] = new char [6][numCol]; // makes a 2d array with the column number from the string
		for(int row=0; row<6; row++){
			for(int col=0; col<numCol; col++){
				if(count<encode.length()){ // if there is a character for a slot in the array
					inArray[row][col]=encode.charAt(count++); // fill in the array one character at a time from rows to columns
				} else{ // otherwise if there is no character in the slot
					inArray[row][col]='X'; // fill it with 'Z'
				}
			}
		}
		for(int row=0; row<5; row++){
			for(int col=0; col<6; col++){
				System.out.print(inArray[col][row] + " "); // go through the array and print in console (testing to see if it works)
				EnOut.print(inArray[col][row] + " "); // goes through the array and input each character in the text file
			}
		}
		
		System.out.println(); // skip a line in the console
		EnOut.print("*"); // prints a * in the end of the text file
		EnOut.close(); // close the print writer
	}
	
	public static void Decrypt(String decode) throws FileNotFoundException {
		PrintWriter DeOut = new PrintWriter("Decode.txt"); // create a text file called Decode
		int numCol=Character.getNumericValue(decode.charAt(1)); // gets the numeric value of the second character in the string
		int numRow=decode.length()/numCol; // gets a value for the row by dividing the string length by the column number
		decode = decode.substring(2, decode.length()-1); // skips to the second characters in the string
		int count=0;
		char outArray[][]= new char[numRow][numCol]; // makes a 2d array with the column number from the string
		for(int row=0; row<numRow; row++){
			for(int col=0; col<numCol; col++){
					outArray[col][row]=decode.charAt(count++); // fill in the array one character at a time from columns to rows
			}
		}
		for(int row=0; row<6; row++){
			for(int col=0; col<6; col++){
				if(outArray[row][col]!='Z'){ // if the array has a 'Z', removes from the array
					System.out.print(outArray[row][col] + " "); // go through the array and print in console (testing to see if it works)
					DeOut.print(outArray[row][col] + " "); // goes through the array and input each character in the text file
				}
			}
		}
		DeOut.print("*"); // prints a * in the end of the text file
		DeOut.close(); // close the print writer
	}
}
