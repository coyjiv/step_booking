package flight;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FlightService {
    public CollectionFlightDAO DAO;

    public FlightService(CollectionFlightDAO dao) {
        this.DAO = dao;
    }

    public Flight getFlightById(int id) {
        for (int i = 0; i < DAO.getAllFlights().size(); i++) {
            if (DAO.getAllFlights().get(i).getId() == id) {
                return DAO.getAllFlights().get(i);
            }
        }
        System.out.println("No such Flight");
        return new Flight();
    }

    public ArrayList<Flight> getFlightsForNumberOfPeople(String destination, String date, int number) {
        ArrayList<Flight> res = new ArrayList<Flight>();
        for (int i = 0; i < DAO.getAllFlights().size(); i++) {
            if (Objects.equals(DAO.getAllFlights().get(i).getDestination(), destination) &&
                    Objects.equals(DAO.getAllFlights().get(i).getDate(), date) &&
                    DAO.getAllFlights().get(i).getFreeSeats() >= number) {
                res.add(DAO.getAllFlights().get(i));
            }
        }
        return res;
    }
    public ArrayList<Flight> getAllFlights(){
        return DAO.getAllFlights();
    }
    public void addFlight(Flight flight){
        DAO.saveFlight(flight);
    }
    public void deleteFlight(Flight flight){
        DAO.deleteFlight(flight);
    }
    public void deleteFlight(int index){
        DAO.deleteFlight(index);
    }
}
