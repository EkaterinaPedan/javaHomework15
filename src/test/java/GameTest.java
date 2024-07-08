import org.junit.jupiter.api.Assertions;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    @Test
    public void shouldWinPlayer1() {
        Player player1 = new Player(1, "Player 1", 13);
        Player player2 = new Player(2, "Player 2", 5);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Player 1", "Player 2");

        Assertions.assertEquals(1, actual);
    }

    @Test
    public void shouldWinPlayer2() {
        Player player1 = new Player(1, "Player 1", 5);
        Player player2 = new Player(2, "Player 2", 13);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Player 1", "Player 2");

        Assertions.assertEquals(2, actual);
    }

    @Test
    public void shouldPlayADraw() {
        Player player1 = new Player(1, "Player 1", 13);
        Player player2 = new Player(2, "Player 2", 13);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Player 1", "Player 2");

        Assertions.assertEquals(0, actual);
    }

    @Test
    public void player2NotRegisteredException() {
        Player player1 = new Player(1, "Player 1", 13);
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player 1", "Player 2");
        });
    }

    @Test
    public void player1NotRegisteredException() {
        Player player2 = new Player(2, "Player 2", 5);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player 1", "Player 2");
        });
    }

    @Test
    public void playersNotRegisteredException() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player 1", "Player 2");
        });
    }

    @Test
    public void shouldGetId() {
        Player player = new Player(7, "Player 7", 20);
        int actual = player.getId();

        Assertions.assertEquals(7, actual);
    }
}
