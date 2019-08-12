package com.noxus.common.event;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author sorata
 * @date 2019-08-01 10:40
 */
@Data
@AllArgsConstructor
public class SimpleEvent implements Event{

    private String some;


    public static void main(String[] args) {
        AppSubjectImpl<SimpleEvent> simpleEventAppSubject = new AppSubjectImpl<>();

        AppObserverListener<SimpleEvent> user1 = event -> {
            System.out.println(event.getSome() + "  a");
        };

        AppObserverListener<SimpleEvent> user2 = event -> {
            System.out.println(event.getSome() + "  b");
        };

        AppObserverListener<SimpleEvent> user3 = event -> {
            System.out.println(event.getSome() + "  c");
        };

        simpleEventAppSubject.register(user1);
        simpleEventAppSubject.register(user2);
        simpleEventAppSubject.register(user3);

        simpleEventAppSubject.notifyEvent(new SimpleEvent("Hello world"));


    }
}
