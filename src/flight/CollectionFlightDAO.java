package flight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionFlightDAO implements FlightDAO{
    ArrayList<Flight> Flights = new ArrayList<>();
    private String filename = "flights.txt";
    public void setFlights(Flight ...flights){
        this.Flights.addAll(List.of(flights));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(Flights);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<Flight> getAllFlights() {
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                Flights = (ArrayList<Flight>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return this.Flights;
    }

    @Override
    public Flight getFlightByIndex(int index) {
        this.Flights = getAllFlights();
        return this.Flights.get(index);
    }

    @Override
    public boolean deleteFlight(int index) {
        try {
            this.Flights.remove(index);
            update();
            return true;
        }catch (Exception e){
            System.out.println("can t delete!");
            return false;
        }
    }

    @Override
    public boolean deleteFlight(Flight flight) {
        try {
            this.Flights.remove(flight);
            update();
            return true;
        }catch (Exception e){
            System.out.println("can t delete!");
            return false;
        }
    }

    @Override
    public void saveFlight(Flight flight) {
        if(!this.Flights.contains(flight)){
            this.Flights.add(flight);
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                oos.writeObject(Flights);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    public void update(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(Flights);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void setFilename(String filename){
        this.filename = filename;
    }

}
