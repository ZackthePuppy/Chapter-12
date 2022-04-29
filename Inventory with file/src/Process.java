import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Process {
    Inventory inv;
    Scanner sc = new Scanner(System.in);
    Design g = new Design();
    int stockNum = 0;
    ArrayList<Inventory> inventories = new ArrayList<Inventory>();

    public void addItem() {
        g.clearConsole();
        g.printBox("ADD AN ITEM");

        System.out.print("Item Name: ");
        String item = sc.next().toUpperCase();

        System.out.print("Item Quantity: ");
        int qty = sc.nextInt();

        inv = new Inventory((1000 + stockNum), qty, item);
        inventories.add(inv);

        g.clearConsole();
        g.printBox("Item Successfully Added!");
        System.out.println("Stock Number: " + inv.getstockNum() + "\nItem Name: " + inv.getItemName() + "\nQuantity: "
                + inv.getitemQty());
        g.enterToContinue();

    }

    public void displayAll() {
        g.clearConsole();
        g.printBox("INVENTORY LIST");
        String format = "%-15s %15s %15s \n";
        System.out.printf(format, "ITEM NAME", "STOCK NUMBER", "ITEM QUANTITY");
        for (int x = 0; x < inventories.size(); x++) {
            System.out.printf(format, inventories.get(x).getItemName(), inventories.get(x).getstockNum(),
                    inventories.get(x).getitemQty() + " PCS");
        }
        g.enterToContinue();
    }

    public void discontinue() {
        g.clearConsole();
        g.printBox("DISCONTINUE AN ITEM");
        String format = "%-20s %15s %15s \n";
        System.out.printf(format, "ITEM NAME", "STOCK NUMBER", "ITEM QUANTITY");

        for (int x = 0; x < inventories.size(); x++) {
            System.out.printf(format, "[" + (x + 1) + "] " + inventories.get(x).getItemName(),
                    inventories.get(x).getstockNum(), inventories.get(x).getitemQty() + " PCS");
        }

        System.out.print("\nWhich Item? ");
        int choice = sc.nextInt();

        if (inventories.get(choice - 1).getItemName() == "DISCONTINUED") {
            System.out.println("This item is already discontinued! ");
        } else {
            inventories.get(choice - 1).setItemName("DISCONTINUED");
            inventories.get(choice - 1).setitemQty(0);
            System.out.println("Product Successfully Discontinued!");
        }

        g.enterToContinue();
    }

    public void displaySpef() {
        g.clearConsole();
        g.printBox("ITEM INFORMATION");

        for (int x = 0; x < inventories.size(); x++) {
            System.out.print("[" + (x + 1) + "] " + inventories.get(x).getItemName() + "\n");
        }

        System.out.print("\nChoose Item: ");
        int choice = sc.nextInt();

        if (choice <= 0) {
            System.out.println("Error Input. Try again!");
        } else {
            if (inventories.get(choice - 1).getItemName() == "DISCONTINUED") {
                System.out.println("Sorry, the item you selected is DISCONTINUED");
            } else {
                g.clearConsole();
                g.printBox("ITEM INFORMATION");
                System.out.println("STOCK NUMBER: " + inventories.get(choice - 1).getstockNum()
                        + "\nITEM NAME: " + inventories.get(choice - 1).getItemName()
                        + "\nITEM QUANTITY: " + inventories.get(choice - 1).getitemQty());
            }
        }
    }

    public void menu() {
        boolean mainLoop = true;

        while (mainLoop) {
            g.printBox("INVENTORY");

            System.out.print("[1] - Add Item \n[2] - Discontinue an Item \n[3] - Display the Amount of Stock of an Item"
                    + "\n[4] - Display all Items \n[5] - Exit \n\nChoose: ");

            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        discontinue();
                        break;
                    case 3:
                        displaySpef();
                        break;
                    case 4:
                        displayAll();
                        break;
                    case 5:
                        System.out.println("Thank you and have a nice day!");
                        mainLoop = false;
                        break;
                    default:
                        System.out.println("Invalid Choice! Please try Again.");
                        g.enterToContinue();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("INVALID INPUT! Try Again");
                stockNum--;
                sc.next();
                g.enterToContinue();
            }
            stockNum++;
            g.enterToContinue();
        }
    }
}
