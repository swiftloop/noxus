package com.noxus.common.event;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sorata
 * @date 2019-08-01 10:33
 */
public class AppSubjectImpl<T extends Event> implements AppSubject<T> {

    private final List<AppObserver<T>> LIST  = new LinkedList<>();

    @Override
    public void register(AppObserver<T> appObserver) {
        LIST.add(appObserver);
    }

    @Override
    public void unregister(AppObserver<T> appObserver) {
        LIST.remove(appObserver);
    }

    @Override
    public void notifyEvent(T t) {
        LIST.forEach(x->{x.observer(t);});
    }
}
