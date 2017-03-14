package initBD;

import dao.CompanyDao;
import model.Company;



public class InitCompanys {
    CompanyDao companyDao;

    public void removeCompanys(){
        companyDao.removeALL();
    }
    public void addCompanys(){
        Company luxoft = new Company();
        luxoft.setName("Luxoft");
        luxoft.setAddress("adr1");
        luxoft.setCountry("Ukraine");
        luxoft.setCity("Kiev");

        Company goggle = new Company();
        goggle.setName("Goggle");
        goggle.setAddress("adr2");
        goggle.setCountry("USA");
        goggle.setCity("Mountain View");

        Company ciklum = new Company();
        ciklum.setName("Ciklum");
        ciklum.setAddress("adr3");
        ciklum.setCountry("Ukraine");
        ciklum.setCity("Kiev");

        Company globalLogic = new Company();
        globalLogic.setName("GlobalLogic");
        globalLogic.setAddress("adr4");
        globalLogic.setCountry("Ukraine");
        globalLogic.setCity("Kiev");

        companyDao.save(luxoft);
        companyDao.save(goggle);
        companyDao.save(ciklum);
        companyDao.save(globalLogic);
    }


}
