//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P03 Kaleidoscopic Pen
// Files: Triangle.java
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
 * This method draws a triangle when every three points are created.
 * It also contains the color changing method.
 * 
 * @author ZhengjiaMao
 *
 */
public class Triangle {

  /**
   * parameters that determines the position, shape, and color of the triangles
   */
  private Point one;
  private Point two;
  private Point three;
  private int colorIndex;
  private static final int[] COLORS = new int[] { 
      // int packed w/8 bits of ARGB
      // WHITE,RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
      -1, -766643, -752563, -723891, -11668348, -11696908, -8106508, -766476};

  /**
   * Default constructor
   * It takes in three point objects and color index, and stores them.
   * @param one
   * @param two
   * @param three
   * @param c
   */
  public Triangle(Point one, Point two, Point three, int c) {
    this.one = one;
    this.two = two;
    this.three = three;
    colorIndex = c;
  }

  /**
   * Mutator
   * It takes the color index from (0-7 system) 
   * and stores the corresponding color index from the color pool array.
   * @param c
   */
  public void setColor(int c) {
    colorIndex = COLORS[c];
  }

  /**
   * The drawing function from PApplet
   * @param drawTo
   */
  public void draw(PApplet drawTo) {
    drawTo.fill(colorIndex);
    //set the color of the triangles from the given color index(0-7 system)
    drawTo.triangle(one.getX(), one.getY(), two.getX(), two.getY(), three.getX(), three.getY());
  } // draw a triangle based on the positions of three given points


  /**
   * I found this algorithm easier than the one provided in the document,
   * credits to GreeksforGreeks.
   * the link: 
   * www.geeksforgeeks.org
   * /check-whether-a-given-point-lies-inside-a-triangle-or-not/
   * @param x1
   * @param y1
   * @param x2
   * @param y2
   * @param x3
   * @param y3
   * @return the area
   */
  static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
    return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
  }

  /**
   * This method checks whether the mouse position is over any existing triangles.
   * @param x
   * @param y
   * @return true or false whether the mouse position is over any existing triangles 
   */
  public boolean isOver(int x, int y) {
   
    double A = area(one.getX(), one.getY(),two.getX(), two.getY(), three.getX(), three.getY());
    
    double A1 = area(x, y, two.getX(), two.getY(), three.getX(), three.getY());
    double A2 = area(one.getX(), one.getY(), x, y, three.getX(), three.getY());
    double A3 = area(one.getX(), one.getY(), two.getX(), two.getY(), x, y);
    //if the sum of the three triangles made of the new position and any other two vertexs
    //equals to the area of the original triangle,
    //it means the new position is inside the original triangle.
    return (A == A1 + A2 + A3);
  }


  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
