package io.test.xo.model;

public class Game {
    private final Player[] players;
    private final Field field;
    private final String name;

    public Game(final Player[] player,
                final Field field,
                final String name) {
        this.players = player;
        this.field = field;
        this.name = name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }
}
