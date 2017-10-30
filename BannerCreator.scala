object BannerCreator {
  private val decor = ".｡:･・.｡:*･★.｡:･・.｡:*･★.｡:･・.｡:*･★.｡:･・.｡:*･★.｡:･・.｡:*･★"

  def create(message: String) = {
    s"""${decor}
       |${message}
       |${decor}""".stripMargin
  }


}
