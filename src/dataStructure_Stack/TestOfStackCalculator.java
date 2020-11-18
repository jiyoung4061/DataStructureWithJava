package dataStructure_Stack;

public class TestOfStackCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StackCalculator cal = new StackCalculator("(1+2)*(3/4)+(5+(6-7))");
		// 12+34/*567-++
		System.out.println(cal.infixToPostfix());
	}

}
