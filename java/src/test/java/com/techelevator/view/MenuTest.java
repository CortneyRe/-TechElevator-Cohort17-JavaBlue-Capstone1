package com.techelevator.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.techelevator.view.Menu;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MenuTest {

	private ByteArrayOutputStream output;

	@Before
	public void setup() {
		output = new ByteArrayOutputStream();
	}

	@Test
	public void display_menu_and_make_a_choice () {
		Object[] options = new Object[] { Integer.valueOf(3), "Blind", "Mice" };
		Menu menu = getMenuForTesting();

		menu.getChoiceFromOptions(options, "");

		String expected = System.lineSeparator() + "(1) " + options[0].toString() + System.lineSeparator() + "(2) " + options[1].toString() + System.lineSeparator() + "(3) "
				+ options[2].toString() + System.lineSeparator() + "Please choose an option ";

		Assert.assertEquals(expected, output.toString());
	}

	@Test
	public void return_user_choice () {
		Integer expected = Integer.valueOf(456);
		Integer[] options = new Integer[] { Integer.valueOf(123), expected, Integer.valueOf(789) };
		Menu menu = getMenuForTestingWithUserInput("2" + System.lineSeparator());

		Integer result = (Integer) menu.getChoiceFromOptions(options, "");

		Assert.assertEquals(expected, result);
	}

	@Test
	public void show_menu_if_choice_is_not_valid () {
		Object[] options = new Object[] { "Larry", "Curly", "Moe" };
		Menu menu = getMenuForTestingWithUserInput("5" + System.lineSeparator() + "1" + System.lineSeparator());

		menu.getChoiceFromOptions(options, "");

		String menuDisplay = System.lineSeparator() + "(1) " + options[0].toString() + System.lineSeparator() + "(2) " + options[1].toString() + System.lineSeparator() + "(3) "
				+ options[2].toString() + System.lineSeparator() + "Please choose an option ";

		String expected = menuDisplay + "5 is not a valid option" + System.lineSeparator() + menuDisplay;

		Assert.assertEquals(expected, output.toString());
	}

	@Test
	public void show_menu_if_choice_less_than_1_ () {
		Object[] options = new Object[] { "Larry", "Curly", "Moe" };
		Menu menu = getMenuForTestingWithUserInput("0" + System.lineSeparator() + "1" + System.lineSeparator());

		menu.getChoiceFromOptions(options, "");

		String menuDisplay = System.lineSeparator() + "(1) " + options[0].toString() + System.lineSeparator() + "(2) " + options[1].toString() + System.lineSeparator() + "(3) "
				+ options[2].toString() + System.lineSeparator() + "Please choose an option ";

		String expected = menuDisplay + "0 is not a valid option" + System.lineSeparator() + menuDisplay;

		Assert.assertEquals(expected, output.toString());
	}

	@Test
	public void show_menu_if_input_is_string () {
		Object[] options = new Object[] { "Larry", "Curly", "Moe" };
		Menu menu = getMenuForTestingWithUserInput("Mickey Mouse" + System.lineSeparator() + "1" + System.lineSeparator());

		menu.getChoiceFromOptions(options, "");

		String menuDisplay = System.lineSeparator() + "(1) " + options[0].toString() + System.lineSeparator() + "(2) " + options[1].toString() + System.lineSeparator() + "(3) "
				+ options[2].toString() + System.lineSeparator() + "Please choose an option";

		String expected = menuDisplay + " Mickey Mouse is not a valid option" + System.lineSeparator() + menuDisplay + " ";

		Assert.assertEquals(expected, output.toString());
	}

	private Menu getMenuForTestingWithUserInput(String userInput) { // could probably delete
		ByteArrayInputStream input = new ByteArrayInputStream(String.valueOf(userInput).getBytes());
		return new Menu(input, output);
	}

	private Menu getMenuForTesting() {
		return getMenuForTestingWithUserInput("1" + System.lineSeparator());
	}
}
