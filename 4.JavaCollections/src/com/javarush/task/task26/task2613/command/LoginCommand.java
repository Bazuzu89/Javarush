package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.math.BigInteger;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private final String cardNumber = "123456789012";
    private final String cardPin = "1234";
    private ResourceBundle validCreditCards = ResourceBundle.getBundle((CashMachine.RESOURCE_PATH + "verifiedCards").replaceAll("\\.", "/"), Locale.ENGLISH);
    private ResourceBundle res = ResourceBundle.getBundle((CashMachine.RESOURCE_PATH + "login_en").replaceAll("\\.", "/"), Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException {
        String cardNumber = null;
        String pin = null;
        do {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            cardNumber = ConsoleHelper.readString();
            pin = ConsoleHelper.readString();
            try {
                BigInteger cardNumberInt = new BigInteger(cardNumber);
                int pinInt = Integer.parseInt(pin);
                if (cardNumber.length() != 12 || pin.length() != 4) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException iae) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                cardNumber = null;
                pin = null;
            }
            if (cardNumber != null && pin != null) {
                if (validCreditCards.containsKey(cardNumber) && validCreditCards.getString(cardNumber).equals(pin)) {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumber));
                } else {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    cardNumber = null;
                    pin = null;
                }
            }
        } while (cardNumber == null || pin == null);
        ConsoleHelper.writeMessage(res.getString("before"));
    }
}
