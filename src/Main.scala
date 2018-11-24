object Main
{

  import engine.Window._

  def main(args: Array[String]): Unit =
  {
    val window: Long = open()
    setupWindowOpenGLContext(window)

    while (shouldLoop(window))
    {

      poll()
    }
  }
}
