package math3d

case class Vec2f(x: Float, y: Float)
{
  def toArray: Array[Float] = Array(x, y)

  //index
  def apply(index: Int): Float = index match
  {
    case 0 => x
    case 1 => y
    case _ => IndexError(index)
  }

  //swizzle
  def xx = Vec2f(x, x)
  def xy = Vec2f(x, y)
  def yx = Vec2f(y, x)
  def yy = Vec2f(y, y)

  //scala operators
  def +(s: Float) = Vec2f(x + s, y + s)
  def -(s: Float) = Vec2f(x - s, y - s)
  def *(s: Float) = Vec2f(x * s, y * s)
  def /(s: Float) = Vec2f(x / s, y / s)

  //piecewise operators
  def +(v: Vec2f) = Vec2f(x + v.x, y + v.y)
  def -(v: Vec2f) = Vec2f(x - v.x, y - v.y)
  def *(v: Vec2f) = Vec2f(x * v.x, y * v.y)
  def /(v: Vec2f) = Vec2f(x / v.x, y / v.y)

  def dot(v: Vec2f): Float = x * v.x + y * v.y
  def mag: Float = Math.sqrt(this dot this).toFloat

  //unary operators
  def unary_- = Vec2f(-x, -y)
}

object Vec2f
{
  def apply(s: Float): Vec2f = Vec2f(s, s)
}
