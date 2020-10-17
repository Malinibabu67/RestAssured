package firsttest;

public class Calculator {

	public static void main(String[] args) {
		Calculator basicCal = new Calculator ();
		basicCal.addNumbers(100,45);
		basicCal.diffNumbers(100,45);
		basicCal.multiplyNumbers(100,45);
		basicCal.divideNumbers(100,45);
	}	
    public void addNumbers(int num1, int num2) {
    	int sum = num1 + num2;
    	System.out.println(sum);
    }
    public void diffNumbers(int num1, int num2) {
    	int diff = num1 - num2;
    	System.out.println(diff);
    }
    public void multiplyNumbers(int num1, int num2) {
    	int multiply = num1 * num2;
    	System.out.println(multiply);
    }
    public void divideNumbers(int num1, int num2) {
    	int divide = num1 / num2;
    	System.out.println("divided number is:" + divide);
    }
}
