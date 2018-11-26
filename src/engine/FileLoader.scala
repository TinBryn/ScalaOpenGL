package engine

import scala.io.Source

object FileLoader
{
  def load(filename: String): String =
  {
    Source.fromFile(filename).mkString("")
  }
}
