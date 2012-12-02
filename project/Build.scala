import sbt._
import Keys._

object OpenplexusLogging extends Build {

  lazy val projectSettings = Defaults.defaultSettings ++ Seq(
    name := "scardf",
    version := "0.7-SNAPSHOT",
    organization := "net.croz.scardf",
    scalaVersion := "2.10.0-RC3",
    fork in run := true,
    libraryDependencies += Dependency.libJodaTime,
    libraryDependencies += Dependency.libJenaARQ,
    libraryDependencies += Dependency.libJenaCore,
    libraryDependencies += Dependency.libLogging,
    libraryDependencies += Dependency.libSpecs2,
    resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
      "releases"  at "http://oss.sonatype.org/content/repositories/releases")
  )

  lazy val root = Project(id = "root", base = file("."), settings = projectSettings)
}


object Dependency {
  val libJodaTime = "joda-time" % "joda-time" % "1.6" withSources() withJavadoc()
  val libJenaARQ = "org.apache.jena" % "jena-arq" % "2.9.4" withSources() withJavadoc()
  val libJenaCore = "org.apache.jena" % "jena-core" % "2.7.4" withSources() withJavadoc()
  val libLogging = "commons-logging" % "commons-logging-api" % "1.1"
  val libSpecs2 = "org.specs2" %% "specs2" % "1.12.4-SNAPSHOT" % "test" withSources()
}
