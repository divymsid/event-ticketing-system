# Event Ticketing System

A console-based Event Ticketing System developed using Scala 3 and Object-Oriented Programming concepts. The application allows users to view events, check seat availability, book tickets, and manage booking information through an interactive menu.

## Features

- View all available events
- Display seat availability for each event
- Book tickets for selected events
- Generate unique ticket IDs
- Prevent double booking
- Handle sold-out events
- Validate event IDs and seat IDs
- Display all booked tickets
- Handle errors using custom exceptions
- Synchronize booking operations to prevent concurrent booking conflicts

## Technology Stack

- **Language:** Scala 3
- **Scala Version:** 3.3.6
- **Build Tool:** sbt 1.10.7
- **JDK:** Java 17
- **Testing Framework:** MUnit

## Project Structure

```text
event-ticketing-system/
│
├── build.sbt
├── README.md
├── .gitignore
│
├── project/
│   └── build.properties
│
└── src/
    ├── main/
    │   └── scala/
    │       ├── Main.scala
    │       ├── Event.scala
    │       ├── Seat.scala
    │       ├── Ticket.scala
    │       ├── BoxOffice.scala
    │       └── Exceptions.scala
    │
    └── test/
        └── scala/
            └── MySuite.scala
```

## Object-Oriented Programming Concepts

### 1. Classes and Objects
The project uses classes such as Event, Seat, and Ticket to represent real-world entities. BoxOffice is implemented as a Scala singleton object.

### 2. Encapsulation
Seat booking status is maintained using a private variable and accessed through methods.

### 3. Abstraction
TicketingException provides a common abstraction for custom application exceptions.

### 4. Inheritance
Custom exceptions inherit from TicketingException.

### 5. Collections
Mutable collections are used to maintain events and generated tickets.

### 6. Exception Handling
Custom exceptions handle invalid events, invalid seats, duplicate bookings, and sold-out events.

### 7. Synchronization
Synchronized booking operations help prevent concurrent booking conflicts.

## Installation and Execution

### Prerequisites

- Java JDK 17 or later
- Scala 3
- sbt 1.10.7

### Clone the Repository

```bash
git clone <git clone https://github.com/divymsid/event-ticketing-system.git>
cd event-ticketing-system
```

### Compile the Project

```bash
sbt compile
```

### Run the Application

```bash
sbt run
```

### Run Automated Tests

```bash
sbt test
```

## Application Menu

```text
====== EVENT TICKETING SYSTEM ======
1. View Events
2. View Available Seats
3. Book Ticket
4. View Booked Tickets
5. Exit
```

## Sample Events

| Event ID | Event Name | Venue | Seats |
|---|---|---|---|
| 1 | Music Concert | Delhi | 5 |
| 2 | Tech Conference | Gurugram | 4 |
| 3 | Comedy Show | Noida | 3 |

## Testing

The project includes automated tests for:

- Successful ticket booking
- Double-booking prevention
- Invalid seat validation
- Sold-out event handling
- Invalid event ID handling

## Current Limitations

- Booking information is stored in memory.
- Bookings reset when the application is restarted.
- The application currently uses a console-based interface.
- Payment processing is not implemented.

## Future Enhancements

- Database integration for permanent booking records
- Ticket cancellation functionality
- User registration and authentication
- Online payment integration
- Graphical user interface
- Booking history and reports

## Conclusion

The Event Ticketing System demonstrates the practical implementation of Scala programming and Object-Oriented Programming principles. It provides a basic but functional ticket booking workflow with seat validation, exception handling, and booking protection.
