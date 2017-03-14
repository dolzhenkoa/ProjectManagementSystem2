package main.java.view;

import main.java.dao.DeveloperDao;
import main.java.dao.SkillDao;
import main.java.model.Developer;
import main.java.model.Skill;
import main.java.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class DeveloperView extends View {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeveloperView.class);

    private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
    private Session session=sessionFactory.getCurrentSession();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String input;
    private DeveloperDao developerDAO = new DeveloperDao(sessionFactory);
    private SkillDao skillDAO = new SkillDao(sessionFactory);

    void displayDevMenu() {
        int choice = 0;
        printLine();
        System.out.println("Please select option:");
        System.out.println("0 - Display find by name");
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

        if (choice == 0) {
        	displayFindByName();
        } else if(choice == 1) {
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
    	session.beginTransaction();
        developerDAO.list().stream().forEach(System.out::println);
        displayDevMenu();
    }

    private void displayFindByName() {
    	try {
    		System.out.print("Please enter Name: ");
    		developerDAO.getList("name", "%"+reader.readLine()+"%").stream().forEach(System.out::println);
		} catch (IOException e) {
			LOGGER.error("IOException occurred:" + e.getMessage());
		}
    	displayDevMenu();
    }
    
    private void updateDev() {
        Developer newDeveloper = new Developer();
        Developer developerToUpdate;
        printLine();
        System.out.print("Please enter developer ID to update: ");
        try {
            input = reader.readLine();
            
            System.out.print("Current developer name: \"" + developerToUpdate.getName()
                    + "\". New developer name (enter \"-\" to leave current name): ");
            getInput();
            if (input.equals("-")){
                newDeveloper.setName(developerToUpdate.getName());
            } else {
                newDeveloper.setName(input);
            }

            System.out.print("Current developer age: \"" + developerToUpdate.getAge()
                    + "\". New developer age (enter \"-\" to leave current age): ");
            getInput();
            if (input.equals("-")){
                newDeveloper.setAge(developerToUpdate.getAge());
            } else {
                newDeveloper.setAge(Integer.valueOf(input));
            }

            System.out.print("Current developer country: \"" + developerToUpdate.getCountry()
                    + "\". New developer country (enter \"-\" to leave current country): ");
            getInput();
            if (input.equals("-")){
                newDeveloper.setCountry(developerToUpdate.getCountry());
            } else {
                newDeveloper.setCountry(input);
            }

            System.out.print("Current developer city: \"" + developerToUpdate.getCity()
                    + "\". New developer city (enter \"-\" to leave current city): ");
            getInput();
            if (input.equals("-")){
                newDeveloper.setCity(developerToUpdate.getCity());
            } else {
                newDeveloper.setCity(input);
            }

            System.out.print("Current developer join date: \"" + developerToUpdate.getJoinDate()
                    + "\". New developer join date in format \"dd.mm.yyyy\" (enter \"-\" to leave current join date): ");
            getInput();
            if (input.equals("-")){
                newDeveloper.setJoinDate(developerToUpdate.getJoinDate());
            } else {
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                Date date = format.parse(input);
                newDeveloper.setJoinDate(date);
            }

            System.out.println("Current developer skills:");
            developerToUpdate.getSkills().stream().forEach(System.out::println);
            System.out.println("Enter \"YES\" if you need to reassign skills otherwise push Enter: ");
            getInput();
            if (input.toLowerCase().equals("yes")){
                newDeveloper.setSkills(setDeveloperSkills());
            } else {
                newDeveloper.setSkills(developerToUpdate.getSkills());
            }
            developerDAO.update(newDeveloper);

        } catch (IOException e) {
            LOGGER.error("IOException occurred:" + e.getMessage());
            new ConsoleHelper().displayStartMenu();
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect value. Please try again.");
        } catch (ParseException e) {
            LOGGER.error(e.getMessage());
        }
        displayDevMenu();
    }

    private void getInput() {
        try {
            input = reader.readLine();
        } catch (IOException e) {
            LOGGER.error("IOException occurred:" + e.getMessage());
        }
    }


    private void insertDev() {
        printLine();
        Developer developer = new Developer();
        try {
            System.out.print("Please enter Name of new developer: ");
            developer.setName(reader.readLine());
            System.out.print("Please enter Age of new developer: ");
            developer.setAge(Integer.valueOf(reader.readLine()));
            System.out.print("Please enter Country of new developer: ");
            developer.setCountry(reader.readLine());
            System.out.print("Please enter City of new developer: ");
            developer.setCity(reader.readLine());
            System.out.print("Please enter Join Date of new developer (in format dd.mm.yyyy): ");
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            input = reader.readLine();
            Date date = format.parse(input);
            developer.setJoinDate(date);


            try {
                developer.setSkills(setDeveloperSkills());
                developerDAO.save(developer);
            } catch (Exception e) {
                System.out.print("Cannot add " + developer + ". There is already developer with id:" + developer.getId());
            }
        } catch (NumberFormatException | ParseException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect value. Please try again.");
        } catch (IOException e) {
            LOGGER.error("IOException occurred:" + e.getMessage());
        }
        displayDevMenu();
    }

    private List<Skill> setDeveloperSkills() throws IOException {
        List<Skill> skills = new ArrayList<>();
        printLine();

        while (true) {
            System.out.println("\nPlease choose id of skill to add as " +
                    "developer skill from list (to stop adding enter \"stop\"):");
            skillDAO.list().stream().forEach(System.out::println);
            System.out.print("Add skill with ID:");
            input = reader.readLine();
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
        try {
            developerDAO.delete(developerDAO.getById(Long.valueOf(input)));
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect developer ID value. Please try again.");
        }
        displayDevMenu();
    }
}
