package task2.model;

import java.util.ArrayList;
import java.util.Comparator;

public class TriangleList {
    private ArrayList<Triangle> triangleList;

    public TriangleList(Triangle... triangles){
        triangleList = new ArrayList<Triangle>();
        for (Triangle triangle : triangles) {
            triangleList.add(triangle);
        }
    }

    public static Comparator<Triangle> TriangleComparatorBySquare = new Comparator<Triangle>() {
        @Override
        public int compare(Triangle a, Triangle b) {
            if(a.getSquare()>b.getSquare()){
                return -1;
            }
            else if(a.getSquare()==b.getSquare()){
                return 0;
            }
            else{
                return 1;
            }
        }
    };
    public static Comparator<Triangle> TriangleComparatorByName = new Comparator<Triangle>() {
        public int compare(Triangle a, Triangle b){
            return a.getName().compareTo(b.getName());
        }
    };


    public void addTriangle(Triangle triangle) {
        triangleList.add(triangle);
    }

    public void removeTriangle(String name) {
        triangleList.remove(getByName(name));
    }

    public Triangle getByName(String name){
        for (Triangle triangle : triangleList) {
            if(triangle.getName()==name){
                return triangle;
            }
        }
        return null;
    }

    public void sortBySquare(){
        triangleList.sort(TriangleComparatorBySquare);
    }
    public void sortByName(){
        triangleList.sort(TriangleComparatorByName);
    }

    public void printString() {
        System.out.println("============= Triangles list: ===============");
        int i = 1;
        for (Triangle triangle : triangleList) {
            System.out.println( ""+(i++)+"."+triangle.toString());
        }

    }
}
