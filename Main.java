

public class Main{
    public static void main(String[] args){
        Door door1 = new Door("north");
        Door door2 = new Door("east");
        Door[] doors1 = {door1, door2};
        
        Room room1 = new Room("INTERIOR", doors1);
        Player player = new Player(room1);
        Input input = new Input(player);
        input.input();

        

    }
}