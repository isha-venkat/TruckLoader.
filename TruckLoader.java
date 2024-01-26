import java.util.Scanner;
public class TruckLoader {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		System.out.println("Welcome to Truck Loader");
		System.out.println("-----------------------");
		System.out.println("What is the maximum number of boxes that can fit inside the truck?");
		int box = input.nextInt();
		String[] CustNames = new String[box]; //String object created for customer's name array.
		Double[] Weight = new Double[box];	  //Double object created for weight of the box array.
		Boolean[] YesNo = new Boolean[box];   //Boolean object created for dangerous or non-dangerous goods in the box array.
		String GoodsType =null;				  //String object with null value.
		for (int i=0; i<box; i++) {
			System.out.println("Please enter the customer name for box "+ (i+1) + ":");
			CustNames[i]= input.next();		  //To store the customer names in "CustNames" array.
			System.out.println("Please enter the weight(kg) for box "+ (i+1) + ":");
			Weight[i]= input.nextDouble();	  //To store the weight of the box in "Weight" array.
			System.out.println("Does box " + (i+1) + " contain dangerous goods (y/n)?");
			String YorN = input.next();		  //To store if the input is 'y' or 'n'.
			if (YorN.equals("y")) {
				YesNo[i]=true;				  //If the input is 'y' then the element in "YesNo" array is stored as true.
			}
			else {
				YesNo[i]=false;				  //If the input is 'n' then the element in "YesNo" array is stored as false.
			}
		}
		System.out.println("All the information regarding the boxes has been entered.");
		while(true) { 						  //While loop created for the whole code to execute again until the user chooses to "quit".	
			System.out.println("List (a)ll boxes information, search boxes by (c)ustomer name or (d)angerous cargo, or (q)uit?");
			String choice = input.next();	  //To store the choice input from the user.
			if (choice.equals("a")) {
				System.out.println("Here is the list of all the boxes:");
				for (int a=0; a<box ; a++) {  //If the user's choice is "a" then for loop is used to display all the details of all the boxes.
					if (YesNo[a].equals(true)) { //To check if the element in the "YesNo" array is true.
						GoodsType ="Dangerous goods."; //Then a string "Dangerous goods" is declared in "GoodsType" variable.
					}
					else {						 //To check if the element in the "YesNo" array is false.
						GoodsType ="Non-Dangerous goods."; //Then a string "Non-dangerous goods" is declared in "GoodsType" variable.
					}
				System.out.println("Box " + (a+1) + " Customer name: " + CustNames[a] + "." + " Weight(kg): " + Weight[a] + ". " + GoodsType);	
				}
			}
			else if (choice.equals("c")) {
				System.out.println("What is the customer's name? ");
				String name = input.next();
				for(int n=0; n<box; n++) {	//If the user's choice is "c" then for loop is used to ask the user to check which customer's name box details they wish to view. 
					if (YesNo[n].equals(true)) { //To check if the element in the "YesNo" array is true.
						GoodsType ="Dangerous goods."; //Then a string "Dangerous goods" is declared in "GoodsType" variable.
					}
					else {						 //To check if the element in the "YesNo" array is false.
						GoodsType ="Non-Dangerous goods."; //Then a string "Non-dangerous goods" is declared in "GoodsType" variable.
					}
					if(CustNames[n].equals(name)) { //To check if the customer's name is same as an element in the "CustNames" array.
						System.out.println("Box "+ (n+1) + " Customer name: " + name + ". Weight(kg): " + Weight[n] + ". " + GoodsType);		
					}
				}
			}
			else if (choice.equals("d")) {
				System.out.println("Search for (d)angerous or (n)on-dangerous?");
				String option = input.next(); //To store the input if the user wants to see the box details of the "Dangerous" or "Non-dangerous" goods.
				for(int c=0; c<box; c++) {	  //If the user's choice is "d" then for loop is used to check the which element is true and false in "YesNo" array.
					if(option.equals("d") && YesNo[c].equals(true)) { //To check if the choice is "d" and the element in the "YesNo" array is true.
						GoodsType="Dangerous goods.";	//Then a string "Dangerous goods" is declared in "GoodsType" variable.
						System.out.println("Box " + (c+1) + " Customer name: " + CustNames[c] + ". Weight(kg): " + Weight[c] + ". " + GoodsType);
					}
					else if(option.equals("n") && YesNo[c].equals(false)) { //To check if the choice is "n" and the element in the "YesNo" array is false.
						GoodsType="Non-Dangerous goods."; //Then a string "Non-dangerous goods" is declared in "GoodsType" variable.
						System.out.println("Box " + (c+1) + " Customer name: " + CustNames[c] + ". Weight(kg): " + Weight[c] + ". " + GoodsType);
					}
				}
			}
			else if(choice.equals("q")) { //To check if the user's choice is "q".
				System.out.println("Thank you for using the Truck Loader.");
				break; //The while loop should break.
			}
			else {
				System.out.println("Please choose correct option.");
			}
			}	
	}
}

