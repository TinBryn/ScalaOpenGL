package math3d

object Mat2
{
  def apply(m: Mat2): Mat2 = Mat2(m.e11, m.e12, m.e21, m.e22)
  def rows(v1: Vec2, v2: Vec2): Mat2 = Mat2(v1.x, v1.y, v2.x, v2.y)
  def apply(s: Float): Mat2 = Mat2(s, 0, 0, s)
  def apply(): Mat2 = Mat2(1)
  def rotate(theta: Float): Mat2 =
  {
    val cos = Math.cos(theta).toFloat
    val sin = Math.sin(theta).toFloat

    Mat2(
      cos, -sin,
      sin, cos)
  }
}

case class Mat2(e11: Float, e12: Float,
                e21: Float, e22: Float)
{
  def toArray = Array(
    e11, e12,
    e21, e22)

  def apply(r: Int, c: Int): Float = row(r)(c)

  def row(r: Int): Vec2 = r match
  {
    case 0 ⇒ Vec2(e11, e12)
    case 1 ⇒ Vec2(e21, e22)
    case _ ⇒ IndexError(r)
  }

  def col(c: Int): Vec2 = c match
  {
    case 0 ⇒ Vec2(e11, e21)
    case 1 ⇒ Vec2(e21, e22)
    case _ ⇒ IndexError(c)
  }

  def mapWith(m: Mat2)(f: (Float, Float) => Float) =
    Mat2(f(e11, m.e11), f(e12, m.e12), f(e21, m.e21), f(e22, m.e22))
  def map(f: Float => Float) =
    Mat2(f(e11), f(e12), f(e21), f(e22))

  //scalar operators
  def +(s: Float) = Mat2(e11 + s, e12 + s, e21 + s, e22 + s)
  def -(s: Float): Mat2 = map(_ - s)
  def *(s: Float): Mat2 = map(_ * s)
  def /(s: Float): Mat2 = map(_ / s)

  //matrix operators
  def +(m: Mat2): Mat2 = mapWith(m)(_ + _)
  def -(m: Mat2): Mat2 = mapWith(m)(_ - _)

  def *(m: Mat2) =
    Mat2(
      e11 * m.e11 + e12 * m.e21, e11 * m.e12 + e12 * m.e22,
      e21 * m.e11 + e22 * m.e21, e21 * m.e12 + e22 * m.e22)

  def *(v: Vec2) =
    Vec2(e11 * v.x + e12 * v.y, e21 * v.x + e22 * v.y)

  def determinant: Float = e11 * e22 - e12 * e21

  def inverse: Mat2 = Mat2(e22, -e21, -e12, e11) / determinant
}
