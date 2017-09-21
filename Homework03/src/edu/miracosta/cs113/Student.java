package edu.miracosta.cs113;
/**
 *Student.java : Data holder for a student registering for a class
 *
 *Class Invariant : Assumes first and last name are not null
 *
 *@author   Zachary Chao <zach.chao@yahoo.com>
 *@version  1.0
 *
 */
public class Student implements Comparable<Student>{
	private String first;
	private String last;
	
	/**
	 * Constructor for a new Student given first and last name
	 * 
	 * @param first The first name of the student
	 * @param last The last name of the student
	 * 
	 * @return None
	 */
	public Student(String first, String last){
		this.setFirst(first);
		this.setLast(last);
	}
	
	/**
	 * Getter for the first name
	 * 
	 * @return The first name
	 */
	public String getFirst() {
		return first;
	}
	
	/**
	 * Setter for the first name
	 * 
	 * @param first The first name to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}
	
	/**
	 * Getter for the last name
	 * 
	 * @return the last name of the student
	 */
	public String getLast() {
		return last;
	}
	
	/**
	 * Setter for the last name
	 * 
	 * @param last The last name to set
	 */
	public void setLast(String last) {
		this.last = last;
	}
	
	/**
	 * The comapreTo method that I thought we needed but we don't but I already made it so it just exists now.
	 * 
	 * @param Student the other student to compare to
	 * 
	 * @return an int representing if it is lower or higher alphabetically
	 */
	@Override
	public int compareTo(Student other) {
		int alphabetical = (first+last).compareToIgnoreCase(other.getFirst() + other.getLast());
		//Alphabetical returns how far off it is, just need negative or positive or equal
		if (alphabetical < 0){
			return -1;
		}else if (alphabetical == 0){
			return 0;
		}else{
			return 1;
		}
	}
	
	/**
	 * toString method to be called implicitly or explicitly
	 * 
	 * @return the string representation of the student
	 */
	@Override
	public String toString(){
		return first + " " + last;
	}
}
