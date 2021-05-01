

public class World {
	public Input input;
	
	
	public World() {
		
		
	}
	
	public void createWorld() {
		
        Room room1 = new Room("INTERIOR", "This is your room. Your twin size bed is against one wall. Your desk is against another. There is a black computer monitor, a keyboard and a mouse on the desk.", "s");
        Item practiceStaff = new Weapon("wooden staff", "A wooden practice staff. It has a few nicks and cuts in it and is quite worn.", "The staff feels as heavy as a metal staff in your hand, but it is still made out of wood.", room1);
        Room room2 = new Room("INTERIOR", "The second room. Congratulations if you made it here!", room1, "n");
        Player player = new Player(room1);
        Character familiar = new Character(room1);
        Input input = new Input(player);
        input.input();
	}
	
}
