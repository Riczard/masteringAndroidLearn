package com.kuklinski.masteringandroid.samples;

import java.util.ArrayList;
import java.util.List;

public class MyObserved {

    public interface ObserverInterface {
        public void notifyListener();
    }

    List<ObserverInterface> observerList;

    public MyObserved() {
        observerList = new ArrayList<>();
    }

    public void addObserver(ObserverInterface observer) {
        observerList.add(observer);
    }

    public void removeObserver(ObserverInterface observer) {
        observerList.remove(observer);
    }

    public void nofifyAllObserver() {
        for(ObserverInterface observer : observerList) {
            observer.notify();
        }
    }
}
