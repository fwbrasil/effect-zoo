package effect_zoo.contests.reint.turbolift_
import effect_zoo.contests.Reint.Shared
import turbolift.{!!, Signature, Effect, Handler}


trait QuerySignature extends Signature:
  def listFruits: Vector[String] !@! ThisEffect

case object Query extends Effect[QuerySignature] with QuerySignature:
  override def listFruits: Vector[String] !! ThisEffect = perform(_.listFruits)

type Query = Query.type  


val toLoggedHttp: Handler.Id[Query, Http & Logging] =
  new Query.Proxy[Http & Logging] with QuerySignature:
    override def listFruits: Vector[String] !@! ThisEffect =
      for
        _ <- Logging.logMsg(Shared.MESSAGE)
        response <- Http.get(Shared.URL)
        lines = response.split('\n').toVector
      yield lines
  .toHandler
