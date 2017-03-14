package view;
import initBD.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private InitCompanys initCompanys;
    private InitCustoner initCustoner;
    private InitDeveloper initDeveloper;
    private InitProjects initProjects;
    private InitSkills initSkills;
    private  boolean reInit;

    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aplication-context.xml");
        Main main = applicationContext.getBean(Main.class);
        consoleHelper.displayStartMenu();
    }

    public void init(){
        if(reInit)    {
            initCompanys.removeCompanys();
            initCustoner.removeCustomer();
            initDeveloper.removeDevelopers();
            initProjects.removeProjects();
            initSkills.removeSkills();

            initCompanys.addCompanys();
            initCustoner.addCustomer();
            initDeveloper.addDevelopers();
            initProjects.addProjects();
            initSkills.addSkills();
        }
    }

    public void setReInit(boolean reInit) {
        this.reInit = reInit;
    }
}
