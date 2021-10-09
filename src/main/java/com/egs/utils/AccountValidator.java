package com.egs.utils;


import com.egs.exception.InsufficientBalanceException;
import com.egs.exception.InvalidAmountException;

public class AccountValidator {
    public static boolean validateRemainingBalance(double amount, double balance) throws InsufficientBalanceException {

        if (balance < amount)
            throw new InsufficientBalanceException("Remaining balance less than withdraw amount");

        return true;
    }

    public static boolean validateAmount(double amount) throws InvalidAmountException {
        if (amount <= 0)
            throw new InvalidAmountException("Amount is  Invalid");
        return true;
    }
}
