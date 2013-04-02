package spde
/*
 * Written by Jose Carlos Carrasco Jimenez
 * Purpose: The purpose of this piece of software is to show the use of Scala-Processing features
 * 			in a simple manner. It simulates a simple police siren.
 */

import processing.core._
import processing.opengl._
import java.awt.event._
import javax.swing.JFrame
import math._
import scala.util.Random

object Siren extends PApplet {
  private var spde: Siren = _

  spde = new Siren

  def main(args: Array[String]) = {

    val frame = new javax.swing.JFrame("Siren")
    frame.getContentPane().add(spde)
    spde.init

    frame.pack
    frame.setVisible(true)

  }

}

class Siren extends PApplet {

  import Siren._

  var middleScreen = width / 2
  val startX = 180 //to the left of the middle of the screen
  val movingWidth = 60 //width of moving rect
  val startY = 50 // below the height/2 point	
  val sirenHeight = 100 //height of moving rect (same as that of siren)
  val movingRate = 1500

  var xcoor: Int = middleScreen - (startX + movingWidth)

  override def setup() = {
    size(900, 300)
    stroke(0, 0, 0)
    frameRate(movingRate)
    noLoop() //do not run until mouse is pressed	
  }

  override def draw() = {
    background(0)
    fill(0, 0, 100) //Color blue
    rect(20, (height / 2) - startY, middleScreen - 20, sirenHeight)
    fill(100, 0, 0) //Color red
    rect(width / 2, (height / 2) - startY, middleScreen - 20, sirenHeight)
    drawFlash() //draw the moving rect

  }

  override def mousePressed() {
    loop() //on mouse pressed, run
  }

  def drawFlash() = {
    middleScreen = width / 2 // just to adjust the width in case the frame changes
    xcoor += 1 //increment xcoor by 1
    if (xcoor > middleScreen + startX) xcoor = middleScreen - (startX + movingWidth)
    if (xcoor < middleScreen - movingWidth) fill(0, 0, 250) else fill(250, 0, 0)

    rect(xcoor, height / 2 - 50, movingWidth, sirenHeight)
  }

}