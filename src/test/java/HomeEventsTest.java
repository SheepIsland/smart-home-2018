import org.junit.Test;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.elements.Door;
import ru.sbt.mipt.oop.elements.Light;
import ru.sbt.mipt.oop.elements.Room;
import ru.sbt.mipt.oop.elements.alarm.Alarm;
import ru.sbt.mipt.oop.event.HomeEventsObserver;
import ru.sbt.mipt.oop.event.RandomSensorEventProvider;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.SensorEventType;
import ru.sbt.mipt.oop.event.processor.AlarmActivatedEventProcessor;
import ru.sbt.mipt.oop.event.processor.DoorEventProcessor;
import ru.sbt.mipt.oop.event.processor.LightsEventProcessor;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Violetta on 26/11/2018.
 */
public class HomeEventsTest {

    @Test
    public void testProcessLightEvent() {
        Collection<Room> rooms = new ArrayList<>();
        Collection<Light> lights = new ArrayList<>();
        String lightOffId = "1";
        String lightOnId = "2";
        Light lightOff = new Light(lightOffId, true);
        Light lightOn = new Light(lightOnId, false);
        lights.add(lightOff);
        lights.add(lightOn);
        Room room = new Room(
                lights,
                Collections.singletonList(new Door(true, "1")),
                "room");
        rooms.add(room);
        SmartHome smartHome = new SmartHome(rooms);
        HomeEventsObserver homeEventsObserver = new HomeEventsObserver(new RandomSensorEventProvider());
        homeEventsObserver.registerEventProcessor(new LightsEventProcessor());
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_OFF, lightOffId);
        homeEventsObserver.runSensorEvent(smartHome,event);
        assertFalse(lightOff.isOn());
        event = new SensorEvent(SensorEventType.LIGHT_ON, lightOnId);
        homeEventsObserver.runSensorEvent(smartHome,event);
        assertTrue(lightOn.isOn());
    }

    @Test
    public void testProcessDoorEvent() {
        Collection<Room> rooms = new ArrayList<>();
        Collection<Door> doors = new ArrayList<>();
        String doorCloseId = "1";
        String doorOpenId = "2";
        Door doorClose = new Door(true, doorCloseId);
        Door doorOpen = new Door(false, doorOpenId);
        doors.add(doorClose);
        doors.add(doorOpen);
        Room room = new Room(
                Collections.singletonList(new Light("0", true)),
                doors,
                "room");
        rooms.add(room);
        SmartHome smartHome = new SmartHome(rooms);
        HomeEventsObserver homeEventsObserver = new HomeEventsObserver(new RandomSensorEventProvider());
        homeEventsObserver.registerEventProcessor(new DoorEventProcessor());
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, doorCloseId);
        homeEventsObserver.runSensorEvent(smartHome,event);
        assertFalse(doorClose.isOpen());
        event = new SensorEvent(SensorEventType.DOOR_OPEN, doorOpenId);
        homeEventsObserver.runSensorEvent(smartHome,event);
        assertTrue(doorOpen.isOpen());
    }

    @Test
    public void testAlarmEvent() throws IOException {
        Collection<Room> rooms = new ArrayList<>();
        String doorId = "1";
        String lightId = "3";
        Light light = new Light(lightId, false);
        Door door = new Door(false, doorId);
        Room room = new Room(
                Collections.singletonList(light),
                Collections.singletonList(door),
                "room");
        rooms.add(room);
        String alarmId = "2";
        String alarmPass = "1111";
        Alarm alarm = new Alarm(alarmPass, alarmId);

        SmartHome smartHome = new SmartHome(rooms, alarm);
        alarm.activate(alarmPass);
        assertTrue(alarm.isActivated());

        HomeEventsObserver homeEventsObserver = new HomeEventsObserver(new RandomSensorEventProvider());
        homeEventsObserver.registerEventProcessor(new AlarmActivatedEventProcessor(new DoorEventProcessor()));
        homeEventsObserver.registerEventProcessor(new AlarmActivatedEventProcessor(new LightsEventProcessor()));
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, lightId);
        homeEventsObserver.runSensorEvent(smartHome,event);
        assertFalse(light.isOn());
        event = new SensorEvent(SensorEventType.DOOR_OPEN, doorId);
        homeEventsObserver.runSensorEvent(smartHome,event);
        assertFalse(door.isOpen());

    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        HomeEventsObserver homeEventsObserver = new HomeEventsObserver();
        homeEventsObserver.runEventsCycle(null);
    }

}
