package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.math.BigDecimal;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options, String message) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			System.out.println(message);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	public Object getChoiceFromOptions(Object[] options) {
		return getChoiceFromOptions(options, "");

	}

	public BigDecimal getAmountFromUserInput() {

		Map<String, String> acceptedBills = new HashMap<String, String>();
		acceptedBills.put("one", "1");
		acceptedBills.put("five", "5");
		acceptedBills.put("ten", "10");
		acceptedBills.put("twenty", "20");
		//acceptedBills.put("zero", "0");

//			String one = "1";
//			String five = "5";
//			String ten = "10";
//			String twenty = "20";


		String userInput;
		out.println();
		out.println("Please enter only (1, 5, 10, 20)");
		out.print("Please enter an amount, press 0 to begin purchase >>> $");
		out.flush();

		userInput = in.nextLine();
		if ((!userInput.toLowerCase().equals("0"))
				&& (userInput.equals(acceptedBills.get("one")) || userInput.equals(acceptedBills.get("five")) || userInput.equals(acceptedBills.get("ten"))
				|| userInput.equals(acceptedBills.get("twenty")))) {
			try {
				return new BigDecimal(userInput);
			} catch (NumberFormatException ex) {
				out.println("Please enter a valid number: ");
				out.println();
				out.flush();
			}

		}
		return null;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		out.print("Please choose an option ");
		out.flush();
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will
			// be null
		}
//		if (Integer.valueOf(userInput) == 4) {
//			System.out.println("This worked");
//		}
		  if (choice == null) {
			out.println(userInput + " is not a valid option");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println("(" + optionNum + ") " + options[i]);
		}
		out.flush();

	}
}
