package engine

import math3d.{Mat4, Vec3}
import org.lwjgl.BufferUtils
import org.lwjgl.opengl.{GL11, GL15, GL20, GL30}

object Cube
{
  val projection: Mat4 = Mat4.perspective(-1, 1, -1, 1, 1, 100)

//  val projection: Mat4 = Mat4(
//    1, 0, 0, 0,
//    0, 1, 0, 0,
//    0, 0, 1, 0,
//    0, 0, 0, 1)
}

case class Cube(program: Program) extends Model
{
  private val vao = GL30.glGenVertexArrays()
  GL30.glBindVertexArray(vao)
  val (vbo: Int, size: Int) = init()

  private def init(): (Int, Int) =
  {
    val VBO = GL15.glGenBuffers()
    GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, VBO)
    val data = loadOBJ.flatMap(v => v.toArray)
    val buffer = BufferUtils.createFloatBuffer(data.length)
    buffer.put(data).flip()

    GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW)

    val position_location = GL20.glGetAttribLocation(program.id, "position")
    val normal_location = GL20.glGetAttribLocation(program.id, "normal")

    GL20.glEnableVertexAttribArray(position_location)
    GL20.glVertexAttribPointer(position_location, 3, GL11.GL_FLOAT, false, 24, 0)

    GL20.glEnableVertexAttribArray(normal_location)
    GL20.glVertexAttribPointer(normal_location, 3, GL11.GL_FLOAT, false, 24, 12)

    (VBO, data.length / 6)
  }

  private var modelView = Mat4(1)

  private var thetaXY = 0f
  private var thetaYZ = 0f
  private var thetaZX = 0f

  def update(): Unit =
  {
    thetaXY += 0.01f
    thetaYZ += 0.0161833f
    thetaZX += 0.0061833f
    modelView = Mat4.translate(0, 0, 5) *
                Mat4.rotateYZ(thetaYZ) * Mat4.rotateXY(thetaXY) * Mat4.rotateZX(thetaZX) * Mat4.scale(1) * Mat4.translate(0, -1, 0)
  }

  val modelView_location: Int = GL20.glGetUniformLocation(program.id, "modelView")
  val projection_location: Int = GL20.glGetUniformLocation(program.id, "projection")

  def loadOBJ: Array[Vec3] =
  {
    OBJParser.parse(FileLoader.loadList("models/teapot.obj"))
  }

  override def setup(): Unit =
  {
    GL30.glBindVertexArray(vao)
    GL20.glEnableVertexAttribArray(0)

    GL20.glUniformMatrix4fv(modelView_location, false, modelView.toArray)
    GL20.glUniformMatrix4fv(projection_location, false, Cube.projection.toArray)
  }

  override def draw(): Unit = GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, size)
}
