

public class World {
	public Input input;
	
	
	public World() {
		
		
	}
	
	public void createWorld() {
		
        Room room1 = new Room("INTERIOR", "This is your room. Your twin size bed is against one wall. Your desk is against another. There is a black computer monitor, a keyboard and a mouse on the desk.", "s");
        Item practiceStaff = new Weapon("wooden staff", "A wooden practice staff. It has a few nicks and cuts in it and is quite worn.", "The staff feels as heavy as a metal staff in your hand, but it is still made out of wood.", room1);
        Item practicesword = new Weapon("wooden sword", "A wooden practice sword. It has a few nicks and cuts in it and is quite worn.", "The sword feels as heavy as a metal sword in your hand, but it is still made out of wood.", room1);
        Item noviceHood = new Head("novice hood", "A basic looking hood made of cotton.", "This hood is lined with some thick fabric on the inside.", room1);
        Item bracelets = new Hands("bracelets", true, "A pair of bracelets made out of small colorful beads.", "The beads are made up of tiny crystals.", room1);
        Item shirt = new Body("cotton shirt", "A white cotton shirt.", "The brand on the tag is unreadable.", room1);
        Item cape = new Back("cotton cape", "A simple grey cotton cape.", "There are small fringes on the ends of this cape.", room1);
        Item jeans = new Legs("jeans", true, "A slightly worn pair of black jeans.", "The brand name on the tag reads 'Lev'.", room1);
        Item mocs = new Feet("moccasins", true, "A pair of tan leather moccasins.", "You remember making these yourself.", room1);
        Item silverRing = new Ring("silver ring", false, "A simple looking silver ring.", "On the inside of the ring there is a circle.", room1);
        Item redRing = new Ring("red ring", false, "A simple lookinng red ring.", "This ring seems to be made out of some fiery red substance.", room1);
        Room room2 = new Room("INTERIOR", "The second room. Congratulations if you made it here!", room1, "n");
        Player player = new Player(room1);
        Character familiar = new Character("Familiar", room1);
        System.out.println("Hi, welcome. Please 'look' or 'l' to look around the room. 'Take' some items and 'equip', 'unequip', and 'drop' them." );
        Input input = new Input(player);
        input.input();
	}
	
}
