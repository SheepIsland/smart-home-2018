package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.alarm.AlarmActivatedEventProcessor;
import ru.sbt.mipt.oop.door.DoorEventProcessor;
import ru.sbt.mipt.oop.light.LightsEventProcessor;

import java.io.IOException;

public class Application {

    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    private static HomeEventsObserver homeEventsObserver =
            new HomeEventsObserver(new RandomSensorEventProvider());

    public static void main(String... args) throws IOException {
        SmartHome smartHome = smartHomeLoader.loadSmartHome();
        homeEventsObserver.registerEventProcessor(new AlarmActivatedEventProcessor(new LightsEventProcessor()));
        homeEventsObserver.registerEventProcessor( new AlarmActivatedEventProcessor(new DoorEventProcessor()));
        homeEventsObserver.runEventsCycle(smartHome);
    }
    AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
    SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
       sensorEventsManager.start();



}
