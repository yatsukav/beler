package example

import org.scalajs.dom
import org.scalajs.dom.html
import scalatags.JsDom.all._

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("ScalaJSExample")
object ScalaJSExample {

  @JSExport
  def main(target: html.Div): Unit = {
    val xhr = new dom.XMLHttpRequest()
    xhr.open("GET", "article.html")
    xhr.onload = (e: dom.Event) => {
      if (xhr.status == 200) {
        val article = div().render
        article.innerHTML = xhr.responseText
        target.appendChild(
          article
        )
      }
    }
    xhr.send()
    target.appendChild(
      div(
        h1("Hello World")
      ).render
    )
  }

}
