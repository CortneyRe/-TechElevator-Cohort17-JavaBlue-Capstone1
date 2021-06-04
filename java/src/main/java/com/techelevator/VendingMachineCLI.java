package com.techelevator;

import com.techelevator.view.Menu;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachineCLI {

	//
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private static final String DISPLAY_MENU_OPTION_BILL_FEED = "Feed dollar bills or insert coins" ;
	private static final String DISPLAY_MENU_OPTION_SELECT_ITEM = "Select item to purchase";
	private static final String DISPLAY_MENU_OPTION_END_TRANSACTION = "End transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { DISPLAY_MENU_OPTION_BILL_FEED, DISPLAY_MENU_OPTION_SELECT_ITEM, DISPLAY_MENU_OPTION_END_TRANSACTION };

	private Menu vendingMachineMenu;


	//
	public VendingMachineCLI(Menu vendingMachineMenu) {
		this.vendingMachineMenu = vendingMachineMenu;
	}


	//
	public void run() throws IOException {
		Inventory newVendingMachineInventory = new Inventory();
		VendingMachine Vend1000 = new VendingMachine();
		Purchase userCart = new Purchase();
		LogEntry logFile = new LogEntry();

		while (true) {
			String choice = (String) vendingMachineMenu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				//keep track of items purchased
				int counter = 0;

				for(String slotName : Vend1000.getVendingMachineInventory().keySet()) {
					System.out.println(Vend1000.getVendingMachineInventory().keySet().toArray()[counter]);
					System.out.println(Vend1000.getVendingMachineInventory().get(slotName).toArray()[0]);
					System.out.println("Number of items left: " + Vend1000.getVendingMachineInventory().get(slotName).size());
					System.out.println();
					counter++;
				}
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				// do purchase
				while (true) {
					choice = (String) vendingMachineMenu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS, "\nAmount of current balance: $ " + Vend1000.getUserBalance());

					if(choice.equals(DISPLAY_MENU_OPTION_BILL_FEED)) {
						BigDecimal amountFromUser = vendingMachineMenu.getAmountFromUserInput();

						while(amountFromUser!= null) {
							Vend1000.addMoreFunds(amountFromUser);
							System.out.println("Your balance is: $ " + Vend1000.getUserBalance());
							logFile.logEntryMethod("Feed dollar bills or insert coins", amountFromUser, Vend1000.getUserBalance());
							amountFromUser = vendingMachineMenu.getAmountFromUserInput();
						}
					}
					if (choice.equals(DISPLAY_MENU_OPTION_SELECT_ITEM)) {
						System.out.println("What would you like to purchase?");
						Scanner userInput = new Scanner(System.in);
						String itemToPurchase = userInput.nextLine();
						Item boughtItem = null;

						if(Vend1000.getVendingMachineInventory().containsKey(itemToPurchase)) {

							try {
								BigDecimal moreLogMethod = Vend1000.getUserBalance();
								boughtItem = Vend1000.buyVendingItem(itemToPurchase);
								userCart.addToCart(boughtItem);
								System.out.println(boughtItem);
								logFile.logEntryMethod( boughtItem.getItemName(), moreLogMethod, Vend1000.getUserBalance());

							} catch (NotInStockException e) {
								System.out.println(e.getMessage());
								choice.equals(DISPLAY_MENU_OPTION_SELECT_ITEM);

							} catch (LackingFundsException e) {
								System.out.println(e.getMessage());
								choice.equals(DISPLAY_MENU_OPTION_SELECT_ITEM);
							}

						} else {
							System.out.println("Please choose a valid item ID");
							choice.equals(DISPLAY_MENU_OPTION_SELECT_ITEM);
						}
					}

					if (choice.equals(DISPLAY_MENU_OPTION_END_TRANSACTION)) {
						BigDecimal moreLogMethod = Vend1000.getUserBalance();
						System.out.println(Vend1000.makeChange());
						logFile.logEntryMethod("GIVE CHANGE", moreLogMethod, Vend1000.getUserBalance());
						System.out.println(userCart.emptyCart());
						break;
					}

				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
