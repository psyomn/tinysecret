package com.psyomn.tinysecret

import swing._
import swing.event._
import scala.swing._

class MainUI extends Dialog { 

  contents = new BorderPanel {
    import BorderPanel.Position._

    layout(new OutputWidget) = North
  }

}
