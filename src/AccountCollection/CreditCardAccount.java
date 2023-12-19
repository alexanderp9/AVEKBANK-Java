package AccountCollection;

import java.util.Random;

public class CreditCardAccount extends BankAccount {

    private int cardNumber;
    private int cardPIN;

    public int getCardNumber() {
        return cardNumber;
    }

    public int getCardPIN() {
        return cardPIN;
    }

    public void changePIN(String newPIN, String oldPIN) {
        if (isFourNumberLong(oldPIN) & isFourNumberLong(newPIN)) {
            if (Integer.parseInt(oldPIN) == cardPIN) {
            cardPIN = Integer.parseInt(newPIN);
            } else {
                System.out.println("Incorrect PIN-code");
            }
        } else {
            System.out.println("PIN most be 4 digits long");
        }

    }

    private boolean isFourNumberLong(String PIN) {
        if (PIN.length() != 4) {
            return false;
        }
        for (char c : PIN.toCharArray())
            if (!Character.isDigit(c)) {
                return false;
            }
        return true;
    }

    public void getRandomizedCardNumber() {
        Random random = new Random();
        cardNumber = random.nextInt(100000, 999999);
    }

    public void getRandomizedPINCode() {
        Random random = new Random();
        cardPIN = random.nextInt(1000, 9999);
    }

}
