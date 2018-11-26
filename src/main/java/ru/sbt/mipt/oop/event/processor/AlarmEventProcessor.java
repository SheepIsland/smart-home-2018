//package ru.sbt.mipt.oop.event.processor;
//
//import ru.sbt.mipt.oop.SmartHome;
//import ru.sbt.mipt.oop.elements.alarm.Alarm;
//import ru.sbt.mipt.oop.event.SensorEvent;
//import ru.sbt.mipt.oop.event.SensorEventType;
//
///**
// * Created by Violetta on 26/11/2018.
// */
//public class AlarmEventProcessor implements EventProcessor {
//
//    private String input;
//
//    public AlarmEventProcessor(String input) {
//        this.input = input;
//    }
//
//    @Override
//    public void processEvent(SmartHome smartHome, SensorEvent event) {
//        if (!isAlarmEvent(event)) return;
//        smartHome.executeAction(object -> {
//            if (object instanceof Alarm) {
//                Alarm alarm = (Alarm) object;
//                if (alarm.getId().equals(event.getObjectId())) {
//                    if (event.getType() == SensorEventType.ALARM_ACTIVATE) {
//                        alarm.activate(input);
//                        return;
//                    }
//                    if (event.getType() == SensorEventType.ALARM_DEACTIVATE) {
//                        alarm.deactivate(input);
//                        return;
//                    }
//                    if (event.getType() == SensorEventType.ALARM_DANGER) {
//                        alarm.danger();
//                        return;
//                    }
//                }
//
//            }
//        });
//    }
//
//
//    private boolean isAlarmEvent(SensorEvent event) {
//        return event.getType() == SensorEventType.ALARM_ACTIVATE || event.getType() == SensorEventType.ALARM_DEACTIVATE;
//    }
//
//}
