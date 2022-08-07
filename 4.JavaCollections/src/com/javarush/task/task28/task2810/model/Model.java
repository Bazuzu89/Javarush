package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;

public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) {

        if (providers != null && providers.length > 0 && view != null) {
            this.view = view;
            this.providers = providers;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void selectCity(String city) {
        ArrayList<Vacancy> listVacancies = new ArrayList<>();
        for (Provider provider : providers) {
            listVacancies.addAll(provider.getJavaVacancies(city));
        }
        view.update(listVacancies);
    }
}
