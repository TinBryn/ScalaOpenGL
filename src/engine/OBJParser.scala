package engine

import math3d.Vec3

import scala.collection.mutable.ArrayBuffer

object OBJParser
{
  def parse(strings: List[String]): Array[Vec3] =
  {
    val verticies = ArrayBuffer.empty[Vec3]
    val normals = ArrayBuffer.empty[Vec3]
    val faces = ArrayBuffer.empty[Vec3]

    val v = """v\s+(-?\d+\.\d+)\s+(-?\d+\.\d+)\s+(-?\d+\.\d+)""".r
    val vn = """vn\s+(-?\d+\.\d+)\s+(-?\d+\.\d+)\s+(-?\d+\.\d+)""".r
    val f3 = """f\s+(\d+)//(\d+)\s+(\d+)//(\d+)\s+(\d+)//(\d+)""".r
    val f4 = """f\s+(\d+)//(\d+)\s+(\d+)//(\d+)\s+(\d+)//(\d+)\s+(\d+)//(\d+)""".r

    def vec(x: String, y: String, z: String) = Vec3(x.toFloat, y.toFloat, z.toFloat)

    for (line <- strings)
    {
      line match
      {
        case v(x, y, z) =>
          verticies.append(vec(x, y, z))
        case vn(x, y, z) =>
          normals.append(vec(x, y, z))
        case f3(v1, n1, v2, n2, v3, n3) =>
          faces.append(
            verticies(v1.toInt - 1),
            normals(n1.toInt - 1),
            verticies(v2.toInt - 1),
            normals(n2.toInt - 1),
            verticies(v3.toInt - 1),
            normals(n3.toInt - 1))
        case f4(v1, n1, v2, n2, v3, n3, v4, n4) =>
          faces.append(
            verticies(v1.toInt - 1),
            normals(n1.toInt - 1),
            verticies(v2.toInt - 1),
            normals(n2.toInt - 1),
            verticies(v3.toInt - 1),
            normals(n3.toInt - 1),
            verticies(v3.toInt - 1),
            normals(n3.toInt - 1),
            verticies(v4.toInt - 1),
            normals(n4.toInt - 1),
            verticies(v1.toInt - 1),
            normals(n1.toInt - 1))
        case _ =>
      }
    }

    faces.toArray
  }
}
