object IntersectionalityWithoutDEI:

  trait Cache:
    lazy val store = scala.collection.mutable.Map.empty[String, Any]

  trait Logger:
    def log(msg: String): Unit = println(s"[Log] $msg")

  trait CachedLogger extends Cache, Logger:
    def fetch(id: String): String

  class UserRepo extends CachedLogger:
    def fetch(id: String): String =
      store.getOrElseUpdate(id, {
        log("DB hit")
        s"User($id)"
      }).asInstanceOf[String]

  @main def runIntersection() =
    val repo: CachedLogger = new UserRepo
    val cacheAndLogger: Cache & Logger = repo
    println(repo.fetch("cs474"))  // first call logs and caches
    println(repo.fetch("cs476"))
    cacheAndLogger.log("Cache currently holds:")
    println(repo.fetch("cs474"))  // served from cache, no log
