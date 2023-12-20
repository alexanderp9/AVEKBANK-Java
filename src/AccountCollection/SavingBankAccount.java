package AccountCollection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SavingBankAccount extends BankAccount {
    private double interestRate;
    private int lockPeriod = 0;

    public double getInterestRate() {
        return interestRate;
    }

    public int getLockPeriod() {
        return lockPeriod;
    }

    public void lockInterestRate(int yearsLocked) {
        if (yearsLocked != 1 && yearsLocked != 3 && yearsLocked != 5) {
            System.out.println("Invalid lock period. Choose 1, 3, or 5 years.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("src/AccountCollection/aboutBank.txt"))) {
            String line;
            boolean foundRates = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Våra räntor:")) {
                    foundRates = true;
                } else if (foundRates) {
                    if (line.trim().isEmpty()) {
                        break;
                    }

                    if (line.contains(yearsLocked + "år")) {
                        String rateStr = line.split("-")[1].trim().replace("%", "").replace(",", ".");
                        interestRate = Double.parseDouble(rateStr) / 100.0;
                        lockPeriod = yearsLocked;
                        System.out.println("Interest rate locked at " + interestRate*100 + "% for " + lockPeriod + " years.");
                        break;
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading the interest rate: " + e.getMessage());
        }
    }
}
