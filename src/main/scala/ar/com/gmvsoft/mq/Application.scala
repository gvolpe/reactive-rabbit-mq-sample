package ar.com.gmvsoft.mq

import akka.actor.ActorSystem
import akka.stream.FlowMaterializer
import akka.stream.scaladsl.Source
import io.scalac.amqp.Connection

object Application extends App {

  val connection = Connection()
  val queue = connection.consume(queue = "users")
  val exchange = connection.publish(exchange = "notifications",
    routingKey = "users")

  implicit val system = ActorSystem()
  implicit val fm = FlowMaterializer()

  Source(queue).map(_.message.body.utf8String).foreach(println)

  //Source(queue).map(_.message).to(Sink(exchange)).run()

}
