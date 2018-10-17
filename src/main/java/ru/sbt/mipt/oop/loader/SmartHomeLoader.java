package ru.sbt.mipt.oop.loader;

import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;

/**
 * Created by Violetta on 04/10/2018.
 */
public interface SmartHomeLoader {
    SmartHome loadSmartHome() throws IOException;
    void saveSmartHome(String pathToSave) throws IOException;

}
