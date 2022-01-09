package cinema;

public class CinemaRoom {
    private final int rows;
    private final int seatsInRow;
    private int totalSeats;
    private final char[][] room;
    private static int currentIncome;
    private static int totalIncome;
    private static int totalReservations;

    public CinemaRoom(int rows, int seatsInRow) {
        this.rows = rows;
        this.seatsInRow = seatsInRow;
        this.room = new char[this.rows][this.seatsInRow];
        fillSeats();
        calculateTotalSeats();
        calculateTotalIncome();
    }

    public void fillSeats() {
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[0].length; j++) {
                room[i][j] = 'S';
            }
        }
    }

    public void calculateTotalSeats() {
        totalSeats = rows * seatsInRow;
        System.out.println("Total seats: " + totalSeats);
    }

    public void showStatistics() {
        double percentage = (double) totalReservations * 100 / totalSeats;
        System.out.println("Number of purchased tickets: " + totalReservations);
        System.out.printf("Percentage: %.2f%%", percentage);
        System.out.printf("\nCurrent income: $%d", currentIncome);
        System.out.printf("\nTotal income: $%d", totalIncome);
        System.out.println();
    }

    public boolean isSeatFree(int rowReserved, int seatReserved) {

        if (room[rowReserved - 1][seatReserved - 1] == 'B') {
            System.out.println("That ticket has already been purchased!");
            return false;
        } else {
            room[rowReserved - 1][seatReserved - 1] = 'B';
            totalReservations++;
            return true;
        }
    }

    public void calculateTicketPrice(int rowReserved) {
        int ticketPrice;
        if (totalSeats < 60) {
            ticketPrice = 10;
        } else {
            ticketPrice = rowReserved <= rows / 2 ? 10 : 8;
        }
        sumCurrentIncome(ticketPrice);
        System.out.println("Ticket price: $" + ticketPrice);
    }

    public void sumCurrentIncome(int ticketPrice) {
        currentIncome += ticketPrice;
    }

    public void calculateTotalIncome() {
        if (totalSeats < 60) {
            totalIncome = totalSeats * 10;
        } else {
            totalIncome = (rows / 2 * seatsInRow * 10)
                    + (rows / 2 * seatsInRow * 8) + (rows % 2 * seatsInRow * 8);
        }
    }

    public void printReservations() {
        System.out.println("Cinema:");
        int c = 1;
        while (c <= room[0].length) {
            System.out.print(" " + c);
            c++;
        }
        System.out.println();
        for (int i = 0; i < room.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < room[0].length; j++) {
                System.out.print(room[i][j] + " ");
            }
            System.out.println();
        }
    }
}
