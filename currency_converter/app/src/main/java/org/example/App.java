/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;
import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }
    public Double getTwoCurrencyConversion() {
        // Ask the user for the first and second currency then find the conversion rate
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first currency: ");
        String currency1 = scanner.nextLine().toUpperCase();
        System.out.println("Enter the second currency: ");
        String currency2 = scanner.nextLine().toUpperCase();
        scanner.close();
        Double conversionRate = scraper.getConversionRate(currency1, currency2);
        System.out.println("The conversion rate from " + currency1 + " to " + currency2 + " is " + conversionRate);
        return conversionRate;
    }
    public Double converTwoCurrency() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first currency: ");
        String currency1 = scanner.nextLine().toUpperCase();
        System.out.println("Enter the second currency: ");
        String currency2 = scanner.nextLine().toUpperCase();
        System.out.println("Enter the amount of " + currency1 + " you want to convert: ");
        Double amount = scanner.nextDouble();
        scanner.close();
        Double conversionRate = scraper.getConversionRate(currency1, currency2);
        Double convertedAmount = amount * conversionRate;
        System.out.println("The amount of " + currency1 + " you entered is " + amount + " and the amount of " + currency2 + " you will get is " + convertedAmount);
        return convertedAmount;
    }

    public static void main(String[] args) {
        App app = new App();
        // Double rate = app.getTwoCurrencyConversion();
        // System.out.println("The conversion rate is " + rate);
        Scanner main_scanner = new Scanner(System.in);
        System.out.println("Enter 1 to get the conversion rate between two currencies.\n2 to convert an amount from one currency to another: ");
        int choice = main_scanner.nextInt();
        switch (choice) {
            case 1:
                app.getTwoCurrencyConversion();
                break;
            case 2:
                app.converTwoCurrency();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        main_scanner.close();
        
    }
}
