package pl.jpaluch.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    @Test
    void itAllowsAssignCreditLimit(){
        //Arrange
        var card=new CreditCard();
        //Act
        card.assignCredit(BigDecimal.valueOf(1000));
        //Assert
        assertEquals(
                BigDecimal.valueOf(1000),
                card.getBalance(),"Credit does not match credit ballance");
    }

    @Test
    void itDenyCreditLimitBelowThreshold(){

        var card=new CreditCard();

        try{
            card.assignCredit(BigDecimal.valueOf(50));
            fail("Exception should be raised");
        }catch(CreditBelowThresholdException e){
            assertTrue(true);
        }
    }

    @Test
    void itDenyCreditLimitBelowThresholdV2(){

        var card=new CreditCard();

        assertThrows(
                CreditBelowThresholdException.class,
                ()->card.assignCredit(BigDecimal.valueOf(50))
        );
    }

    @Test
    void itCantReassignCreditLimit(){

        var card=new CreditCard();

        card.assignCredit(BigDecimal.valueOf(1500));

        assertThrows(
                CreditCantBeReassignedException.class,
                ()->card.assignCredit(BigDecimal.valueOf(2000))
        );
    }

    @Test
    void itAllowsWithdrawMoney(){

        var card= new CreditCard();

        card.assignCredit(BigDecimal.valueOf(2000));

        card.withdraw(BigDecimal.valueOf(1000));

        assertEquals(BigDecimal.valueOf(1000),card.getBalance());

    }

    @Test
    void itDenyTransactionsOverTheBalance(){

        var card= new CreditCard();

        card.assignCredit(BigDecimal.valueOf(2000));

        card.withdraw(BigDecimal.valueOf(1000));

        assertThrows(
                TransactionDenyException.class,
                ()->card.withdraw(BigDecimal.valueOf(1000))
        );

        assertEquals(BigDecimal.valueOf(1000),card.getBalance());

    }



}
