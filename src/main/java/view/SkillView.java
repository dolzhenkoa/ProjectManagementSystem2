package view;

import dao.SkillDao;
import model.Skill;

import java.io.IOException;


class SkillView extends View {

    private SkillDao skillDAO = new SkillDao(sessionFactory);

    void displaySkillMenu() {
        int choice = 0;
        printLine();
        System.out.println("Please select option:");
        System.out.println("1 - Display all available skills");
        System.out.println("2 - Insert new skill");
        System.out.println("3 - Update skill by ID");
        System.out.println("4 - Delete skill by ID");
        System.out.println("5 - Return to main menu");
        printExitMessage();
        printLine();
        System.out.print("Please enter your choice:");

        try {
            input = reader.readLine();
        } catch (IOException e) {
            LOGGER.error("IOException occurred:" + e.getMessage());
            displaySkillMenu();
        }
        isQuitInput(input, LOGGER);

        try {
            choice = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect value. Please try again.");
            displaySkillMenu();
        }

        if (choice == 1) {
            displayAll();
        } else if (choice == 2) {
            insertSkill();
        } else if (choice == 3) {
            updateSkill();
        } else if (choice == 4) {
            deleteSkill();
        } else if (choice == 5) {
            new ConsoleHelper().displayStartMenu();
        } else {
            System.out.println("An incorrect value. Please try again.");
            new ConsoleHelper().displayStartMenu();
        }
        displaySkillMenu();
    }

    private void displayAll() {
        skillDAO.list().forEach(System.out::println);
        displaySkillMenu();
    }


    private void updateSkill() {
        System.out.print("Please enter skill ID to update: ");
        getInput();
        Long id;
        try {
            if (skillDAO.getById(Long.valueOf(input)) != null) {
                id = Long.valueOf(input);
            } else {
                throw new NumberFormatException("No item with such ID in DB.");
            }
            Skill skill = skillDAO.getById(Long.valueOf(input));
            System.out.println("Current skill description - \"" + skill.getDescription() + "\".");
            System.out.print("Do you need to update description? (yes - to update, another value not to update): ");
            getInput();
            if (!input.toLowerCase().equals("yes")) {
                System.out.print("Enter new description: ");
                getInput();
                skill.setDescription(input);
            }
            skillDAO.update(skill);
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect ID value. Please try again.");
        }
    }

    private void insertSkill() {
        printLine();
        Skill skill = new Skill();
        System.out.print("Please enter description of new skill: ");
        getInput();
        skill.setDescription(input);
        skillDAO.save(skill);
        displaySkillMenu();
    }

    private void deleteSkill() {
        printLine();
        System.out.print("Please enter skill ID to delete: ");
        getInput();
        try {
            Skill skill = skillDAO.getById(Long.valueOf(input));
            if (skill != null) {
                skillDAO.delete(skill);
            } else {
                LOGGER.error("Fail to delete Skill with ID=" + input + ". No Skills with such ID in DB.");
                System.out.println("No Skills with such ID in DB. Please try again.");
            }
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect skill ID value. Please try again.");
        }
        displaySkillMenu();
    }
}