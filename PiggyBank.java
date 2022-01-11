import java.util.Random;

public class PiggyBank {
    public final static int[] COINS_VALUES = {1, 5, 10, 25}; // coins values in cents
    // coins names
    public final static String[] COINS_NAMES = {"PENNY", "NICKEL", "DIME", "QUARTER"};
    public final static String NO_SUCH_COIN = "N/A"; // N/A string
    private final static Random RAND_GEN = new Random(100); // generator of random integers

    /**
     * Returns the name of a specified coin value
     * @param coin represents a coin value in cents.
     * @return the String name of a specified coin value if it is valid and N/A if the
     *        coin value is not valid
     */
    public static String getCoinName(int coin) {
        for (int i=0; i < COINS_VALUES.length; i++) {
            if (coin == COINS_VALUES[i]) {
                return COINS_NAMES[i];
            }
        }

        return NO_SUCH_COIN; // return an empty string
    }

    /**
     * Returns the balance of a piggy bank in cents
     * @param coins an oversize array which contains all the coins held in a piggy bank
     * @param size the total number of coins stored in coins array
     * @return the total value of the coins held in a piggy bank in cents
     */
    public static int getBalance(int[] coins, int size) {
        int totalValue = 0;
        for (int i = 0; i < size; i++) {
            totalValue += coins[i];
        }
        return totalValue;

    }

    /**
    * Returns the total number of coins of a specific coin value held in a piggy bank *
    * @param coinValue the value of a specific coin
    * @param coins an over size array which contains all the coins held in a piggy
    * bank
    * @param size the total number of coins stored in coins array
    * @return the number of coins of value coinValue stored in the array coins
    */
    public static int getSpecificCoinCount(int coinValue, int[] coins, int size) {
        int timesEqual = 0;
        for (int i = 0; i < size; i++) {
            if (coinValue == coins[i]) {
                timesEqual++;
            }
        }
        return timesEqual;

    }

    /**
     * Displays information about the content of a piggy bank
     *
     * @param coins an oversize array storing the coins held in a piggy bank
     * @param size number of coin held array coins
     */
    public static void printPiggyBank(int[] coins, int size) {
        System.out.println("QUARTERS: " + getSpecificCoinCount(25, coins, size));
        System.out.println("DIMES: " + getSpecificCoinCount(10, coins, size));
        System.out.println("NICKELS: " + getSpecificCoinCount(5, coins, size));
        System.out.println("PENNIES: " + getSpecificCoinCount(1, coins, size));
        System.out.println("Balance: $" + getBalance(coins, size) * 0.01);
    }

    /**
    * Adds a given coin to a piggy bank. This operation can terminate
    * successfully or unsuccessfully. For either cases, this method
    * displays a descriptive message for either cases.
    *
    * @param coin the coin value in cents to be added to the array coins
    * @param coins an oversize array storing the coins held in a piggy bank 
    * @param size the total number of coins contained in the array coins
    * before this addCoin method is called.
    * @return the new size of the coins array after trying to add coin.
    */
    public static int addCoin(int coin, int[] coins, int size) {
        String nameofCoin = "";
        String tempEmpty = "";
      final int originalSize = size;
        for (int i = 0; i < COINS_VALUES.length; i++) {
            if (coin == COINS_VALUES[i]) {
                nameofCoin = COINS_NAMES[i];
            }
        }
        
        if (nameofCoin.compareTo(tempEmpty) > 0) {
                coins[size-1] = coin;
                size++;
                
                if (size == coins.length || size > coins.length) {
                    System.out.println("Tried to add a " + nameofCoin
                        + ", but could not because the piggy bank is full.");
                    return originalSize;
                }
                System.out.println("Added a " + nameofCoin + ".");
                return size;

            }

        else {
                System.out.println(coin
                    + "cents is not a valid US currency coin.");
                return originalSize;
            }
        
    }
      
    
    

    /**
    * Removes an arbitrary coin from a piggy bank. This method may terminate
    * successfully or unsuccessfully. In either cases, a descriptive message
    * is displayed.
    *
    * @param coins an oversize array which contains the coins held in a piggy bank 
    * @param size the number of coins held in the coins array before this method
    * is called
    * @return the size of coins array after this method returns successfully
    */
    public static int removeCoin(int[] coins, int size) {
        String nameOfCoin = "";
        if (size == 0) {
            System.out
                .println("Tried to remove a coin, but could not because the piggy bank is empty.");
            return size;
        }
        int coinToRemove = RAND_GEN.nextInt(size);
        nameOfCoin = getCoinName(coins[coinToRemove]);
        for (int i = coinToRemove; i < size; i++) {
            coins[i] = coins[i + 1];
        }
        coins[size - 1] = 0;

        --size;
        System.out.println("Removed a " + nameOfCoin + ".");
        return size;


    }

