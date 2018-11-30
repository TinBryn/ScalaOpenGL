package math3d

case class Mat2x2f(e00: Float, e01: Float, e10: Float, e11: Float)
{
  def toArray = Array(
    e00, e01,
    e10, e11)

  def array(c: Int, r: Int): Float = (c, r) match
  {
    case (0, 0) => e00
    case (0, 1) => e01
    case (1, 0) => e10
    case (1, 1) => e11
    case _ => IndexError((c, r))
  }

  def mapWith(m: Mat2x2f)(f: (Float, Float) => Float) =
    Mat2x2f(f(e00, m.e00), f(e01, m.e01), f(e10, m.e10), f(e11, m.e11))
  def map(f: Float => Float) =
    Mat2x2f(f(e00), f(e01), f(e10), f(e11))

  //scalar operators
  def +(s: Float): Mat2x2f = map(_ + s)
  def -(s: Float): Mat2x2f = map(_ - s)
  def *(s: Float): Mat2x2f = map(_ * s)
  def /(s: Float): Mat2x2f = map(_ / s)

  //matrix operators
  def +(m: Mat2x2f): Mat2x2f = mapWith(m)(_ + _)
  def -(m: Mat2x2f): Mat2x2f = mapWith(m)(_ - _)

  def *(m: Mat2x2f) =
    Mat2x2f(
      e00 * m.e00 + e01 * m.e10, e00 * m.e01 + e01 * m.e11,
      e10 * m.e00 + e11 * m.e10, e10 * m.e01 + e11 * m.e11)

  def *(v: Vec2) =
    Vec2(e00 * v.x + e01 * v.y, e10 * v.x + e11 * v.y)

  def determinant: Float = e00 * e11 - e01 * e10

  def inverse: Mat2x2f = Mat2x2f(e11, -e10, -e01, e00) / determinant
}

object Mat2x2f
{
  def apply(m: Mat2x2f): Mat2x2f = Mat2x2f(m.e00, m.e01, m.e10, m.e11)
  def apply(v1: Vec2, v2: Vec2): Mat2x2f = Mat2x2f(v1.x, v1.y, v2.x, v2.y)
  def apply(s: Float): Mat2x2f = Mat2x2f(s, 0, 0, s)
  def apply(): Mat2x2f = Mat2x2f(1, 0, 0, 1)
  def rotate(theta: Float): Mat2x2f =
  {
    val cos = Math.cos(theta).toFloat
    val sin = Math.sin(theta).toFloat

    Mat2x2f(cos, -sin, sin, cos)
  }
}
