package edu.miracosta.cs113;

import java.util.Scanner;

/** Represents a equilateral triangle.
 * Extends a shape
 */
public class EquilateralTriangle extends Shape{
	// Data Fields
	/** The side length of the triangle. */
	private double side;
	
	//Constructors
	public EquilateralTriangle(){
		super("EquilateralTriangle");
	}
	
	/** Constructs an equilateral triangle of the specified size.
	 * @param side the side
	 */
	public EquilateralTriangle(double side){
		super("EquilateralTriangle");
		this.side = side;
	}
	
	//Methods
	/** Get the side.
	 * @return The side
	 */
	public double getSide(){
		return side;
	}
	
	/** Compute the area.
	 * @return The area of the rectangle
	 */
	@Override
	public double computeArea(){
		return (Math.pow(3, 0.5) / 4) * side * side;
	}
	
	/** Compute the perimeter
	 * @return The perimeter of the equilateral triangle
	 */
	@Override
	public double computePerimeter(){
		return side * 3;
	}
	
	/** Read the attributes of the equilateral triangle */
	@Override
	public void readShapeData(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the base of the equilateral triangle");
		side = in.nextDouble();
	}
	
	/** Create a string representation of the equilateral triangle
	 * @return a String representation of the equilateral triangle
	 */
	@Override
	public String toString(){
		return super.toString() + ":side is " + side;
	}
}

