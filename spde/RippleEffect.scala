package spde

/*
 * Written by: Jose Carlos Carrasco Jimenez
 * Purpose: The purpose of this piece of software is to show the use of Scala-Processing features
 * 			in a simple manner. It draws a simple ripple starting in the x-y coordinates of a 
 *    		mouse click.
 */

import processing.core._
import processing.opengl._
import java.awt.event._
import javax.swing.JFrame
import math._

object RippleEffect extends PApplet {

  private var ripple: RippleEffect = _

  ripple = new RippleEffect
  def main(args: Array[String]) {
    val frame = new javax.swing.JFrame("Ripple")
    frame.getContentPane().add(ripple)
    ripple.init

    frame.pack
    frame.setVisible(true)
  }
}

class RippleEffect extends PApplet {

  import RippleEffect._

  val movingRate = 1
  val numCircles = 5
  var circle = 0
  var circRadius = width / 2
  var deltaWidth = circRadius / numCircles
  var xcoor = mouseX
  var ycoor = mouseY
  var deltaGrayscale = 15
  var gray = 250

  override def setup() {
    //background()
    size(900, 300)
    stroke(0, 0, 0)
    frameRate(movingRate)
    noLoop()
  }

  override def draw() {
    drawRipple()
  }

  def drawRipple() {
    if (circle < numCircles) {
      fill(gray, gray, gray)
      ellipse(xcoor, ycoor, circRadius, circRadius)
      gray -= deltaGrayscale //change gray scale
      circRadius -= deltaWidth //change radius of circle
      circle += 1
    } else {
      circle = 0 //reset circle coounter
      gray = 250 //reset gray color
      circRadius = width / 2
    }
  }

  override def mousePressed() {

    xcoor = mouseX
    ycoor = mouseY
    circRadius = width / 2
    deltaWidth = circRadius / numCircles
    loop()
    /*circRadius = width / 2
    deltaWidth = circRadius / numCircles
    deltaGrayscale = 15

    for (c <- 1 to numCircles) {
      fill(gray, gray, gray)
      ellipse(xcoor, ycoor, circRadius, circRadius)
      gray -= deltaGrayscale //change gray scale
      circRadius -= deltaWidth //change radius of circle
      //circle += 1
    } //else circle = 0 //reset circle coounter*/

  }
}