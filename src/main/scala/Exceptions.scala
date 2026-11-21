
abstract class TicketingException(message: String)
    extends RuntimeException(message)

class DoubleBookingException(message: String)
    extends TicketingException(message)

class EventSoldOutException(message: String)
    extends TicketingException(message)

class SeatNotFoundException(message: String)
    extends TicketingException(message)

class EventNotFoundException(message: String)
    extends TicketingException(message)

class EventAlreadyExistsException(message: String)
    extends TicketingException(message)
