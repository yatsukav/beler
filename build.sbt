organization := "net.iatsuk"
scalaVersion := "2.12.8"
version := "1.0.0-SNAPSHOT"
name := "beler"

enablePlugins(ScalaJSPlugin)
enablePlugins(WorkbenchPlugin)

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.6",
  "com.lihaoyi" %%% "scalatags" % "0.6.7",
  "com.lihaoyi" %%% "upickle" % "0.7.4",
  "com.lihaoyi" %%% "utest" % "0.6.7" % "test",
)

testFrameworks += new TestFramework("utest.runner.Framework")
