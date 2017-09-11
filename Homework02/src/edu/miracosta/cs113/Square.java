package edu.miracosta.cs113;

import java.util.Scanner;

/** Represents a square.
 * Extends a shape
 */
public class Square extends Shape{
	// Data Fields
	/** The side of the rectangle. */
	private double side = 0;
	
	//Constructors
	public Square(){
		super("Square");
	}
	
	/** Constructs a rectangle of the specified size.
	 * @param width the width
	 * @param height the height
	 */
	public Square(double side){
		super("Square");
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
	 * @return The area of the square
	 */
	@Override
	public double computeArea(){
		return side * side;
	}
	
	/** Compute the perimeter
	 * @return The perimeter of the square
	 */
	@Override
	public double computePerimeter(){
		return 4 * side;
	}
	
	/** Read the attributes of the square */
	@Override
	public void readShapeData(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the side length of the square");
		side = in.nextDouble();
	}
	
	/** Create a string representation of the square
	 * @return a String representation of the square
	 */
	@Override
	public String toString(){
		return super.toString() + ":side is " + side;
	}
}

