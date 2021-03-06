package math3d

object Vec4
{
  def apply(s: Float): Vec4 = Vec4(s, s, s, s)
  def apply(v: Vec3, s: Float): Vec4 = Vec4(v.x, v.y, v.z, s)
  def apply(v: Vec2, s: Float, t: Float): Vec4 = Vec4(v.x, v.y, s, t)
}

case class Vec4(x: Float, y: Float, z: Float, w: Float)
{
  def toArray = Array(x, y, z, w)

  def apply(index: Int): Float = index match
  {
    case 0 ⇒ x
    case 1 ⇒ y
    case 2 ⇒ z
    case 3 ⇒ w
    case _ ⇒ IndexError(index)
  }

  //scala operators
  def +(s: Float) = Vec4(x + s, y + s, z + s, w + s)
  def -(s: Float) = Vec4(x - s, y - s, z - s, w - s)
  def *(s: Float) = Vec4(x * s, y * s, z * s, w * s)
  def /(s: Float) = Vec4(x / s, y / s, z / s, w / s)

  //piecewise operators
  def +(v: Vec4) = Vec4(x + v.x, y + v.y, z + v.z, w + v.w)
  def -(v: Vec4) = Vec4(x - v.x, y - v.y, z - v.z, w - v.w)
  def *(v: Vec4) = Vec4(x * v.x, y * v.y, z * v.z, w * v.w)
  def /(v: Vec4) = Vec4(x / v.x, y / v.y, z / v.z, w / v.w)

  def dot(v: Vec4): Float = x * v.x + y * v.y + z * v.z + w * v.w

  //swizzle
  def xx = Vec2(x, x)
  def xy = Vec2(x, y)
  def xz = Vec2(x, z)
  def xw = Vec2(x, w)
  def yx = Vec2(y, x)
  def yy = Vec2(y, y)
  def yz = Vec2(y, z)
  def yw = Vec2(y, w)
  def zx = Vec2(z, x)
  def zy = Vec2(z, y)
  def zz = Vec2(z, z)
  def zw = Vec2(z, w)
  def wx = Vec2(w, x)
  def wy = Vec2(w, y)
  def wz = Vec2(w, z)
  def ww = Vec2(w, w)
  def xxx = Vec3(x, x, x)
  def xxy = Vec3(x, x, y)
  def xxz = Vec3(x, x, z)
  def xxw = Vec3(x, x, w)
  def xyx = Vec3(x, y, x)
  def xyy = Vec3(x, y, y)
  def xyz = Vec3(x, y, z)
  def xyw = Vec3(x, y, w)
  def xzx = Vec3(x, z, x)
  def xzy = Vec3(x, z, y)
  def xzz = Vec3(x, z, z)
  def xzw = Vec3(x, z, w)
  def xwx = Vec3(x, w, x)
  def xwy = Vec3(x, w, y)
  def xwz = Vec3(x, w, z)
  def xww = Vec3(x, w, w)
  def yxx = Vec3(y, x, x)
  def yxy = Vec3(y, x, y)
  def yxz = Vec3(y, x, z)
  def yxw = Vec3(y, x, w)
  def yyx = Vec3(y, y, x)
  def yyy = Vec3(y, y, y)
  def yyz = Vec3(y, y, z)
  def yyw = Vec3(y, y, w)
  def yzx = Vec3(y, z, x)
  def yzy = Vec3(y, z, y)
  def yzz = Vec3(y, z, z)
  def yzw = Vec3(y, z, w)
  def ywx = Vec3(y, w, x)
  def ywy = Vec3(y, w, y)
  def ywz = Vec3(y, w, z)
  def yww = Vec3(y, w, w)
  def zxx = Vec3(z, x, x)
  def zxy = Vec3(z, x, y)
  def zxz = Vec3(z, x, z)
  def zxw = Vec3(z, x, w)
  def zyx = Vec3(z, y, x)
  def zyy = Vec3(z, y, y)
  def zyz = Vec3(z, y, z)
  def zyw = Vec3(z, y, w)
  def zzx = Vec3(z, z, x)
  def zzy = Vec3(z, z, y)
  def zzz = Vec3(z, z, z)
  def zzw = Vec3(z, z, w)
  def zwx = Vec3(z, w, x)
  def zwy = Vec3(z, w, y)
  def zwz = Vec3(z, w, z)
  def zww = Vec3(z, w, w)
  def wxx = Vec3(w, x, x)
  def wxy = Vec3(w, x, y)
  def wxz = Vec3(w, x, z)
  def wxw = Vec3(w, x, w)
  def wyx = Vec3(w, y, x)
  def wyy = Vec3(w, y, y)
  def wyz = Vec3(w, y, z)
  def wyw = Vec3(w, y, w)
  def wzx = Vec3(w, z, x)
  def wzy = Vec3(w, z, y)
  def wzz = Vec3(w, z, z)
  def wzw = Vec3(w, z, w)
  def wwx = Vec3(w, w, x)
  def wwy = Vec3(w, w, y)
  def wwz = Vec3(w, w, z)
  def www = Vec3(w, w, w)
  def xxxx = Vec4(x, x, x, x)
  def xxxy = Vec4(x, x, x, y)
  def xxxz = Vec4(x, x, x, z)
  def xxxw = Vec4(x, x, x, w)
  def xxyx = Vec4(x, x, y, x)
  def xxyy = Vec4(x, x, y, y)
  def xxyz = Vec4(x, x, y, z)
  def xxyw = Vec4(x, x, y, w)
  def xxzx = Vec4(x, x, z, x)
  def xxzy = Vec4(x, x, z, y)
  def xxzz = Vec4(x, x, z, z)
  def xxzw = Vec4(x, x, z, w)
  def xxwx = Vec4(x, x, w, x)
  def xxwy = Vec4(x, x, w, y)
  def xxwz = Vec4(x, x, w, z)
  def xxww = Vec4(x, x, w, w)
  def xyxx = Vec4(x, y, x, x)
  def xyxy = Vec4(x, y, x, y)
  def xyxz = Vec4(x, y, x, z)
  def xyxw = Vec4(x, y, x, w)
  def xyyx = Vec4(x, y, y, x)
  def xyyy = Vec4(x, y, y, y)
  def xyyz = Vec4(x, y, y, z)
  def xyyw = Vec4(x, y, y, w)
  def xyzx = Vec4(x, y, z, x)
  def xyzy = Vec4(x, y, z, y)
  def xyzz = Vec4(x, y, z, z)
  def xyzw = Vec4(x, y, z, w)
  def xywx = Vec4(x, y, w, x)
  def xywy = Vec4(x, y, w, y)
  def xywz = Vec4(x, y, w, z)
  def xyww = Vec4(x, y, w, w)
  def xzxx = Vec4(x, z, x, x)
  def xzxy = Vec4(x, z, x, y)
  def xzxz = Vec4(x, z, x, z)
  def xzxw = Vec4(x, z, x, w)
  def xzyx = Vec4(x, z, y, x)
  def xzyy = Vec4(x, z, y, y)
  def xzyz = Vec4(x, z, y, z)
  def xzyw = Vec4(x, z, y, w)
  def xzzx = Vec4(x, z, z, x)
  def xzzy = Vec4(x, z, z, y)
  def xzzz = Vec4(x, z, z, z)
  def xzzw = Vec4(x, z, z, w)
  def xzwx = Vec4(x, z, w, x)
  def xzwy = Vec4(x, z, w, y)
  def xzwz = Vec4(x, z, w, z)
  def xzww = Vec4(x, z, w, w)
  def xwxx = Vec4(x, w, x, x)
  def xwxy = Vec4(x, w, x, y)
  def xwxz = Vec4(x, w, x, z)
  def xwxw = Vec4(x, w, x, w)
  def xwyx = Vec4(x, w, y, x)
  def xwyy = Vec4(x, w, y, y)
  def xwyz = Vec4(x, w, y, z)
  def xwyw = Vec4(x, w, y, w)
  def xwzx = Vec4(x, w, z, x)
  def xwzy = Vec4(x, w, z, y)
  def xwzz = Vec4(x, w, z, z)
  def xwzw = Vec4(x, w, z, w)
  def xwwx = Vec4(x, w, w, x)
  def xwwy = Vec4(x, w, w, y)
  def xwwz = Vec4(x, w, w, z)
  def xwww = Vec4(x, w, w, w)
  def yxxx = Vec4(y, x, x, x)
  def yxxy = Vec4(y, x, x, y)
  def yxxz = Vec4(y, x, x, z)
  def yxxw = Vec4(y, x, x, w)
  def yxyx = Vec4(y, x, y, x)
  def yxyy = Vec4(y, x, y, y)
  def yxyz = Vec4(y, x, y, z)
  def yxyw = Vec4(y, x, y, w)
  def yxzx = Vec4(y, x, z, x)
  def yxzy = Vec4(y, x, z, y)
  def yxzz = Vec4(y, x, z, z)
  def yxzw = Vec4(y, x, z, w)
  def yxwx = Vec4(y, x, w, x)
  def yxwy = Vec4(y, x, w, y)
  def yxwz = Vec4(y, x, w, z)
  def yxww = Vec4(y, x, w, w)
  def yyxx = Vec4(y, y, x, x)
  def yyxy = Vec4(y, y, x, y)
  def yyxz = Vec4(y, y, x, z)
  def yyxw = Vec4(y, y, x, w)
  def yyyx = Vec4(y, y, y, x)
  def yyyy = Vec4(y, y, y, y)
  def yyyz = Vec4(y, y, y, z)
  def yyyw = Vec4(y, y, y, w)
  def yyzx = Vec4(y, y, z, x)
  def yyzy = Vec4(y, y, z, y)
  def yyzz = Vec4(y, y, z, z)
  def yyzw = Vec4(y, y, z, w)
  def yywx = Vec4(y, y, w, x)
  def yywy = Vec4(y, y, w, y)
  def yywz = Vec4(y, y, w, z)
  def yyww = Vec4(y, y, w, w)
  def yzxx = Vec4(y, z, x, x)
  def yzxy = Vec4(y, z, x, y)
  def yzxz = Vec4(y, z, x, z)
  def yzxw = Vec4(y, z, x, w)
  def yzyx = Vec4(y, z, y, x)
  def yzyy = Vec4(y, z, y, y)
  def yzyz = Vec4(y, z, y, z)
  def yzyw = Vec4(y, z, y, w)
  def yzzx = Vec4(y, z, z, x)
  def yzzy = Vec4(y, z, z, y)
  def yzzz = Vec4(y, z, z, z)
  def yzzw = Vec4(y, z, z, w)
  def yzwx = Vec4(y, z, w, x)
  def yzwy = Vec4(y, z, w, y)
  def yzwz = Vec4(y, z, w, z)
  def yzww = Vec4(y, z, w, w)
  def ywxx = Vec4(y, w, x, x)
  def ywxy = Vec4(y, w, x, y)
  def ywxz = Vec4(y, w, x, z)
  def ywxw = Vec4(y, w, x, w)
  def ywyx = Vec4(y, w, y, x)
  def ywyy = Vec4(y, w, y, y)
  def ywyz = Vec4(y, w, y, z)
  def ywyw = Vec4(y, w, y, w)
  def ywzx = Vec4(y, w, z, x)
  def ywzy = Vec4(y, w, z, y)
  def ywzz = Vec4(y, w, z, z)
  def ywzw = Vec4(y, w, z, w)
  def ywwx = Vec4(y, w, w, x)
  def ywwy = Vec4(y, w, w, y)
  def ywwz = Vec4(y, w, w, z)
  def ywww = Vec4(y, w, w, w)
  def zxxx = Vec4(z, x, x, x)
  def zxxy = Vec4(z, x, x, y)
  def zxxz = Vec4(z, x, x, z)
  def zxxw = Vec4(z, x, x, w)
  def zxyx = Vec4(z, x, y, x)
  def zxyy = Vec4(z, x, y, y)
  def zxyz = Vec4(z, x, y, z)
  def zxyw = Vec4(z, x, y, w)
  def zxzx = Vec4(z, x, z, x)
  def zxzy = Vec4(z, x, z, y)
  def zxzz = Vec4(z, x, z, z)
  def zxzw = Vec4(z, x, z, w)
  def zxwx = Vec4(z, x, w, x)
  def zxwy = Vec4(z, x, w, y)
  def zxwz = Vec4(z, x, w, z)
  def zxww = Vec4(z, x, w, w)
  def zyxx = Vec4(z, y, x, x)
  def zyxy = Vec4(z, y, x, y)
  def zyxz = Vec4(z, y, x, z)
  def zyxw = Vec4(z, y, x, w)
  def zyyx = Vec4(z, y, y, x)
  def zyyy = Vec4(z, y, y, y)
  def zyyz = Vec4(z, y, y, z)
  def zyyw = Vec4(z, y, y, w)
  def zyzx = Vec4(z, y, z, x)
  def zyzy = Vec4(z, y, z, y)
  def zyzz = Vec4(z, y, z, z)
  def zyzw = Vec4(z, y, z, w)
  def zywx = Vec4(z, y, w, x)
  def zywy = Vec4(z, y, w, y)
  def zywz = Vec4(z, y, w, z)
  def zyww = Vec4(z, y, w, w)
  def zzxx = Vec4(z, z, x, x)
  def zzxy = Vec4(z, z, x, y)
  def zzxz = Vec4(z, z, x, z)
  def zzxw = Vec4(z, z, x, w)
  def zzyx = Vec4(z, z, y, x)
  def zzyy = Vec4(z, z, y, y)
  def zzyz = Vec4(z, z, y, z)
  def zzyw = Vec4(z, z, y, w)
  def zzzx = Vec4(z, z, z, x)
  def zzzy = Vec4(z, z, z, y)
  def zzzz = Vec4(z, z, z, z)
  def zzzw = Vec4(z, z, z, w)
  def zzwx = Vec4(z, z, w, x)
  def zzwy = Vec4(z, z, w, y)
  def zzwz = Vec4(z, z, w, z)
  def zzww = Vec4(z, z, w, w)
  def zwxx = Vec4(z, w, x, x)
  def zwxy = Vec4(z, w, x, y)
  def zwxz = Vec4(z, w, x, z)
  def zwxw = Vec4(z, w, x, w)
  def zwyx = Vec4(z, w, y, x)
  def zwyy = Vec4(z, w, y, y)
  def zwyz = Vec4(z, w, y, z)
  def zwyw = Vec4(z, w, y, w)
  def zwzx = Vec4(z, w, z, x)
  def zwzy = Vec4(z, w, z, y)
  def zwzz = Vec4(z, w, z, z)
  def zwzw = Vec4(z, w, z, w)
  def zwwx = Vec4(z, w, w, x)
  def zwwy = Vec4(z, w, w, y)
  def zwwz = Vec4(z, w, w, z)
  def zwww = Vec4(z, w, w, w)
  def wxxx = Vec4(w, x, x, x)
  def wxxy = Vec4(w, x, x, y)
  def wxxz = Vec4(w, x, x, z)
  def wxxw = Vec4(w, x, x, w)
  def wxyx = Vec4(w, x, y, x)
  def wxyy = Vec4(w, x, y, y)
  def wxyz = Vec4(w, x, y, z)
  def wxyw = Vec4(w, x, y, w)
  def wxzx = Vec4(w, x, z, x)
  def wxzy = Vec4(w, x, z, y)
  def wxzz = Vec4(w, x, z, z)
  def wxzw = Vec4(w, x, z, w)
  def wxwx = Vec4(w, x, w, x)
  def wxwy = Vec4(w, x, w, y)
  def wxwz = Vec4(w, x, w, z)
  def wxww = Vec4(w, x, w, w)
  def wyxx = Vec4(w, y, x, x)
  def wyxy = Vec4(w, y, x, y)
  def wyxz = Vec4(w, y, x, z)
  def wyxw = Vec4(w, y, x, w)
  def wyyx = Vec4(w, y, y, x)
  def wyyy = Vec4(w, y, y, y)
  def wyyz = Vec4(w, y, y, z)
  def wyyw = Vec4(w, y, y, w)
  def wyzx = Vec4(w, y, z, x)
  def wyzy = Vec4(w, y, z, y)
  def wyzz = Vec4(w, y, z, z)
  def wyzw = Vec4(w, y, z, w)
  def wywx = Vec4(w, y, w, x)
  def wywy = Vec4(w, y, w, y)
  def wywz = Vec4(w, y, w, z)
  def wyww = Vec4(w, y, w, w)
  def wzxx = Vec4(w, z, x, x)
  def wzxy = Vec4(w, z, x, y)
  def wzxz = Vec4(w, z, x, z)
  def wzxw = Vec4(w, z, x, w)
  def wzyx = Vec4(w, z, y, x)
  def wzyy = Vec4(w, z, y, y)
  def wzyz = Vec4(w, z, y, z)
  def wzyw = Vec4(w, z, y, w)
  def wzzx = Vec4(w, z, z, x)
  def wzzy = Vec4(w, z, z, y)
  def wzzz = Vec4(w, z, z, z)
  def wzzw = Vec4(w, z, z, w)
  def wzwx = Vec4(w, z, w, x)
  def wzwy = Vec4(w, z, w, y)
  def wzwz = Vec4(w, z, w, z)
  def wzww = Vec4(w, z, w, w)
  def wwxx = Vec4(w, w, x, x)
  def wwxy = Vec4(w, w, x, y)
  def wwxz = Vec4(w, w, x, z)
  def wwxw = Vec4(w, w, x, w)
  def wwyx = Vec4(w, w, y, x)
  def wwyy = Vec4(w, w, y, y)
  def wwyz = Vec4(w, w, y, z)
  def wwyw = Vec4(w, w, y, w)
  def wwzx = Vec4(w, w, z, x)
  def wwzy = Vec4(w, w, z, y)
  def wwzz = Vec4(w, w, z, z)
  def wwzw = Vec4(w, w, z, w)
  def wwwx = Vec4(w, w, w, x)
  def wwwy = Vec4(w, w, w, y)
  def wwwz = Vec4(w, w, w, z)
  def wwww = Vec4(w, w, w, w)
}
