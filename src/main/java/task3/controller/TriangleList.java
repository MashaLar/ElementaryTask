package task3.controller;

import task3.model.Triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TriangleList {
    //list of triangles
    private ArrayList<Triangle> triangleList;

    //constructor of list
    public TriangleList(Triangle... triangles){
        triangleList = new ArrayList<>();
        Collections.addAll(triangleList, triangles);
    }

    public ArrayList<Triangle> getTriangleList(){
        return triangleList;
    }

    //comparator class to sort by square (descending)
    public static Comparator<Triangle> TriangleComparatorBySquare = new Comparator<Triangle>() {
        @Override
        public int compare(Triangle a, Triangle b) {
            return Double.compare(b.getSquare(), a.getSquare());
        }
    };

    //method to add new triangle to list
    public void addTriangle(Triangle triangle) {
        triangleList.add(triangle);
    }

    //method to delete triangle by name
    public void removeTriangle(String name) {
        triangleList.remove(findByName(name));
    }

    //method to search triangle by name
    public Triangle findByName(String name){
        for (Triangle triangle : triangleList) {
            if(triangle.getName().equals(name)){
                return triangle;
            }
        }
        return null;
    }

    //method to sort list (descending)
    public void sortBySquare(){
        triangleList.sort(TriangleComparatorBySquare);
    }

}
