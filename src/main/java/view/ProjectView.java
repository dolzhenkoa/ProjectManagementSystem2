package view;

import dao.CompanyDao;
import dao.CustomerDao;
import dao.ProjectDao;
import model.Project;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class ProjectView extends View {
    private ProjectDao projectDAO = new ProjectDao(sessionFactory);
    private CompanyDao companyDAO = new CompanyDao(sessionFactory);
    private CustomerDao customerDAO = new CustomerDao(sessionFactory);

    void displayProjectMenu() {
        int choice = 0;
        printLine();
        System.out.println("Please select option:");
        System.out.println("1 - Display all available projects");
        System.out.println("2 - Insert new project");
        System.out.println("3 - Update project by ID");
        System.out.println("4 - Delete project by ID");
        System.out.println("5 - Return to main menu");
        printExitMessage();
        printLine();
        System.out.print("Please enter your choice:");

        try {
            input = reader.readLine();
        } catch (IOException e) {
            LOGGER.error("IOException occurred:" + e.getMessage());
            displayProjectMenu();
        }
        isQuitInput(input, LOGGER);

        try {
            choice = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect value. Please try again.");
            displayProjectMenu();
        }

        if (choice == 1) {
            displayAll();
        } else if (choice == 2) {
            insertProject();
        } else if (choice == 3) {
            updateProject();
        } else if (choice == 4) {
            deleteProject();
        } else if (choice == 5) {
            new ConsoleHelper().displayStartMenu();
        } else {
            System.out.println("An incorrect value. Please try again.");
            new ConsoleHelper().displayStartMenu();
        }
        displayProjectMenu();
    }

    private void displayAll() {
        List<Project> projects = new ArrayList<>(projectDAO.list());
        projects.forEach(System.out::println);
        displayProjectMenu();
    }


    private void insertProject() {
        printLine();
        Project project = new Project();
        System.out.print("Please enter name of new project: ");
        getInput();
        project.setName(input);

        try {
            chooseCustomer(project);
            chooseCompany(project);
            System.out.print("Please enter project cost: ");
            getInput();
            project.setCost(BigDecimal.valueOf(Long.valueOf(input)));
            projectDAO.save(project);
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect ID value. Please try again.");
        }
        displayProjectMenu();
    }

    private void chooseCompany(Project project) {
        System.out.println("Please select project company from the list:");
        companyDAO.list().forEach(System.out::println);
        System.out.print("Please enter project company ID: ");
        getInput();
        project.setCompany(companyDAO.getById(Long.valueOf(input)));
    }

    private void chooseCustomer(Project project) {
        System.out.println("Please select project customer from the list:");
        customerDAO.list().forEach(System.out::println);
        System.out.print("Please enter project customer ID: ");
        getInput();
        project.setCustomer(customerDAO.getById(Long.valueOf(input)));
    }

    private void updateProject() {
        System.out.print("Please enter project ID to update: ");
        getInput();
        Long id;
        try {
            if (projectDAO.getById(Long.valueOf(input)) != null) {
                id = Long.valueOf(input);
            } else {
                throw new NumberFormatException("No item with such ID in DB.");
            }

            Project project = new Project();

            System.out.println("Current project name - \"" + project.getName() + "\".");
            System.out.print("Do you need to update name? (yes - to update, another value not to update): ");
            getInput();
            if (!input.toLowerCase().equals("yes")) {
                System.out.print("Enter new name: ");
                getInput();
                project.setName(input);
            }

            System.out.println("Current project customer - \"" + project.getCustomer() + "\".");
            System.out.print("Do you need to update customer? (yes - to update, another value not to update): ");
            getInput();
            if (!input.toLowerCase().equals("yes")) {
                chooseCustomer(project);
            }

            System.out.println("Current project company - \"" + project.getCompany() + "\".");
            System.out.print("Do you need to update company? (yes - to update, another value not to update): ");
            getInput();
            if (!input.toLowerCase().equals("yes")) {
                chooseCompany(project);
            }

            System.out.println("Current project cost - \"" + project.getCost() + "\".");
            System.out.print("Do you need to update cost? (yes - to update, another value not to update): ");
            getInput();
            if (!input.toLowerCase().equals("yes")) {
                System.out.print("Enter new cost: ");
                getInput();
                project.setCost(BigDecimal.valueOf(Long.valueOf(input)));
            }
            projectDAO.update(project);

        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect ID value. Please try again.");
        }
    }

    private void deleteProject() {
        printLine();
        System.out.print("Please enter project ID to delete: ");
        getInput();
        try {
            Project skill = projectDAO.getById(Long.valueOf(input));
            if (skill != null) {
                projectDAO.delete(skill);
            } else {
                LOGGER.error("Fail to delete Project with ID=" + input + ". No Project with such ID in DB.");
                System.out.println("No Skills with such ID in DB. Please try again.");
            }
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect project ID value. Please try again.");
        }
        displayProjectMenu();
    }
}
