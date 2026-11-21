
class Event(
    val eventId: Int,
    val eventName: String,
    val venue: String,
    totalSeats: Int
) {

  require(totalSeats > 0, "Total seats must be greater than zero")

  val seats: Map[String, Seat] =
    (1 to totalSeats).map { number =>
      val id = s"S$number"
      id -> new Seat(id)
    }.toMap

  def availableSeats: Int = {
    seats.values.count(seat => !seat.isBooked)
  }

  def getSeat(seatId: String): Seat = {
    seats.getOrElse(
      seatId.trim.toUpperCase,
      throw new SeatNotFoundException(
        s"Seat $seatId does not exist!"
      )
    )
  }

  def displaySeats(): Unit = {
    println(s"\nSeats for $eventName")

    seats.values.toSeq
      .sortBy(_.seatId.drop(1).toInt)
      .foreach { seat =>
        val status =
          if (seat.isBooked) "BOOKED"
          else "AVAILABLE"

        println(s"${seat.seatId} : $status")
      }
  }
}
