package cinema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CinemaObject {
        // This class creates a Cinema Object
        public String name;
        public int rooms;
        //At this time the cinema will have only one room.
        public CinemaRoom room1;

        CinemaObject(String name) {
                this.name = name;
                this.rooms = 1;
        }

        public void CreateNewRoom(int rows, int seats) {
                //Not implemented yet

        }

        void calculateMaxProfits() {
                //Not implemented yet


        }



}
