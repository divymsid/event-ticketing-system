
import scala.collection.mutable

object BoxOffice {

  private val events =
    mutable.LinkedHashMap[Int, Event]()

  private val tickets =
    mutable.ArrayBuffer[Ticket]()

  private var ticketCounter = 1001

  def addEvent(event: Event): Unit = synchronized {
    if (events.contains(event.eventId)) {
      throw new EventAlreadyExistsException(
        "Event ID already exists!"
      )
    }

    events(event.eventId) = event
  }

  def getEvent(eventId: Int): Event = synchronized {
    events.getOrElse(
      eventId,
      throw new EventNotFoundException("Event not found!")
    )
  }

  def getAllEvents: Seq[Event] = synchronized {
    events.values.toSeq
  }

  def getAllTickets: Seq[Ticket] = synchronized {
    tickets.toSeq
  }

  def bookTicket(eventId: Int, seatId: String): Ticket =
    synchronized {

      val event = getEvent(eventId)

      if (event.availableSeats == 0) {
        throw new EventSoldOutException(
          "Sorry! This event is completely sold out."
        )
      }

      val seat = event.getSeat(seatId)

      seat.book()

      val ticket = new Ticket(
        ticketCounter,
        event.eventName,
        seat.seatId,
        event.venue
      )

      ticketCounter += 1
      tickets += ticket

      ticket
    }
}
