package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.List;
import java.util.*;
import java.util.concurrent.*;

public class StatisticAdvertisementManager {
    private AdvertisementStorage adStorage = AdvertisementStorage.getInstance();
    private static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();

    private StatisticAdvertisementManager() {

    }

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null) {
            instance = new StatisticAdvertisementManager();
        }
        return instance;
    }

    public List<Advertisement> getAdsList(boolean isActive) {
        List<Advertisement> resultMap = new ArrayList<>();
        for (Advertisement ad : adStorage.list()) {
            if (!isActive ^ ad.isActive()) {
                resultMap.add(ad);
            }
        }
        return resultMap;
    }

    /* public List<Advertisement> getArchivedAds() {
        List<Advertisement> listAd = adStorage.list();
        List<Advertisement> resultList = new ArrayList<>();
        for (Advertisement ad : listAd) {
            if (!ad.isActive()) {
                resultList.add(ad);
            }
        }
        return resultList;
    } */
}
