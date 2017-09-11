package edu.miracosta.cs113;

import java.util.Scanner;

/** Represents a circle.
 * Extends a shape
 */
public class Circle extends Shape{
	// Data Fields
	/** The radius of the circle. */
	private double radius = 0;
	
	//Constructors
	public Circle(){
		super("Circle");
	}
	
	/** Constructs a circle of the specified radius.
	 * @param radius the radius
	 */
	public Circle(double radius){
		super("Circle");
		this.radius = radius;
	}
	
	//Methods
	/** Get the radius.
	 * @return The radius
	 */
	public double getRadius(){
		return radius;
	}

	/** Compute the area of the circle.
	 * @return The area of the circle using PI r ** 2
	 */
	@Override
	public double computeArea(){
		return (Math.PI) * (Math.pow(radius, 2));
	}
	
	/** Compute the perimeter of the circle
	 * @return The perimeter of the circle
	 */
	@Override
	public double computePerimeter(){
		return 2 * (Math.PI) * radius;
	}
	
	/** Read the attributes of the rectangle */
	@Override
	public void readShapeData(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the radius of the circle");
		radius = in.nextDouble();
	}
	
	/** Create a string representation of the circle
	 * @return a String representation of the circle
	 */
	@Override
	public String toString(){
		return super.toString() + ":radius is " + radius;
	}
}

