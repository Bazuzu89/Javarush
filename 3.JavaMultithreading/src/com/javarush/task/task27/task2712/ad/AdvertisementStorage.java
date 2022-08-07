package com.javarush.task.task27.task2712.ad;

import java.util.List;
import java.util.ArrayList;

public class AdvertisementStorage {
    private static AdvertisementStorage instance;
    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "first Video", 5000, 100, 3 * 60)); // 3 min
        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        videos.add(new Advertisement(someContent, "third Video", 400, 2, 10 * 60)); //10 min
        videos.add(new Advertisement(someContent, "Fourth Video", 500, 10, 1 * 60)); // 1
        videos.add(new Advertisement(someContent, "Fifth Video", 50, 1, 7 * 60)); // 7
        videos.add(new Advertisement(someContent, "sixth Video", 800, 9, 5 * 60)); // 5
        videos.add(new Advertisement(someContent, "Eight Video", 100, 250, 9 * 60)); // 9
        videos.add(new Advertisement(someContent, "Ninth Video", 200, 10, 15 * 60)); // 15
        videos.add(new Advertisement(someContent, "Seventh Video", 300, 20, 3 * 60)); // 3
        videos.add(new Advertisement(someContent, "Tenth Video", 400, 30, 6 * 60)); // 6
        for (int i = 11; i < 12; i++) {
            int initialAmount = (int) (Math.random() * 100);
            int hits = (int) (Math.random() * 10);
            int duration = (int) ((0.1 + Math.random()) * 60);
            videos.add(new Advertisement(someContent,  "Видео" + i, initialAmount, hits, duration));
        }
    }

    public static AdvertisementStorage getInstance() {
        if (instance == null) {
            instance = new AdvertisementStorage();
        }
        return instance;
    }

    public List<Advertisement> list()
    {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
