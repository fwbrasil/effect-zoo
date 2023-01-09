/*******************************/
/* Generated by `sbt meta/run` */
/*******************************/
package effect_zoo.bench.contests
import java.util.concurrent.TimeUnit
import org.openjdk.jmh.annotations._
import effect_zoo.registry.Registry

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.Throughput))
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(jvmArgs = Array("-Dcats.effect.tracing.mode=DISABLED", "-Xms2g", "-Xmx2g"))
class Cdown {
  val reg = Registry.findByContestName("Cdown")

  val CatsCore__run = reg.findRound("CatsCore", 0).run
  val CatsMTL__run = reg.findRound("CatsMTL", 0).run
  val CatsIO__run = reg.findRound("CatsIO", 0).run
  val CatsIO_Ref__run = reg.findRound("CatsIO_Ref", 0).run
  val CatsEff__run = reg.findRound("CatsEff", 0).run
  val Turbolift__run = reg.findRound("Turbolift", 0).run
  val ZIO_Cake__run = reg.findRound("ZIO_Cake", 0).run
  val ZIO_Mono__run = reg.findRound("ZIO_Mono", 0).run
  val ZIO_Ref__run = reg.findRound("ZIO_Ref", 0).run
  val ZPure__run = reg.findRound("ZPure", 0).run
  
  @Benchmark def CatsCore = CatsCore__run()
  @Benchmark def CatsMTL = CatsMTL__run()
  @Benchmark def CatsIO = CatsIO__run()
  @Benchmark def CatsIO_Ref = CatsIO_Ref__run()
  @Benchmark def CatsEff = CatsEff__run()
  @Benchmark def Turbolift = Turbolift__run()
  @Benchmark def ZIO_Cake = ZIO_Cake__run()
  @Benchmark def ZIO_Mono = ZIO_Mono__run()
  @Benchmark def ZIO_Ref = ZIO_Ref__run()
  @Benchmark def ZPure = ZPure__run()
}
