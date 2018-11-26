package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.elements.remoteControl.ControlPanel;
import ru.sbt.mipt.oop.elements.remoteControl.RemoteControl;
import ru.sbt.mipt.oop.elements.remoteControl.RemoteControlRegistry;
import ru.sbt.mipt.oop.event.HomeEventsObserver;
import ru.sbt.mipt.oop.event.RandomSensorEventProvider;
import ru.sbt.mipt.oop.homeloader.FileSmartHomeLoader;
import ru.sbt.mipt.oop.homeloader.SmartHomeLoader;

import java.io.IOException;

/**
 * Created by Violetta on 26/11/2018.
 */

@Configuration
public class Config {

    @Bean
    SmartHomeLoader smartHomeLoader() {
        return new FileSmartHomeLoader();
    }

    @Bean
    HomeEventsObserver homeEventsObserver() {
        return new HomeEventsObserver(new RandomSensorEventProvider());
    }

    @Bean
    RemoteControlRegistry remoteControlRegistry() {return new RemoteControlRegistry();}

    @Bean
    RemoteControl controlPanel() throws IOException {
        return  new ControlPanel();
    }

}
