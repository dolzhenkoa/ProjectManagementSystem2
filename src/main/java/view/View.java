package view;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import dao.HibernateUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class View {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    final Logger LOGGER = Logger.getLogger(this.getClass());
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String input;


    void printExitMessage() {
        System.out.println("To close application please enter \"Quit\"");
    }

    void printLine() {
        System.out.println("\n===============================================\n");
    }


    void isQuitInput(String input, Logger logger) {
        if (input.toLowerCase().equals("quit")) {
            logger.info("Application shutdown");
            HibernateUtil.shutdown();
            System.exit(0);
        }
    }

    void getInput() {
        try {
            input = reader.readLine();
        } catch (IOException e) {
            LOGGER.error("IOException occurred:" + e.getMessage());
        }
    }
}
