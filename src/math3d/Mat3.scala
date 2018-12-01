package math3d

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
