package view;

import dao.CustomerDao;
import model.Customer;

import java.io.IOException;

class CustomerView extends View{

    private CustomerDao customerDAO = new CustomerDao(sessionFactory);

    void displayCustomerMenu() {
        int choice = 0;
        printLine();
        System.out.println("Please select option:");
        System.out.println("1 - Display all available customers");
        System.out.println("2 - Insert new customer");
        System.out.println("3 - Update customer by ID");
        System.out.println("4 - Delete customer by ID");
        System.out.println("5 - Return to main menu");
        printExitMessage();
        printLine();
        System.out.print("Please enter your choice:");

        try {
            input = reader.readLine();
        } catch (IOException e) {
            LOGGER.error("IOException occurred:" + e.getMessage());
            displayCustomerMenu();
        }
        isQuitInput(input, LOGGER);

        try {
            choice = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect value. Please try again.");
            displayCustomerMenu();
        }

        if (choice == 1) {
            displayAll();
        } else if (choice == 2) {
            insertCustomer();
        } else if (choice == 3) {
            updateCustomer();
        } else if (choice == 4) {
            deleteCustomer();
        } else if (choice == 5) {
            new ConsoleHelper().displayStartMenu();
        } else {
            System.out.println("An incorrect value. Please try again.");
            new ConsoleHelper().displayStartMenu();
        }

    }

    private void displayAll() {
        customerDAO.list().forEach(System.out::println);
        displayCustomerMenu();
    }


    private void updateCustomer() {
        System.out.print("Please enter customer ID to update: ");
        getInput();
        Long id;
        try {
            if (customerDAO.getById(Long.valueOf(input)) != null) {
                id = Long.valueOf(input);
            } else {
                throw new NumberFormatException("No item with such ID in DB.");
            }
            Customer customer = customerDAO.getById(Long.valueOf(input));
            System.out.println("Current customer name - \"" + customer.getName() + "\".");
            System.out.print("Do you need to update name? (yes - to update, another value not to update): ");
            getInput();
            if (!input.toLowerCase().equals("yes")) {
                System.out.print("Enter new name: ");
                getInput();
                customer.setName(input);
            }
            customerDAO.update(customer);
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect ID value. Please try again.");
        }
        displayCustomerMenu();
    }

    private void insertCustomer() {
        printLine();
        Customer customer = new Customer();
        System.out.print("Please enter name of new customer: ");
        getInput();
        customer.setName(input);
        customerDAO.save(customer);
        displayCustomerMenu();
    }

    private void deleteCustomer() {
        printLine();
        System.out.print("Please enter customer ID to delete: ");
        getInput();
        try {
            Customer customer = customerDAO.getById(Long.valueOf(input));
            if (customer != null) {
                customerDAO.delete(customer);
            } else {
                LOGGER.error("Fail to delete customer with ID=" + input + ". No customer with such ID in DB.");
                System.out.println("No customer with such ID in DB. Please try again.");
            }
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect skill ID value. Please try again.");
        }
        displayCustomerMenu();
    }
}
