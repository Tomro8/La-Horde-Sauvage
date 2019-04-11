name := "Projet"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "org.apache.kafka" %% "kafka" % "2.1.0"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3" % Runtime
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.0"
libraryDependencies += "org.apache.spark" %% "spark-unsafe" % "2.4.0"
