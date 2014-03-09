package com.psyomn.tinysecret

import swing._
import swing.event._
import scala.swing._


/** 
 * A menu for telling the user if there are any problems that were encountered
 * 
 * @author Simon Symeonidis
 */
class OutputWidget extends BorderPanel {
  import BorderPanel.Position._

  val errorLabel : Label =
    new Label { text = "Output" } 

  val buttonLabels = Array[String]("Show", "Hide")

  val buttons = buttonLabels.map(new Button(_))

  val buttonPanel = new BoxPanel(Orientation.Horizontal) {
    for (button <- buttons)
      contents += button
  }

  var outputTextField : TextArea = 
    new TextArea(rows = 10, columns = 60){
      // preferredSize = new Dimension(300, 200)
    }

  var scroll = new ScrollPane(outputTextField)
  
  layout(errorLabel) = North
  layout(scroll) = Center
  layout(buttonPanel) = South

}
