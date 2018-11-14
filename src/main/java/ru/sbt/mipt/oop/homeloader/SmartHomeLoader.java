package ru.sbt.mipt.oop.homeloader;

import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;

/**
 * Created by Violetta on 04/10/2018.
 */
public interface SmartHomeLoader {
    SmartHome loadSmartHome() throws IOException;

}
