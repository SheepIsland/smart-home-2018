//package ru.sbt.mipt.oop.event;
//
//import com.coolcompany.smarthome.events.SensorEventsManager;
//import ru.sbt.mipt.oop.event.processor.EventProcessor;
//
///**
// * Created by Violetta on 02/11/2018.
// */
//public class EventsObserverAdapter implements EventManager {
//
//    private SensorEventsManager sensorEventsManager;
//
//    public EventsObserverAdapter(SensorEventsManager sensorEventsManager) {
//        this.sensorEventsManager = sensorEventsManager;
//    }
//
//    @Override
//    public void registerEventProcessor(EventProcessor eventProcessor) {
//        sensorEventsManager.registerEventHandler(event -> {
//            System.out.println("Event type [" + event.getEventType() + "] from object with id=" + event.getObjectId() + "]");
//        });
//        sensorEventsManager.start();
//    }
//}
