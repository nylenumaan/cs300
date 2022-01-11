
public class PiggyBankTester {
   
    /**
     * Checks whether PiggyBank.getCoinName() method works as expected.
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean getCoinNameTestMethod() {
        // change some coin values and names
        PiggyBank.COINS_NAMES[1] = "Two cents";
        PiggyBank.COINS_NAMES[3] = "Fifty Cents";
        PiggyBank.COINS_VALUES[1] = 2;
        PiggyBank.COINS_VALUES[3] = 50;
        // consider all coin values as input arguments
        for (int i = 0; i < PiggyBank.COINS_VALUES.length; i++)
         if (!PiggyBank.getCoinName(PiggyBank.COINS_VALUES[i]).equals(PiggyBank.COINS_NAMES[i]))
           return false;
        // consider input argument which does not correspond to a coin value
        if (!PiggyBank.getCoinName(7).equals(PiggyBank.NO_SUCH_COIN))
         return false;
        if (!PiggyBank.getCoinName(-10).equals(PiggyBank.NO_SUCH_COIN))
         return false;
        return true;
    }
    
    /**
     * Checks whether PiggyBank.getBalance() method works as expected.
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean getBalanceTestMethod() {
      // scenario 1 - empty piggy bank
      int[] coins = new int[10]; // array storing the coins held in a piggy bank
      int size = 0; // number of coins held in coins array
      if(PiggyBank.getBalance(coins, size)!= 0) {
       System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
           + "return the expected output when passed a empty piggy bank.");
       return false;
      }
      // scenario 2 - non empty piggy bank
      coins = new int[] {10, 1, 5, 25, 1, 0, 0};
      size = 5;
      if(PiggyBank.getBalance(coins, size)!= 42) {
       System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
           + "return the expected output when passed a piggy bank that holds "
           + "two pennies, a nickel, a dime, and a quarter.");
       return false;
      }
      // scenario 3 - another non empty piggy bank
      coins = new int[] {10, 1, 5, 25, 1, 0};
      size = 3;
      if(PiggyBank.getBalance(coins, size)!= 16) {
       System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
           + "return the expected output when passed a piggy bank that holds "
           + "a penny, a nickel, and a dime, only.");
       return false;
      }
      return true;
    }
    
    /**
     * Checks whether PiggyBank.getSpecificCoinCount() method works as expected.
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean getSpecificCoinCountTestMethod() {
        int coinValue = 1;
        int[] coins = new int[20];
        int size = 0; 
       //test an empty piggybank
        if (PiggyBank.getSpecificCoinCount(coinValue, coins, size) != 0) {
            System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCount() did not "
                    + "return the expected output when passed a empty piggy bank. Searching for"
                    + " a coin value that doesn't exist.");
                    
            return false;
        }
 
        coinValue = 1;
        coins = new int[] { 5, 5, 10, 1,};
        size = 4;
        //test a piggy bank with just one penny
        if (PiggyBank.getSpecificCoinCount(coinValue, coins, size) != 1) {
            System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCount() did not "
                    + "return the expected output when passed a piggy bank that holds"
                    + " one penny only.");
                    
            return false;
        
    }
        coinValue = 5;
        coins = new int[] { 5, 5, 10, 25,};
        size = 3;
        //test a piggy bank with multiple nickels
        if (PiggyBank.getSpecificCoinCount(coinValue, coins, size) != 2) {
            System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCount() did not "
                    + "return the expected output when passed a piggy bank that holds"
                    + " one penny only.");
                    
            return false;
    }
        
     return true; 
     
    }
    
    /**
     * Checks whether PiggyBank.getSpecificCoinCount() method works as expected.
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean addCoinTestMethod() {
        int coin = 1;
            int[] coins = new int[] {5,10,25,1,1};
        int size = 5;
        //test adding coin when piggy bank is full
        if (PiggyBank.addCoin(coin, coins, size) != 5) {
            System.out.println("Problem detected. Your PiggyBank.addCoin() did not "
                + "return the expected output when passed a piggy bank that is"
                + "full");
            return false;
        }
        
        coin = 21;
       coins = new int[] {5,10,25,10,1};
           size = 2;
           // test adding an invalid coin
           if (PiggyBank.addCoin(coin, coins, size) != 2) {
               System.out.println("Problem detected. Your PiggyBank.addCoin() did not "
                   + "return the expected output when passed a coin that "
                   + "doesn't exist");
               return false;
           }
           coin = 1;
           coins = new int[] {5,10,25,1,5};
           size = 3;
           //test adding a coin
           if (PiggyBank.addCoin(coin, coins, size) != 4) {
               System.out.println("Problem detected. Your PiggyBank.addCoin() did not "
                   + "return the expected output when adding a coin ");
               return false;
           }
         return true;
    }
    /**
     * Checks whether PiggyBank.removeCoin() method works as expected.
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean removeCoinTestMethod() {
     
        int[] coins = new int[] {5,10,25,1,5};
        int size = 3;
        //test removing a random coin
        if (PiggyBank.removeCoin(coins, size) != 2) {
            System.out.println("Problem detected. Your PiggyBank.removeCoin() did not "
                + "return the expected output when removing a coin ");
            return false;
    }
        coins = new int[] {5,5,25,1,5};
       size = 0;
//test removing a random coin from an empty piggy bank
        if (PiggyBank.removeCoin(coins, size) != 0) {
            System.out.println("Problem detected. Your PiggyBank.removeCoin() did not "
                + "return the expected output when removing a coin ");
            return false;
        }
        return true; 
        }
    
    /**
     * Checks whether PiggyBank.emptyPiggyBank() method works as expected.
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean emptyPiggyBankTestMethod() {
        int [] coins = new int [] {10,25,1,1,5,5,5,5,25,1,1,1};
        int size = 8;
        if (PiggyBank.emptyPiggyBank(coins, size) != -4) {
            System.out.println("Problem detected. Your PiggyBank.emptyPiggyBank() did not "
                + "return the expected output when attempting to empty the Piggy Bank ");
           System.out.println(PiggyBank.emptyPiggyBank(coins, size));
            return false;
        }
        return true; 
    }
    /**
     * Checks whether PiggyBank.withdraw() method works as expected.
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean withdrawTestMethod() {
        int amount = 25;
        int[] coins = new int[] {25,1,1};
        int size = 3;
           if (PiggyBank.withdraw(amount, coins, size)[1] != 0) {
               System.out.println("Problem detected. Your PiggyBank.withdraw() did not "
                   + "return the expected output when attempting to withdraw a quarter from the Piggy Bank "); 
          System.out.print(PiggyBank.withdraw(amount, coins, size)[1]);
               return false;
           }
           amount = 27;
           coins = new int[] {25,5};
           size = 2;
           if (PiggyBank.withdraw(amount, coins, size)[3] != 0) {
               System.out.println("Problem detected. Your PiggyBank.withdraw() did not "
                   + "return the expected output when attempting to withdraw 27 cents from the Piggy Bank containing a nickel and a quarter"); 
               System.out.print(PiggyBank.withdraw(amount, coins, size)[3]);
               return false; }
           amount = 96;
           coins = new int[] {25,5,1};
           size = 3;
           if (PiggyBank.withdraw(amount, coins, size)[0] != 3) {
               System.out.println("Problem detected. Your PiggyBank.withdraw() did not "
                   + "return the expected output when attempting to withdraw 96 cents from a Piggy Bank containing 31 cents"); 
          System.out.print(PiggyBank.withdraw(amount, coins, size)[0]);
               return false; }
           return true; 
    }

        

    /**
     * Calls the test methods implemented in this class and displays their output
     * @param args input arguments if any
     */
    public static void main(String[] args) {
        System.out.println("getCoinNameTest(): " + getCoinNameTestMethod());
        System.out.println("getBalanceTest(): " + getBalanceTestMethod());
        System.out.println("getSpecificCoinCountTest(): " + getSpecificCoinCountTestMethod());
        System.out.println("removeCoinTest(): " + removeCoinTestMethod());
        System.out.println("emptyPiggyBankTest(): " + emptyPiggyBankTestMethod());
        System.out.println("withdrawTest(): " + withdrawTestMethod());   
        System.out.println("addCoinTest(): " + addCoinTestMethod());
}

}
