package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.HomeEventsObserver;
import ru.sbt.mipt.oop.event.RandomSensorEventProvider;
import ru.sbt.mipt.oop.event.processor.AlarmActivatedEventProcessor;
import ru.sbt.mipt.oop.event.processor.DoorEventProcessor;
import ru.sbt.mipt.oop.homeloader.FileSmartHomeLoader;
import ru.sbt.mipt.oop.homeloader.SmartHomeLoader;
import ru.sbt.mipt.oop.event.processor.LightsEventProcessor;

import java.io.IOException;


//TODO 1. перенести на Spring
//TODO 2. покрыть Unit тестами все

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

}
