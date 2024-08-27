package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

public class scraper {
    // Get the conversion rate between two currencies
    public static double getConversionRate(String fromCurrency, String toCurrency) {
        double conversionRate = 0;
        try {
            String url = "https://www.x-rates.com/calculator/?from=" + fromCurrency + "&to=" + toCurrency + "&amount=1";
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("span.ccOutputRslt");

            // System.out.println(elements.text());

            // keep the first word in elements
            String rate = elements.text().split(" ")[0];
            conversionRate = Double.parseDouble(rate);
            // System.out.println(rate);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conversionRate;
    }

    // Get the name of a currency from ISO code
    public static String getCurrencyName(String isoCode) {
        String currencyName = "";
        try {
            String url = "https://en.wikipedia.org/wiki/List_of_circulating_currencies";
            Document doc = Jsoup.connect(url).get();
            Elements rows = doc.select("table.wikitable tbody tr");
            if (rows != null) {
                for (Element row: rows) {
                    Elements columns = row.select("td");
                    // System.out.println(columns.text());
                    if (columns.size() > 2) {
                        String code = columns.get(2).text();
                        // System.out.println(code);
                        if (code.equalsIgnoreCase(isoCode)) {
                            currencyName = columns.get(0).text();
                        }
                    }

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currencyName;
    }

    // Get the ISO code of a currency from its name or countries that use it
    public static String getCurrencyISOCode(String Name) {
        String isoCode = "";
        try {
            String url = "https://en.wikipedia.org/wiki/List_of_circulating_currencies";
            Document doc = Jsoup.connect(url).get();
            Elements rows = doc.select("table.wikitable tbody tr");
            if (rows != null) {
                for (Element row: rows) {
                    Elements columns = row.select("td");
                    if (columns.size() > 2) {
                        // if the name equal to currency name
                        String currencyName = columns.get(1).text();
                        if (currencyName.equalsIgnoreCase(Name)) {
                            isoCode = columns.get(3).text();
                            return isoCode;
                        }
                        // if the name equal to country name
                        String countryName = columns.get(0).text();
                        // System.out.println(countryName);
                        if (countryName.equalsIgnoreCase(Name)) {
                            // System.out.println(columns.text());
                            isoCode = columns.get(3).text();
                            if (isoCode.length() != 3) {
                                continue;
                            }
                            return isoCode;
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isoCode;
    }
    
    public static void main(String[] args) {
        // System.out.println(getConversionRate("USD", "EUR"));
        // System.out.println(getCurrencyName("USD"));
        // System.out.println(getCurrencyISOCode("EURO"));
        System.out.println(getCurrencyISOCode("russian ruble"));
        // System.out.println(getCurrencyISOCode("Australia"));

    }
}
