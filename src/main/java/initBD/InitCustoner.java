package initBD;


import dao.CustomerDao;
import model.Customer;

public class InitCustoner {
    CustomerDao customerDao;

    public void removeCustomer(){
        customerDao.removeALL();
    }

    public void addCustomer(){
        Customer payCash = new Customer();
        payCash.setName("PayCash");
        payCash.setInn(123456790);
        payCash.setEdrpou(123456);

        Customer bIScience = new Customer();
        bIScience.setName("BIScience");
        bIScience.setInn(123987654);
        bIScience.setEdrpou(654321);

        Customer techFinancials = new Customer();
        techFinancials.setName("TechFinancials");
        techFinancials.setInn(143257855);
        techFinancials.setEdrpou(567422);

        Customer society = new Customer();
        society.setName("Society");
        society.setInn(128733546);
        society.setEdrpou(7665832);

        customerDao.save(payCash);
        customerDao.save(bIScience);
        customerDao.save(techFinancials);
        customerDao.save(society);
    }

}
