import Terrain.terrain;

public class Main{
    public static void main(String[] args){
        Room room1 = new Room("INTERIOR");
        Player player = new Player(room1);
        player.Look();

    }
}