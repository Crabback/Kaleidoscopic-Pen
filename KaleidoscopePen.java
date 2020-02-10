//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P03 Kaleidoscopic Pen
// Files: KaleidoscopePen.java
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
 * The final art tool that calls TrianglePen class to draw multiple triangles 
 * to create kaleidoscope.
 * 
 * @author ZhengjiaMao
 * 
 */
public class KaleidoscopePen{
  
  /**
   * These are the parameters will be used in this class.
   */
  private TrianglePen[] TrianglePen;
  private int numberOfObjects;
  /**
   * Default constructor
   * It initializes the private parameters created above.
   * @param drawTo
   * @param numberOfTrianglePens
   */
  public KaleidoscopePen(PApplet drawTo, int numberOfTrianglePens) {
    // creates a perfect size array of TrianglePen objects
    TrianglePen = new TrianglePen[numberOfTrianglePens];
    numberOfObjects = numberOfTrianglePens; // size of the array
    for (int i = 0; i < numberOfObjects; i++) { // populates the array
      if (i == 0) {
        TrianglePen[i] = new TrianglePen(drawTo, true);
      } else {
        TrianglePen[i] = new TrianglePen(drawTo, false);
      }
    }
  }

  /**
   * This method keeps updating the position as the mouse moves and
   * calls the update method in the TranglePen class to draw the triangles in the array.
   * @param mouseX
   * @param mouseY
   * @param mousePressed
   * @param keyPressed
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {
    for (int i = 0; i < numberOfObjects; i++) {
      if (TrianglePen[i] != null) {
        double angle = i * 2 * Math.PI / numberOfObjects;
        // use the provided rotate method to renew the position
        int posX = rotate(mouseX, mouseY, angle)[0];
        int posY = rotate(mouseX, mouseY, angle)[1];
        // updates the objects in the array in order
        TrianglePen[i].update(posX, posY, mousePressed, keyPressed);
      }
    }
  }

  /**
   * Rotates a position around the center of an 800x600 screen by the specified amount, and then
   * returns an array containing the resulting position.
   * @param x position of the point to be rotated (0 to 800 pixels)
   * @param y position of the point to be rotated (0 to 600 pixels)
   * @param angle amount of rotation to apply (angle in radians units: 0 to 2*PI) 
   * @return the rotated position array: x @ index 0, y @ index 1
   */
  public static int[] rotate(int x, int y, double angle) {
    x -= 400; // translate center of screen to origin (0,0)
    y -= 300;
    int[] rotatedPosition = new int[] { // rotate around origin
        (int) (x * Math.cos(angle) - y * Math.sin(angle)),
        (int) (x * Math.sin(angle) + y * Math.cos(angle))
        };
    rotatedPosition[0] += 400;    // return to center of screen 
    rotatedPosition[1] += 300;
    return rotatedPosition;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
