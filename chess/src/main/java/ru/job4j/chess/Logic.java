package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = this.findBy(source);
        if(index != -1) {
            Cell[] steps = this.figures[index].way(dest);
            this.free(steps);
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                this.figures[index] = this.figures[index].copy(dest);

            }
        }
    }

    private boolean free(Cell[] steps) throws OccupiedCellException {
        for(Cell a : steps) {
            for(int i = 0; i < index; i++){
                if(figures[i].position().equals(a)){
                    throw new OccupiedCellException("OccupiedCellException");
                }
            }

        }
        return true;
    }




    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException("Figure not found.");
    }
}
