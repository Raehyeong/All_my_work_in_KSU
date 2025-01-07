/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab#: Assignment1
*/

import java.lang.Math;
class Circle{
    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public double circumference(){
        return 2*Math.PI*this.radius;
    }

    public double area(){
        return Math.PI*this.radius*this.radius;
    }
}

class Triangle{
    private int side1;
    private int side2;
    private int side3;

    public Triangle(int side1, int side2, int side3) {

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public Triangle() {
        super();
        this.side1 = 3;
        this.side2 = 4;
        this.side3 = 5;
    }

    public int perimeter(){
        return this.side1+this.side2+this.side3;
    }

    public double area(){
        double p = (this.side1+this.side2+this.side3)/2;
        double area = Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));

        return area;
    }

    public double height(){
        int min = Math.min(side1,side2);
        min = Math.min(min,side3);
        double a = area()*2;
        double h = a/min;

        return h;
    }

    public String toString(){
        return "Area of a traingle "+side1+"X"+side2+"X"+side3+" is "+this.area()+", perimeter of "+this.perimeter()+" and height "+this.height();
    }
}

class Rectangle{
    private double height;
    private double width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public double perimeter(){
        return 2*(height+width);
    }

    public double area(){
        return height*width;
    }

}
public class Assignment1 {
    public static void main(String[] args) {
        Circle c ;
        Triangle t;
        Rectangle r;

        for(int i=1;i<=10;i++){
            c = new Circle(i);
            System.out.println("Area of a circle with radius "+i+" is "+c.area()+" circumference is "+c.circumference());
        }
        for(int i=1;i<=3;i++){
            for(int j=1;j<=3;j++){
                r = new Rectangle(i,j);
                System.out.println("Area of a rectangle "+i+" by "+j+" is "+r.area()+" and its perimeter is "+r.perimeter());
            }
        }
        t = new Triangle(18,30,24);
        System.out.println(t.toString());
        Triangle t1 = new Triangle();
        System.out.println(t1.toString());
    }

}

