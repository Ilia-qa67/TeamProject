package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void CreditAccountWithNegativeInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account account1 = new CreditAccount(-100, 500, 10);
        });
    }

    @Test
    public void CreditAccountWithNegativeCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account account1 = new CreditAccount(100, -500, 10);
        });
    }
    @Test
    public void CreditAccountWithNegativeRate() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account account1 = new CreditAccount(100, 500, -10);
        });
    }

    @Test
    public void ShouldPay() {
        CreditAccount acc = new CreditAccount(100,1000,10 );

        acc.pay(600);

        int actual = acc.getBalance();
        int expected = -500;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void PayIfAmountNegative() {
        CreditAccount acc = new CreditAccount(100,1000,10 );

        Assertions.assertEquals(false, acc.pay(-600));

    }

    @Test
    public void ShouldPayBoolean() {
        CreditAccount acc = new CreditAccount(100, 500, 10);

        boolean expected = true;

        boolean actual = acc.pay(200);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void PayIfAmountMoreThanLimit() {
        CreditAccount acc = new CreditAccount(100,1000,10);

        acc.pay(2000);

        int expected = -1900;
        int actual = acc.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void PayBooleanIfAmountMoreThanLimit() {
        CreditAccount acc = new CreditAccount(100,1000,10 );

        Assertions.assertEquals(false, acc.pay(2000));
    }

    @Test
    public void PayIfAmountEqualsLimit() {
        CreditAccount acc = new CreditAccount(100,1000,10 );

        acc.pay(1100);

        Assertions.assertEquals(-1000, acc.getBalance());

    }
    @Test
    public void PayBooleanIfAmountEqualsLimit() {
        CreditAccount acc = new CreditAccount(100,1000,10 );

        Assertions.assertEquals(true, acc.pay(1100));

    }

    @Test
    public void ShouldAdd() {
        CreditAccount acc = new CreditAccount(100,1000,10 );

        acc.add(500);

        Assertions.assertEquals(600, acc.getBalance());
    }

    @Test
    public void AddIfAmountNegative() {
        CreditAccount acc = new CreditAccount(100,1000,10 );

        Assertions.assertEquals(false, acc.add(-100));
    }

    @Test
    public void ShouldYearChange() {
        CreditAccount acc = new CreditAccount(0,2000,10 );

        acc.pay(1000);

        Assertions.assertEquals(-100, acc.yearChange());
    }

    @Test
    public void ShouldYearChangeIfBalanceIsPositive() {
        CreditAccount acc = new CreditAccount(1000,2000,10 );

        Assertions.assertEquals(0, acc.yearChange());
    }

}


