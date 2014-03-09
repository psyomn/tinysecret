package com.psyomn.tinysecret

import swing._
import swing.event._
import scala.swing._


/** 
 * A menu for telling the user if there are any problems that were encountered
 * 
 * @author Simon Symeonidis
 */
class ErrorWidget extends BorderPanel {
  import BorderPanel.Position._

  val errorLabel : Label =
    new Label { text = "Error" } 

  var outputTextField : TextArea = 
    new TextArea(rows = 10, columns = 60)

  var scroll = new ScrollPane(outputTextField)
  
  layout(errorLabel) = North
  layout(scroll) = Center

}
