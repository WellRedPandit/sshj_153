package wrp.tests

import net.schmizz.sshj.common.SecurityUtils
import org.scalatest.{BeforeAndAfterAll, FunSuiteLike}
import wrp.ssh._

class SshjCmd extends FunSuiteLike with BeforeAndAfterAll {

  val pkey = "<PATH/TO/YOUR/KEY/FILE>"
  val host = "555.555.555.555"
  val port = 22
  val user = "USER"

  test("pwd") {
    assert(Sshj.pwd(host, user, port, pkey) == 0)
  }

  override def beforeAll {
    if(!SecurityUtils.isBouncyCastleRegistered) throw new AssertionError("bouncy castle needed")
  }

}
