package com.epam.task07.main.observer;

import com.epam.task07.main.model.Point;
import com.epam.task07.main.model.Triangle;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TriangleObservable extends Triangle implements Observable {

    private final int id;

    private Set<Observer> observers = new HashSet<Observer>();

    public TriangleObservable(final int id, final Point pointA, final Point pointB, final Point pointC) {
        super(pointA, pointB, pointC);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Set<Observer> getObservers() {
        return observers;
    }

    @Override
    public void setPointA(Point pointA) {
        super.setPointA(pointA);
        notifyObservers();
    }

    @Override
    public void setPointB(Point pointB) {
        super.setPointB(pointB);
        notifyObservers();
    }

    @Override
    public void setPointC(Point pointC) {
        super.setPointC(pointC);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.updateParameters(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        TriangleObservable that = (TriangleObservable) o;
        return id == that.id &&
                observers.equals(that.observers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, observers);
    }

    @Override
    public String toString() {
        return String.format("TriangleObservable{id=%d, observers=%s}", id, observers);
    }
}