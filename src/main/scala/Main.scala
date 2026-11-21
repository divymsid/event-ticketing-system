
import scala.io.StdIn

object Main {

  def readInt(message: String): Option[Int] = {
    print(message)
    Option(StdIn.readLine()).flatMap(_.trim.toIntOption)
  }

  def readMenuChoice(): Option[String] = {
    var line = Option(StdIn.readLine())

    while (line.exists(_.trim.isEmpty)) {
      line = Option(StdIn.readLine())
    }

    line.map(_.trim)
  }

  def showEvents(): Unit = {
    println("\n========== AVAILABLE EVENTS ==========")

    BoxOffice.getAllEvents.foreach { event =>
      println(s"\nEvent ID: ${event.eventId}")
      println(s"Name: ${event.eventName}")
      println(s"Venue: ${event.venue}")
      println(s"Available Seats: ${event.availableSeats}")
    }
  }

  def viewSeats(): Unit = {
    readInt("Enter Event ID: ") match {
      case Some(id) =>
        BoxOffice.getEvent(id).displaySeats()

      case None =>
        println("Please enter a valid event ID.")
    }
  }

  def bookTicket(): Unit = {
    readInt("Enter Event ID: ") match {
      case Some(id) =>
        val event = BoxOffice.getEvent(id)

        event.displaySeats()

        print("\nEnter Seat ID: ")
        val seatId = Option(StdIn.readLine())
          .getOrElse("")
          .trim
          .toUpperCase

        val ticket = BoxOffice.bookTicket(id, seatId)

        println("\nTicket booked successfully!")
        ticket.displayTicket()

      case None =>
        println("Please enter a valid event ID.")
    }
  }

  def showTickets(): Unit = {
    val tickets = BoxOffice.getAllTickets

    if (tickets.isEmpty) {
      println("\nNo tickets booked yet.")
    } else {
      tickets.foreach(_.displayTicket())
    }
  }

  def main(args: Array[String]): Unit = {

    BoxOffice.addEvent(
      new Event(1, "Music Concert", "Delhi", 5)
    )

    BoxOffice.addEvent(
      new Event(2, "Tech Conference", "Gurugram", 4)
    )

    BoxOffice.addEvent(
      new Event(3, "Comedy Show", "Noida", 3)
    )

    var running = true

    while (running) {

      println("\n====== EVENT TICKETING SYSTEM ======")
      println("1. View Events")
      println("2. View Available Seats")
      println("3. Book Ticket")
      println("4. View Booked Tickets")
      println("5. Exit")

      print("\nEnter your choice: ")

      readMenuChoice() match {
        case None =>
          running = false

        case Some(choice) =>
          try {
            choice match {
              case "1" =>
                showEvents()

              case "2" =>
                viewSeats()

              case "3" =>
                bookTicket()

              case "4" =>
                showTickets()

              case "5" =>
                running = false
                println("Thank you for using our system!")

              case _ =>
                println("Invalid choice. Please try again.")
            }
          } catch {
            case e: TicketingException =>
              println(s"\nBooking Error: ${e.getMessage}")
          }
      }
    }
  }
}
