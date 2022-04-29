import java.io.*;
import java.util.*;

public class Process implements Serializable {
    Inventory inv;
    Scanner sc = new Scanner(System.in);
    Design g = new Design();
    int stockNum = 0;
    ArrayList<Inventory> inventories = new ArrayList<Inventory>();
    File inventoryFile = new File(
            "inventory.txt");

    public void storeObj (ArrayList <Inventory> inventFile){

        if (inventoryFile.exists()) {
            try {
                /* write objects */
                FileOutputStream out = new FileOutputStream(inventoryFile);
                ObjectOutputStream writeInventory = new ObjectOutputStream(out);
                // @SuppressWarnings ("unchecked")

                writeInventory.writeObject(inventFile);
                writeInventory.close();
                System.out.println("DATA IN FILES ADDED/UPDATED SUCCESSFULLY!");
                g.printBox("Item Successfully Added!");
                System.out.println("Stock Number: " + inventFile.get(inventFile.size()-1).getstockNum() + "\nItem Name: " + inventFile.get(inventFile.size()-1).getItemName() + "\nQuantity: "
                        + inventFile.get(inventFile.size()-1).getitemQty());
                g.enterToContinue();
            } catch (FileNotFoundException e) {
                System.out.println("File could not be found.");
                System.err.println("FileNotFoundException: "
                        + e.getMessage());
            } catch (IOException e) {
                System.out.println("Problem with input/output.");
                System.err.println("IOException: " + e.getMessage());
            } 
        } else {
            System.out.println("No File Found!!!");
        }
    }

    public void storeUpdated (ArrayList <Inventory> inventFile){

        if (inventoryFile.exists()) {
            try {
                /* write objects */
                FileOutputStream out = new FileOutputStream(inventoryFile);
                ObjectOutputStream writeInventory = new ObjectOutputStream(out);
                // @SuppressWarnings ("unchecked")

                writeInventory.writeObject(inventFile);
                writeInventory.close();
            } catch (FileNotFoundException e) {
                System.out.println("File could not be found.");
                System.err.println("FileNotFoundException: "
                        + e.getMessage());
            } catch (IOException e) {
                System.out.println("Problem with input/output.");
                System.err.println("IOException: " + e.getMessage());
            } 
        } else {
            System.out.println("No File Found!!!");
        }
    }
    public void addItem() {
        g.clearConsole();
        g.printBox("ADD AN ITEM");

        System.out.print("Item Name: ");
        String item = sc.next().toUpperCase();

        System.out.print("Item Quantity: ");
        int qty = sc.nextInt();

        inv = new Inventory((1000 + stockNum), qty, item);
        inventories.add(inv);

        g.printBox("Item Successfully Added!");
        System.out.println("Stock Number: " + inventories.get(inventories.size()-1).getstockNum() + "\nItem Name: " + inventories.get(inventories.size()-1).getItemName() + "\nQuantity: "
                + inventories.get(inventories.size()-1).getitemQty());
        g.enterToContinue();

    }

    public void newItem() {
        g.clearConsole();
        g.printBox("ADD AN ITEM");

        System.out.print("Item Name: ");
        String item = sc.next().toUpperCase();

        System.out.print("Item Quantity: ");
        int qty = sc.nextInt();

        inv = new Inventory((1000 + stockNum), qty, item);
        inventories.add(inv);

        g.clearConsole();
        storeObj(inventories);

    }

    public void displayAll(ArrayList <Inventory> inventFile) {
        g.clearConsole();
        g.printBox("INVENTORY LIST");
        String format = "%-15s %15s %15s \n";
        System.out.printf(format, "ITEM NAME", "STOCK NUMBER", "ITEM QUANTITY");
        for (int x = 0; x < inventFile.size(); x++) {
            System.out.printf(format, inventFile.get(x).getItemName(), inventFile.get(x).getstockNum(),
            inventFile.get(x).getitemQty() + " PCS");
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
            try {
                FileInputStream in = new FileInputStream(inventoryFile);
                ObjectInputStream readInventory = new ObjectInputStream(in);
                @SuppressWarnings ("unchecked")
                ArrayList <Inventory> inventFile = (ArrayList <Inventory>) readInventory.readObject();
                
            g.printBox("INVENTORY");

            System.out.print("[1] - Add Item \n[2] - Discontinue an Item \n[3] - Display the Amount of Stock of an Item"
                    + "\n[4] - Display all Items \n[5] - Exit \n\nChoose: ");

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
                        displayAll(inventFile);
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
                readInventory.close();
            } catch (InputMismatchException e) {
                System.out.println("INVALID INPUT! Try Again");
                stockNum--;
                sc.next();
                g.enterToContinue();
            } catch (FileNotFoundException e) {
                System.out.println("File could not be found.");
                System.err.println("FileNotFoundException: "
                        + e.getMessage());
            } catch (IOException e) {
                System.out.println("Problem with input/output.");
                System.err.println("IOException: " + e.getMessage());
                if (e.getMessage() == null){
                    System.out.println("There is no items in your Inventory! Let's add atleast one");
                    g.enterToContinue();
                    newItem();
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Class could not be used to cast object.");
                System.err.println("ClassNotFoundException: "
                        + e.getMessage());
            }
            
         
            stockNum++;
            g.enterToContinue();
        }
    }
}
