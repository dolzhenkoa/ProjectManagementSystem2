package main.java.initBD;

import main.java.dao.CompanyDao;
import main.java.dao.ProjectDao;
import main.java.model.Company;
import main.java.model.Project;

import java.util.ArrayList;
import java.util.List;


public class InitCompanys {
    CompanyDao companyDao;
    ProjectDao projectDao;

    public void removeCompanys(){
        companyDao.removeALL();
    }

    public void addCompanys(){
        Company luxoft = new Company();
        luxoft.setName("Luxoft");
        luxoft.setAddress("adr1");
        luxoft.setCountry("Ukraine");
        luxoft.setCity("Kiev");
        List<Project> luxoftProjects = new ArrayList<>();
        luxoftProjects.add(projectDao.get("name", "ProjectX"));
        luxoftProjects.add(projectDao.get("name", "BIScience"));
        luxoft.setProjects(luxoftProjects);


        Company goggle = new Company();
        goggle.setName("Goggle");
        goggle.setAddress("adr2");
        goggle.setCountry("USA");
        goggle.setCity("Mountain View");
        List<Project> goggleProjects = new ArrayList<>();
        goggleProjects.add(projectDao.get("name", "Google Pixel"));
        goggleProjects.add(projectDao.get("name", "PayCash2"));
        goggle.setProjects(goggleProjects);

        Company ciklum = new Company();
        ciklum.setName("Ciklum");
        ciklum.setAddress("adr3");
        ciklum.setCountry("Ukraine");
        ciklum.setCity("Kiev");
        List<Project> ciklumProjects = new ArrayList<>();
        ciklumProjects.add(projectDao.get("name", "Google Soli"));
        ciklumProjects.add(projectDao.get("name", "BIScience3"));
        ciklum.setProjects(ciklumProjects);

        Company globalLogic = new Company();
        globalLogic.setName("GlobalLogic");
        globalLogic.setAddress("adr4");
        globalLogic.setCountry("Ukraine");
        globalLogic.setCity("Kiev");
        List<Project> globalLogicProjects = new ArrayList<>();
        globalLogicProjects.add(projectDao.get("name", "PayCash"));
        globalLogicProjects.add(projectDao.get("name", "TechFinancials"));
        globalLogic.setProjects(globalLogicProjects);

        companyDao.save(luxoft);
        companyDao.save(goggle);
        companyDao.save(ciklum);
        companyDao.save(globalLogic);
    }




}
