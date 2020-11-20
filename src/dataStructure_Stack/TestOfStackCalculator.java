package dataStructure_Stack;

public class TestOfStackCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		StackCalculator cal = new StackCalculator("(1+2)*(3/4)+(5+(6-7))");
//		StackCalculator cal2 = new StackCalculator("(1+2*3)/7");
//		StackCalculator cal3 = new StackCalculator("2*3/(2-4)+1");
//		StackCalculator cal4 = new StackCalculator("3*4");
		StackCalculator cal4 = new StackCalculator("(8+2)/5*3-9+(6+9*(2-1))");

//		System.out.println(cal.infixToPostfix());
//		System.out.println(cal2.infixToPostfix());
//		System.out.println(cal3.infixToPostfix());
		System.out.println(cal4.infixToPostfix());
//		System.out.println(cal.CalculatorUsingStack());
//		System.out.println(cal2.CalculatorUsingStack());
//		System.out.println(cal3.CalculatorUsingStack());
		System.out.println(cal4.CalculatorUsingStack());
	}
}
