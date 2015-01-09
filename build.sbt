// https://github.com/hierynomus/sshj/issues/153
name := "sshj_153"

version := "0.0.0"

scalaVersion := "2.11.5"

crossScalaVersions := Seq("2.11.5")

crossVersion := CrossVersion.binary

resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/")

libraryDependencies ++= Seq(
  "net.schmizz" % "sshj" % "0.10.0" % "compile",
  "org.bouncycastle" % "bcpkix-jdk15on" % "1.51",
  "ch.qos.logback" % "logback-classic" % "1.1.2",
  "ch.qos.logback" % "logback-core" % "1.1.2",
  "org.scalatest" %% "scalatest" % "2.2.3" % "test"
)
