package engine

import org.lwjgl.opengl.{GL11, GL15, GL20}

object Shaders
{
  private def makeShader(source: String, enum: Int): Shader =
  {
    val id = GL20.glCreateShader(enum)

    GL20.glShaderSource(id, source)
    GL20.glCompileShader(id)
    if (GL20.glGetShaderi(id, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE)
    {
      GLError(GL20.glGetShaderInfoLog(id))
    }

    Shader(id)
  }

  def makeVertexShader(source: String): Shader = makeShader(source, GL20.GL_VERTEX_SHADER)

  def makeFragmentShader(source: String): Shader = makeShader(source, GL20.GL_FRAGMENT_SHADER)

  def makeProgram(shaders: Shader*): Program =
  {
    val id = GL20.glCreateProgram()

    shaders.foreach(s => GL20.glAttachShader(id, s.id))

    GL20.glLinkProgram(id)
    if (GL20.glGetProgrami(id, GL20.GL_LINK_STATUS) == GL11.GL_FALSE)
    {
      GLError(GL20.glGetProgramInfoLog(id))
    }
    GL20.glValidateProgram(id)
    if (GL20.glGetProgrami(id, GL20.GL_VALIDATE_STATUS) == GL11.GL_FALSE)
    {
      GLError(GL20.glGetProgramInfoLog(id))
    }

    shaders.foreach(s =>
    {
      GL20.glDetachShader(id, s.id)
      GL20.glDeleteShader(s.id)
    })

    Program(id)
  }
}
