import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqadiplom.Bank;
import ru.netology.javaqadiplom.CreditAccount;
import ru.netology.javaqadiplom.SavingAccount;

public class BankTest {

    SavingAccount accountS1 = new SavingAccount(2000, 0, 5000, 10);
    SavingAccount accountS2 = new SavingAccount(2000, 0, 5000, 10);
    CreditAccount accountC1 = new CreditAccount(500, 3000, 10);
    CreditAccount accountC2 = new CreditAccount(500, 3000, 10);


    @Test
    public void shouldTransferFromSavingToSavingDecreaseCheckPositive() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountS2, 1000);

        int expected = 1000;
        int actual = accountS1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToSavingIncreaseCheckPositive() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountS2, 1000);

        int expected = 3000;
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

        int expected = 1500;
        int actual = accountC2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToCreditDecreaseCheckPositive() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountC2, 1000);

        int expected = 1000;
        int actual = accountS1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToCreditIncreaseCheckPositive() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountC2, 1000);

        int expected = 1500;
        int actual = accountC2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToSavingDecreaseCheckPositive() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountS2, 1000);

        int expected = -500;
        int actual = accountC1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToSavingIncreaseCheckPositive() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountS2, 1000);

        int expected = 3000;
        int actual = accountS2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToSavingDecreaseOverCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountS2, 4000);

        int expected = 2000;
        int actual = accountS1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToSavingIncreaseOverCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountS2, 4000);

        int expected = 2000;
        int actual = accountS2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToSavingDecreaseZeroCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountS2, 0);

        int expected = 2000;
        int actual = accountS1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToSavingIncreaseZeroCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountS2, 0);

        int expected = 2000;
        int actual = accountS2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToSavingDecreaseNegativeCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountS2, -500);

        int expected = 2000;
        int actual = accountS1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToSavingIncreaseNegativeCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountS2, -500);

        int expected = 2000;
        int actual = accountS2.getBalance();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldTransferFromCreditToCreditDecreaseOverCheck() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountC2, 4000);

        int expected = 4500;
        int actual = accountC1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToCreditIncreaseOverCheck() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountC2, 4000);

        int expected = 4500;
        int actual = accountC2.getBalance();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldTransferFromCreditToCreditDecreaseZeroCheck() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountC2, 0);

        int expected = 500;
        int actual = accountC1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToCreditIncreaseZeroCheck() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountC2, 0);

        int expected = 500;
        int actual = accountC2.getBalance();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldTransferFromCreditToCreditDecreaseNegativeCheck() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountC2, -500);

        int expected = 500;
        int actual = accountC1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToCreditIncreaseNegativeCheck() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountC2, -500);

        int expected = 500;
        int actual = accountC2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToCreditDecreaseExtraCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountC2, 3000);

        int expected = 5000;
        int actual = accountS1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToCreditIncreaseExtraCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountC2, 3000);

        int expected = 3500;
        int actual = accountC2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToSavingDecreaseExtraCheck() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountS2, 3500);

        int expected = -3000;
        int actual = accountC1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToSavingIncreaseExtraCheck() {
        Bank bank = new Bank();

        bank.transfer(accountC1, accountS2, 3500);

        int expected = 2000;
        int actual = accountS2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToCreditDecreaseOverCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountC2, 5000);

        int expected = 500;
        int actual = accountC1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToCreditIncreaseOverCheck() {
        Bank bank = new Bank();

        bank.transfer(accountS1, accountC2, 5000);

        int expected = 2000;
        int actual = accountS2.getBalance();

        Assertions.assertEquals(expected, actual);
    }


}
