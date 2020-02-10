//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P03 Kaleidoscopic Pen
// Files: Point.java
// Course: CS 300
//
// Author: Zhengjia Mao
// Email: zmao27@wisc.edu
// Lecturer's Name: Gary DAHL
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Bailong Huang
// Partner Email: bhuang67@wisc.edu
// Partner Lecturer's Name: Gary DAHL
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _YES__ Write-up states that pair programming is allowed for this assignment.
// _YES__ We have both read and understand the course Pair Programming Policy.
// _YES__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: ULC tutors
// Online Sources: GeeksforGeeks
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import processing.core.PApplet;

/**
 * This tool draws a  point as the mouse clicks.
 * 
 * @author ZhengjiaMao
 */
public class Point {
  
  /**
   * constant diameter and position parameters
   */
  private static final int POINT_DIAMETER = 8;
  int xPos;
  int yPos;

  /**
   * Default constructor
   * It initializes the x and y positions.
   * @param x
   * @param y
   */
  public Point(int x, int y) {
    xPos = x;
    yPos = y;
  }

  /**
   * The accessor to get the x-coordinate
   * @return the x-coordinate
   */
  public int getX() {
    return xPos;
  }

  /**
   * The accessor to get the y-coordinate
   * @return the y-coordinate
   */
  public int getY() {
    return yPos;
  }

  /**
   * The mutator that updates the position by taking in x and y coordinates
   * @param x
   * @param y
   */
  public void setPosition(int x, int y) {
    xPos = x;
    yPos = y;
  }

  /**
   * The drawing function from PApplet
   * @param drawTo
   */
  public void draw(PApplet drawTo) {
    drawTo.fill(-1); 
    //fills the point with default color of white
    drawTo.circle(xPos, yPos, POINT_DIAMETER);
  } // draw a white circle at this point’s position

  /**
   * This method checks whether the mouse position is over any existing point.
   * @param x
   * @param y
   * @return a boolean that tells whether the mouse position is over any existing point
   */
  public boolean isOver(int x, int y) {
    return (Math.sqrt(Math.pow((x - xPos), 2) + Math.pow((y - yPos), 2)) <= POINT_DIAMETER / 2);
  }
  // returns true when the position x, y is within the circle drawn to visualize
  // this point, otherwise returns false

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
