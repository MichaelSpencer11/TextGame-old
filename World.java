

public class World {
	public Input input;
	
	
	public World() {
		
		
	}
	
	public void createWorld() {
		
		String[] d1 = {"s"};
        Room room1 = new Room("INTERIOR", d1, "This is your room. Your twin size bed is against one wall. Your desk is against another. There is a black computer monitor, a keyboard and a mouse on the desk. The computer is turned " + computer.getOnOff() + ".");
        String[] d2 = {"s"};
        Room room2 = new Room("INTERIOR", room1, d2, "The second room. Congratulations if you made it here!");
        Player player = new Player(room1);
        Input input = new Input(player);
        input.input();
	}
	
}
