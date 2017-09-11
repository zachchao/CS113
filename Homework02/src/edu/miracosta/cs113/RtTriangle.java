package edu.miracosta.cs113;

import java.util.Scanner;

/** Represents a right triangle.
 * Extends a shape
 */
public class RtTriangle extends Shape{
	// Data Fields
	/** The base of the triangle. */
	private double base = 0;
	/** The height of the triangle */
	private double height = 0;
	
	//Constructors
	public RtTriangle(){
		super("RtTriangle");
	}
	
	/** Constructs a rectangle of the specified size.
	 * @param base the base
	 * @param height the height
	 */
	public RtTriangle(double base, double height){
		super("RtTriangle");
		this.base = base;
		this.height = height;
	}
	
	//Methods
	/** Get the base.
	 * @return The base
	 */
	public double getBase(){
		return base;
	}
	
	/** Get the height.
	 * @return The height
	 */
	public double getHeight(){
		return height;
	}
	
	/** Compute the area.
	 * @return The area of the rectangle
	 */
	@Override
	public double computeArea(){
		return 0.5 * base * height;
	}
	
	/** Compute the perimeter
	 * @return The perimeter of the right triangle
	 */
	@Override
	public double computePerimeter(){
		return Math.pow((base * base) + (height * height), 0.5) + base + height;
	}
	
	/** Read the attributes of the right triangle */
	@Override
	public void readShapeData(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the base of the right triangle");
		base = in.nextDouble();
		System.out.println("Enter the height of the right triangle");
		height = in.nextDouble();
	}
	
	/** Create a string representation of the right triangle
	 * @return a String representation of the right triangle
	 */
	@Override
	public String toString(){
		return super.toString() + ":base is " + base + ", height is " + height;
	}
}

