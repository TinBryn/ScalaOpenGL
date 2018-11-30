package engine

import java.nio.FloatBuffer

import math3d.{Mat4, Vec3}
import org.lwjgl.BufferUtils
import org.lwjgl.opengl.{GL11, GL15, GL20, GL30}

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
      Vec3(-0.433f, -0.25f, 0.0f),
      Vec3(0.433f, -0.25f, 0.0f),
      Vec3(0.0f, 0.5f, 0.0f)).map(_ * 1.5f).flatMap(v => v.toArray)

    val vBuff: FloatBuffer = BufferUtils.createFloatBuffer(verticies.length)
    vBuff.put(verticies).flip()

    GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vBuff, GL15.GL_STATIC_DRAW)

    GL20.glEnableVertexAttribArray(0)

    val position_location = GL20.glGetAttribLocation(program.id, "position")

    GL20.glVertexAttribPointer(position_location, 3, GL11.GL_FLOAT, false, 0, 0)

    VBO
  }

  private var MVP = Mat4(1)

  private var theta = 0f

  def update(): Unit =
  {
    theta += 0.01f
    MVP = Mat4.rotateXY(theta)
  }

  val MVP_location: Int = GL20.glGetUniformLocation(program.id, "MVP")

  override def setup(): Unit =
  {
    GL30.glBindVertexArray(VAO)
    GL20.glEnableVertexAttribArray(0)

    GL20.glUniformMatrix4fv(MVP_location, false, MVP.toArray)
  }

  override def draw(): Unit = GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, 3)
}
