package com.epam.task07.main.logic.comparator;

import com.epam.task07.main.observer.TriangleObservable;

import java.util.Comparator;

public class IdComparator implements Comparator<TriangleObservable> {

    @Override
    public int compare(TriangleObservable first, TriangleObservable second) {
        int firstId = first.getId();
        int secondId = second.getId();

        return Long.compare(firstId, secondId);
    }
}