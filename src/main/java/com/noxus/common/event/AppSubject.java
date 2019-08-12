package com.noxus.common.event;

/**
 * @author sorata
 * @date 2019-08-01 10:27
 */
public interface AppSubject<T extends Event> {

     void register(AppObserver<T> appObserver);

     void unregister(AppObserver<T> appObserver);

     void notifyEvent(T t);
}
