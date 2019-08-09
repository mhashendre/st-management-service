// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mhashendre/Desktop/CingleVue/studentservice/conf/routes
// @DATE:Fri Aug 09 04:27:05 IST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
