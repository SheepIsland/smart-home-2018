package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.*;
import ru.sbt.mipt.oop.event.processor.DoorEventProcessor;
import ru.sbt.mipt.oop.event.processor.EventProcessor;
import ru.sbt.mipt.oop.event.processor.HallDoorEventProcessor;
import ru.sbt.mipt.oop.event.processor.LightsEventProcessor;
import ru.sbt.mipt.oop.loader.JSSmartHomeLoader;
import ru.sbt.mipt.oop.loader.SmartHomeLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Application {

    private static SmartHomeLoader smartHomeLoader = new JSSmartHomeLoader();

    public static void setSmartHomeLoader(SmartHomeLoader smartHomeLoader) {
        Application.smartHomeLoader = smartHomeLoader;
    }

    public static void main(String... args) throws IOException {
        SmartHome smartHome = smartHomeLoader.loadSmartHome();
        runEventsCycle(smartHome);
    }

    private static void runEventsCycle(SmartHome smartHome) {
        SensorEvent event = RandomSensorEventProvider.getNextSensorEvent();
        Collection<EventProcessor> eventProcessors = configureEventProcessors();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor eventProcessor : eventProcessors) {
                eventProcessor.processEvent(smartHome, event);
            }
            event = RandomSensorEventProvider.getNextSensorEvent();
        }
    }

    private static Collection<EventProcessor> configureEventProcessors() {
        Collection<EventProcessor> eventProcessors = new ArrayList<>();
        eventProcessors.add(new LightsEventProcessor());
        eventProcessors.add(new DoorEventProcessor());
        eventProcessors.add(new HallDoorEventProcessor());
        return eventProcessors;
    }

}
