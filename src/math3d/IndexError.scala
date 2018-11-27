package math3d

object IndexError
{
  def apply(message: Any) = throw new ArrayIndexOutOfBoundsException(message.toString)
}
