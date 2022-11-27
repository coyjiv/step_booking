package flight;

import java.util.ArrayList;
import java.util.List;

public class FlightController {
    FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    public Flight getFlightById(int id) {
        return service.getFlightById(id);
    }

    public List<Flight> getFlightsForNumberOfPeople(String destination, String date, int number) {
        return service.getFlightsForNumberOfPeople(destination, date, number);
    }
    public ArrayList<Flight> getAllFlights(){
        return service.getAllFlights();
    }
}
