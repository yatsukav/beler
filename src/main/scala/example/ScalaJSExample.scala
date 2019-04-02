package example

import org.scalajs.dom
import org.scalajs.dom.html
import scalatags.JsDom.all._

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("ScalaJSExample")
object ScalaJSExample {

  @JSExport
  def main(target: html.Div): Unit = {
    target.appendChild(
      div(
        h1("Hello World")
      ).render
    )
  }

}
