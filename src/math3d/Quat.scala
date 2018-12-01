package math3d

object Quat
{
  def apply(r: Float, v: Vec3): Quat = Quat(r, v.x, v.y, v.z)
  def axisAngle(angle: Float, axis: Vec3): Quat =
  {
    val s = Math.sin(angle / 2).toFloat
    val c = Math.cos(angle / 2).toFloat

    Quat(c, axis * s)
  }
}

case class Quat(r: Float, x: Float, y: Float, z: Float)
{
  def +(q: Quat) = Quat(r + q.r, x + q.x, y + q.y, z + q.z)
  def -(q: Quat) = Quat(r - q.r, x - q.x, y - q.y, z - q.z)
  def *(s: Float) = Quat(r * s, x * s, y * s, z * s)
  def /(s: Float) = Quat(r / s, x / s, y / s, z / s)
  def *(q: Quat) = Quat(r * q.r - (im dot q.im), q.im * r + im * q.r + (im cross q.im))
  def conj = Quat(r, -x, -y, -z)
  def re: Float = r
  def im: Vec3 = Vec3(x, y, z)
  def norm: Float = r * r + x * x + y * y + z * z
  def inv: Quat = conj / norm

  def rot(v: Vec3): Vec3 = (this * Quat(0, v) * this.inv).im
}
