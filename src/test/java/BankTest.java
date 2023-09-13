import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqadiplom.Bank;
import ru.netology.javaqadiplom.CreditAccount;
import ru.netology.javaqadiplom.SavingAccount;

public class BankTest {

    CreditAccount account1 = new CreditAccount(1000,2000, 10);
    CreditAccount account2 = new CreditAccount(2000,3000,10);

    SavingAccount account3 = new SavingAccount(1000,0,3000,10);
    SavingAccount account4 = new SavingAccount(2000,1000,2900,10);

    @Test
    public void TransferIfAmountIsNegative() {
        Bank bank = new Bank();

        Assertions.assertEquals(false, bank.transfer(account1, account2, -500));
    }

    @Test
    public void shouldTransferFromCreditToCredit() {
        Bank bank = new Bank();

        Assertions.assertEquals(true, bank.transfer(account1, account2, 500));

    }

    @Test
    public void shouldTransferFromCreditToCreditFirstAccCheck() {
        Bank bank = new Bank();

        bank.transfer(account1, account2, 500);

        int expected = 500;
        int actual = account1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToCreditSecondAccCheck() {
        Bank bank = new Bank();

        bank.transfer(account1, account2, 500);

        int expected = 2500;
        int actual = account2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TransferFromCreditToCreditIfAmountMoreThanLimit() {
        Bank bank = new Bank();

        Assertions.assertEquals(false, bank.transfer(account1, account2, 5000));
    }

    @Test
    public void TransferFromCreditToCreditIfAmountMoreThanLimitFirstAccCheck() {
        Bank bank = new Bank();

        bank.transfer(account1, account2, 5000);

        int expected = 1000;
        int actual = account1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TransferFromCreditToCreditIfAmountMoreThanLimitSecondAccCheck() {
        Bank bank = new Bank();

        bank.transfer(account1, account2, 5000);

        int expected = 2000;
        int actual = account2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToCreditIfAmountIsEqualToLimit() {
        Bank bank = new Bank();

        Assertions.assertEquals(true, bank.transfer(account1, account2, 3000));
    }

    @Test
    public void shouldTransferFromCreditToCreditIfAmountIsEqualToLimitFirstAccCheck() {
        Bank bank = new Bank();

        bank.transfer(account1, account2, 3000);

        int expected = -2000;
        int actual = account1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToCreditIfAmountIsEqualToLimitSecondAccCheck() {
        Bank bank = new Bank();

        bank.transfer(account1, account2, 3000);

        int expected = 5000;
        int actual = account2.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToSaving() {
        Bank bank = new Bank();

        Assertions.assertEquals(true, bank.transfer(account3, account4, 500));

    }

    @Test
    public void shouldTransferFromSavingToSavingFirstAccCheck() {
        Bank bank = new Bank();

        bank.transfer(account3, account4, 500);

        int expected = 500;
        int actual = account3.getBalance();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldTransferFromSavingToSavingSecondAccCheck() {
        Bank bank = new Bank();

        bank.transfer(account3, account4, 500);

        int expected = 2500;
        int actual = account4.getBalance();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void TransferFromSavingToSavingIfAmountMoreThanMinBalance() {
        Bank bank = new Bank();

        Assertions.assertEquals(false, bank.transfer(account3, account4, 2000));

    }

    @Test
    public void TransferFromSavingToSavingIfAmountMoreThanMinBalanceFirstAccCheck() {
        Bank bank = new Bank();

        bank.transfer(account3, account4, 2000);

        int expected = 1000;
        int actual = account3.getBalance();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void TransferFromSavingToSavingIfAmountMoreThanMinBalanceSecondAccCheck() {
        Bank bank = new Bank();

        bank.transfer(account3, account4, 2000);

        int expected = 2000;
        int actual = account4.getBalance();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void TransferFromSavingToSavingIfAmountMoreThanMaxBalance() {
        Bank bank = new Bank();

        Assertions.assertEquals(false,bank.transfer(account3, account4, 950));
    }

    @Test
    public void TransferFromSavingToSavingIfAmountMoreThanMaxBalanceFirstAccCheck() {
        Bank bank = new Bank();

        bank.transfer(account3, account4, 950);

        int expected = 1000;
        int actual = account3.getBalance();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void TransferFromSavingToSavingIfAmountMoreThanMaxBalanceSecondAccCheck() {
        Bank bank = new Bank();

        bank.transfer(account3, account4, 950);

        int expected = 2000;
        int actual = account4.getBalance();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldTransferFromCreditToSaving() {
        Bank bank = new Bank();

        Assertions.assertEquals(true, bank.transfer(account1, account3, 500));
    }

    @Test
    public void shouldTransferFromCreditToSavingFirstAccCheck() {
        Bank bank = new Bank();

        bank.transfer(account1, account3, 500);

        int expected = 500;
        int actual = account1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromCreditToSavingSecondAccCheck() {
        Bank bank = new Bank();

        bank.transfer(account1, account3, 500);

        int expected = 1500;
        int actual = account3.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToCredit() {
        Bank bank = new Bank();

        Assertions.assertEquals(true, bank.transfer(account3, account1, 500));
    }

    @Test
    public void shouldTransferFromSavingToCreditFirstAccCheck() {
        Bank bank = new Bank();

        bank.transfer(account3, account1, 500);

        int expected = 500;
        int actual = account3.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTransferFromSavingToCreditSecondAccCheck() {
        Bank bank = new Bank();

        bank.transfer(account3, account1, 500);

        int expected = 1500;
        int actual = account1.getBalance();

        Assertions.assertEquals(expected, actual);
    }

}
