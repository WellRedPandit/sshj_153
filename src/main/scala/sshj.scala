package wrp.ssh

import java.util.concurrent.TimeUnit

import net.schmizz.sshj.SSHClient
import net.schmizz.sshj.common.IOUtils
import net.schmizz.sshj.transport.verification.PromiscuousVerifier

object Sshj {

  def pwd(hostIp: String, user: String, port: Int, pkey: String) = {
    val sshc = new SSHClient
    sshc.getTransport().addHostKeyVerifier(new PromiscuousVerifier())
    //sshc.loadKnownHosts()
    sshc.connect(hostIp, port)
    try {
      sshc.authPublickey(user, pkey)
      val session = sshc.startSession()
      try {
        val cmd = session.exec("pwd")
        println(IOUtils.readFully(cmd.getInputStream()).toString())
        cmd.join(5, TimeUnit.SECONDS)
        cmd.getExitStatus()
      } finally {
        session.close()
      }
    } finally {
      sshc.disconnect()
    }
  }
}
