package engine

import org.lwjgl.glfw._
import GLFW._
import org.lwjgl.opengl._

object Window
{
  private val NULL = 0
  def open(width: Int = 480, height: Int = 320): Long =
  {
    GLFWErrorCallback.createPrint(System.err)

    if (!glfwInit())
      throw new RuntimeException("Failed to initialize glfw")

    glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3)
    glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3)
    glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE)
    glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)

    val window = glfwCreateWindow(width, height, "window", NULL, NULL)

    if (window == 0)
      throw new RuntimeException("Failed to create glfw window")

    glfwSetKeyCallback(window, keyboardCallback)
    glfwSetFramebufferSizeCallback(window, frameBufferCallback)
    glfwSwapInterval(1)

    window
  }

  def setupWindowOpenGLContext(window: Long): Unit =
  {
    glfwMakeContextCurrent(window)
    GL.createCapabilities()
    glfwShowWindow(window)
  }

  private def keyboardCallback(window: Long, key: Int, code: Int, action: Int, mods: Int): Unit =
  {
    if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS)
      glfwSetWindowShouldClose(window, true)
  }

  private def frameBufferCallback(window: Long, width: Int, height: Int): Unit =
  {
    GL11.glViewport(0, 0, width, height)
  }

  def shouldLoop(window: Long): Boolean = !glfwWindowShouldClose(window)

  def poll(): Unit = glfwPollEvents()

  def swapBuffers(window: Long): Unit = glfwSwapBuffers(window)

  def cleanUp(): Unit = glfwTerminate()
}
