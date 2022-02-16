package ru.geekbrains.classwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class MyMain {
    private static final Logger logger = Logger.getLogger(MyMain.class.getName());
    public static void main(String[] args) throws IOException {

        //logger.log(Level.INFO, "java");
        //logger.info("java");

//        Handler consoleHandler = new ConsoleHandler();
//
//        Handler fileHandler = new FileHandler("log_%g.log",10*1024, 20,  true);
//
//        consoleHandler.setLevel(Level.FINE);
//        fileHandler.setFormatter(new SimpleFormatter());
//
//        logger.addHandler(consoleHandler);
//        logger.addHandler(fileHandler);
//        logger.setUseParentHandlers(false);
//        logger.setLevel(Level.ALL);


        LogManager manager = LogManager.getLogManager();
        manager.readConfiguration(new FileInputStream("Lesson6/logging.properties"));

        logger.log(Level.INFO, "java");
        logger.log(Level.FINE, "java");
        logger.log(Level.SEVERE, "java");
    }

}
