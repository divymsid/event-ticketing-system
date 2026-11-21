
class Ticket(
    val ticketId: Int,
    val eventName: String,
    val seatId: String,
    val venue: String
) {

  def displayTicket(): Unit = {
    println("\n========== EVENT TICKET ==========")
    println(s"Ticket ID : $ticketId")
    println(s"Event     : $eventName")
    println(s"Venue     : $venue")
    println(s"Seat      : $seatId")
    println("==================================")
  }
}
