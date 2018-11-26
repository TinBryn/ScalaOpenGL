package engine

import java.nio.FloatBuffer

import org.lwjgl.BufferUtils
import org.lwjgl.opengl.{GL11, GL15, GL20, GL30}
import subspace.Vector3

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
      Vector3(-0.433f, -0.25f, 0.0f),
      Vector3(0.433f, -0.25f, 0.0f),
      Vector3(0.0f, 0.5f, 0.0f)).flatMap(_.toArray)

    println(verticies.toList)

    val vBuff: FloatBuffer = BufferUtils.createFloatBuffer(verticies.length)
    vBuff.put(verticies).flip()

    GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vBuff, GL15.GL_STATIC_DRAW)

    GL20.glEnableVertexAttribArray(0)

    val position_location = GL20.glGetAttribLocation(program.id, "position")

    GL20.glVertexAttribPointer(position_location, 3, GL11.GL_FLOAT, false, 0, 0)

    VBO
  }

  var MVP: Array[Float] =
    Array(
      1,0,0,0,
      0,1,0,0,
      0,0,1,0,
      0,0,0,1)

  def update(): Unit =
  {

  }

  val MVP_location: Int = GL20.glGetUniformLocation(program.id, "MVP")

  override def setup(): Unit =
  {
    GL30.glBindVertexArray(VAO)
    GL20.glEnableVertexAttribArray(0)

    GL20.glUniformMatrix4fv(MVP_location, false, MVP.toList.toArray)
  }

  override def draw(): Unit = GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, 3)
}