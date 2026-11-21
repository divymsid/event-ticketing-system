
class MySuite extends munit.FunSuite {

  test("successful ticket booking") {
    val event = new Event(1001, "Test Concert", "Delhi", 2)
    BoxOffice.addEvent(event)

    val ticket = BoxOffice.bookTicket(1001, "S1")

    assertEquals(ticket.seatId, "S1")
    assertEquals(ticket.eventName, "Test Concert")
    assertEquals(event.availableSeats, 1)
  }

  test("prevent double booking") {
    val event = new Event(1002, "Test Event", "Delhi", 2)
    BoxOffice.addEvent(event)

    BoxOffice.bookTicket(1002, "S1")

    intercept[DoubleBookingException] {
      BoxOffice.bookTicket(1002, "S1")
    }
  }

  test("reject invalid seat") {
    val event = new Event(1003, "Test Event", "Delhi", 2)
    BoxOffice.addEvent(event)

    intercept[SeatNotFoundException] {
      BoxOffice.bookTicket(1003, "S99")
    }
  }

  test("prevent booking when event is sold out") {
    val event = new Event(1004, "Sold Out Event", "Delhi", 1)
    BoxOffice.addEvent(event)

    BoxOffice.bookTicket(1004, "S1")

    intercept[EventSoldOutException] {
      BoxOffice.bookTicket(1004, "S1")
    }
  }

  test("reject invalid event ID") {
    intercept[EventNotFoundException] {
      BoxOffice.bookTicket(999999, "S1")
    }
  }
}
