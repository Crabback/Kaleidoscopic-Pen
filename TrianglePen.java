//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P03 Kaleidoscopic Pen
// Files: TrianglePen.java
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

import java.util.ArrayList;
import processing.core.PApplet;

/**
 * This is the TrianglePen tool that draws triangles.
 * It changes the positions of points.
 * It also changes the colors and shapes of triangles.
 * 
 * @author ZhengjiaMao
 *
 */
public class TrianglePen {

  /**
   * These are the private parameters will be used in this class.
   */
  private boolean mouseWasPressed; // mousePressed from previous update() call
  private char keyWasPressed; // keyPressed from previous update() call
  private ArrayList<Point> pAL;
  private ArrayList<Triangle> tAL;
  private PApplet pro;
  private boolean showP;
  private Point where;

  /**
   * Default constructor
   * It initializes some of the private parameters created above.
   * @param processing
   * @param showPoints
   */
  public TrianglePen(PApplet processing, boolean showPoints) {
    mouseWasPressed = false;
    keyWasPressed = '\0';
    pAL = new ArrayList<>();
    tAL = new ArrayList<>();
    pro = processing;
    showP = showPoints;
  }
  
  /**
   * This method keeps updating the position as the mouse moves also calls the 
   * mousePressed method and KeyPressed method once detects the pressing
   * 
   * @param mouseX
   * @param mouseY
   * @param mousePressed
   * @param keyPressed
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {
    // process mouse-based user input
    if (mousePressed != mouseWasPressed) {
      if (mousePressed)
        handleMousePress(mouseX, mouseY);
      else
        handleMouseRelease(mouseX, mouseY);
    }
    if (mousePressed)
      handleMouseDrag(mouseX, mouseY);
    mouseWasPressed = mousePressed;
    // process keyboard-based user input
    if (keyPressed != keyWasPressed)
      handleKeyPress(mouseX, mouseY, keyPressed);
    keyWasPressed = keyPressed;
    // draw everything in its current state
    draw();
  }

  /**
   * This method reads the position when the mouse is clicked. 
   * It creates new points or drags points.
   * @param mouseX
   * @param mouseY
   */
  private void handleMousePress(int mouseX, int mouseY) {
    for (int i = 0; i < pAL.size(); i++) {
      if (pAL.get(i).isOver(mouseX, mouseY)) {
        where = pAL.get(i);
        return;
      }
    }
    where = null; //set the selection to null as default if no existing point
    pAL.add(new Point(mouseX, mouseY)); //add points
    if (pAL.size() % 3 == 0) {
      int n = pAL.size() / 3; //n groups of three points
      tAL.add(new Triangle(
          pAL.get(3 * n - 3), 
          pAL.get(3 * n - 2), 
          pAL.get(3 * n - 1), 
          -1));
    }
  }

  /**
   * This method deselects the point when finishing dragging and releasing the mouse.
   * @param mouseX
   * @param mouseY
   */
  private void handleMouseRelease(int mouseX, int mouseY) {
    where = null; //set the selection to null when release the mouse
  }

  /**
   * If the mouse is dragging an existing point, 
   * keep updating the position of selected point.
   * @param mouseX
   * @param mouseY
   */
  private void handleMouseDrag(int mouseX, int mouseY) {
    if (where != null) { 
      where.setPosition(mouseX, mouseY);
    }
  }

  /**
   * This method reads the mouse poisiton and keypressed as colorindex,
   * check whether the mouse is over any triangles.
   * if yes, change their colors based on the color index.
   * @param mouseX
   * @param mouseY
   * @param keyPressed
   */
  private void handleKeyPress(int mouseX, int mouseY, char keyPressed) {
    int key = keyPressed - '0'; //convert char to int
    for (int i = 0; i <= 7; i++) {
      if (key == i) { //only works if the keypressed is within 0-7
        for (int j = 0; j < tAL.size(); j++) {
          if (tAL.get(j).isOver(mouseX, mouseY)) { //check which triangles are the mouse over
            tAL.get(j).setColor(key); //change the color of all the over triangles
          }
        }
      }
    }
  }
  
/**
 * This method draws points only if the showPoints parameter is true.
 */
  private void draw() {
    if (showP) { //only draw points when the showPoints parameter is true
      for (int i = 0; i < pAL.size(); i++) {//draw points in the arraylist
        pAL.get(i).draw(pro);
      }
    }
    for (int j = 0; j < tAL.size(); j++) {//draw triangles in the arraylist
      tAL.get(j).draw(pro);
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
