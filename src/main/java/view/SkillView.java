package main.java.view;

import main.java.model.Skill;
import main.java.utils.HibernateUtil;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.dao.SkillDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class SkillView extends View {
    private static final Logger LOGGER = LoggerFactory.getLogger(SkillView.class);

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String input;
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

    }

    private void displayAll() {
        List<Skill> list = new ArrayList<>(skillDAO.getAll());
        list.forEach(System.out::println);
        displaySkillMenu();
    }


    private void updateSkill() {
        Skill skill;
        printLine();
        List<Skill> list = new ArrayList<>(skillDAO.getAll());
        list.forEach(System.out::println);
        System.out.print("Please enter skill ID to update: ");
        try {
            input = reader.readLine();
        } catch (IOException e) {
            LOGGER.error("IOException occurred:" + e.getMessage());
            new ConsoleHelper().displayStartMenu();
        }

        try {
            skill = skillDAO.load(Long.valueOf(input));
            if (skill != null) {
                System.out.print("Please input new description of skill:");
                try {
                    input = reader.readLine();
                    skill.setName(input);
                } catch (IOException e) {
                    LOGGER.error("IOException occurred:" + e.getMessage());
                }
                skillDAO.update(skill);

            } else {
                LOGGER.error("Fail to delete Skill with ID=" + input + ". No Skills with such ID in DB.");
                System.out.println("No Skills with such ID in DB. Please try again.");
            }
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect value. Please try again.");
        }
        displaySkillMenu();
    }

    private void insertSkill() {
        printLine();
        Skill skill = new Skill();
        try {
            System.out.print("Please enter description of new skill: ");
            input = reader.readLine();
            skill.setName(input);
            skillDAO.save(skill);
        } catch (IOException e) {
            LOGGER.error("IOException occurred:" + e.getMessage());
        }
        displaySkillMenu();
    }

    private void deleteSkill() {
        printLine();
        System.out.print("Please enter skill ID to delete: ");
        try {
            input = reader.readLine();
        } catch (IOException e) {
            LOGGER.error("IOException occurred:" + e.getMessage());
        }
        try {
            Skill skill = skillDAO.load(Long.valueOf(input));
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


