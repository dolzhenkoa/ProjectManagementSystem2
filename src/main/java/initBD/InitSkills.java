package initBD;


import dao.SkillDao;
import model.Skill;

public class InitSkills {
    private SkillDao skillDao;

    public void removeSkills(){
        skillDao.removeALL();
    }

    public void addSkills(){
        Skill java = new Skill();
        java.setDescription("Java");
        skillDao.save(java);

        Skill cSharp = new Skill();
        cSharp.setDescription("C#");
        skillDao.save(cSharp);

        Skill javaScript = new Skill();
        javaScript.setDescription("JavaScript");
        skillDao.save(javaScript);

        Skill cPlusPlus = new Skill();
        cPlusPlus.setDescription("C++");
        skillDao.save(cPlusPlus);

        Skill python = new Skill();
        python.setDescription("Python");
        skillDao.save(python);

        Skill scala = new Skill();
        scala.setDescription("Scala");
        skillDao.save(scala);

        Skill php = new Skill();
        php.setDescription("PHP");
        skillDao.save(php);

        Skill perl = new Skill();
        perl.setDescription("Perl");
        skillDao.save(perl);
    }
}
