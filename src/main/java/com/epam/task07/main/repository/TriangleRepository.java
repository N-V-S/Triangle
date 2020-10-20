package com.epam.task07.main.repository;

import com.epam.task07.main.observer.TriangleObservable;

import java.util.Map;

public interface TriangleRepository {

    void add(TriangleObservable triangle);

    void remote(TriangleObservable triangle);

    void update (TriangleObservable triangle);

    Map<Integer, TriangleObservable> query(TriangleSpecification specification);

    int size();
}