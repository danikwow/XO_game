package io.test.xo.model;

import io.test.xo.model.exception.InvalidPointException;

import java.awt.*;
public class Field<T> {

    private static final int MIN_COORDINATE = 0;

    private final T[][] field;

    private final int filedSize;

    public Field(final int filedSize) {
        this.filedSize = filedSize;
        field = (T[][]) new Object[filedSize][filedSize];
    }

    public int getSize() {
        return filedSize;
    }

    public T getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final T figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length);
    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }

}
