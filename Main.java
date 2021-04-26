

public class Main{
    public static void main(String[] args){
    	String[] d1 = {"n"};
    	
        Room room1 = new Room("INTERIOR", d1, "Starting room. There is nothing here.");
        String[] d2 = {"s"};
        Room room2 = new Room("INTERIOR", room1, d2, "The second room. Congratulations if you made it here!");
        Player player = new Player(room1);
        Input input = new Input(player);
        input.input();
        
    }
}