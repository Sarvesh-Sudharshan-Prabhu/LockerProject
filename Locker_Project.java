import java.util.Random;

public class Locker
{
    private String combOne;
    private String combTwo;
    private String combThree;
    private String combFour;
    private String combFive;
    private String items;
    private String currentComb;
    private int lockerComb;

    /**
     * Constructor for locker that initializes the state of the object
     * Initializes the locker with 5 random combinations and sets the initial combination
     * @param lockerComb
     */
    public Locker(int lockerComb)
    {
        Random randy = new Random();
        this.lockerComb = lockerComb;

        int firOne = randy.nextInt(50);
        int secOne = randy.nextInt(10);
        int lasOne = randy.nextInt(50);
        combOne = firOne + "-" + secOne + "-" + lasOne;

        int firTwo = randy.nextInt(50);
        int secTwo = randy.nextInt(10,20);
        int lasTwo = randy.nextInt(50);
        combTwo = firTwo + "-" + secTwo + "-" + lasTwo;

        int firThree = randy.nextInt(50);
        int secThree = randy.nextInt(20,30);
        int lasThree = randy.nextInt(50);
        combThree = firThree + "-" + secThree + "-" + lasThree;

        int firFour = randy.nextInt(50);
        int secFour = randy.nextInt(30,40);
        int lasFour = randy.nextInt(50);
        combFour = firFour + "-" + secFour + "-" + lasFour;

        int firFive = randy.nextInt(50);
        int secFive = randy.nextInt(40,50);
        int lasFive = randy.nextInt(50);
        combFive = firFive + "-" + secFive + "-" + lasFive;

        currentComb = combOne;
        items = "";
    }

    public String getCombination()
    {
        return currentComb;
    }
// Updates combination after every year. This is cyclic, so every 6 years the last combination will cycle back to the first one.
    public void nextCombination()
    {
        if (currentComb.equals(combOne))
        {
            currentComb = combTwo;
        }
        else if (currentComb.equals(combTwo))
        {
            currentComb = combThree;
        }
        else if (currentComb.equals(combThree))
        {
            currentComb = combFour;
        }
        else if (currentComb.equals(combFour))
        {
            currentComb = combFive;
        }
        else if (currentComb.equals(combFive))
        {
            currentComb = combOne;
        }
    }

    /**
     * Adds items to the locker. Items are added in the beginning to the existing list
     * Most recently added item appears first in the list.
     * @param stuff
     */
    public void addItem(String stuff)
    {
        if (items.length() == 0)
        {
            items = stuff;
        }
        else
        {
            items = stuff + "," + items;
        }
    }

    public String getContents()
    {
        return items;
    }

    public void removeItem(String item)
    {
        int beg = 0;
        String newItems = "";
        int end = 0;
        boolean first = true; // Sets a boolean to test whether the item being added is the first item in the list

        while (beg < items.length())
        {
            end = items.indexOf(',', beg);
            if (end == -1) // Tells the program that the end of the string has been reached because no comma is found. End is set to the length of items.
            {
                end = items.length();
            }

            String current = items.substring(beg, end);

            if (!current.equals(item)) // If current item is not equal to an item, this item should be included in newItems and be prepended to the contents of the locker.
            {
                if (!first) // Tests whether locker already has some items. If there is a comma needs to be added before appending the new item to the newItem's variable.
                {
                    newItems = newItems + ",";
                }
                newItems = newItems + current;
                first = false;
            }

            beg = end + 1; // Increases or updating beg to the index after the comma to start adding next item.
        }

        items = newItems;
    }

    public String toString()
    {
        return "Locker: " + lockerComb + "\n" +
                "A: " + combOne + "\n" +
                "B: " + combTwo + "\n" +
                "C: " + combThree + "\n" +
                "D: " + combFour + "\n" +
                "E: " + combFive + "\n" +
                "Contents: " + items;
    }
}
