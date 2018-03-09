package io.kpritam.sbt.sbtzip

import sbt._

trait ZipKeys {
  lazy val sourceZipDir = settingKey[File]("source directory to generate zip from.")
  lazy val targetZipDir = settingKey[File]("target directory to store generated zip.")
  lazy val zip = taskKey[Unit]("Generates zip file which includes all files from sourceZipDir")
}
