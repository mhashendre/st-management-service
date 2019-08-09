name := """studentservice"""
organization := "com.cinglevue"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.3"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-deprecation", "-Xlint")

lazy val root = (project in file(".")).enablePlugins(PlayJava)

libraryDependencies += guice
libraryDependencies += ehcache
libraryDependencies += ws
libraryDependencies += "org.webjars" % "bootstrap" % "2.3.2"
libraryDependencies += "org.webjars" % "flot" % "0.8.3"
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.0"

libraryDependencies ++= Seq(
  "com.googlecode.json-simple" % "json-simple" % "1.1.1",
  "com.google.inject" % "guice" % "4.1.0",
  "org.apache.poi" % "poi" % "3.8",
  "org.apache.poi" % "poi-ooxml" % "3.9",
  "org.mongodb" % "mongo-java-driver" % "3.0.1",
  "org.mongodb.morphia" % "morphia" % "1.3.2",
  "commons-io" % "commons-io" % "2.4",
  "org.apache.commons" % "commons-lang3" % "3.6",
  "org.apache.commons" % "commons-text" % "1.4"
)


libraryDependencies += "org.assertj" % "assertj-core" % "3.8.0" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "3.0.0" % Test

//LessKeys.compress := true



// Compile the project before generating Eclipse files, so that generated .scala or .class files for views and routes are present
EclipseKeys.preTasks := Seq(compile in Compile, compile in Test)
