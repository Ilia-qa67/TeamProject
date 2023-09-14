import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqadiplom.Bank;
import ru.netology.javaqadiplom.CreditAccount;
import ru.netology.javaqadiplom.SavingAccount;

public class BankTest {

    SavingAccount accountS1 = new SavingAccount(1000, 0, 3000, 10);
    SavingAccount accountS2 = new SavingAccount(1500, 1500, 2000, 10);
    CreditAccount accountC1 = new CreditAccount(500, 2500, 10);
    CreditAccount accountC2 = new CreditAccount(1000, 3000, 10);


    @Test
    public void shouldTransferFromSavingToSavingDecreaseCheckNegative() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountS2, 1000);

        int expected = 1000;
        int actual = accountS1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToSavingIncreaseCheckOverMaxLimit() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountS2, 1000);

        int expected = 1500;
        int actual = accountS2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToCreditDecreaseCheckPositive() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountC2, 1000);

        int expected = -500;
        int actual = accountC1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToCreditIncreaseCheckPositive() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountC2, 1000);

        int expected = 2000;
        int actual = accountC2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToCreditDecreaseCheckZero() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountC2, 1000);

        int expected = 0;
        int actual = accountS1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToCreditIncreaseCheckPositive() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountC2, 1000);

        int expected = 2000;
        int actual = accountC2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToSavingDecreaseCheckPositive() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountS2, 1000);

        int expected = 500;
        int actual = accountC1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToSavingIncreaseCheckPositive() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountS2, 1000);

        int expected = 1500;
        int actual = accountS2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToSavingDecreaseOverCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountS2, 1000);

        int expected = 1000;
        int actual = accountS1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToSavingIncreaseOverCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountS2, 1000);

        int expected = 1500;
        int actual = accountS2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToSavingDecreaseZeroCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountS2, 0);

        int expected = 1000;
        int actual = accountS1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToSavingIncreaseNegativeCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountS2, 1000);

        int expected = 1000;
        int actual = accountS1.getBalance();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldTransferFromCreditToCreditDecreaseOverCheck() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountC2, 4000);

        int expected = 500;
        int actual = accountC1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToCreditIncreaseOverCheck() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountC2, 3000);

        int expected = 4000;
        int actual = accountC2.getBalance();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldTransferFromCreditToCreditDecreaseExtraCheck() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountC2, 3500);

        int expected = 500;
        int actual = accountC1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToCreditIncreaseZeroCheck() {
        Bank bank = new Bank();

        bank.transfer(accountC2, accountC1, 0);

        int expected = 1000;
        int actual = accountC2.getBalance();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldTransferFromCreditToCreditDecreaseNegativeCheck() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountC2, 2500);

        int expected = -2000;
        int actual = accountC1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToCreditIncreaseNegativeCheck() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountC2, 2500);

        int expected = 3500;
        int actual = accountC2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToCreditDecreaseExtraCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountC2, 3000);

        int expected = 1000;
        int actual = accountS1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToCreditIncrease() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountC2, 3000);

        int expected = 1000;
        int actual = accountS1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToSavingDecreaseExtraCheck() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountS2, 500);

        int expected = 0;
        int actual = accountC1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToSavingIncreaseExtraCheck() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountS2, 2500);

        int expected = 500;
        int actual = accountC1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToCreditDecreaseOverCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountC2, 5000);

        int expected = 1000;
        int actual = accountC2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToCreditIncreaseOverCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountC2, 1000);

        int expected = 2000;
        int actual = accountC2.getBalance();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void transferFromCreditToCreditIfAmountMoreThanLimit() {
        Bank bank = new Bank();

        Assertions.assertEquals(false, bank.transfer(accountC1, accountC2, 5000));
    }

    @Test
    public void transferFromSavingToSavingIfAmountMoreThanMinBalance() {
        Bank bank = new Bank();

        Assertions.assertEquals(false, bank.transfer(accountS1, accountS2, 3000));

    }

    @Test
    public void transferFromSavingToSavingIfAmountMoreThanMaxBalance() {
        Bank bank = new Bank();

        Assertions.assertEquals(false, bank.transfer(accountS1, accountS2, 1000));
    }

    @Test
    public void transferFromSavingToSavingIfAmountMoreThanMaxBalanceOverCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountS2, 1000);

        int expected = 1000;
        int actual = accountS1.getBalance();

        Assertions.assertEquals(expected, actual);


    }

}

