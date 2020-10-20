package com.epam.task07.main.repository;

import com.epam.task07.main.observer.TriangleObservable;

public interface TriangleSpecification {

    boolean specified(TriangleObservable triangle);
}