package edu.miracosta.cs113;
/**
 *Term.java : Data holder for a term in a polynomial
 *
 *Class Invariant : Assumes the variable itself does not matter,
 *only coefficient and exponent
 *
 *@author   Zachary Chao <zach.chao@yahoo.com>
 *@version  1.0
 *
 */
public class Term implements Comparable<Term> {
	private int coefficient;
	private int exponent;
	
	/**
	 * Constructor for term
	 * 
	 * @param coefficient The coefficient of the term
	 * @param exponent The exponent of the term
	 * 
	 * @return None
	 */
	public Term(int coefficient, int exponent){
		this.setCoefficient(coefficient);
		this.setExponent(exponent);
	}
	
	/**
	 * Getter for the coefficient
	 * 
	 * @param None
	 * 
	 * @return The coefficient
	 */
	public int getCoefficient() {
		return coefficient;
	}
	
	/**
	 * Setter for the coefficient
	 * 
	 * @param coefficient The coefficient to be added
	 * 
	 * @return None
	 */
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
	
	/**
	 * Getter for the exponent
	 * 
	 * @param None
	 * 
	 * @return The exponent
	 */
	public int getExponent() {
		return exponent;
	}
	
	/**
	 * Setter for the exponent
	 * 
	 * @param exponent The exponent to be added
	 * 
	 * @return None
	 */
	public void setExponent(int exponent) {
		this.exponent = exponent;
	}
	
	/**
	 * toString method to be called implicitly or explicitly
	 * 
	 * @param None
	 * 
	 * @return Returns a String
	 */
	@Override
	public String toString(){
		return (coefficient + "x^" + exponent);
	}
	
	/**
	 * compareTo method to allow for implementing comparable
	 * 
	 * @param other The other term to compare 
	 * 
	 * @return an integer representing if the other is less
	 * than, equal to or less than
	 */

	@Override
	public int compareTo(Term other){
		if(other.getExponent() > this.exponent){
			return -1;
		}else if(other.getExponent() == this.exponent){
			return 0;
		}else{
			return 1;
		}
	}
}
