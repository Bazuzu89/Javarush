package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.nodes.Document;
import org.jsoup.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=java+%s&page=%d";

    public List<Vacancy> getVacancies(String searchString) {
        ArrayList<Vacancy> resultList = new ArrayList<>();
        try {
            int i = 0;
            Elements elements;
            do {
                Document doc = getDocument(searchString, i);
                i++;
                elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements.size() > 0) {
                    for (Element element : elements) {
                        Vacancy vacancy = new Vacancy();
                        String city = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").get(0).text();
                        vacancy.setCity(city);
                        String title = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").get(0).text();
                        vacancy.setTitle(title);
                        String salary;
                        try {
                            salary = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").get(0).text();
                        } catch (IndexOutOfBoundsException iofbe) {
                            salary = "";
                        }
                        vacancy.setSalary(salary);
                        String companyName = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").get(0).text();
                        vacancy.setCompanyName(companyName);
                        String siteName = "hh.ru";
                        vacancy.setSiteName(siteName);
                        String url = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").get(0).attr("href").split("&amp")[0];
                        vacancy.setUrl(url);
                        resultList.add(vacancy);
                    }
                }
            } while (elements.size() > 0);
        } catch (IOException ioe) {

        }
        return resultList;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        Document doc = Jsoup.connect(String.format(URL_FORMAT, searchString, page)).get();
        /*.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.160 YaBrowser/22.5.4.904 Yowser/2.5 Safari/537.36")
                .referrer("https://hh.ru/search/vacancy?text=java+moscow&page=1&hhtmFrom=vacancy_search_list")*/
        return doc;
    }

}
