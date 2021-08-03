/**
 * Name Surname: Dilay Sapmaz
 * ID: 041701032
 * Date: 05.11.2018
 * This code executes for a parenthesis error in the mathematical expression that the user enters.
*/

package MathematicalParenthesisChecker;

import java.util.Scanner;

public class dilay_sapmaz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a mathematical expression: ");
		String expression=input.next(); 
		parenthesisMethod(expression);   //calling the method
		input.close();

	}

	public static void parenthesisMethod(String paranthesis) { //this method is looking for; if there is a mistake about parenthesis or not.

		char[] input = paranthesis.toCharArray(); 
		myStack<Character> stack = new myStack<>(); 
		int counter = 0;  //if user enters close parenthesis: ")" program gives an error. I use this for solving this problem.

		for(int i=0 ; i<input.length ; i++) { 
			
			if(paranthesis.charAt(0)==')' || paranthesis.charAt(0)== ']') { //it takes the first char at users expression
				System.out.println("Parentheses do not match!");
				counter = 3; //if the first char is close parenthesis, counter will be 3. I made up my head that 3 number.
				break;  //if user's input is closing parenthesis, this code break it and says
			} 
 
			if(  (  (input[i] == '(' )  ||  (input[i]== '[')  )  ) { // if user write open parenthesis

				stack.push(input[i]);//we add that stack
				System.out.print("Stack Contents: [top]    ");

				for (Character value : stack) { 
					System.out.print(value + " "); //it writes parenthesis in stack
				}
				System.out.println("    [bottom]"); 

			}else if( (input[i] == ')' && stack.peek()=='(') || (input[i] ==']' && stack.peek()=='[' ) ) { //if user writes closing paranthesis and 
				//if parenthesis are matching, it will pop out.
				stack.pop(); 
			}
		}

		if((stack.isEmpty()) && (counter!=3) ){ // if stack is empty and not start with close parenthesis, it executes this:
			System.out.println("Parentheses are correct. ");
		}else if (stack.isEmpty()==false && counter!=3){ //stack is full, not start with closing parenthesis
			System.out.println("Parentheses do not match: Final stack is not empty!  ");
		}else if (stack.isEmpty()==true && counter !=3){ //stack is empty and starting with closing parenthesis
			System.out.println("Parantheses do not match. ");
		}
	}
}
