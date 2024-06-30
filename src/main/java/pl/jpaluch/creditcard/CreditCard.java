package pl.jpaluch.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal creditlimitig;
    private BigDecimal balance;

    public void assignCredit(BigDecimal creditlimitig) {

        if(isCreditAlreadyAssigned()){
            throw new CreditCantBeReassignedException();
        }

        if(isCreditBelowThreshold(creditlimitig)){
            throw new CreditBelowThresholdException();
        }

        this.creditlimitig = creditlimitig;
        this.balance=creditlimitig;
    }

    public void withdraw(BigDecimal money){

        if(isBelowBalance(money)<=0){
            throw new TransactionDenyException();
        }
        this.balance= balance.subtract(money);

    }

    private int isBelowBalance(BigDecimal money) {
        return balance.subtract(money).compareTo(BigDecimal.ZERO);
    }

    private boolean isCreditAlreadyAssigned() {
        return this.creditlimitig != null;
    }

    private static boolean isCreditBelowThreshold(BigDecimal creditlimitig) {
        return BigDecimal.valueOf(100).compareTo(creditlimitig) > 0;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
