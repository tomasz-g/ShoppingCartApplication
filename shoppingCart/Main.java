package shoppingCart;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static ArrayList<Product> inventory = new ArrayList<Product>();
	private static ArrayList<Product> basket = new ArrayList<Product>();
	private static Scanner input = new Scanner(System.in);
	private static BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
	

	public static void main(String[] args) {
		menu();
	}

	/*This is the first method in the program, user chooses if they would like
	 * to go to the admin menu or if they would like to go shopping*/  
	private static void menu() {
		
		System.out.println("\n \n***************************************************************");
		System.out.println("Press 1 for admin menu or any other key to start shopping");	
		System.out.println("***************************************************************");

		String choice = input.next();
		
		switch (choice) {
		
			case "1": {
				adminMenu();
				break;
			}
			default: {
				buyItem();
				break;
			}
		}
	}

	/* This is the admin menu, it gives the user 4 different choices, they can 
	 * add product to add new stock, or print product to see what products are
	 * already in stock, or delete product to remove a product from stock or
	 * simply return to the main menu*/
	private static void adminMenu() {
		System.out.println("\n \n***************************************************************");
		System.out.println(" add Product - press 1 \n print Products - press 2");
		System.out.println(" delete Product - press 3 \n back to main - press any other key");
		System.out.println("***************************************************************");

		String choice = input.next();
		
		switch (choice) {
		
			case "1": {
				addProduct();
				menu();
				break;
			}
			case "2": {
				printInventory(inventory);
				menu();
				break;
			}
			case "3": {
				deletePrduct();
				break;
			}
			default: {
				menu();
				break;
			}
		}
	}

	/* After selecting add product the user is brought to this menu, this is where they
	 * select which item is being added to stock, they select which products to stock or
	 *return to main*/
	private static void addProduct() {
		
		System.out.println("\n \n***************************************************************");
		System.out.println("Add Shoes - press 1");
		System.out.println("Add Books - press 2");
		System.out.println("Add DVD - press 3");
		System.out.println("Back to main - press 4");
		System.out.println("***************************************************************");

		
		String choice = input.next();
		
		switch (choice) {
		
			case "1": {
				addShoes();
				break;
			}
			case "2": {
				addBook();
				break;
			}
			case "3": {
				addDVD();
				break;
			}
			case "4": {
				menu();
				break;
			}
			default: {
				System.out.println("Wrong input, Try again");
				addProduct();
				break;
			}
		}
	}

	/*this is where you add select the shoe specifications*/
	private static void addShoes() {
		
		Shoe s = new Shoe();
		System.out.println("\n \n***************************************************************");
		
		try {
			System.out.println("Enter brand:");
			s.setName(input2.readLine());
			System.out.println("Material Type:");
			s.setMaterial(input2.readLine());
			System.out.println("Enter size:");
			s.setSize(input.nextInt());
			System.out.println("Enter price:");
			s.setPrice(input.nextDouble());
			System.out.println("Enter quantity:");
			s.setQuantity(input.nextInt());
			s.setType("shoes");
		}
		
		catch (InputMismatchException | IOException  e) {
			System.out.println("Error, WRONG INPUT - please try again");
			addShoes();
		}
		
		System.out.println("***************************************************************");
		inventory.add(s);
	}

	/*this is where you add select the book specifications*/
	private static void addBook() {
		
		Book b = new Book();
		System.out.println("\n \n***************************************************************");
		
		try {
			System.out.println("Enter title:");
			b.setName(input2.readLine());
			System.out.println("Enter author:");
			b.setAuthor(input2.readLine());
			System.out.println("Enter ISBN number:");
			b.setIsbn(input.nextInt());
			System.out.println("Enter price:");
			b.setPrice(input.nextDouble());
			System.out.println("Enter quantity:");
			b.setQuantity(input.nextInt());
			b.setType("book");
		}
		
		catch (InputMismatchException | IOException  e) {
			System.out.println("Error, WRONG INPUT - please try again");
			addBook();
		}
		
		System.out.println("***************************************************************");
		
		inventory.add(b);
	}

	/*this is where you add select the DVD specifications*/
	private static void addDVD() {

		DVD d = new DVD();
		System.out.println("\n \n***************************************************************");

		
		try {
			System.out.println("Enter title:");
			d.setName(input2.readLine());
			System.out.println("Enter category:");
			d.setCategory(input2.readLine());
			System.out.println("Enter language:");
			d.setLanguage(input2.readLine());
			System.out.println("Enter price:");
			d.setPrice(input.nextDouble());
			System.out.println("Enter quantity:");
			d.setQuantity(input.nextInt());
			d.setType("DVD");
		}
		
		catch (InputMismatchException | IOException  e) {
			System.out.println("Error, WRONG INPUT - please try again");
			addBook();
		}
		
		System.out.println("***************************************************************");

		inventory.add(d);
	}

	/* this is method where the information that the admin entered about the product is displayed*/
	private static void printInventory(ArrayList<Product> itemsList) {
		
		int productId = 1;
		
		for (Product i: itemsList) {
			
			if (i.getType() == "shoes") {
				
				Shoe temp = (Shoe)i;
				
				System.out.println("\n***********************************************************************************");
				System.out.print("Product ID \t");
				System.out.print("Brand \t\t");
				System.out.print("Price \t");
				System.out.print("Quantity \t");
				System.out.print("Material Type \t");
				System.out.print("Size \n");
				System.out.println();
				System.out.print("\t" + productId + "\t");
				temp.print();
				System.out.print(temp.getMaterial() + "\t \t" + temp.getSize() + "\n");
				System.out.println("***********************************************************************************");
				System.out.println();
				
				productId++;
			}
			
			if (i.getType() == "book") {
				
				Book temp = (Book)i;
				
				System.out.println("\n***********************************************************************************");
				System.out.print("Product ID \t");
				System.out.print("Title \t\t");
				System.out.print("Price \t");
				System.out.print("Quantity \t");
				System.out.print("Author \t\t");
				System.out.print("ISBN \n");
				System.out.println();
				System.out.print("\t" + productId + "\t");
				temp.print();
				System.out.print(temp.getAuthor() + "\t\t" + temp.getIsbn() + "\n");
				System.out.println("***********************************************************************************");
				System.out.println();
				
				productId++;
			}
			
			if (i.getType() == "DVD") {
				
				DVD temp = (DVD)i;
				
				System.out.println("\n***********************************************************************************");
				System.out.print("Product ID \t");
				System.out.print("Title \t\t");
				System.out.print("Price \t");
				System.out.print("Quantity \t");
				System.out.print("Category \t");
				System.out.print("Language \n");
				System.out.println();
				System.out.print("\t" + productId + "\t");
				temp.print();
				System.out.print(temp.getCategory() + "\t \t" + temp.getLanguage() + "\n");
				System.out.println("***********************************************************************************");
				System.out.println();
				
				productId++;
			}
		}			
	}

	/*this is where the admin can delete product from stock by selecting the ID number of the product*/
	private static void deletePrduct() {
		
		System.out.println("Chose product to delete by Product ID from list below");
		printInventory(inventory);
		
		inventory.remove(input.nextInt() -1);
		menu();
	}
	
	private static void shopping() {
		
		System.out.println("\n \n***************************************************************");
		System.out.println(" 1 to buy more items \n 2 to checkout \n 3 to back to main");
		System.out.println("***************************************************************");

		String choice = input.next();
		
		switch (choice) {
			
			case "1": {
				buyItem();
				break;
			}
			case "2": {
				checkout();
				break;
			}
			case "3": {
				menu();
				break;
			}
			default: {
				System.out.println("Wrong input, Try again");
				shopping();
				break;
			}
		}
	}
	
	private static void buyItem() {
		
		System.out.println("\n \n \n***************************************************************\n");
		System.out.println("Chose item to buy by ID from list below");
		printInventory(inventory);
		
		int choice = (input.nextInt() -1);
		int itemQuantity = inventory.get(choice).getQuantity();
		String productType = inventory.get(choice).getType();
		Product tempItem = inventory.get(choice);

		if (productType == "shoes") {
		
			Shoe tempShoe = new Shoe();
			Shoe temp = (Shoe)tempItem;
			
			tempShoe.setName(tempItem.getName());
			tempShoe.setPrice(tempItem.getPrice());
			tempShoe.setQuantity(1);
			tempShoe.setType(productType);
			
			tempShoe.setMaterial(temp.getMaterial());
			tempShoe.setSize(temp.getSize());
			
			basket.add(tempShoe);
		}
		
		else if (productType == "book") {
			
			Book tempBook = new Book();
			Book temp = (Book)tempItem;
			
			tempBook.setName(tempItem.getName());
			tempBook.setPrice(tempItem.getPrice());
			tempBook.setQuantity(1);
			tempBook.setType(productType);
			
			tempBook.setAuthor(temp.getAuthor());
			tempBook.setIsbn(temp.getIsbn());

			basket.add(tempBook);
		}
		
		else if (productType == "DVD") {
			
			DVD tempDVD = new DVD();
			DVD temp = (DVD)tempItem;
			
			tempDVD.setName(tempItem.getName());
			tempDVD.setPrice(tempItem.getPrice());
			tempDVD.setQuantity(1);
			tempDVD.setType(productType);
			
			tempDVD.setCategory(temp.getCategory());
			tempDVD.setLanguage(temp.getLanguage());

			basket.add(tempDVD);
		}
		
		if (itemQuantity > 1) {
			inventory.get(choice).setQuantity(itemQuantity -1);
		}
		else {
			inventory.remove(choice);
		}
		System.out.println("Your basket");
		printInventory(basket);
		System.out.println("*************************************************************** \n");

		shopping();
		
	}
	
	private static void checkout() {
		
		Double total = 0.0;
		
		for (Product i: basket) {
			total += i.getPrice();
		}
		System.out.println("\n \n***************************************************************");
		System.out.println("We will debet your credit card for:" + total);
		System.out.println("Thank You for shopping");
		System.out.println("***************************************************************");

		menu();
	}
}
