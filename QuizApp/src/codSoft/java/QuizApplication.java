package codSoft.java;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {

	private static final int TIME_LIMIT = 10; // Time limit in seconds for each question
	private static int score = 0;
	private static int questionIndex = 0;
	private static Scanner scanner = new Scanner(System.in);
	private static QuizQuestion[] questions = {
			new QuizQuestion("What is the size of int in Java?",
					new String[] { "1 byte", "2 bytes", "4 bytes", "8 bytes" }, 2),
			new QuizQuestion("Which company developed Java?",
					new String[] { "Microsoft", "Apple", "Sun Microsystems", "Google" }, 2),
			new QuizQuestion("Which keyword is used to define a class in Java?",
					new String[] { "define", "class", "struct", "object" }, 1),
			new QuizQuestion("What is the default value of a boolean variable in Java?",
					new String[] { "true", "false", "0", "null" }, 1),
			new QuizQuestion("Which method is the entry point of a Java program?",
					new String[] { "start()", "main()", "run()", "init()" }, 1) };

	public static void main(String[] args) {
		while (questionIndex < questions.length) {
			askQuestion(questions[questionIndex]);
			questionIndex++;
		}
		displayResults();
	}

	private static void askQuestion(QuizQuestion question) {
		System.out.println("Question " + (questionIndex + 1) + ": " + question.getQuestion());
		String[] options = question.getOptions();
		for (int i = 0; i < options.length; i++) {
			System.out.println((i + 1) + ". " + options[i]);
		}

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println("\nTime's up! Moving to the next question.");
				questionIndex++;
				if (questionIndex < questions.length) {
					askQuestion(questions[questionIndex]);
				} else {
					displayResults();
					System.exit(0);
				}
			}
		};
		timer.schedule(task, TIME_LIMIT * 1000);

		int answer = scanner.nextInt();
		timer.cancel();

		if (answer - 1 == question.getCorrectAnswerIndex()) {
			score++;
			System.out.println("Correct!");
		} else {
			System.out.println("Incorrect. The correct answer was: " + options[question.getCorrectAnswerIndex()]);
		}
	}

	private static void displayResults() {
		System.out.println("\nQuiz over! Your final score is: " + score + "/" + questions.length);
		for (int i = 0; i < questions.length; i++) {
			System.out.println("Question " + (i + 1) + ": " + questions[i].getQuestion());
			System.out.println("Correct answer: " + questions[i].getOptions()[questions[i].getCorrectAnswerIndex()]);
		}
	}
}
