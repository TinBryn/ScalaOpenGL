import engine._

object Main
{

  import Window._
  import org.lwjgl.opengl._

  def main(args: Array[String]): Unit =
  {
    val window: Long = open(800, 800)
    setupWindowOpenGLContext(window)

    GL11.glEnable(GL11.GL_DEPTH_TEST)
    GL11.glClearColor(0.2f, 0.3f, 0.3f, 1.0f)

    val vertexShader = Shaders.makeVertexShader(FileLoader.loadAll("shaders/basic.vert"))
    val fragmentShader = Shaders.makeFragmentShader(FileLoader.loadAll("shaders/basic.frag"))

    val program = Shaders.makeProgram(vertexShader, fragmentShader)

    GL20.glUseProgram(program.id)

    val triangle = Cube(program)


    while (shouldLoop(window))
    {
      GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT)
      triangle.update()
      triangle.setup()
      triangle.draw()
      swapBuffers(window)
      poll()
    }
    cleanUp()
  }
}
