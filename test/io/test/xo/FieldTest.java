package io.test.xo;

import io.test.xo.model.Field;
import io.test.xo.model.Figure;
import io.test.xo.model.exception.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void testGetSize() {
        final Field<Figure> field = new Field<>(3);
        assertEquals(3, field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint,inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure,actualFigure);

    }
    @Test
    public void testFigureWhenFigureIsNotSet() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);

    }
    @Test
    public void testFigureWhenXIsLessThenZero() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point inputPoint = new Point(-1,0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}

    }
    @Test
    public void testFigureWhenYIsLessThenZero() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point inputPoint = new Point(0,-1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}

    }
    @Test
    public void testFigureWhenXIsMoreSize() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point inputPoint = new Point(field.getSize() + 1,0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}

    }
    @Test
    public void testFigureWhenYIsMoreSize() throws Exception {
        final Field<Figure> field = new Field<>(3);
        final Point inputPoint = new Point(0,field.getSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}

    }
}