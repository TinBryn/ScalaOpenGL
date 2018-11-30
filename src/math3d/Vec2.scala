package math3d

object Vec2
{
  def apply(s: Float): Vec2 = Vec2(s, s)
}

case class Vec2(x: Float, y: Float)
{
  def toArray: Array[Float] = Array(x, y)

  //index
  def apply(index: Int): Float = index match
  {
    case 0 => x
    case 1 => y
    case _ => IndexError(index)
  }

  //scala operators
  def +(s: Float) = Vec2(x + s, y + s)
  def -(s: Float) = Vec2(x - s, y - s)
  def *(s: Float) = Vec2(x * s, y * s)
  def /(s: Float) = Vec2(x / s, y / s)

  //piecewise operators
  def +(v: Vec2) = Vec2(x + v.x, y + v.y)
  def -(v: Vec2) = Vec2(x - v.x, y - v.y)
  def *(v: Vec2) = Vec2(x * v.x, y * v.y)
  def /(v: Vec2) = Vec2(x / v.x, y / v.y)

  def dot(v: Vec2): Float = x * v.x + y * v.y
  def mag: Float = Math.sqrt(this dot this).toFloat

  //unary operators
  def unary_- = Vec2(-x, -y)

  //swizzle
  def xx = Vec2(x, x)
  def xy = Vec2(x, y)
  def yx = Vec2(y, x)
  def yy = Vec2(y, y)
  def xxx = Vec3(x, x, x)
  def xxy = Vec3(x, x, y)
  def xyx = Vec3(x, y, x)
  def xyy = Vec3(x, y, y)
  def yxx = Vec3(y, x, x)
  def yxy = Vec3(y, x, y)
  def yyx = Vec3(y, y, x)
  def yyy = Vec3(y, y, y)
  def xxxx = Vec4(x, x, x, x)
  def xxxy = Vec4(x, x, x, y)
  def xxyx = Vec4(x, x, y, x)
  def xxyy = Vec4(x, x, y, y)
  def xyxx = Vec4(x, y, x, x)
  def xyxy = Vec4(x, y, x, y)
  def xyyx = Vec4(x, y, y, x)
  def xyyy = Vec4(x, y, y, y)
  def yxxx = Vec4(y, x, x, x)
  def yxxy = Vec4(y, x, x, y)
  def yxyx = Vec4(y, x, y, x)
  def yxyy = Vec4(y, x, y, y)
  def yyxx = Vec4(y, y, x, x)
  def yyxy = Vec4(y, y, x, y)
  def yyyx = Vec4(y, y, y, x)
  def yyyy = Vec4(y, y, y, y)
}
