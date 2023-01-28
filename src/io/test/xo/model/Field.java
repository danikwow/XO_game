package io.test.xo.model;
import io.test.xo.model.exception.InvalidPointException;
import io.test.xo.model.exception.PointAlreadyOccupiedException;

import java.awt.Point;
public class Field {
    private final static int MIN_COORDINATE = 0;
    private final Figure[][] field;
    private final int fieldSize;

    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }

    public int getSize() {
        return fieldSize;
    }
    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)){
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }
    public void setFigure( final Point point,
                           final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        field[point.x][point.y] = figure;
    }
    private boolean checkPoint(final Point point){
        return checkCoordinate(point.x, field.length)
                && checkCoordinate(point.y, field[point.x].length);
    }
    private boolean checkCoordinate(final int coordinate,final int maxCoordinate){
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }
}
