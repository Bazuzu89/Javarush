package com.javarush.task.task27.task2712.ad;

import java.util.*;
import com.javarush.task.task27.task2712.*;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.*;

import java.util.concurrent.*;

public class AdvertisementManager {
    public final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    private Set<List<Advertisement>> listOfAdvertisementSets = new CopyOnWriteArraySet<List<Advertisement>>( /* new Comparator<List<Advertisement>>() {
        @Override
        public int compare(List<Advertisement> list1, List<Advertisement> list2) {
            return list1.equals(list2) ? 0 : 1;
        }
    } */);

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        } else {
            List<Advertisement> videosHitsFiltered = new ArrayList<>();
            for (Advertisement ad : storage.list()) {
                if (ad.getHits() > 0) {
                    videosHitsFiltered.add(ad);
                }
            }
            sortList(videosHitsFiltered, timeSeconds, 0);
        }
        List<Advertisement> resultList = new ArrayList();
        List<List<Advertisement>> listOfAdSetsToFindMaxAmount = new ArrayList<>();
        Long maxAmount = 0L;
        for (List<Advertisement> list : listOfAdvertisementSets) {
            if (getAmountOfListOfAd(list) > maxAmount) {
                maxAmount = getAmountOfListOfAd(list);
            }
        }
        for (List<Advertisement> list : listOfAdvertisementSets) {
            if (getAmountOfListOfAd(list) == maxAmount) {
                listOfAdSetsToFindMaxAmount.add(list);
            }
        }
        if (listOfAdSetsToFindMaxAmount.size() > 1) {
            int maxTimeSeconds = 0;

            for (List<Advertisement> list : listOfAdSetsToFindMaxAmount) {
                if (getAmountOfListOfAd(list) == maxAmount && getTimeOfListOfAd(list) > maxTimeSeconds) {
                    maxTimeSeconds = getTimeOfListOfAd(list);
                }
            }

            List<List<Advertisement>> listOfAdSetsToFindMaxTime = new ArrayList<>();
            for (List<Advertisement> list : listOfAdSetsToFindMaxAmount) {
                if (getTimeOfListOfAd(list) == maxTimeSeconds) {
                    listOfAdSetsToFindMaxTime.add(list);
                }
            }
            if (listOfAdSetsToFindMaxTime.size() > 1) {
                int minSize = Integer.MAX_VALUE;
                for (List<Advertisement> list : listOfAdSetsToFindMaxTime) {
                    if (list.size() < minSize) {
                        minSize = list.size();
                    }
                }
                for (List<Advertisement> list : listOfAdSetsToFindMaxTime) {
                    if (list.size() == minSize) {
                        resultList = list;
                        break;
                    }
                }
            } else resultList = listOfAdSetsToFindMaxTime.get(0);
        } else resultList = listOfAdSetsToFindMaxAmount.get(0);

        Comparator<Advertisement> comparator = Comparator.comparingLong(Advertisement :: getAmountPerOneDisplaying)
                                                          .reversed()
                                                         .thenComparingLong(Advertisement :: getAmountPerSecond);
        Collections.sort(resultList, comparator);
        StatisticManager statisticManager = StatisticManager.getInstance();
        EventDataRow data = new VideoSelectedEventDataRow(resultList, getAmountOfListOfAd(resultList), getTimeOfListOfAd(resultList));
        statisticManager.register(data);
        displayVideos(resultList);
    }


    private void sortList(List<Advertisement> inputList, int timeSeconds, long maxAmount) {
        if (inputList.size() == 0 || getAmountOfListOfAd(inputList) < maxAmount) {
            return;
        }
        if (getTimeOfListOfAd(inputList) <= timeSeconds) {
            listOfAdvertisementSets.add(inputList);
            if (getAmountOfListOfAd(inputList) > maxAmount) {
                maxAmount = getAmountOfListOfAd(inputList);
            }
            return;
        } else {
            for (Advertisement advertisement : inputList) {
                ArrayList<Advertisement> newNewList = new ArrayList<>(inputList);
                newNewList.remove(advertisement);
                sortList(newNewList, timeSeconds, maxAmount);
            }
        }
    }

    private long getAmountOfListOfAd(List<Advertisement> listAd) {
        long amountSum = 0l;
        for (Advertisement advertisement : listAd) {
            amountSum = amountSum + advertisement.getAmountPerOneDisplaying();
        }
        return amountSum;
    }

    private int getTimeOfListOfAd(List<Advertisement> listAd) {
        int time = 0;
        for (Advertisement advertisement : listAd) {
            time = time + advertisement.getDuration();
        }
        return time;
    }

    public void displayVideos(List<Advertisement> list) {
        for (Advertisement ad : list) {
            ConsoleHelper.writeMessage(ad.getName() + " is displaying... " + ad.getAmountPerOneDisplaying() +
                    ", " + (1000 * ad.getAmountPerOneDisplaying() / ad.getDuration()));
            ad.revalidate();
        }
    }
}
