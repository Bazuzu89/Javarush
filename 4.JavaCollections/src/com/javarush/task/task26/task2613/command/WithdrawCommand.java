package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

class WithdrawCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle((CashMachine.RESOURCE_PATH + "withdraw_en").replaceAll("\\.", "/"), Locale.ENGLISH);

    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String curCode;
        do {
        curCode = ConsoleHelper.askCurrencyCode();
        } while (curCode == null);
        CurrencyManipulator curMan = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(curCode);
        ConsoleHelper.writeMessage(res.getString("specify.amount"));
        String amount;
        int intAmount = 0;
        Map<Integer, Integer> mapWithdraw = new HashMap<>();
        do {
            try {
                amount = ConsoleHelper.readString();
                intAmount = Integer.parseInt(amount);
                mapWithdraw = curMan.withdrawAmount(intAmount);
                if (mapWithdraw.size() == 0) {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    amount = null;
                    ConsoleHelper.writeMessage(res.getString("specify.amount"));
                    continue;
                }
            } catch (NumberFormatException nfe) {
                amount = null;
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            } catch (NotEnoughMoneyException neme) {
                amount = null;
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
        } while (amount == null);

        Map<Integer, Integer> mapWithdrawSorted = new HashMap<>();
        mapWithdraw.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEachOrdered(x -> mapWithdrawSorted.put(x.getKey(), x.getValue()));
        int amountWithdrawn = 0;
        for (Integer denomination : mapWithdrawSorted.keySet()) {
            //ConsoleHelper.writeMessage(String.format("\t%d - %d", denomination, mapWithdrawSorted.get(denomination)));
            amountWithdrawn = amountWithdrawn + denomination * mapWithdrawSorted.get(denomination);
        }

        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amountWithdrawn, curCode));
    }
}
