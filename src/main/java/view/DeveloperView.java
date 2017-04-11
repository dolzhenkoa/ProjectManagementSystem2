package view;

import dao.DeveloperDao;
import dao.ProjectDao;
import dao.SkillDao;
import model.Developer;
import model.Skill;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class DeveloperView extends View {

    private DeveloperDao developerDAO = new DeveloperDao(sessionFactory);
    private SkillDao skillDAO = new SkillDao(sessionFactory);
    private ProjectDao projectDAO = new ProjectDao(sessionFactory);

    void displayDevMenu() {
        int choice = 0;
        printLine();
        System.out.println("Please select option:");
        System.out.println("1 - Display all available developers");
        System.out.println("2 - Insert new developer");
        System.out.println("3 - Update developer by ID");
        System.out.println("4 - Delete developer by ID");
        System.out.println("5 - Return to main menu");
        printExitMessage();
        printLine();
        System.out.print("Please enter your choice:");

        try {
            input = reader.readLine();
        } catch (IOException e) {
            LOGGER.error("IOException occurred:" + e.getMessage());
            displayDevMenu();
        }
        isQuitInput(input, LOGGER);

        try {
            choice = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect value. Please try again.");
            displayDevMenu();
        }

        if (choice == 1) {
            displayAll();
        } else if (choice == 2) {
            insertDev();
        } else if (choice == 3) {
            updateDev();
        } else if (choice == 4) {
            deleteDev();
        } else if (choice == 5) {
            new ConsoleHelper().displayStartMenu();
        } else {
            System.out.println("An incorrect value. Please try again.");
            displayDevMenu();
        }
    }

    private void displayAll() {
        developerDAO.list().forEach(System.out::println);
        displayDevMenu();
    }


    private void updateDev() {
        System.out.print("Please enter developer ID to update: ");
        getInput();
        Long id;
        try {
            if (developerDAO.getById(Long.valueOf(input)) != null) {
                id = Long.valueOf(input);
            } else {
                throw new NumberFormatException("No item with such ID in DB.");
            }
            Developer developer = new Developer();

            System.out.println("Current developer name - \"" + developer.getName() + "\".");
            System.out.print("Do you need to update name? (yes - to update, another value not to update): ");
            getInput();
            if (!input.toLowerCase().equals("yes")) {
                System.out.print("Enter new name: ");
                getInput();
                developer.setName(input);
            }

            System.out.println("Current developer age - \"" + developer.getAge() + "\".");
            System.out.print("Do you need to update age? (yes - to update, another value not to update): ");
            getInput();
            if (!input.toLowerCase().equals("yes")) {
                System.out.print("Enter new age: ");
                getInput();
                developer.setAge(Integer.valueOf(input));
            }

            System.out.println("Current developer salary - \"" + developer.getSalary() + "\".");
            System.out.print("Do you need to update salary? (yes - to update, another value not to update): ");
            getInput();
            if (!input.toLowerCase().equals("yes")) {
                System.out.print("Enter new salary: ");
                getInput();
                developer.setSalary(BigDecimal.valueOf(Integer.valueOf(input)));
            }

            System.out.println("Current developer skills - \"" + developer.getSkills() + "\".");
            System.out.print("Do you need to reassign skills? (yes - to update, another value not to update): ");
            getInput();
            if (!input.toLowerCase().equals("yes")) {
                developer.setSkills(setDeveloperSkills());
            }

            System.out.println("Current developer project - \"" + developer.getProject() + "\".");
            System.out.print("Do you need to update project? (yes - to update, another value not to update): ");
            getInput();
            if (!input.toLowerCase().equals("yes")) {
                chooseProject(developer);
            }

            developerDAO.update(developer);

        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect ID value. Please try again.");
        }
        displayDevMenu();
    }

    private void chooseProject(Developer developer) {
        System.out.println("Please select developer project from the list:");
        projectDAO.list().forEach(System.out::println);
        System.out.print("Please enter project ID: ");
        getInput();
        developer.setProject(projectDAO.getById(Long.valueOf(input)));
    }

    private void insertDev() {
        printLine();
        Developer developer = new Developer();
        try {
            System.out.print("Please enter Name of new developer: ");
            getInput();
            developer.setName(input);
            System.out.print("Please enter Age of new developer: ");
            getInput();
            developer.setAge(Integer.valueOf(input));
            System.out.print("Please enter Salary of new developer: ");
            getInput();
            developer.setSalary(BigDecimal.valueOf(Integer.valueOf(input)));
            chooseProject(developer);
            developer.setSkills(setDeveloperSkills());
            developerDAO.save(developer);

        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect value. Please try again.");
        }
        displayDevMenu();
    }


    private List<Skill> setDeveloperSkills() {
        List<Skill> skills = new ArrayList<>();
        printLine();

        while (true) {
            System.out.println("\nPlease choose id of skill to add as " +
                    "developer skill from list (to stop adding enter \"stop\"):");
            skillDAO.list().forEach(System.out::println);
            System.out.print("Add skill with ID:");
            getInput();
            if (input.toLowerCase().equals("stop")) {
                break;
            } else {
                skills.add(skillDAO.getById(Long.valueOf(input)));
            }
        }
        return skills;
    }

    private void deleteDev() {
        printLine();
        System.out.print("Please enter developer ID to delete: ");
        getInput();
    }
}


