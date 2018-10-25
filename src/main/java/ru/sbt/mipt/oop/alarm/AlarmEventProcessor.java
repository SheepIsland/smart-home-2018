package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATE;

/**
 * Created by Violetta on 25/10/2018.
 */
public class AlarmEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
            if (!isAlarmEvent(event)) return;
            smartHome.executeAction(object -> {
                if (object instanceof Alarm) {
                    Alarm alarm = (Alarm) object;
                    if (alarm.getId().equals(event.getObjectId())) {
                        changeLightState(alarm, event);
                    }
                }
            });

    }

    private void changeLightState(Alarm alarm, SensorEvent event) {
        if (event.getType() == ALARM_ACTIVATE) {
            alarm.activate();
        } else {
            alarm.deactivate();
        }
    }

    private boolean isAlarmEvent(SensorEvent event) {
        return event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE;
    }
}
