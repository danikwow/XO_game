package io.test.xo.controllers;

import io.test.xo.model.Field;
import io.test.xo.model.Figure;
import io.test.xo.model.exception.InvalidPointException;
import io.test.xo.model.exception.PointAlreadyOccupiedException;

import java.awt.*;

public class MoveController {
    public void applyFigure(final Field field,
                             final Point point,
                             final Figure figure) throws InvalidPointException,
                                                            PointAlreadyOccupiedException {

        if (field.getFigure(point) != null){
            throw new PointAlreadyOccupiedException();
        }
        field.setFigure(point, figure);

    }
}
