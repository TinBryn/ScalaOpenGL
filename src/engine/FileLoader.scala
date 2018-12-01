package engine

import scala.io.Source

object FileLoader
{
  def loadAll(filename: String): String =
  {
    Source.fromFile(filename).mkString("")
  }

  def loadList(filename: String): List[String] =
  {
    Source.fromFile(filename).getLines().toList
  }
}
