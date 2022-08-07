package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HtmlView implements View {
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replaceAll("[.]", "/") + "/vacancies.html";
        //this.getClass().getPackageName() src/com/javarush/task/task28/task2810/view/vacancies.html



    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        String result = "";
        try {
            Document doc = getDocument();
            Elements elements = doc.getElementsByClass("template");
            Element template = elements.clone().removeAttr("style").removeClass("template").get(0);
            Elements formerVacancies = doc.getElementsByClass("vacancy");
            for (Element elementToRemove : formerVacancies) {
                if (!elementToRemove.hasClass("template")) {
                    elementToRemove.remove();
                }
            }
            for (Vacancy vacancy : vacancies) {
                Element vacancyElement = template.clone();
                Element element = vacancyElement.getElementsByAttribute("href").get(0);
                element.appendText(vacancy.getTitle());
                element.attr("href", vacancy.getUrl());
                vacancyElement.getElementsByClass("city").get(0).appendText(vacancy.getCity());
                vacancyElement.getElementsByClass("companyName").get(0).appendText(vacancy.getCompanyName());
                vacancyElement.getElementsByClass("salary").get(0).appendText(vacancy.getSalary());
                
                elements.before(vacancyElement.outerHtml());
            }
            return doc.html();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Some exception occurred";
    }

    private void updateFile(String string) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(string);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException {
        File file = new File(filePath);
        return Jsoup.parse(file, "UTF-8");
    }
}
