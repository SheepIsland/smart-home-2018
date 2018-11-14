package ru.sbt.mipt.oop.event.processor;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

/**
 * Created by Violetta on 26/10/2018.
 */
public class AlarmActivatedEventProcessor implements EventProcessor {

    private EventProcessor eventProcessor;

    public AlarmActivatedEventProcessor(EventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (smartHome.isAlarmActivated()){
            System.out.println("Alarm is activated! email: Stranger in my home!");
            smartHome.getAlarm().danger();
        } else {
            eventProcessor.processEvent(smartHome, event);
        }
    }


}
