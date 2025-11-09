/*
* DrawingShapes.java
* Author: Yueyue(Rita) Ma
*/
import java.util.Scanner;

public class DrawingShapes {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		//user enter a shape
		System.out.println("Enter a shape: r t h o p");
		String shape = keyboard.nextLine();
		
		//valid input
		if(!shape.equals("r") && !shape.equals("t") && !shape.equals("h") && !shape.equals("o") && !shape.equals("p")) {
			System.out.println("Invalid shape");
			System.out.println("Goodbye!");
			keyboard.close();
			return;
		}
		
		// initialize
		int length, height;
		
	    //Rectangle
		
		//length
		if(shape.equals("r")) {
			System.out.println("Enter a length");
			length = keyboard.nextInt();
			
			//invalid input
			if (length <= 1) {
                System.out.println("Length must be greater than 1");
                System.out.println("Goodbye!");
                keyboard.close();
                return;
			}
			
			//height
			System.out.println("Enter a height");
	        height = keyboard.nextInt();
	        
	        //invalid input
	        if (height <= 1) {
	        	System.out.println("Height must be greater than 1");
	        	System.out.println("Goodbye!");
	        	keyboard.close();
	        	return;
	        }
	        
	        System.out.println("Below is a " + length + " by " + height + " rectangle of *");
	        
	        //draw rectangle
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            keyboard.close();
            return;
		}
		
		//Triangle
		if (shape.equals("t")) {
            System.out.println("Enter a length");
            length = keyboard.nextInt();
            
            //invalid input
            if (length <= 1) {
                System.out.println("Length must be greater than 1");
                System.out.println("Goodbye!");
                keyboard.close();
                return;
            }
            System.out.println("Below is a triangle with two side lengths of " + length + " *");
            
            //draw triangle
            for (int i = 0; i < length; i++) {
                for (int s = 0; s < length - i - 1; s++) {
                    System.out.print(" ");
                }
                
                for (int j = 0; j < (2 * i + 1); j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            keyboard.close();
            return;
        }
		
		//Hexagon
		if (shape.equals("h")) {
            System.out.println("Enter a length");
            length = keyboard.nextInt();
            
            //invalid input
            if (length <= 1) {
                System.out.println("Length must be greater than 1");
                System.out.println("Goodbye!");
                keyboard.close();
                return;
            }
            System.out.println("Below is a hexagon with side lengths of " + length + " *");

            // draw Hexagon
            for (int i = 0; i < length; i++) {
                for (int s = 0; s < length - i - 1; s++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < length + 2 * i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            
            for (int i = length - 2; i >= 0; i--) {
                for (int s = 0; s < length - i - 1; s++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < length + 2 * i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            keyboard.close();
            return;
        }
		
		//Octagon
		if (shape.equals("o")) {
            System.out.println("Enter a length");
            length = keyboard.nextInt();
            
            //invalid input
            if (length <= 1) {
                System.out.println("Length must be greater than 1");
                System.out.println("Goodbye!");
                keyboard.close();
                return;
            }

            System.out.println("Below is an octagon with side lengths of " + length + " *");
            
            //draw Octagon
            for (int i = 0; i < length; i++) {
                for (int s = 0; s < length - i - 1; s++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < length + 2 * i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            
            for (int i = 0; i < length-1; i++) {
                for (int j = 0; j < 3 * length - 2; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            
            for (int i = length - 2; i >= 0; i--) {
                for (int s = 0; s < length - i - 1; s++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < length + 2 * i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            keyboard.close();
            return;
        }
		
		//Pentagon
		if (shape.equals("p")) {
            System.out.println("Enter a length");
            length = keyboard.nextInt();
            
            //invalid input
            if (length <= 1) {
                System.out.println("Length must be greater than 1");
                System.out.println("Goodbye!");
                keyboard.close();
                return;
            }

            System.out.println("Below is a pentagon with 4 side lengths of " + length + " *");
            
            //draw Pentagon
            
            //top part
            for (int i = 0; i < length; i++) {
                for (int s = 0; s < length - i - 1; s++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 2 * i + 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            
            //bottom part
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < 2 * length - 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            
            keyboard.close();
            return;
        }
		
        keyboard.close();
            
	}
	
}