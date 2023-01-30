import io.test.xo.model.Field;
import io.test.xo.model.Figure;
import io.test.xo.model.Game;
import io.test.xo.model.Player;
import io.test.xo.view.ConsoleView;

public class ClientXO {

    public static void main(final String[] args) {
        final String name1 = "Maksim";
        final String name2 = "Aleksandr";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game<Figure> gameXO = new Game<>(players, new Field<>(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while(consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }

}