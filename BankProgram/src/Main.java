public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Oreintal Bank Of Commerce");

        bank.addBranch("Mau Nath Bhanjan");
        bank.addCustomer("Mau Nath Bhanjan", "Aamir", 100.00);
        bank.addCustomer("Mau Nath Bhanjan", "Adil", 1000.20);
        bank.addCustomer("Mau Nath Bhanjan", "Akif", 50.50);

        bank.addBranch("Varanasi");
        bank.addCustomer("Varanasi", "Abid", 200.40);
        bank.addCustomer("Varanasi", "Saquib", 20.00);

        bank.addCustomerTransaction("Mau Nath Bhanjan", "Aamir", 400.40);
        bank.addCustomerTransaction("Mau Nath Bhanjan", "Aamir", 200.40);
        bank.addCustomerTransaction("Mau Nath Bhanjan", "Adil", 400.40);
        bank.addCustomerTransaction("Varanasi", "Abid", 200.40);
        bank.addCustomerTransaction("Varanasi", "Abid", 100.40);
        bank.addCustomerTransaction("Varanasi", "Saquib", 50.40);

        bank.listOfCustomers("Mau Nath Bhanjan", true);
        bank.listOfCustomers("Varanasi", true);
    }
}
