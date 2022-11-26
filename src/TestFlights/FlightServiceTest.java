package TestFlights;

import flight.CollectionFlightDAO;
import flight.Flight;
import flight.FlightService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FlightServiceTest {

    @Test
    void getFlightByIdTest() {
        CollectionFlightDAO DAO = new CollectionFlightDAO();
        Flight f = new Flight(0, "25/12/2022", "22:30", "Wroclaw", 15);
        Flight f1 = new Flight(1, "15/11/2022", "09:30", "London", 0);
        Flight f2 = new Flight(2, "17/11/2022", "17:55", "Paris", 10);
        DAO.setFilename("flightsTest.dat");
        DAO.setFlights(f,f1,f2);
        FlightService service = new FlightService(DAO);

        Flight test = service.getFlightById(0);
        assertEquals(test, f);

        test = service.getFlightById(1);
        assertEquals(test, f1);

        test = service.getFlightById(2);
        assertEquals(test, f2);
    }

    @Test
    void getFlightsForNumberOfPeopleTest() {
        CollectionFlightDAO DAO = new CollectionFlightDAO();
        Flight f = new Flight(0, "25/12/2022", "22:30", "London", 15);
        Flight f1 = new Flight(1, "25/12/2022", "09:30", "London", 10);
        Flight f2 = new Flight(2, "25/12/2022", "17:55", "London", 5);

        DAO.setFilename("flightsTest.dat");
        DAO.setFlights(f,f1,f2);
        FlightService service = new FlightService(DAO);
        service.getFlightsForNumberOfPeople("London","25/12/2022", 9);
        ArrayList<Flight> test = new ArrayList<>();

        test.add(f);
        assertEquals(test.toString(),service.getFlightsForNumberOfPeople
                ("London","25/12/2022", 11).toString());

        test.add(f1);
        assertEquals(test.toString(),service.getFlightsForNumberOfPeople
                ("London","25/12/2022", 9).toString());

        test.add(f2);
        assertEquals(test.toString(),service.getFlightsForNumberOfPeople
                ("London","25/12/2022", 4).toString());
    }
}