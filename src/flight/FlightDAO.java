package flight;

import java.util.List;

public interface FlightDAO {
    public List<Flight> getAllFlights();

    public Flight getFlightByIndex(int index);

    public boolean deleteFlight(int index);

    public boolean deleteFlight(Flight flight);

    public void saveFlight(Flight flight);

}
