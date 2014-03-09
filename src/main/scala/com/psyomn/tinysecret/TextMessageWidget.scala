package com.psyomn.tinysecret 

import swing._
import swing.event._
import scala.swing._

class TextMessageWidget extends BorderPanel { 
  import BorderPanel.Position._

  var messageText = new TextArea(rows = 20, columns = 30)

  var messageScroll = new ScrollPane(messageText)

  var sampleText = new TextArea(rows = 20, columns = 30) 

  var sampleScroll = new ScrollPane(sampleText)

  var messageLabel = new Label { text = "Your Message" }

  var sampleLabel = new Label { text = "Your Sample" }

  var samplePanel = new BoxPanel(Orientation.Vertical) {
    contents += sampleLabel
    contents += sampleScroll
  }

  var messagePanel = new BoxPanel(Orientation.Vertical) {
    contents += messageLabel
    contents += messageScroll
  }

  layout(samplePanel) = West
  layout(messagePanel) = East

}
