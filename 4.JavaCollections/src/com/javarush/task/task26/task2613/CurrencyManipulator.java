package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.get(denomination) != null) {
            int newCount = denominations.get(denomination) + count;
            denominations.put(denomination, newCount);
        } else
        denominations.put(denomination, count);
    }

    public void removeAmount(int denomination, int count) {
        int newCount = denominations.get(denomination) > count ? denominations.get(denomination) - count : 0;
        if (newCount != 0) {
            denominations.put(denomination, newCount);
        } else {
            denominations.remove(denomination);
        }
    }

    public int getTotalAmount() {
        int totalAmount = 0;
        for (Integer denomination : denominations.keySet()) {
            totalAmount = totalAmount + denominations.get(denomination) * denomination;
        }
        return totalAmount;
    }

    public boolean hasMoney() {
        return getTotalAmount() > 0;
    }

    public boolean isAmountAvailable(int amount) {
        return amount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        if (!isAmountAvailable(expectedAmount)) {
            throw new NotEnoughMoneyException();
        }
        ArrayList<Integer> banknotesArrayList = new ArrayList<>();
        for (Integer denomination : denominations.keySet()) {
            for (int i = 0; i < denominations.get(denomination); i++) {
                banknotesArrayList.add(denomination);
            }
        }
        Collections.sort(banknotesArrayList);

        ArrayList<ArrayList<Integer>> listOfCombinationsFeetForAmount = new ArrayList<>();

        int minCombinationSize = Integer.MAX_VALUE;
        int maxBanknoteDenomination = 0;
        for (int j = banknotesArrayList.size() -1; j >= 0; j--) {
            ArrayList<Integer> currentList = new ArrayList<>();
            currentList.add(banknotesArrayList.get(j));
            int i = j - 1;
            do {
                if (currentList.size() > minCombinationSize) {
                    break;
                }
                if (i >= 0 && getListAmount(currentList) < expectedAmount) {
                    currentList.add(banknotesArrayList.get(i));
                } else if (getListAmount(currentList) > expectedAmount) {
                    currentList.remove(currentList.size() - 1);
                }
                if (getListAmount(currentList) == expectedAmount) {
                    if (listOfCombinationsFeetForAmount.size() == 0 || (listOfCombinationsFeetForAmount.size() > 0 && currentList.size() <= listOfCombinationsFeetForAmount.get(0).size())) {
                        if (i >= 0 && banknotesArrayList.get(i) > maxBanknoteDenomination) {
                            maxBanknoteDenomination = banknotesArrayList.get(i);
                        }
                        if (banknotesArrayList.get(j) > maxBanknoteDenomination) {
                            maxBanknoteDenomination = banknotesArrayList.get(j);
                        }
                        if (currentList.size() < minCombinationSize) {
                            minCombinationSize = currentList.size();
                        }
                        listOfCombinationsFeetForAmount.add(currentList);
                        break;
                    }
                }
                i--;
            } while (i >= 0);
        }
        final int minSize = minCombinationSize;
        final int maxBanknote = maxBanknoteDenomination;
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        listOfCombinationsFeetForAmount
                .stream()
                .filter(list -> list.size() == minSize)
                .filter(list -> list.contains(maxBanknote))
                .forEach(list -> resultList.add(list));

        HashMap<Integer, Integer> resultMap = new HashMap<>();
        if (resultList.size() > 0) {
            for (Integer denomination : resultList.get(0)) {
                if (!resultMap.keySet().contains(denomination)) {
                    resultMap.put(denomination, 1);
                } else {
                    int newCount = resultMap.get(denomination) + 1;
                    resultMap.put(denomination, newCount);
                }
            }
        }
        if (resultMap.size() > 0) {
            for (Integer denomination : resultMap.keySet()) {
                removeAmount(denomination, resultMap.get(denomination));
            }
        }

        return resultMap;
    }

    private int getListAmount(List<Integer> list) {
        int amount = 0;
        for (Integer integer : list) {
            amount = amount + integer;
        }
        return amount;
    }
}
