package com.patterns.observer;


import java.util.ArrayList;
import java.util.List;

public class ForumTopic implements Observable {

    private final List<Observer> observers;
    private final List<String> massages;
    private final String name;

    public ForumTopic(String name) {
        this.observers = new ArrayList<>();
        this.massages = new ArrayList<>();
        this.name = name;
    }

    public void addPost(String post) {
        massages.add(post);
        notifyObservers();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public List<String> getMassages() {
        return massages;
    }

    public String getName() {
        return name;
    }
}
