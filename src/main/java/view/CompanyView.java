package view;

import dao.CompanyDao;
import model.Company;

import java.io.IOException;

class CompanyView extends View{

    private CompanyDao companyDAO = new CompanyDao(sessionFactory);

    void displayCompanyMenu() {
        int choice = 0;
        printLine();
        System.out.println("Please select option:");
        System.out.println("1 - Display all available companies");
        System.out.println("2 - Insert new company");
        System.out.println("3 - Update company by ID");
        System.out.println("4 - Delete company by ID");
        System.out.println("5 - Return to main menu");
        printExitMessage();
        printLine();
        System.out.print("Please enter your choice:");

        try {
            input = reader.readLine();
        } catch (IOException e) {
            LOGGER.error("IOException occurred:" + e.getMessage());
            displayCompanyMenu();
        }
        isQuitInput(input, LOGGER);

        try {
            choice = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect value. Please try again.");
            displayCompanyMenu();
        }

        if (choice == 1) {
            displayAll();
        } else if (choice == 2) {
            insertCompany();
        } else if (choice == 3) {
            updateCompany();
        } else if (choice == 4) {
            deleteCompany();
        } else if (choice == 5) {
            new ConsoleHelper().displayStartMenu();
        } else {
            System.out.println("An incorrect value. Please try again.");
            new ConsoleHelper().displayStartMenu();
        }

    }

    private void displayAll() {
        companyDAO.list().forEach(System.out::println);
        displayCompanyMenu();
    }


    private void updateCompany() {
        System.out.print("Please enter company ID to update: ");
        getInput();
        Long id;
        try {
            if (companyDAO.getById(Long.valueOf(input)) != null) {
                id = Long.valueOf(input);
            } else {
                throw new NumberFormatException("No item with such ID in DB.");
            }
            Company company = companyDAO.getById(Long.valueOf(input));
            System.out.println("Current company name - \"" + company.getName() + "\".");
            System.out.print("Do you need to update name? (yes - to update, another value not to update): ");
            getInput();
            if (!input.toLowerCase().equals("yes")) {
                System.out.print("Enter new name: ");
                getInput();
                company.setName(input);
            }
            companyDAO.update(company);
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect ID value. Please try again.");
        }
        displayCompanyMenu();
    }

    private void insertCompany() {
        printLine();
        Company company = new Company();
        System.out.print("Please enter name of new company: ");
        getInput();
        company.setName(input);
        companyDAO.save(company);
        displayCompanyMenu();
    }

    private void deleteCompany() {
        printLine();
        System.out.print("Please enter company ID to delete: ");
        getInput();
        try {
            Company company = companyDAO.getById(Long.valueOf(input));
            if (company != null) {
                companyDAO.delete(company);
            } else {
                LOGGER.error("Fail to delete company with ID=" + input + ". No company with such ID in DB.");
                System.out.println("No company with such ID in DB. Please try again.");
            }
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect skill ID value. Please try again.");
        }
        displayCompanyMenu();
    }
}
