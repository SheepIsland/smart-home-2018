package ru.sbt.mipt.oop.elements.remoteControl.command;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.elements.Light;

import java.util.List;


/**
 * Created by Violetta on 15/11/2018.
 */
public class SwitchOffAllLightCommand implements RemoteControlCommand {

    private SmartHome smartHome;

    public SwitchOffAllLightCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
       smartHome.turnOffAllLights(true);
    }
}
