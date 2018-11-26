package engine

object GLError
{
  def apply(message: String) = throw new RuntimeException(message)
}
