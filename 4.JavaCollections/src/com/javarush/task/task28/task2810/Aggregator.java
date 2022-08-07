package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.*;
import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;

public class Aggregator {

    public static void main(String[] args) {
        HtmlView view = new HtmlView();
        HHStrategy strategy1 = new HHStrategy();
        Provider provider1 = new Provider(strategy1);
        HabrCareerStrategy strategy2 = new HabrCareerStrategy();
        Provider provider2 = new Provider(strategy2);
        Model model = new Model(view, provider1, provider2);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}
