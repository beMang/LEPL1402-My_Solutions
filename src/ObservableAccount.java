import java.util.ArrayList;

/**
 * This class implements a bank account.
 * You can deposit and withdraw money from the account.
 * Read carefully the comments of each method and fill the missing
 * parts marked with "TODO".
 * You can ADD any code you like in this class (new members, new methods, etc.).
 * You can also add imports.
 */

public class ObservableAccount {

    public interface AccountObserver {
        void accountHasChanged();
    }

    protected static class Pair{
        int max;
        AccountObserver observer;

        Pair(AccountObserver o, int m){
            max = m;
            observer = o;
        }
    }
    int balance = 0;
    ArrayList<Pair> observers = new ArrayList<>();

    /**
     * Get the account balance  (franc. "solde")
     * The initial balance of the account is 0.
     *
     * @return The balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Deposit an amount into the account
     *
     * @param amount The amount to deposit
     */
    public void deposit(int amount) {
        balance+=amount;
        notifyEveryone(amount);
    }

    /**
     * Withdraw an amount from the account.
     * An account cannot become negative.
     * If you try to withdraw 1000 Euro from an account that has
     * only 500 Euro, the withdrawal is NOT executed.
     *
     * @param amount The sum to withdraw
     */
    public void withdraw(int amount) {
        if(balance-amount<0){
            return;
        }
        balance-=amount;
        notifyEveryone(amount);
    }

    /**
     * Add an observer to the account.
     * The observer will be notified if an amount is deposited or withdrawn
     * that is greater than the specified maximum.
     * The observer must NOT be notified if the withdrawal is not executed
     * (see comment of the method 'withdraw')
     *
     * The user of this class can change the maximum for an added observer by calling
     * this method again with the same observer. Example:
     *      account.addObserver(myObserver,1000);
     *      account.addObserver(myObserver,2000); // change maximum for this observer
     *
     * @param observer The observer to add.
     * @param maximum The observer will be notified if the deposited or withdrawn
     *                amount is greater than "maximum".
     *
     */
    public void addObserver(AccountObserver observer, int maximum) {
        boolean modified = false;
        for(Pair pair : observers){
            if(pair.observer.equals(observer)){
                pair.max = maximum;
                modified = true;
            }
        }
        if(!modified) {
            observers.add(new Pair(observer, maximum));
        }
    }

    public void notifyEveryone(int amount){
        for(Pair pair : observers){
            if(amount>pair.max){
                pair.observer.accountHasChanged();
            }
        }
    }
}
