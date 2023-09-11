package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void CreationSavingAccountWithNegativeInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account account = new SavingAccount(-1000, 1000, 10_000, 10);
        });
    }

    @Test
    public void CreationSavingAccountWithNegativeMinBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account account = new SavingAccount(1000, -500, 10_000, 10);
        });
    }

    @Test
    public void CreationSavingAccountWithNegativeRate() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account account = new SavingAccount(2000, 1000, 10_000, -10);
        });
    }

    @Test
    public void CreationSavingAccountWithNegativeMaxBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account account = new SavingAccount(2000, 1000, -10_000, 10);
        });
    }

    @Test
    public void CreationSavingAccountWithMaxBalanceLessMinBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            Account account = new SavingAccount(2000, 2000, 1750, 10);

        });
    }

    @Test
    public void CreationSavingAccountWithInitialBalanceLessMinBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account account = new SavingAccount(500, 1000, 10_000, 10);
        });
    }

    @Test
    public void CreationSavingAccountWithInitialBalanceMoreMaxBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account account = new SavingAccount(11_000, 1000, 10_000, 10);
        });
    }

    @Test
    public void SavingAccPayIfAmountNegative() {
        SavingAccount acc = new SavingAccount(1000, 100, 10_000, 10);
        Assertions.assertEquals(false, acc.pay(-500));
    }

    @Test
    public void SavingAccShouldPayBoolean() {
        SavingAccount acc = new SavingAccount(1000, 100, 10_000, 10);
        boolean expected = true;

        boolean actual = acc.pay(500);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SavingAccShouldPayWithLimit() {
        SavingAccount acc = new SavingAccount(1000, 100, 10_000, 10);

        acc.pay(500);

        int actual = acc.getBalance();
        int expected = 500;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ShouldPayOnBorder() {
        SavingAccount acc = new SavingAccount(1000, 100, 10_000, 10);

        acc.pay(900);

        int actual = acc.getBalance();
        int expected = 100;

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void ShouldPayBelowBorder() {
        SavingAccount acc = new SavingAccount(1000, 100, 10_000, 10);

        acc.pay(1000);

        int actual = acc.getBalance();
        int expected = 1000;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ShouldPayBelowNegativeBorder() {
        SavingAccount acc = new SavingAccount(1000, 100, 10_000, 10);

        acc.pay(2000);

        int actual = acc.getBalance();
        int expected = 1000;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void SavingAccAddIfAmountNegative() {
        SavingAccount acc = new SavingAccount(1000, 100, 10_000, 10);
        Assertions.assertEquals(false, acc.add(10_000));
    }

    @Test
    public void SavingAccAddIfAmountEqualsLimit() {
        SavingAccount acc = new SavingAccount(1000, 100, 10_000, 10);

        Assertions.assertEquals(true, acc.add(9000));
    }

    @Test
    public void ShouldAddLessThanMaxBalance() {
        SavingAccount acc = new SavingAccount(

                2_000,
                1_000,
                10_000,
                10
        );

        acc.add(3_000);

        Assertions.assertEquals(5_000, acc.getBalance());
    }

    @Test
    public void ShouldAddMoreThanMaxBalance() {
        SavingAccount acc = new SavingAccount(

                2_000,
                0,
                10_000,
                15
        );

        acc.add(9_000);

        Assertions.assertEquals(2_000, acc.getBalance());
    }

    @Test
    public void ShouldAddEqualThenMaxBalance() {
        SavingAccount acc = new SavingAccount(
                1_000,
                1_000,
                10_000,

                25
        );

        acc.add(9_000);

        Assertions.assertEquals(10_000, acc.getBalance());
        
    }

    @Test
    public void ShouldAddMoreThanMaxBalance() {
        SavingAccount acc = new SavingAccount(
                2_000,
                0,
                10_000,
                15
        );

        acc.add(9_000);

        Assertions.assertEquals(2_000, acc.getBalance());
    }

    @Test
    public void ShouldAddEqualThenMaxBalance() {
        SavingAccount acc = new SavingAccount(
                1_000,
                1_000,
                10_000,
                25
        );

        acc.add(9_000);

        Assertions.assertEquals(10_000, acc.getBalance());
    }

    @Test
    public void ShouldAddZeroToBalance() {
        SavingAccount acc = new SavingAccount(
                2_000,
                1_000,
                10_000,
                20
        );

        acc.add(0);

        Assertions.assertEquals(2_000, acc.getBalance());
    }

    @Test
    public void ShouldAddIfAmountNegative() {
        SavingAccount acc = new SavingAccount(1000, 100, 10_000, 10);

        Assertions.assertEquals(false, acc.add(-500));
    }

    @Test
    public void SavingAccShouldYearChange() {
        SavingAccount acc = new SavingAccount(1000, 100, 10_000, 10);
        acc.add(1000);
        Assertions.assertEquals(100, acc.yearChange());
    }

    @Test
    public void SavingAccShouldYearChangeInLimit() {
        SavingAccount acc = new SavingAccount(1500, 100, 10_000, 15);

        Assertions.assertEquals(225, acc.yearChange());
    }

    @Test
    public void SavingAccShouldYearChangeInZero() {
        SavingAccount acc = new SavingAccount(0, 0, 10_000, 10);
        acc.add(0);
        Assertions.assertEquals(0, acc.yearChange());
    }

    @Test
    public void SavingAccShouldYearChangeInFractional() {
        SavingAccount acc = new SavingAccount(1234, 100, 10_000, 12);

        Assertions.assertEquals(144, acc.yearChange());

    }

    @Test
    public void ShouldAddZeroToBalance() {
        SavingAccount acc = new SavingAccount(
                2_000,
                1_000,
                10_000,
                20
        );

        acc.add(0);

        Assertions.assertEquals(2_000, acc.getBalance());
    }

    @Test
    public void ShouldAddIfAmountNegative() {
        SavingAccount acc = new SavingAccount(1000, 100, 10_000, 10);

        Assertions.assertEquals(false, acc.add(-500));
    }

    @Test
    public void SavingAccShouldYearChange() {
        SavingAccount acc = new SavingAccount(1000, 100, 10_000, 10);
        Assertions.assertEquals(100, acc.yearChange());
    }

    @Test
    public void SavingAccShouldYearChangeInLimit() {
        SavingAccount acc = new SavingAccount(1500, 100, 10_000, 15);

        Assertions.assertEquals(225, acc.yearChange());
    }

    @Test
    public void SavingAccShouldYearChangeInZero() {
        SavingAccount acc = new SavingAccount(0, 0, 10_000, 10);
        acc.add(0);
        Assertions.assertEquals(0, acc.yearChange());
    }

    @Test
    public void SavingAccShouldYearChangeInFractional() {
        SavingAccount acc = new SavingAccount(1234, 100, 10_000, 12);

        Assertions.assertEquals(144, acc.yearChange());
    }

    @Test
    public void SavingAccPayExtraLimit() {
        SavingAccount acc = new SavingAccount(1000, 100, 10_000, 10);
        Assertions.assertEquals(false, acc.pay(2_000));
    }
}
