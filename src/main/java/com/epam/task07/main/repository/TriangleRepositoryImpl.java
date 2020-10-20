package com.epam.task07.main.repository;

import com.epam.task07.main.observer.TriangleObservable;

import java.util.*;

public class TriangleRepositoryImpl implements TriangleRepository {

    private Map<Integer, TriangleObservable> trianglesMap = new HashMap<Integer, TriangleObservable>();

    @Override
    public void add(TriangleObservable triangle) {
        int id = triangle.getId();
        trianglesMap.put(id, triangle);
    }

    @Override
    public void remote(TriangleObservable triangle) {
        int id = triangle.getId();
        trianglesMap.remove(id);
    }

    @Override
    public void update(TriangleObservable triangle) {
        int id = triangle.getId();
        trianglesMap.replace(id, triangle);
    }

    @Override
    public Map<Integer, TriangleObservable> query(TriangleSpecification specification) {
        Map<Integer, TriangleObservable> specifiedTriangles = new HashMap<Integer, TriangleObservable>();
        for (Map.Entry<Integer, TriangleObservable> item : trianglesMap.entrySet()) {
            TriangleObservable triangle = item.getValue();
            if (specification.specified(triangle)) {
                int triangleId = item.getKey();
                specifiedTriangles.put(triangleId, triangle);
            }
        }
        return specifiedTriangles;
    }

    public int size() {
        return trianglesMap.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TriangleRepositoryImpl that = (TriangleRepositoryImpl) o;
        return trianglesMap.equals(that.trianglesMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trianglesMap);
    }

    @Override
    public String toString() {
        return String.format("TriangleRepositoryImpl{trianglesMap=%s}", trianglesMap.toString());
    }
}
