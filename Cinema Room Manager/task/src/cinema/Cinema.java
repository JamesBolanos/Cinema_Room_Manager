package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here

        CinemaObject silverSpot = new CinemaObject("SilverSpot");

        // Now create the room.
        // Read two positive integer numbers that represents the rows and seats
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        silverSpot.room1 = new CinemaRoom(rows,seats);

        int option = 9;

        while (option != 0 ) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            option = scanner.nextInt();

            if (option == 0) {
                break;
            }

            switch (option) {
                case 1:
                    silverSpot.room1.showSeatMap();
                    break;
                case 2:
                    buyTicket(silverSpot, scanner);
                    break;
                case 3:
                    showStatistics(silverSpot);

                    break;
            }
        }
    }

    private static void showStatistics(CinemaObject silverSpot) {

        System.out.println("");
        System.out.printf("Number of purchased tickets: %d%n", silverSpot.room1.purchasedTickets);
        System.out.printf("Percentage: %.2f%%%n", ((float)(silverSpot.room1.purchasedTickets) / (float)silverSpot.room1.getNumberOfSeats()) * 100);
        System.out.printf("Current income: $%d%n",silverSpot.room1.currentIncome);
        System.out.printf("Total income: $%d%n", silverSpot.room1.maxPossibleIncome);
        System.out.println("");

    }

    private static void buyTicket(CinemaObject silverSpot, Scanner scanner) {
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();

        int seatPrice = 0;
        if (silverSpot.room1.reserveSeat(row,seat)) {
            seatPrice = silverSpot.room1.getTicketPrice(row, seat);
            System.out.printf("Ticket price: $%d%n",seatPrice);
        } else {
                buyTicket(silverSpot,scanner);
        }


    }

}