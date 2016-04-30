package local

import akka.actor.Actor
import domain.Person
import akka.actor.actorRef2Scala

class PersonActor extends Actor {

  def receive: Actor.Receive = {
    case person: Person =>
      println(s"RemoteActor received a Person[${person.name}, ${person.age}]");
      sender ! "Gotcha!"
  }
}