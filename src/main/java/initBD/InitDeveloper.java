package main.java.initBD;


import main.java.dao.DeveloperDao;
import main.java.model.Developer;

import java.util.Date;

public class InitDeveloper {
    DeveloperDao developerDao;

    public void removeDevelopers(){
        developerDao.removeALL();
    }

    public void addDevelopers(){
        Developer semen = new Developer();
        semen.setName("Semen");
        semen.setAge(20);
        semen.setCountry("Ukraine");
        semen.setCity("Kiev");
        semen.setJoinDate(new Date());
        developerDao.save(semen);

        Developer ivan= new Developer();
        ivan.setName("Ivan");
        ivan.setAge(20);
        ivan.setCountry("Ukraine");
        ivan.setCity("Kiev");
        ivan.setJoinDate(new Date());
        developerDao.save(ivan);

        Developer elena= new Developer();
        elena.setName("Elena");
        elena.setAge(20);
        elena.setCountry("Ukraine");
        elena.setCity("Kiev");
        elena.setJoinDate(new Date());
        developerDao.save(elena);

        Developer nata= new Developer();
        nata.setName("Nata");
        nata.setAge(20);
        nata.setCountry("Ukraine");
        nata.setCity("Kiev");
        nata.setJoinDate(new Date());
        developerDao.save(nata);

        Developer igor= new Developer();
        igor.setName("Igor");
        igor.setAge(22);
        igor.setCountry("Ukraine");
        igor.setCity("Lviv");
        igor.setJoinDate(new Date());
        developerDao.save(igor);

        Developer andrey = new Developer();
        andrey.setName("Andrey");
        andrey.setAge(21);
        andrey.setCountry("Ukraine");
        andrey.setCity("Dnipro");
        andrey.setJoinDate(new Date());
        developerDao.save(andrey);

        Developer nastya = new Developer();
        nastya.setName("Nastya");
        nastya.setAge(18);
        nastya.setCountry("Ukraine");
        nastya.setCity("Kiev");
        nastya.setJoinDate(new Date());
        developerDao.save(nastya);

        Developer grigoriy = new Developer();
        grigoriy.setName("Grigoriy");
        grigoriy.setAge(19);
        grigoriy.setCountry("Ukraine");
        grigoriy.setCity("Lutsk");
        grigoriy.setJoinDate(new Date());
        developerDao.save(grigoriy);

        Developer anna = new Developer();
        anna.setName("Anna");
        anna.setAge(24);
        anna.setCountry("Ukraine");
        anna.setCity("Lutsk");
        anna.setJoinDate(new Date());
        developerDao.save(anna);

        Developer iryna = new Developer();
        iryna.setName("Iryna");
        iryna.setAge(20);
        iryna.setCountry("Ukraine");
        iryna.setCity("Kiev");
        iryna.setJoinDate(new Date());
        developerDao.save(iryna);

        Developer alex = new Developer();
        alex.setName("Alex");
        alex.setAge(20);
        alex.setCountry("Ukraine");
        alex.setCity("Kiev");
        alex.setJoinDate(new Date());
        developerDao.save(alex);

        Developer artem = new Developer();
        artem.setName("Artem");
        artem.setAge(19);
        artem.setCountry("Ukraine");
        artem.setCity("Lviv");
        artem.setJoinDate(new Date());
        developerDao.save(artem);

        Developer alla = new Developer();
        alla.setName("Alla");
        alla.setAge(20);
        alla.setCountry("Ukraine");
        alla.setCity("Lviv");
        alla.setJoinDate(new Date());
        developerDao.save(alla);

        Developer maria = new Developer();
        maria.setName("Maria");
        maria.setAge(25);
        maria.setCountry("Ukraine");
        maria.setCity("Lviv");
        maria.setJoinDate(new Date());
        developerDao.save(maria);

        Developer alyona = new Developer();
        alyona.setName("Alyona");
        alyona.setAge(25);
        alyona.setCountry("Ukraine");
        alyona.setCity("Lviv");
        alyona.setJoinDate(new Date());
        developerDao.save(alyona);

        Developer evgeniy = new Developer();
        evgeniy.setName("Evgeniy");
        evgeniy.setAge(18);
        evgeniy.setCountry("Ukraine");
        evgeniy.setCity("Lviv");
        evgeniy.setJoinDate(new Date());
        developerDao.save(evgeniy);

        Developer slava = new Developer();
        slava.setName("Slava");
        slava.setAge(18);
        slava.setCountry("Ukraine");
        slava.setCity("Lviv");
        slava.setJoinDate(new Date());
        developerDao.save(slava);

        Developer stas = new Developer();
        stas.setName("Stas");
        stas.setAge(18);
        stas.setCountry("Ukraine");
        stas.setCity("Lviv");
        stas.setJoinDate(new Date());
        developerDao.save(stas);

        Developer alexandr = new Developer();
        alexandr.setName("Alexandr");
        alexandr.setAge(18);
        alexandr.setCountry("Ukraine");
        alexandr.setCity("Lviv");
        alexandr.setJoinDate(new Date());
        developerDao.save(alexandr);

        Developer inna = new Developer();
        inna.setName("Inna");
        inna.setAge(18);
        inna.setCountry("Ukraine");
        inna.setCity("Odessa");
        inna.setJoinDate(new Date());
        developerDao.save(inna);

        Developer igor2 = new Developer();
        igor2.setName("Igor");
        igor2.setAge(18);
        igor2.setCountry("Ukraine");
        igor2.setCity("Odessa");
        igor2.setJoinDate(new Date());
        developerDao.save(igor2);

        Developer vasyliy = new Developer();
        vasyliy.setName("Vasyliy");
        vasyliy.setAge(18);
        vasyliy.setCountry("Ukraine");
        vasyliy.setCity("Odessa");
        vasyliy.setJoinDate(new Date());
        developerDao.save(vasyliy);

        Developer yakov = new Developer();
        yakov.setName("Yakov");
        yakov.setAge(28);
        yakov.setCountry("Ukraine");
        yakov.setCity("Odessa");
        yakov.setJoinDate(new Date());
        developerDao.save(yakov);

        Developer lyly = new Developer();
        lyly.setName("Lyly");
        lyly.setAge(28);
        lyly.setCountry("Ukraine");
        lyly.setCity("Odessa");
        lyly.setJoinDate(new Date());
        developerDao.save(lyly);

        Developer eleanora = new Developer();
        eleanora.setName("Eleanora");
        eleanora.setAge(28);
        eleanora.setCountry("Ukraine");
        eleanora.setCity("Odessa");
        eleanora.setJoinDate(new Date());
        developerDao.save(eleanora);

        Developer ilya = new Developer();
        ilya.setName("Ilya");
        ilya.setAge(28);
        ilya.setCountry("Ukraine");
        ilya.setCity("Odessa");
        ilya.setJoinDate(new Date());
        developerDao.save(ilya);

        Developer elly = new Developer();
        elly.setName("Elly");
        elly.setAge(28);
        elly.setCountry("Ukraine");
        elly.setCity("Odessa");
        elly.setJoinDate(new Date());
        developerDao.save(elly);
    }
}
