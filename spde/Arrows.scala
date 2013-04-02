package spde

/*
 * Written by Jose Carlos Carrasco Jimenez
 * Purpose: The purpose of this piece of software is to show the use of Scala-Processing features
 * 			in a simple manner. It simulates and electronic arrow board. It changes the direction
 *    		of the arrow when you click on the frame.
 */

import processing.core._
import processing.opengl._
import java.awt.event._
import javax.swing.JFrame
import math._

object Arrows extends PApplet {
  private var arrow: Arrows = _

  arrow = new Arrows

  def main(args: Array[String]) = {

    val frame = new javax.swing.JFrame("Arrow")
    frame.getContentPane().add(arrow)
    arrow.init

    frame.pack
    frame.setVisible(true)

  }
}

class Arrows extends PApplet {

  val movingRate = 2
  var left = true
  val padding = 50
  var xcoor = padding
  var ycoor = height / 2
  var circleWidth = width / 13 //divide the width by 13 because of configuration
  var circleHeight = circleWidth
  var on = false

  override def setup() {
    background(0)
    size(900, 300)
    stroke(0, 0, 0)
    frameRate(movingRate)
  }

  override def draw() {
    circleWidth = width / 13
    circleHeight = circleWidth
    xcoor = padding + circleWidth
    ycoor = height / 2
    if (!on) fill(139, 90, 43) else fill(250, 250, 0)
    //Draw configuration of circles that will go on to show an electronic arrow
    for (index <- 1 to 11) {
      if (index % 2 != 0) ellipse(xcoor, ycoor, circleWidth, circleHeight)
      if (index == 2) {
        if (left && on) fill(250, 250, 0) else fill(139, 90, 43)
        ycoor += 2 * circleWidth; ellipse(xcoor, ycoor, circleWidth, circleHeight)
        ycoor = height / 2
        ycoor -= 2 * circleWidth; ellipse(xcoor, ycoor, circleWidth, circleHeight)
        ycoor = height / 2
        if (!on) fill(139, 90, 43) else fill(250, 250, 0)
      }

      if (index == 10) {
        if (!left && on) fill(250, 250, 0) else fill(139, 90, 43)
        ycoor += 2 * circleWidth; ellipse(xcoor, ycoor, circleWidth, circleHeight)
        ycoor = height / 2
        ycoor -= 2 * circleWidth; ellipse(xcoor, ycoor, circleWidth, circleHeight)
        ycoor = height / 2
        if (!on) fill(139, 90, 43) else fill(250, 250, 0)
      }
      xcoor += circleWidth

    }
    on = !on
  }

  override def mousePressed() {
    left = !left
  }
}