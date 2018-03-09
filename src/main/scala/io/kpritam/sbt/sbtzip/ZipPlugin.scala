package io.kpritam.sbt.sbtzip

import java.io.File

import sbt.Keys.target
import sbt._
import sbt.io.{IO, Path}

object ZipPlugin extends AutoPlugin {
  override val trigger: PluginTrigger = noTrigger

  override val requires: Plugins = plugins.JvmPlugin

  object autoImport extends ZipKeys
  import autoImport._

  override lazy val projectSettings: Seq[Setting[_]] = Seq(
    targetZipDir := target.value / "zip",
    zip := zipTask.value
  )

  private def zipTask =  Def.task {
    lazy val zip = new File(targetZipDir.value, sourceZipDir.value.getName + ".zip")
    IO.zip(Path.allSubpaths(sourceZipDir.value), zip)
    zip
  }

}
