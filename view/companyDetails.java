public void displayDetails(Company c) {
    System.out.println("Company: " + c.getName() + " (" + c.getTicker() + ")");
    System.out.println("Price: $" + c.getCurrentPrice());
    System.out.println("About: " + c.getDescription());
}