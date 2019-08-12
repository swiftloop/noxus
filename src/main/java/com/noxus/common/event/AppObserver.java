package com.noxus.common.event;

/**
 * @author sorata
 * @date 2019-08-01 10:30
 */
public interface AppObserver<T extends Event> {

    void observer(T event);

}
