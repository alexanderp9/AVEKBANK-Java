package AccountCollection;

import java.util.Random;

public class CreditCardAccount extends BankAccount{

    private int cardNumber;
    private int cardPIN;

    public int getCardNumber() {
        return cardNumber;
    }

    public int getCardPIN() {
        return cardPIN;
    }

    public void changePIN (int newPIN, int oldPIN) {
        if (oldPIN == cardPIN) {
            cardPIN = newPIN;
        }
    }

    public void getRandomizedCardNumber(){
        Random random = new Random();
        cardNumber = random.nextInt(100000,999999);
    }

    public void getRandomizedPINCode(){
        Random random = new Random();
        cardPIN = random.nextInt(1000,9999);
    }

}
