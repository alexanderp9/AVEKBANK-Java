package AccountCollection;


public class SavingBankAccount extends BankAccount {

    private double interestRate;

    private int amountOfYearsSaving;

    private boolean savingYearPeriod;

    public SavingBankAccount() {
        this.interestRate = 0.15;
        this.amountOfYearsSaving = 2;
        this.savingYearPeriod = true;

    }

    @Override

    public void withdraw(double amount) {
        if (!savingYearPeriod) {
            super.withdraw(amount);
        } else {
            System.out.println("You cannot withdraw during your savingperiod, please contact the bank if you want to cancel the savingperiod.");
        }
    }

    public void simulateOneYearPast() { // metod för att simulera år och låsa pengarna med ränta.
        if (amountOfYearsSaving > 0) {
            balance += balance * interestRate;
            amountOfYearsSaving--;
            if (amountOfYearsSaving == 0) {
                savingYearPeriod = false;
                System.out.println("Your saving period is now over!");
            }
        }
    }




}
