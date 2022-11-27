package flight;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Flight implements Serializable {
    private int id;
    private long date;
    private String time;
    private String destination;
    private int freeSeats;

    public Flight() {
    }

    public Flight(int id, String date, String time, String destination, int freeSeats) {
        this.id = id;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String add = " 00:00";
        date = date + add;
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        this.date = localDateTime.atZone(ZoneId.of("Europe/Paris"))
                .toInstant().toEpochMilli();
        this.time = time;
        this.destination = destination;
        this.freeSeats = freeSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        LocalDateTime localDateTime = Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(localDateTime);

    }

    public String getTime() {
        return time;
    }

    public String getDestination() {
        return destination;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Flight flight = (Flight) o;

        if (!Objects.equals(getDate(), flight.getDate())) {
            return false;
        }
        if (!Objects.equals(getDestination(), getDestination())) {
            return false;
        }
        if (!Objects.equals(getTime(), flight.getTime())) {
            return false;
        }
        return getId() == flight.getId();

    }


    @Override
    public String toString() {
        if (!Objects.equals(this.getDate(), "01/01/1970")) {
            return "Flight{" +
                    "id=" + id +
                    ", date=" + getDate() +
                    ", time='" + time + '\'' +
                    ", destination='" + destination + '\'' +
                    ", freeSeats=" + freeSeats +
                    '}';
        } else{
            return "";
        }
    }
}
