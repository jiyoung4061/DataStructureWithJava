package dataStructure_Stack;

public class TestOfStackCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StackCalculator cal = new StackCalculator("(1+2)*(3/4)+(5+(6-7))");
		StackCalculator cal2 = new StackCalculator("(1+2*3)/7");
		StackCalculator cal3 = new StackCalculator("2*3/(2+4)+1");
		// 12+34/*567-++
		System.out.println(cal.infixToPostfix());
//		System.out.println(cal2.infixToPostfix());
//		System.out.println(cal3.infixToPostfix());
	}

}
