object Main
{

  import engine.Window._
  import org.lwjgl.opengl._

  def main(args: Array[String]): Unit =
  {
    val window: Long = open()
    setupWindowOpenGLContext(window)

    GL11.glClearColor(0.2f, 0.3f, 0.4f, 1.0f)

    while (shouldLoop(window))
    {
      GL11.glClear(GL11.GL_COLOR_BUFFER_BIT)
      swapBuffers(window)
      poll()
    }
  }
}
