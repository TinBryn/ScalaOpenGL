package math3d

object Mat3
{
  def apply(m: Mat4): Mat3 = Mat3(
    m.e11, m.e12, m.e13,
    m.e21, m.e22, m.e23,
    m.e31, m.e32, m.e33)

  def apply(m: Mat3): Mat3 = Mat3(
    m.e11, m.e12, m.e13,
    m.e21, m.e22, m.e23,
    m.e31, m.e32, m.e33)

  def apply(m: Mat2): Mat3 = Mat3(
    m.e11, m.e12, 0,
    m.e21, m.e22, 0,
    0, 0, 1)

  def apply(q: Quat): Mat3 = Mat3.rows(
    q rot Vec3(1, 0, 0),
    q rot Vec3(0, 1, 0),
    q rot Vec3(0, 0, 1))

  def rows(v: Vec3, u: Vec3, w: Vec3): Mat3 = Mat3(
    v.x, v.y, v.z,
    u.x, u.y, u.z,
    w.x, w.y, w.z)

  def cols(v: Vec3, u: Vec3, w: Vec3): Mat3 = Mat3(
    v.x, u.x, w.x,
    v.y, u.y, w.y,
    v.z, u.z, w.z)

  def rotateXY(t: Float): Mat3 =
  {
    val s = Math.cos(t).toFloat
    val c = Math.cos(t).toFloat

    Mat3(
      c, -s, 0,
      s, c, 0,
      0, 0, 1)
  }

  def rotateYZ(t: Float): Mat3 =
  {
    val s = Math.cos(t).toFloat
    val c = Math.cos(t).toFloat

    Mat3(
      1, 0, 0,
      0, c, -s,
      0, s, c)
  }

  def rotateZX(t: Float): Mat3 =
  {
    val s = Math.cos(t).toFloat
    val c = Math.cos(t).toFloat

    Mat3(
      c, 0, s,
      0, 1, 0,
      -s, 0, c)
  }
}

case class Mat3(e11: Float, e12: Float, e13: Float,
                e21: Float, e22: Float, e23: Float,
                e31: Float, e32: Float, e33: Float)
{
  def toArray = Array(
    e11, e12, e13,
    e21, e22, e23,
    e31, e32, e33)

  def row(r: Int): Vec3 = r match
  {
    case 0 ⇒ Vec3(e11, e12, e13)
    case 1 ⇒ Vec3(e21, e22, e23)
    case 2 ⇒ Vec3(e31, e32, e33)
    case _ ⇒ IndexError(r)
  }

  def col(c: Int): Vec3 = c match
  {
    case 0 ⇒ Vec3(e11, e21, e31)
    case 1 ⇒ Vec3(e12, e22, e32)
    case 2 ⇒ Vec3(e13, e23, e33)
    case _ ⇒ IndexError(c)
  }

  def apply(r: Int, c: Int): Float = row(r)(c)
}
