package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance());

        bankAccount.withdraw(-50);

        assertEquals(100,bankAccount.getBalance());

        bankAccount.withdraw(300);

        assertEquals(100,bankAccount.getBalance());
    }

    @Test
    void isAmountValidTest(){
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        assertTrue(bankAccount.isAmountValid(100.10));
        assertFalse(bankAccount.isAmountValid(100.101));
        assertFalse(bankAccount.isAmountValid(-100.10));

    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertFalse( BankAccount.isEmailValid(""));
        assertFalse(BankAccount.isEmailValid("@v.com"));
        assertFalse(BankAccount.isEmailValid("v@v"));
        assertFalse(BankAccount.isEmailValid("v@.com"));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());

        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("email2@Email2.com", -300));

        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("email3@Email3.com", 1.111));

        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}