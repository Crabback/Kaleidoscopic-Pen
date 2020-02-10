//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P03 Kaleidoscopic Pen
// Files: DriverApplication.java
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
 * This is the application driver for P03 Kaleidocopic Pen (CS300, Fall 2019):
 * an art tool that can be used for the generation of kaleidoscopic images.
 * 
 * @author dahl
 */
public class DriverApplication extends PApplet {
  

  private KaleidoscopePen pen; // the pen that manages this application's drawing
  
  /**
   * Creates and being updating a new processing application.  This involves
   * calling settings() and setup() once at the beginning of the application, 
   * and then calling draw() repeated after that.
   * @param args - command line arguments are not used by this program
   */
  public static void main(String[] args) {
    PApplet.main("DriverApplication");
  }
  
  /**
   *  This method runs once before setup, and is ONLY used to initialize the 
   *  size of the processing window that later graphics will be drawn to.
   */
  public void settings() {
    size(800,600);
  }
  
  /**
   *  This method runs once before draw is repeatedly called by processing.
   *  It is only used to construct a new pen object for this application.
   */
  public void setup() {
    pen = new KaleidoscopePen(this, 5);
  }
  
  /**
   *  This method repeatedly updates the display, for as long as this program
   *  is running.  On each update, it clears the screen and then updates its 
   *  pen.  This update provides the pen with information about user input,
   *  and also forces an updated view of the display to be drawn.
   */
  public void draw() {
    background(204, 255, 153);
    pen.update(mouseX,mouseY,mousePressed,keyPressed?key:'\0');
  }
  
}