    /**
     * Removes all the coins in a piggy bank. It also displays the total value
     * of the removed coins
     *
     * @param coins an oversize array storing the coins held in a piggy bank application
     * @param size number of coins held in coins array before this method is called
     * @return the new size of the piggy bank after removing all its coins.
     */
    public static int emptyPiggyBank(int[] coins, int size) {

        if (size == 0) {
            System.out.println("Zero coin removed. The piggy bank is already empty.");
        }
        int totalAmountofMoney = 0;
        for (int i = 0; i < coins.length; i++) {
            totalAmountofMoney += coins[i];
            coins[i] = 0;
            size--;
        }
        System.out.println("All done. " + totalAmountofMoney + " cents removed.");
        return size;
    }



    /**
     * Removes the least number of coins needed to fulfill a withdrawal request
     *
     * @param amount amount to withdraw given in cents
     * @param coins an oversize array storing the coins held in a piggy bank
     * @param size number of coins stored in coins array before this method is called
     * @return perfect size array of 5 elements, index 0 stores the new size of
     *        the piggy bank after this method returns. Indexes 1, 2, 3, and 4
     *        store respectively the number of removed quarters, dimes,
     *        nickels, and pennies.
     */
    public static int[] withdraw(int amount, int[] coins, int size) {
        int[] moneyQuantities = {0, 0, 0, 0, 0};
        if (getBalance(coins, size) < amount) {
            moneyQuantities[0] = size;
            System.out.print(
                "Unable to withdraw " + amount + " cents. NOT enough money in the piggy bank.");
            return moneyQuantities;
        } else {
            int quartersRequired = amount / COINS_VALUES[3];
            int quartersUsed;
            int quartersAvailable = getSpecificCoinCount(COINS_VALUES[3], coins, size);

            if (quartersRequired <= quartersAvailable) {
                amount -= (quartersRequired * COINS_VALUES[3]);
                quartersUsed = quartersRequired;
            } else {
                amount -= (quartersAvailable * COINS_VALUES[3]);
                quartersUsed = quartersAvailable;
            }

            int dimesRequired = amount / COINS_VALUES[2];
            int dimesUsed;
            int dimesAvailable = getSpecificCoinCount(COINS_VALUES[2], coins, size);

            if (dimesRequired <= dimesAvailable) {
                amount -= (dimesRequired * COINS_VALUES[2]);
                dimesUsed = dimesRequired;
            } else {
                amount -= (dimesAvailable * COINS_VALUES[2]);
                dimesUsed = dimesAvailable;
            }

            int nickelsRequired = amount / COINS_VALUES[1];
            int nickelsUsed;
            int nickelsAvailable = getSpecificCoinCount(COINS_VALUES[1], coins, size);

            if (nickelsRequired <= nickelsAvailable) {
                amount -= (nickelsRequired * COINS_VALUES[1]);
                nickelsUsed = nickelsRequired;
            } else {
                amount -= (nickelsAvailable * COINS_VALUES[1]);
                nickelsUsed = nickelsAvailable;
            }
            int penniesRequired = amount / COINS_VALUES[0];
            int penniesUsed;
            int penniesAvailable = getSpecificCoinCount(COINS_VALUES[0], coins, size);

            if (penniesRequired <= penniesAvailable) {
                amount -= (penniesRequired * COINS_VALUES[0]);
                penniesUsed = penniesRequired;
            } else {
                amount -= (penniesAvailable * COINS_VALUES[0]);
                penniesUsed = penniesAvailable;
            }
            size -= (quartersUsed + dimesUsed + nickelsUsed + penniesUsed);

            moneyQuantities[0] = size;
            moneyQuantities[1] = quartersUsed;
            moneyQuantities[2] = dimesUsed;
            moneyQuantities[3] = nickelsUsed;
            moneyQuantities[4] = penniesUsed;

            return moneyQuantities;

        }

    }



}
