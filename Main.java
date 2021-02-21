import java.io.Console;

public class Main{
    public static void main(String[] args){
        Console console = System.console();
        Room room1 = new Room("INTERIOR");
        Player player = new Player(room1);
        player.Look();
        console.readLine();

    }
}