package sbtzip

import java.io.File

import sbt.Keys.{sLog, target}
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
    val log = sLog.value
    lazy val zip = new File(targetZipDir.value, sourceZipDir.value.getName + ".zip")

    log.info("Zipping file...")
    IO.zip(Path.allSubpaths(sourceZipDir.value), zip)
    zip
  }
}
