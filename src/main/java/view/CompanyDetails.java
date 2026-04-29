package view;

import model.Company;

/**
 * Utility class for displaying detailed information about a {@link Company}.
 * <p>
 * Provides a static method to print a company's name, ticker symbol,
 * current stock price, and description to the console.
 * </p>
 */

public class CompanyDetails {

    /**
     * Prints the full details of the given company to standard output,
     * including its name, ticker symbol, current stock price, and description.
     *
     * @param c the {@link Company} whose details will be displayed
     */
    
    public static void displayDetails(Company c) {
        System.out.println("Company: " + c.getName() + " (" + c.getTicker() + ")");
        System.out.println("Price: $" + c.getCurrentPrice());
        System.out.println("About: " + c.getDescription());
    }
}