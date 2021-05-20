import java.util.Scanner;

public class Question {
	private Scanner keyboard = new Scanner (System.in);
	private String theQuestion;
	private int theNumber;
	private String userAnswer;
	private String theAnswer;
	private boolean correctOrNot = false;
	
	public Question(String question, String correctAnswer) {
		theQuestion = question;
		theAnswer = correctAnswer.toLowerCase();;
	}	
	
	public boolean askQuestion() {
		System.out.println(theQuestion);
		System.out.print("Enter your answer: ");
		userAnswer = keyboard.nextLine();
		userAnswer = userAnswer.toLowerCase();
		if (userAnswer.equals(theAnswer)) {
			correctOrNot = true;
			System.out.println("Correct, + $1000");
		} else {
			correctOrNot = false;
			System.out.println("Wrong, + 0$");
		}
		
		return correctOrNot;
		
	}
		
}
