package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class scraper {
    public static double getConversionRate(String fromCurrency, String toCurrency) {
        double conversionRate = 0;
        try {
            String url = "https://www.x-rates.com/calculator/?from=" + fromCurrency + "&to=" + toCurrency + "&amount=1";
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("span.ccOutputRslt");
            for (Element element : elements) {
                System.out.println(element.text());
            }
            System.out.println(elements.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conversionRate;
    }
    
    public static void main(String[] args) {
        System.out.println(getConversionRate("USD", "EUR"));
    }
}
