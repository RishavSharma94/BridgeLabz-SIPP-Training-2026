class MovieTicket {

    String movieName;
    int seatNumber;
    double price;

    void bookTicket(String movieName, int seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    void display() {
        System.out.println("Movie: " + movieName +
                " | Seat: " + seatNumber +
                " | Price: " + price);
    }
}

public class MovieTicketApp {

    public static void main(String[] args) {

        MovieTicket t = new MovieTicket();
        t.bookTicket("Avengers", 12, 300);
        t.display();
    }
}