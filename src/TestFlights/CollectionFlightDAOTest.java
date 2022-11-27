package TestFlights;

import flight.CollectionFlightDAO;
import flight.Flight;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CollectionFlightDAOTest {

    @org.junit.jupiter.api.Test
    void getAllFlightsTest() {
        CollectionFlightDAO DAO = new CollectionFlightDAO();
        Flight f = new Flight(0, "25/12/2022", "22:30", "Wroclaw", 15);
        Flight f1 = new Flight(1, "15/11/2022", "09:30", "London", 0);
        Flight f2 = new Flight(2, "17/11/2022", "17:55", "Paris", 10);
        DAO.setFilename("flightsTest.dat");
        DAO.setFlights(f,f1,f2);

        ArrayList<Flight> test = new ArrayList<>();
        test.add(f);
        test.add(f1);
        test.add(f2);

        assertEquals(test.toString(),DAO.getAllFlights().toString());
    }

    @org.junit.jupiter.api.Test
    void getFlightByIndexTest() {
        CollectionFlightDAO DAO = new CollectionFlightDAO();
        Flight f = new Flight(0, "25/12/2022", "22:30", "Wroclaw", 15);
        Flight f1 = new Flight(1, "15/11/2022", "09:30", "London", 0);
        Flight f2 = new Flight(2, "17/11/2022", "17:55", "Paris", 10);
        DAO.setFilename("flightsTest.dat");
        DAO.setFlights(f,f1,f2);

        assertEquals(f1.toString(),DAO.getFlightByIndex(1).toString());
        assertEquals(f.toString(),DAO.getFlightByIndex(0).toString());
        assertEquals(f2.toString(),DAO.getFlightByIndex(2).toString());
    }

    @org.junit.jupiter.api.Test
    void deleteFlightTest() {
        CollectionFlightDAO DAO = new CollectionFlightDAO();
        Flight f = new Flight(0, "25/12/2022", "22:30", "Wroclaw", 15);
        Flight f1 = new Flight(1, "15/11/2022", "09:30", "London", 0);
        Flight f2 = new Flight(2, "17/11/2022", "17:55", "Paris", 10);
        DAO.setFilename("flightsTest.dat");

        DAO.setFlights(f,f1,f2);
        DAO.deleteFlight(f1);

        ArrayList<Flight> test = new ArrayList<>();
        test.add(f);
        test.add(f2);

        assertEquals(test.toString(),DAO.getAllFlights().toString());

        DAO.deleteFlight(0);
        test.remove(0);

        assertEquals(test.toString(),DAO.getAllFlights().toString());
    }


    @org.junit.jupiter.api.Test
    void saveFlight() {
        CollectionFlightDAO DAO = new CollectionFlightDAO();
        Flight f = new Flight(0, "25/12/2022", "22:30", "Wroclaw", 15);
        Flight f1 = new Flight(1, "15/11/2022", "09:30", "London", 0);
        Flight f2 = new Flight(2, "17/11/2022", "17:55", "Paris", 10);
        ArrayList<Flight> test = new ArrayList<>();
        DAO.setFilename("flightsTest.dat");

        DAO.saveFlight(f);
        test.add(f);
        assertEquals(test.toString(),DAO.getAllFlights().toString());

        DAO.saveFlight(f1);
        test.add(f1);
        assertEquals(test.toString(),DAO.getAllFlights().toString());
    }
}