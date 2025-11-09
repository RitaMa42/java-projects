/*
* StringFun.java
* Author: Yueyue(Rita) Ma
*/

import java.util.Scanner;

public class StringFun {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		//get the sentence from users
		System.out.println("Enter the string to be manipulated");
		String sentence = keyboard.nextLine();
		
		//get the command from users
		String command = ""; //initialize
		while (!command.equalsIgnoreCase("quit")) {
	            System.out.println("Enter your command (reverse, replace first, replace last, remove all, remove, quit)");
	            command = keyboard.nextLine();
	            
	            //reverse
	            if (command.equalsIgnoreCase("reverse")) {
	            	sentence = reverseString(sentence);
	            	System.out.println("The new sentence is: " + sentence);
	            	
	            //replace first
	            }else if (command.equalsIgnoreCase("replace first")) {
	            		 System.out.println("Enter the character to replace");
	                     String oldInput = keyboard.nextLine();
	                     char oldChar = readFirstCharOrNull(oldInput);

	                     System.out.println("Enter the new character");
	                     String newInput = keyboard.nextLine();
	                     char newChar = readFirstCharOrNull(newInput);
	                     
	                     //if not found
	                     int index = firstIndexOf(sentence, oldChar);
	                     if (index == -1) {
	                         System.out.println("The letter was not found in the word");
	                     } else {
	                         sentence = sentence.substring(0, index) + newChar + sentence.substring(index + 1);
	                         System.out.println("The new sentence is: " + sentence);
	                     }
	                     
	              //replace last
	              } else if (command.equalsIgnoreCase("replace last")) {
	                     System.out.println("Enter the character to replace");
	                     String oldInput = keyboard.nextLine();
	                     char oldChar = readFirstCharOrNull(oldInput);

	                     System.out.println("Enter the new character");
	                     String newInput = keyboard.nextLine();
	                     char newChar = readFirstCharOrNull(newInput);
	                     
	                     //if not found
	                     int index = lastIndexOf(sentence, oldChar);
	                     if (index == -1) {
	                         System.out.println("The letter was not found in the word");
	                     } else {
	                         sentence = sentence.substring(0, index) + newChar + sentence.substring(index + 1);
	                         System.out.println("The new sentence is: " + sentence);
	                     }
	                       
	             //remove all
	          	 } else if (command.equalsIgnoreCase("remove all")) {
	          		     System.out.println("Enter the character to remove");
	                     String chInput = keyboard.nextLine();
	                     char target = readFirstCharOrNull(chInput);

	                     sentence = removeAllOccurrences(sentence, target);
	                     System.out.println("The new sentence is: " + sentence);
	                       
	             //remove
	             } else if (command.equalsIgnoreCase("remove")) {
	                     System.out.println("Enter the character to remove");
	                     String chInput = keyboard.nextLine();
	                     char target = readFirstCharOrNull(chInput);
	                       
	                     System.out.println("Enter the " + target + " you would like to remove (Not the index - 1 = 1st, 2 = 2nd, etc.):");
	                     String kInput = keyboard.nextLine();
	                     int kth = parsePositiveIntOrZero(kInput); // <=0 means invalid
	                     
	                     //if invalid 
	                     if (kth <= 0) {
	                     System.out.println("Error: the letter you are trying to remove does not exist");
	                     
	                     //if valid
	               		}else {
	               			String newSentence = removeKthOccurrence(sentence, target, kth);
	               			if (newSentence.equals(sentence)) {
	                       				
	                    // if not found
	                    System.out.println("Error: the letter you are trying to remove does not exist");
	                    } else {
	                    	sentence = newSentence;
	                       	System.out.println("The new sentence is: " + sentence);
	                           }
	                       }
	                       
	              //quit and end program
	              }else if (command.equalsIgnoreCase("quit")) {
	                     System.out.println("…Execution Ends…");
	                     
	             //if command invalid
	             } else {
	                     System.out.println("Command invalid. Try again");
	                   }
	               }
	            	keyboard.close();
	            }
	
	//method used
	            
		//reverseString
		private static String reverseString(String s) {
	        String result = "";
	        int i = s.length() - 1;
	        while (i >= 0) {
	            result = result + s.charAt(i);
	            i = i - 1;
	        }
	        return result;
	    }
		
		//Find first index of a character, and return -1 if not found
	    private static int firstIndexOf(String s, char ch) {
	        int i = 0;
	        int found = -1;
	        while (i < s.length()) {
	            if (s.charAt(i) == ch && found == -1) {
	                found = i;
	            }
	            i = i + 1;
	        }
	        return found;
	    }
	    
	    //Find last index of a char
	    private static int lastIndexOf(String s, char ch) {
	        int i = s.length() - 1;
	        int found = -1;
	        while (i >= 0) {
	            if (s.charAt(i) == ch && found == -1) {
	                found = i;
	            }
	            i = i - 1;
	        }
	        return found;
	    }
	    
	    //remove all occurrences of target char
	    private static String removeAllOccurrences(String s, char target) {
	        String result = "";
	        int i = 0;
	        while (i < s.length()) {
	            char c = s.charAt(i);
	            if (c == target) {
	                // skip appending (no continue used)
	            } else {
	                result = result + c;
	            }
	            i = i + 1;
	        }
	        return result;
	    }
	    

	    // Remove the kth occurrence of target character; if not present, returns original string.
	    private static String removeKthOccurrence(String s, char target, int kth) {
	        String result = "";
	        int i = 0;
	        int count = 0;
	        boolean removed = false;

	        while (i < s.length()) {
	            char c = s.charAt(i);
	            boolean isTarget = (c == target);

	            if (isTarget && !removed) {
	                int nextCount = count + 1;
	                if (nextCount == kth) {
	                    // Skip -> removal
	                    removed = true;
	                    count = nextCount;
	                    // do not append
	                } else {
	                    // Not the kth yet; append and update count
	                    result = result + c;
	                    count = nextCount;
	                }
	            } else {
	                // Non-target or already removed; just append
	                result = result + c;
	            }

	            i = i + 1;
	        }

	        // If not removed (kth > total occurrences), return original unchanged
	        if (!removed) {
	            return s;
	        }
	        return result;
	    }

	    // read first character of a line; if empty, returns '\0' 
	    private static char readFirstCharOrNull(String line) {
	        if (line.length() > 0) {
	            return line.charAt(0);
	        }
	        return '\0';
	    }

	    // Parse a positive integer, or return 0 if invalid
	    private static int parsePositiveIntOrZero(String s) {
	        int i = 0;
	        int value = 0;
	        boolean seenDigit = false;

	        while (i < s.length()) {
	            char ch = s.charAt(i);
	            if (ch >= '0' && ch <= '9') {
	                int digit = ch - '0';
	                value = value * 10 + digit;
	                seenDigit = true;
	            } else if (ch == ' ' || ch == '\t') {
	            } else {
	                // invalid character -> fail
	                return 0;
	            }
	            i = i + 1;
	        }
	        if (!seenDigit) {
	            return 0;
	        }
	        if (value <= 0) {
	            return 0;
	        }
	        return value;
	    }
	}
