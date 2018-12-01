package math3d

object Mat4
{
  def apply: Mat4 = Mat4(1)

  def apply(s: Float): Mat4 = Mat4(
    s, 0, 0, 0,
    0, s, 0, 0,
    0, 0, s, 0,
    0, 0, 0, s)

  def apply(m: Mat2): Mat4 = Mat4(
    m.e11, m.e12, 0, 0,
    m.e21, m.e22, 0, 0,
    0, 0, 1, 0,
    0, 0, 0, 1)

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

  def rotateYZ(t: Float): Mat4 =
  {
    val s = Math.sin(t).toFloat
    val c = Math.cos(t).toFloat

    Mat4(
      1, 0, 0, 0,
      0, c, -s, 0,
      0, s, c, 0,
      0, 0, 0, 1)
  }

  def rotateZX(t: Float): Mat4 =
  {
    val s = Math.sin(t).toFloat
    val c = Math.cos(t).toFloat

    Mat4(
      c, 0, s, 0,
      0, 1, 0, 0,
      -s, 0, c, 0,
      0, 0, 0, 1)
  }

  def translate(x: Float, y: Float, z: Float) = Mat4(
    1, 0, 0, x,
    0, 1, 0, y,
    0, 0, 1, z,
    0, 0, 0, 1)

  def translate(v: Vec3): Mat4 = translate(v.x, v.y, v.z)

  def scale(x: Float, y: Float, z: Float) = Mat4(
    x, 0, 0, 0,
    0, y, 0, 0,
    0, 0, z, 0,
    0, 0, 0, 1)

  def scale(v: Vec3): Mat4 = scale(v.x, v.y, v.z)

  def scale(f: Float): Mat4 = scale(f, f, f)

  def perspective(l: Float, r: Float, b: Float, t: Float, n: Float, f: Float): Mat4 =
  {
    val iw = 1 / (r - l)
    val ih = 1 / (t - b)
    val id = 1 / (f - n)

    val x = (r + l) * iw
    val y = (t + b) * ih
    val z = (f * n) * id

    Mat4(
      2 * iw, 0, 0, 0,
      0, 2 * ih, 0, 0,
      x, y, -2 * id, -1,
      0, 0, z, 0)
  }

  def ortho(l: Float, r: Float, b: Float, t: Float, n: Float, f: Float): Mat4 =
  {
    val iw = 1 / (r - l)
    val ih = 1 / (t - b)
    val id = 1 / (f - n)

    val x = (l + r) * iw
    val y = (t + b) * ih
    val z = (f + n) * id

    Mat4(
      2 * iw, 0, 0, y,
      0, 2 * ih, 0, x,
      0, 0, -2 * id, z,
      0, 0, 0, 1)
  }
}

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

  def row(index: Int): Vec4 = index match
  {
    case 0 => Vec4(e11, e12, e13, e14)
    case 1 => Vec4(e21, e22, e23, e24)
    case 2 => Vec4(e31, e32, e33, e34)
    case 3 => Vec4(e41, e42, e43, e44)
    case _ => IndexError(index)
  }

  def col(index: Int): Vec4 = index match
  {
    case 0 => Vec4(e11, e21, e31, e41)
    case 1 => Vec4(e12, e22, e32, e42)
    case 2 => Vec4(e13, e23, e33, e43)
    case 3 => Vec4(e14, e24, e34, e44)
    case _ => IndexError(index)
  }

  def *(m: Mat4) = Mat4(
    row(0) dot m.col(0), row(0) dot m.col(1), row(0) dot m.col(2), row(0) dot m.col(3),
    row(1) dot m.col(0), row(1) dot m.col(1), row(1) dot m.col(2), row(1) dot m.col(3),
    row(2) dot m.col(0), row(2) dot m.col(1), row(2) dot m.col(2), row(2) dot m.col(3),
    row(3) dot m.col(0), row(3) dot m.col(1), row(3) dot m.col(2), row(3) dot m.col(3))

  def det: Float = ???

  def inv: Mat4 = ???
}
