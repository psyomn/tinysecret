import AssemblyKeys._

assemblySettings

name         := "tinysecret"

version      := "1.0"

scalaVersion := "2.10.0"

libraryDependencies ++= Seq(
  "org.scalatest"           % "scalatest_2.10"     % "1.9.1" % "test",
  "org.scala-lang"          % "scala-swing"        % "2.10.0"
)

exportJars := true

