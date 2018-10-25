package ru.sbt.mipt.oop.light;

import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.light.Light;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

/**
 * Created by Violetta on 04/10/2018.
 */
public class LightsEventProcessor implements EventProcessor {
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isLightEvent(event)) return;
        smartHome.executeAction(object -> {
            if (object instanceof Light) {
                Light light = (Light) object;
                if (light.getId().equals(event.getObjectId())) {
                    changeLightState(light, event);
                }
            }
        });
    }

    private void changeLightState(Light light, SensorEvent event) {
        if (event.getType() == LIGHT_ON) {
            light.setOn(true);
            System.out.println("Light " + light.getId());
        } else {
            light.setOn(false);
            System.out.println("Light " + light.getId());
        }
    }

    private boolean isLightEvent(SensorEvent event) {
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }
}
