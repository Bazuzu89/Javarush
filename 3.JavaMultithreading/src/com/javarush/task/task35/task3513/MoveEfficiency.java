package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.score = score;
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.move = move;

    }

    public Move getMove() {
        return this.move;
    }

    public int compareTo(MoveEfficiency m2) {
        int result = Integer.compare(this.numberOfEmptyTiles, m2.numberOfEmptyTiles);
        if (result == 0) {
            result = Integer.compare(this.score, m2.score);
        }
        return result;

        /* return m2.numberOfEmptyTiles - this.numberOfEmptyTiles != 0 ? (m2.numberOfEmptyTiles - this.numberOfEmptyTiles) :
                (m2.score - this.score); */
    }
}
