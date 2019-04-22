organization := "net.iatsuk"
scalaVersion := "2.12.8"
version := "1.0.0-SNAPSHOT"
name := "portfolio"

enablePlugins(ScalaJSPlugin)
enablePlugins(WorkbenchPlugin)

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "com.lihaoyi" %%% "scalatags" % "0.6.7"
)
