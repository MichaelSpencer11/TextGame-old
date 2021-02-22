

public class Main{
    public static void main(String[] args){
        Door door1 = new Door("north");
        Door[] doors = {door1};
        Room room1 = new Room("INTERIOR", doors);
        Player player = new Player(room1);
        Input input = new Input();
        

    }
}