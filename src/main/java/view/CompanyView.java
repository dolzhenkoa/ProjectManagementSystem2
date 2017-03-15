package main.java.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Project;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.dao.CompanyDao;
import main.java.dao.ProjectDao;

import main.java.model.Company;
import main.java.utils.HibernateUtil;

public class CompanyView extends View {
    private static final Logger LOGGER = LoggerFactory.getLogger(SkillView.class);

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String input;
    private CompanyDao companyDao = new CompanyDao(sessionFactory);
    private ProjectDao projectDao = new ProjectDao(sessionFactory);

	public void displayCompanyMenu() {
		int choice = 0;
        printLine();
        System.out.println("Please select option:");
        System.out.println("0 - Display find by name");
        System.out.println("1 - Display all available companys");
        System.out.println("2 - Insert new company");
        System.out.println("3 - Update company by ID");
        System.out.println("4 - Delete company by ID");
        System.out.println("5 - Display all available projects");
        System.out.println("6 - Insert new  projects");
        System.out.println("7 - Delete projects");
        System.out.println("8 - Return to main menu");
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

        if (choice == 0) {
        	displayFindByName();
        } else if(choice == 1) {
            displayAll();
        } else if (choice == 2) {
        	insertCompany();
        } else if (choice == 3) {
            updateCompany();
        } else if (choice == 4) {
            deleteCompany();
        } else if (choice == 5) {
        	displayProjectsAll();
        } else if (choice == 6) {
        	insertProject();
        } else if (choice == 7) {
        	deleteProject();
        } else if (choice == 8) {
            new ConsoleHelper().displayStartMenu();
        } else {
            System.out.println("An incorrect value. Please try again.");
            displayCompanyMenu();
        }
    }

    private void deleteProject() {
    	printLine();
       	try {
//            System.out.print("Please enter ID of company: ");
//            int companyId=Integer.valueOf(reader.readLine());
            System.out.print("Please enter ID of project: ");
            long projectId=Long.valueOf(reader.readLine());


            projectDao.delete(projectDao.getById(projectId));

       	} catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect company ID value. Please try again.");
        } catch (IOException e) {
        	LOGGER.error("IOException occurred:" + e.getMessage());
		}
        displayCompanyMenu();
	}

	private void insertProject() {
		printLine();
       	try {
            System.out.print("Please enter ID of company: ");
            Long companyId=Long.valueOf(reader.readLine());
            System.out.print("Please enter ID of project: ");
            Long projectId=Long.valueOf(reader.readLine());

            Company companyToInsert = new Company();
            companyToInsert = companyDao.getById(companyId);

            Project projectIsInsert = new Project();
            projectIsInsert = projectDao.getById(projectId);

            List<Project> projectList = new ArrayList<>();
            projectList.add(projectIsInsert);

            companyToInsert.setProjects(projectList);

       	} catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect company ID value. Please try again.");
        } catch (IOException e) {
        	LOGGER.error("IOException occurred:" + e.getMessage());
		}
        displayCompanyMenu();
	}

	private void displayProjectsAll() {
		try {
			System.out.print("Please enter ID of company: ");
			companyDao.getById(Long.valueOf(reader.readLine())).getProjects().stream().forEach(System.out::println);

		} catch (IOException e) {
			LOGGER.error("IOException occurred:" + e.getMessage());
		}
        displayCompanyMenu();
	}

	private void displayAll() {
    	List<Company> allCompanies = new ArrayList<>(companyDao.list());
    	allCompanies.forEach(System.out::println);
        displayCompanyMenu();
    }

    private void displayFindByName() {
    	try {
    		System.out.print("Please enter Name: ");
			companyDao.get("name", String.valueOf(reader.readLine()));
		} catch (IOException e) {
			LOGGER.error("IOException occurred:" + e.getMessage());
		}
        displayCompanyMenu();
    }

    private void insertCompany() {
        printLine();
        Company company = new Company();
        try {
            System.out.print("Please enter Name of new company: ");
            company.setName(reader.readLine());
            System.out.print("Please enter Address of new company: ");
            company.setAddress(reader.readLine());
            System.out.print("Please enter Country of new company: ");
            company.setCountry(reader.readLine());
            System.out.print("Please enter City of new company: ");
            company.setCity(reader.readLine());
            companyDao.save(company);
        } catch (IOException e) {
            LOGGER.error("IOException occurred:" + e.getMessage());
        }
        displayCompanyMenu();
    }

    private void getInput() {
        try {
            input = reader.readLine();
        } catch (IOException e) {
            LOGGER.error("IOException occurred:" + e.getMessage());
        }
    }

    private void deleteCompany() {
        printLine();
        System.out.print("Please enter company ID to delete: ");
        getInput();
        try {
            Company company = new Company();
            company = companyDao.getById(Long.valueOf(input));
            companyDao.delete(company);
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect company ID value. Please try again.");
        }
        displayCompanyMenu();
    }

    private void updateCompany() {
    	Company newCompany = new Company();
    	Company companyToUpdate;
        printLine();
        System.out.print("Please enter company ID to update: ");
        try {
            input = reader.readLine();
            companyToUpdate = companyDao.getById(Long.valueOf(input));
            System.out.print("Current company name: \"" + companyToUpdate.getName()
                    + "\". New company name (enter \"-\" to leave current name): ");
            getInput();
            if (input.equals("-")){
                newCompany.setName(companyToUpdate.getName());
            } else {
                newCompany.setName(input);
            }

            System.out.print("Current company address: \"" + companyToUpdate.getAddress()
                    + "\". New company age (enter \"-\" to leave current address): ");
            getInput();
            if (input.equals("-")){
                newCompany.setAddress(companyToUpdate.getAddress());
            } else {
                newCompany.setAddress(input);
            }

            System.out.print("Current company country: \"" + companyToUpdate.getCountry()
                    + "\". New company country (enter \"-\" to leave current country): ");
            getInput();
            if (input.equals("-")){
                newCompany.setCountry(companyToUpdate.getCountry());
            } else {
                newCompany.setCountry(input);
            }

            System.out.print("Current company city: \"" + companyToUpdate.getCity()
                    + "\". New company city (enter \"-\" to leave current city): ");
            getInput();
            if (input.equals("-")){
                newCompany.setCity(companyToUpdate.getCity());
            } else {
                newCompany.setCity(input);
            }
            getInput();

            companyDao.update(newCompany);

        } catch (IOException e) {
            LOGGER.error("IOException occurred:" + e.getMessage());
            new ConsoleHelper().displayStartMenu();
        } catch (NumberFormatException e) {
            LOGGER.error("NumberFormatException occurred:" + e.getMessage());
            System.out.println("An incorrect value. Please try again.");
        }
        displayCompanyMenu();
    }

}
