name := """reactive-rabbit-mq-sample"""

version := "1.0"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  "io.scalac" %% "reactive-rabbit" % "0.2.2",
  "com.typesafe.akka" %% "akka-stream-experimental" % "0.11",
  "org.scalatest" %% "scalatest" % "2.1.6" % "test"
)