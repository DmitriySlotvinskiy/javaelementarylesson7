package com.slotvinskiy;

import java.util.ArrayList;
import java.util.List;

public class Task5 {

    private static class Ball {
    }

    private static class Board {
        private List balls;  //We can also rewrite this line as --->>>  private List balls = new ArrayList<>();
        //Logic in class will be WRONG but NullPointerException will NOT be thrown
        public Board() {
            List balls = new ArrayList<>();
            balls.add(new Ball());
            balls.add(new Ball());
            balls.add(new Ball());
            this.balls = balls; //  <<<----- THIS LINE WAS ADDED
        }

        public int count() {
            return balls.size();
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.count());
    }
}
