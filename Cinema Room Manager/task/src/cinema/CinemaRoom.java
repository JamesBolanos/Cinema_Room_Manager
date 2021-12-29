package cinema;

import java.util.Arrays;

public class CinemaRoom {

    //This is the array that shows the seats in the room.
    final int TICKET_PRICE_FRONT_HALF = 10;
    final int TICKET_PRICE_BACK_HALF = 8;
    char[][] seatMapArray;
    int[][] seatPrices;
    private int rows;
    private int seats;
    int maxPossibleIncome = 0;
    int purchasedTickets = 0;
    private int numberOfSeats = 0;
    int currentIncome = 0;




    CinemaRoom(int rows, int seats) {

        this.setRows(rows);
        this.setSeats(seats);
        this.setNumberOfSeats(rows * seats);

        //Initialize the seat map array...
        seatMapArray = new char[rows][seats];

        //Now let's fill the array with the char 'S' which mean it is empty...
        for (char[] row: seatMapArray) {
            Arrays.fill(row, 'S');
        }

        //Now let's calculate each seat price...
        seatPrices = new int[rows][seats];
        calculateAllSeatPrices();

    }

    private void calculateAllSeatPrices() {

        //This module fills each array position with the value of the seat
        //Also calculates the maximum possible income for the room.

        // if the cinema has less than 60 seats, each seat is at the same price.
        if ((getRows() * getSeats()) < 60) {

            for (int[] row: seatPrices) {
                Arrays.fill(row,TICKET_PRICE_FRONT_HALF);
            }

            maxPossibleIncome = getRows() * getSeats() * TICKET_PRICE_FRONT_HALF;

        } else {

            // ((rows / 2)  is the number of front half rows (always)
            // (rows - (rows / 2)) is the number of back half rows (even or odd)

            for (int i = 0; i < seatPrices.length; i++) {

                if (i + 1 <= (getRows() / 2)) {
                    Arrays.fill(seatPrices[i], TICKET_PRICE_FRONT_HALF);
                    maxPossibleIncome += seats * TICKET_PRICE_FRONT_HALF;
                } else {
                    Arrays.fill(seatPrices[i], TICKET_PRICE_BACK_HALF);
                    maxPossibleIncome += seats * TICKET_PRICE_BACK_HALF;
                }
            }
        }
     }

    void showSeatMap() {
        // This method shows a seat map for the room to the standard output

        //Headers and Column Numbers
        System.out.println("Cinema:");

        StringBuilder seatHeaders = new StringBuilder(" ");

        for (int i = 1; i <= seatMapArray[0].length; i++) {
            seatHeaders.append(" " + i);
        }

        System.out.println(seatHeaders);

        //For each row ...
        for (int i = 0; i <= seatMapArray.length - 1; i++) {

            // for each seat in the row
            StringBuilder row = new StringBuilder() ;
            // insert the row number at the left of the String...
            row.append(i + 1);
            for (int j = 0; j <= seatMapArray[0].length - 1; j++) {
                row.append(' ');
                row.append(seatMapArray[i][j]);
            }
            System.out.println(row);
        }

        System.out.println("");

    }

    private int isSeatAvailable(int row, int seat) {

        //Check if the array is out of bounds...
        if (seatMapArray.length < row) {
            return -1;
        }

        if (seatMapArray[0].length < seat) {
            return -1;
        }

        if (seatMapArray[row -1][seat -1]=='S') {
            return 0;
        } else {
            return 1;
        }
    }

    boolean reserveSeat(int row, int seat) {

        switch (isSeatAvailable(row,seat)) {
            case -1:
                System.out.println("Wrong input!");
                return false;
            case 0:
                seatMapArray[row-1][seat-1]='B';
                ++purchasedTickets;
                currentIncome = currentIncome + seatPrices[row -1][seat -1];
                return true;
            case 1:
            //case default:
                System.out.println("That ticket has already been purchased!");
                return false;
        }
        return false;
    }

    int getTicketPrice(int row, int seat) {

        return seatPrices[row-1][seat-1];

    }


    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getNumberOfSeats() { return numberOfSeats; }

    public void setNumberOfSeats(int numberOfSeats) { this.numberOfSeats = numberOfSeats; }

}
