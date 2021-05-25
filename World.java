import java.util.Random;

public class World {
	public Input input;
	
	
	public World() {
		
		
	}
	
	//this section before createWorld() will be for global helper methods
	
	//these will print "a" or "an" depending on if the word passed starts with a vowel or a consonant
	public static String aAn(String thing) {
		if(thing.toLowerCase().startsWith("a") ||
				thing.toLowerCase().startsWith("e") ||
				thing.toLowerCase().startsWith("i") ||
				thing.toLowerCase().startsWith("o") ||
				thing.toLowerCase().startsWith("u") ||
				thing.toLowerCase().startsWith("y")){
			return "an";
		} else return "a";
	}
	
	public static String capAAn(String thing) {
		if(thing.toLowerCase().startsWith("a") ||
				thing.toLowerCase().startsWith("e") ||
				thing.toLowerCase().startsWith("i") ||
				thing.toLowerCase().startsWith("o") ||
				thing.toLowerCase().startsWith("u") ||
				thing.toLowerCase().startsWith("y")){
			return "An";
		} else return "A";
	}
	
	
	//this creates the world and begins the game. This is where you will place all the things to go in the world.
	public void createWorld() {
		
        Room room = new Room("interior", "This is your room. Your twin size bed is against one wall. Your desk is against another. There is a black computer monitor, a keyboard and a mouse on the desk.", "w", "s");
        Room playerCloset = new Room("interior", "Your walk-in closet. There are clothes hanging up in the closet and some on the floor neatly placed under the racks.", null, null, room, null, null, null, null, null, null, null);
        Room hallwayStairs = new Room("interior", "The upstairs hallway in your home. There is a stairway here that goes down.", room, null, null,null,null,null,null,null,null,null);
        Room hallway = new Room("interior", "The upstairs hallway in your house. There is a bannister next to the staircase and a way to the bathroom and your parents' room.", null, null, null, null, null, null, hallwayStairs, null, null, null);
        Room bathroom = new Room("interior", "The upstairs bathroom in your house. There is a large garden tub, a toilet and a sink. The room is decorated in floral drapes and leafy brown towels.", null, null, null, null, hallway, null, null, null, null, null);
        Room parentsRoom = new Room("interior", "Your parents' master bedroom. There is a king size bed with end tables and a dresser.", null, null, null, null, null, null, hallway, null, null, null);
        Room stairway = new Room("interior", "The bottom of the stairway at your house. The stairs are carpeted with a thick woolish material and are alternating tan and brown.", null, null, null, null, null, null, null, null, hallwayStairs, null);
        Room kitchen = new Room("interior", "Your home's kitchen. It is pretty well stocked with cooking utensils, spices and various foods. There is also a kitchen island for extra counter space.", null, null, null, null, stairway, null, null, null, null, null);
        Room diningRoom = new Room("interior", "Your home's dining room. There is an oak table. Against the wall is a cabinet with cookbooks and various trinkets.", null, null, null, null, null, stairway, kitchen, null, null, null);
        Room livingRoom = new Room("interior", "Your living room is sort of dusty as it hasn't seen much use lately. There is a tv screen on one wall and some paintings.", diningRoom, null, null, null, null, null, stairway, null, null, null);
        Room backyard = new Room("grass", "The backyard's grass is getting a little long. There is a patio with a table and chairs and an old grill with rust on it. \nA brown fence surrounds the grass and there is a gate at the back.", null, null, null, null, diningRoom, null, null, null, null, null);
        Room frontYard = new Room("grass", "The front yard in front of your house. There is a small path in front of the house and some tall grass.", livingRoom, null, null, null, null, null, null, null, null, null);
        Room wpStreet3 = new Room("town", "West Peregrine street in front of your house. It's pretty quiet around here most of the time, an occasional car goes by.", frontYard, null, null, null, null, null, null, null, null, null);
        Room wpStreet2 = new Room("town", "West Peregrine street in front of house number 2 west. There are some cherry trees on this part of the street.", null, null, null, null, null, null, wpStreet3, null, null, null);
        Room wpStreet1 = new Room("town", "A quiet part of Peregrine street. There is an oak tree on this part of the street.", null, null, null, null, null, null, wpStreet2, null, null, null);
        Room mainSquare = new Room("town", "The center of Tsiporim town, where Main and Peregrine streets cross.", null, null, null, null, null, null, wpStreet1, null, null, null);
        Room epStreet1 = new Room("town", "East Peregrine street. The general store is to the north. There is not much going on around here.", null, null, null, null, null, null, mainSquare, null, null, null );
        Item practiceStaff = new Tool("wooden staff", "A wooden practice staff. It has a few nicks and cuts in it and is quite worn.", "The staff feels as heavy as a metal staff in your hand, but it is still made out of wood.", playerCloset);
        Item practicesword = new Tool("wooden sword", "A wooden practice sword. It has a few nicks and cuts in it and is quite worn.", "The sword feels as heavy as a metal sword in your hand, but it is still made out of wood.", playerCloset);
        Item noviceHood = new Head("novice hood", "A basic looking hood made of cotton.", "This hood is lined with some thick fabric on the inside.", playerCloset);
        Item bracelets = new Hands("bracelets", true, "A pair of bracelets made out of small colorful beads.", "The beads are made up of tiny crystals.", playerCloset);
        Item shirt = new Body("cotton shirt", "A white cotton shirt.", "The brand on the tag is unreadable.", playerCloset);
        Item cape = new Back("cotton cape", "A simple grey cotton cape.", "There are small fringes on the ends of this cape.", playerCloset);
        Item jeans = new Legs("jeans", true, "A slightly worn pair of black jeans.", "The brand name on the tag reads 'Lev'.", playerCloset);
        Item mocs = new Feet("moccasins", true, "A pair of tan leather moccasins.", "You remember making these yourself.", playerCloset);
        Item silverRing = new Ring("silver ring", false, "A simple looking silver ring.", "On the inside of the ring there is a circle.", playerCloset);
        Item redRing = new Ring("red ring", false, "A simple lookinng red ring.", "This ring seems to be made out of some fiery red substance.", playerCloset);
        Item desk = new Desk("desk", "Your wooden desk in your room. It has a few nicks in the finish but is very sturdy.", room);
        Player player = new Player(room);
        Character familiar = new Familiar("Someone is standing or floating here, it is very hard to see them, they are almost not there but you know that there is definitely a presence here.", room);
        Character practiceRobot = new Automaton("An ordinary looking automaton with mechanical limbs and a rudimentary programmed action stack. It is currently sitting in a corner non-functionally." , room);
        System.out.println("Hi, welcome. Please 'look' or 'l' to look around the room. 'Take' some items and 'equip', 'unequip', and 'drop' them. Type 'help' to get some." );
        Input input = new Input(player);
        input.input();
	}
	
}
