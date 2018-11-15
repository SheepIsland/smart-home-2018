package ru.sbt.mipt.oop.elements.remoteControl.command;

import ru.sbt.mipt.oop.elements.Light;

import java.util.List;

/**
 * Created by Violetta on 15/11/2018.
 */
public class SwitchOnAllLightCommand implements RemoteControlCommand {
    private List<Light> lights;

    public SwitchOnAllLightCommand(List<Light> lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        for (Light light : lights) {
            light.setOn(true);
        }
    }

}
