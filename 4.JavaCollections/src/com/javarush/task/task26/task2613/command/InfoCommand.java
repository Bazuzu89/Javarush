package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.*;

class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle((CashMachine.RESOURCE_PATH + "info_en").replaceAll("\\.", "/"), Locale.ENGLISH);

    public void execute() {
        Collection<CurrencyManipulator> map = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (map.isEmpty()) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
            return;
        }
        for (CurrencyManipulator currencyManipulator : map) {
            if (currencyManipulator.hasMoney()) {
                ConsoleHelper.writeMessage(String.format("%s - %d", currencyManipulator.getCurrencyCode(), currencyManipulator.getTotalAmount()));
            } else {
                ConsoleHelper.writeMessage(res.getString("no.money"));
            }
        }
    }
}
