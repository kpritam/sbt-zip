import sbtzip.ZipPlugin

lazy val root = (project in file("."))
    .enablePlugins(ZipPlugin)
  .settings(
    scalaVersion := "2.12.4",
    version := "0.1",
    sourceZipDir := crossTarget.value,
    scriptedBufferLog := false
  )