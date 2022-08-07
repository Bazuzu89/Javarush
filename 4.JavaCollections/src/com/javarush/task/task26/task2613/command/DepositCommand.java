package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle((CashMachine.RESOURCE_PATH + "deposit_en").replaceAll("\\.", "/"), Locale.ENGLISH);

    public void execute() throws InterruptOperationException {
        String currencyCode;
        do {
            currencyCode = ConsoleHelper.askCurrencyCode();
            if (currencyCode == null) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        } while (currencyCode == null);

        String[] numbers;
        do {
            numbers = ConsoleHelper.getValidTwoDigits(currencyCode);
            if (numbers == null) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        } while (numbers == null);
        ConsoleHelper.writeMessage(res.getString("before"));
        CurrencyManipulator curMan = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int denomination = Integer.parseInt(numbers[0]);
        int count = Integer.parseInt(numbers[1]);
        curMan.addAmount(denomination, count);
        int amount = count * denomination;
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));
    }
}
