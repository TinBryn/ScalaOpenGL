package engine

import java.nio.FloatBuffer

import math3d.{Mat4, Vec3}
import org.lwjgl.BufferUtils
import org.lwjgl.opengl.{GL11, GL15, GL20, GL30}

object Triangle
{
  val projection: Mat4 = Mat4(
    1, 0, 0, 0,
    0, 1, 0, 0,
    0, 0, 1, 1,
    0, 0, 0, 1)
}

case class Triangle(program: Program) extends Model
{
  private val VAO: Int = GL30.glGenVertexArrays()

  GL30.glBindVertexArray(VAO)

  private val VBO: Int = init()

  private def init(): Int =
  {
    val VBO: Int = GL15.glGenBuffers()

    GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, VBO)

    val verticies = Array(
      Vec3(-0.75f, -0.433f, 0.5f),
      Vec3(-0.75f, -0.433f, 0.5f),
      Vec3(0.75f, -0.433f, 0.5f),
      Vec3(0.75f, -0.433f, 0.5f),
      Vec3(0.0f, 0.866f, 0.5f),
      Vec3(0.0f, 0.866f, 0.5f))
      .flatMap(v => v.toArray)

    val vBuff: FloatBuffer = BufferUtils.createFloatBuffer(verticies.length)
    vBuff.put(verticies).flip()

    GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vBuff, GL15.GL_STATIC_DRAW)

    val position_location = GL20.glGetAttribLocation(program.id, "position")
    val normal_location = GL20.glGetAttribLocation(program.id, "normal")

    GL20.glEnableVertexAttribArray(position_location)
    GL20.glVertexAttribPointer(position_location, 3, GL11.GL_FLOAT, false, 24, 0)

    GL20.glEnableVertexAttribArray(normal_location)
    GL20.glVertexAttribPointer(normal_location, 3, GL11.GL_FLOAT, false, 24, 12)

    VBO
  }

  private var modelView = Mat4(1)

  private var theta = 0f

  def update(): Unit =
  {
    theta += 0.01f
    modelView = Mat4.rotateXY(theta)
  }

  val modelView_location: Int = GL20.glGetUniformLocation(program.id, "modelView")
  val projection_location: Int = GL20.glGetUniformLocation(program.id, "projection")

  println(Triangle.projection)

  override def setup(): Unit =
  {
    GL30.glBindVertexArray(VAO)
    GL20.glEnableVertexAttribArray(0)

    GL20.glUniformMatrix4fv(modelView_location, false, modelView.toArray)
    GL20.glUniformMatrix4fv(projection_location, true, Triangle.projection.toArray)
  }

  override def draw(): Unit = GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, 3)
}
