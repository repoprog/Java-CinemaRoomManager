package cinema;

import java.util.Scanner;


public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsInRow = scanner.nextInt();

        CinemaRoom room = new CinemaRoom(rows, seatsInRow);

        boolean quit = false;
        while (!quit) {
            System.out.println("\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "0. Exit\n" +
                    "3. Statistics");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    room.printReservations();
                    break;
                case 2:
                    boolean seatFree = false;
                    int rowReserved = 0;
                    while (!seatFree) {
                        System.out.println("Enter a row number:");
                        rowReserved = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int seatReserved = scanner.nextInt();

                        if (rowReserved > rows || seatReserved > seatsInRow) {
                            System.out.println("Wrong input!");
                        } else {
                            seatFree = room.isSeatFree(rowReserved, seatReserved);
                        }
                    }
                    room.calculateTicketPrice(rowReserved);
                    break;
                case 3:
                    room.showStatistics();
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Choose one of the choices.");
            }
        }
    }

}

