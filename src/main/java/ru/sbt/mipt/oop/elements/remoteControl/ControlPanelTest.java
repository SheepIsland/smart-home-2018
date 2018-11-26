package ru.sbt.mipt.oop.elements.remoteControl;

import org.junit.Test;
import ru.sbt.mipt.oop.elements.Light;
import ru.sbt.mipt.oop.elements.alarm.Alarm;
import ru.sbt.mipt.oop.elements.remoteControl.command.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Violetta on 26/11/2018.
 */
public class ControlPanelTest {

    @Test
    public void run(){
        ControlPanel controlPanel = new ControlPanel();
        String alarmId = "1";
        String alarmPass = "1111";
        Alarm alarm = new Alarm(alarmPass,alarmId);
        List<Light> lights = new ArrayList<>();
        String lightOffId = "1";
        String lightOnId = "2";
        Light lightOff = new Light(lightOffId, true);
        Light lightOn = new Light(lightOnId, false);
        lights.add(lightOff);
        lights.add(lightOn);
        RemoteControlCommand activateAlarm = new ActivateAlarmCommand(alarm);
        RemoteControlCommand activateDangerAlarm = new ActivateDangerStateAlarmCommand(alarm);
        RemoteControlCommand swichOffLights = new SwitchOffAllLightCommand(lights);
        RemoteControlCommand swichOnLights = new SwitchOnAllLightCommand(lights);
        controlPanel.setCommand("A", activateAlarm);
        controlPanel.setCommand("B", activateDangerAlarm);
        controlPanel.setCommand("1", swichOffLights);
        controlPanel.setCommand("2",swichOnLights);
        controlPanel.onButtonPressed("A");
        assertTrue(alarm.isActivated());
        controlPanel.onButtonPressed("B");
        assertTrue(alarm.isActivated());
        controlPanel.onButtonPressed("1");
        assertFalse(lightOff.isOn());
        assertFalse(lightOn.isOn());
        controlPanel.onButtonPressed("2");
        assertTrue(lightOff.isOn());
        assertTrue(lightOn.isOn());
    }
}
