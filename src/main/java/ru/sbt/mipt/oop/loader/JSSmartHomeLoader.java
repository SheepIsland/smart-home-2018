package ru.sbt.mipt.oop.loader;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Violetta on 04/10/2018.
 */
public class JSSmartHomeLoader implements SmartHomeLoader {

    @Override
    public SmartHome loadSmartHome() throws IOException {
        // считываем состояние дома из файла
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
        //String json = new String(Files.readAllBytes(Paths.get(pathToLoad)));
        return gson.fromJson(json, SmartHome.class);

    }

    @Override
    public void saveSmartHome(String pathToSave) throws IOException {
        //TODO
    }

}
