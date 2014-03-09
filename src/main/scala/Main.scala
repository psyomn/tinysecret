package com.psyomn.tinysecret 

import scala.collection.mutable.HashMap
import scala.util.Random

import swing._
import swing.event._
import scala.swing._

/** 
 * Main entry point
 * @author Simon Symeonidis 
 */
object Main extends SimpleSwingApplication {

  var textMessageWidget = new TextMessageWidget()
  var outputWidget = new OutputWidget()
  var errorWidget = new ErrorWidget()

  def top = new MainFrame { 
    title = "tinysecret v1.0"
    
    contents = new BoxPanel(Orientation.Vertical){
      contents += textMessageWidget
      contents += outputWidget
      contents += errorWidget
    }
  }

  listenTo(outputWidget.buttons:_*)

  reactions += {
    case ButtonClicked(b) => 
    b.text match {
      case "Show" => decrypt
      case "Hide" => encrypt
    }
  }

  def decrypt : Unit = { 
    var hash = makeHash(textMessageWidget.sampleText.text)
    var indiceStr = outputWidget.outputTextField.text
    var indiceInt = indiceStr.split(" ").map(_.toInt)
    var sampleList = textMessageWidget.sampleText.text.toList
    var result : String = "" 
    
    for (indice <- indiceInt) {
      result += sampleList(indice)
    }
    
    textMessageWidget.messageText.text = result
  }

  def encrypt : Unit = { 
    var message = textMessageWidget.messageText.text
    var sample = textMessageWidget.sampleText.text
    var hash = makeHash(sample)
    var result : String = ""
    var errors : String = ""

    for (chr <- message.toList) {
      if (hash.contains(chr)) {
        var arr = hash.get(chr) getOrElse Array[Int]()
        result += randomElement(arr).toString + " "
      }
      else 
        errors += "unmatched token '" + chr + "' \n"
    }
    
    outputWidget.outputTextField.text = result
    errorWidget.outputTextField.text = errors
  }

  def makeHash(str: String) : HashMap[Char, Array[Int]] = {
    var letterIndexHash = new HashMap[Char, Array[Int]]

    str.toList.zipWithIndex.foreach{
      case (e, i) =>
        if (letterIndexHash.contains(e)) {
          var tmp = (letterIndexHash.get(e) getOrElse Array[Int]()) ++ Array[Int](i)
          letterIndexHash.put(e, tmp)
        }
        else
          letterIndexHash.put(e, Array(i))
    }

    letterIndexHash
  }

  def randomElement(arr : Array[Int]) : Int = {
    val rand = new Random(System.currentTimeMillis())
    val rix = rand.nextInt(arr.length)
    arr(rix)
  }

}
