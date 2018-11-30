package math3d

case class Mat4(e11: Float, e12: Float, e13: Float, e14: Float,
                e21: Float, e22: Float, e23: Float, e24: Float,
                e31: Float, e32: Float, e33: Float, e34: Float,
                e41: Float, e42: Float, e43: Float, e44: Float)
{
  def toArray = Array(
    e11, e12, e13, e14,
    e21, e22, e23, e24,
    e31, e32, e33, e34,
    e41, e42, e43, e44)
}

object Mat4
{
  def apply(s: Float): Mat4 = Mat4(
    s, 0, 0, 0,
    0, s, 0, 0,
    0, 0, s, 0,
    0, 0, 0, s)

  def rotateXY(t: Float): Mat4 =
  {
    val s = Math.sin(t).toFloat
    val c = Math.cos(t).toFloat

    Mat4(
      c, -s, 0, 0,
      s, c, 0, 0,
      0, 0, 1, 0,
      0, 0, 0, 1)
  }
}
