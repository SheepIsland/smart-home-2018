package ru.sbt.mipt.oop;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sbt.mipt.oop.elements.remoteControl.ControlPanel;
import ru.sbt.mipt.oop.elements.remoteControl.RemoteControl;
import ru.sbt.mipt.oop.elements.remoteControl.RemoteControlRegistry;
import ru.sbt.mipt.oop.event.HomeEventsObserver;
import ru.sbt.mipt.oop.event.RandomSensorEventProvider;
import ru.sbt.mipt.oop.event.processor.AlarmActivatedEventProcessor;
import ru.sbt.mipt.oop.event.processor.DoorEventProcessor;
import ru.sbt.mipt.oop.homeloader.FileSmartHomeLoader;
import ru.sbt.mipt.oop.homeloader.SmartHomeLoader;
import ru.sbt.mipt.oop.event.processor.LightsEventProcessor;

import java.io.IOException;

public class Application {

    private static final Logger logger = LogManager.getLogger(Application.class);

    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    private static HomeEventsObserver homeEventsObserver =
            new HomeEventsObserver(new RandomSensorEventProvider());

    public static void setSmartHomeLoader(SmartHomeLoader smartHomeLoader) {
        Application.smartHomeLoader = smartHomeLoader;
    }

    public static void main(String... args) throws IOException {
        logger.info("Starting configuration");
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SmartHomeLoader smartHomeLoader = context.getBean(SmartHomeLoader.class);
        HomeEventsObserver homeEventsObserver = context.getBean(HomeEventsObserver.class);
        SmartHome smartHome = smartHomeLoader.loadSmartHome();

        RemoteControlRegistry remoteControlRegistry = context.getBean(RemoteControlRegistry.class);
        RemoteControl smartHomeRemoteControl = context.getBean(RemoteControl.class);
        remoteControlRegistry.registerRemoteControl(smartHomeRemoteControl, "1");

        homeEventsObserver.registerEventProcessor(new AlarmActivatedEventProcessor(new LightsEventProcessor()));
        homeEventsObserver.registerEventProcessor(new AlarmActivatedEventProcessor(new DoorEventProcessor()));
        homeEventsObserver.runEventsCycle(smartHome);
    }

}
