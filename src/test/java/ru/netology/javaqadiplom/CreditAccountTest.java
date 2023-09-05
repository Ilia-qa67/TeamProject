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
}
