package com.epam.task07.main.repository.specification;

import com.epam.task07.main.observer.TriangleObservable;
import com.epam.task07.main.repository.TriangleSpecification;

public class IdTriangleSpecification implements TriangleSpecification {

    private final long id;

    public IdTriangleSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specified(TriangleObservable triangle) {
        return triangle.getId() == id;
    }
}