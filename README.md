Locker Project (Java)

A simple Java program that simulates a locker system with rotating combinations and stored items. Each locker maintains multiple possible combinations that change over time, along with a dynamic list of items.

📂 Project Structure
LockerProject-main/
└── Locker_Project.java

🧩 Overview

The Locker class represents a locker with:

Five unique combinations, automatically generated at initialization.

A rotating combination system, cycling every “year” (via nextCombination()).

An item management system — add or remove stored items.

Easy retrieval of current combination and locker contents.

🧠 Core Class: Locker
Constructor
public Locker(int lockerComb)


Creates a new locker with a randomly generated set of five combinations and initializes an empty item list.

Key Methods
Method	Description
String getCombination()	Returns the current active combination.
void nextCombination()	Advances to the next combination (cyclic every 5 changes).
void addItem(String item)	Adds a new item to the locker (most recent item appears first).
String getContents()	Returns a comma-separated list of all stored items.
void removeItem(String item)	Removes a specified item from the locker.
🧪 Example Usage
public class Main {
    public static void main(String[] args) {
        Locker myLocker = new Locker(101);

        System.out.println("Initial combination: " + myLocker.getCombination());

        myLocker.addItem("Books");
        myLocker.addItem("Shoes");
        myLocker.addItem("Jacket");

        System.out.println("Contents: " + myLocker.getContents());

        myLocker.removeItem("Shoes");
        System.out.println("After removing shoes: " + myLocker.getContents());

        myLocker.nextCombination();
        System.out.println("Next combination: " + myLocker.getCombination());
    }
}

Sample Output
Initial combination: 23-4-17
Contents: Jacket,Shoes,Books
After removing shoes: Jacket,Books
Next combination: 12-15-33

⚙️ How to Run

Ensure Java (JDK 8+) is installed.

Save Locker_Project.java and Main.java in the same directory.

Compile and run:

javac Locker_Project.java Main.java
java Main
