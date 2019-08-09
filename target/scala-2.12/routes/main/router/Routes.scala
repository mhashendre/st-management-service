// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mhashendre/Desktop/CingleVue/studentservice/conf/routes
// @DATE:Fri Aug 09 04:27:05 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_2: controllers.HomeController,
  // @LINE:8
  StudentController_0: controllers.StudentController,
  // @LINE:12
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_2: controllers.HomeController,
    // @LINE:8
    StudentController_0: controllers.StudentController,
    // @LINE:12
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_2, StudentController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_2, StudentController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """save/student""", """controllers.StudentController.saveStudent"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """fetch/students""", """controllers.StudentController.fetchStudents"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_2.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_StudentController_saveStudent1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("save/student")))
  )
  private[this] lazy val controllers_StudentController_saveStudent1_invoker = createInvoker(
    StudentController_0.saveStudent,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.StudentController",
      "saveStudent",
      Nil,
      "POST",
      this.prefix + """save/student""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_StudentController_fetchStudents2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("fetch/students")))
  )
  private[this] lazy val controllers_StudentController_fetchStudents2_invoker = createInvoker(
    StudentController_0.fetchStudents,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.StudentController",
      "fetchStudents",
      Nil,
      "GET",
      this.prefix + """fetch/students""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_2.index)
      }
  
    // @LINE:8
    case controllers_StudentController_saveStudent1_route(params@_) =>
      call { 
        controllers_StudentController_saveStudent1_invoker.call(StudentController_0.saveStudent)
      }
  
    // @LINE:9
    case controllers_StudentController_fetchStudents2_route(params@_) =>
      call { 
        controllers_StudentController_fetchStudents2_invoker.call(StudentController_0.fetchStudents)
      }
  
    // @LINE:12
    case controllers_Assets_versioned3_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
