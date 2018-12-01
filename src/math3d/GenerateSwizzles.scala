package math3d

object GenerateSwizzles
{
  def generate(elements: List[Char]): List[String] =
  {
    (for(a ← elements; b ← elements)
      yield genSwizzle(a, b)) ++
      (for(a ← elements; b ← elements; c ← elements)
      yield genSwizzle(a, b, c)) ++
      (for(a ← elements; b ← elements; c ← elements; d ← elements)
        yield genSwizzle(a, b, c, d))
  }

  def main(args: Array[String]): Unit =
  {
    println("//swizzle")
    println(generate(List('x', 'y')).mkString("\n"))
    println("\n\n//swizzle")
    println(generate(List('x', 'y', 'z')).mkString("\n"))
    println("\n\n//swizzle")
    println(generate(List('x', 'y', 'z', 'w')).mkString("\n"))

  }

  def genSwizzle(a: Char, b: Char) =
    s"def $a$b = Vec2($a, $b)"
  def genSwizzle(a: Char, b: Char, c: Char) =
    s"def $a$b$c = Vec3($a, $b, $c)"
  def genSwizzle(a: Char, b: Char, c: Char, d: Char) =
    s"def $a$b$c$d = Vec4($a, $b, $c, $d)"
}
