package initBD;


import dao.ProjectDao;
import model.Project;

public class InitProjects {
    private ProjectDao projectDao;

    public void removeProjects(){
        projectDao.removeALL();
    }

    public void addProjects(){
        Project projectX = new Project();
        projectX.setName("ProjectX");
        projectX.setDescription("project1");
        projectDao.save(projectX);

        Project googlePixel = new Project();
        googlePixel.setName("Google Pixel");
        googlePixel.setDescription("project2");
        projectDao.save(googlePixel);

        Project googleSoli = new Project();
        googleSoli.setName("Google Soli");
        googleSoli.setDescription("project3");
        projectDao.save(googleSoli);

        Project payCash = new Project();
        payCash.setName("PayCash");
        payCash.setDescription("project4");
        projectDao.save(payCash);

        Project bIScience = new Project();
        bIScience.setName("BIScience");
        bIScience.setDescription("project5");
        projectDao.save(bIScience);

        Project payCash2 = new Project();
        payCash2.setName("PayCash2");
        payCash2.setDescription("project6");
        projectDao.save(payCash2);

        Project bIScience3 = new Project();
        bIScience3.setName("BIScience3");
        bIScience3.setDescription("project7");
        projectDao.save(bIScience3);

        Project techFinancials = new Project();
        techFinancials.setName("TechFinancials");
        techFinancials.setDescription("project8");
        projectDao.save(techFinancials);
    }

};