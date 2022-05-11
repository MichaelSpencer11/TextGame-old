package textgame;

public class Legs extends Item {

	public Legs(String name, boolean plural, String description, String desc2, Room room) {
		this.itemName = name;
		this.plural = plural;
		this.description = description;
		this.desc2 = desc2;
		this.itemId = itemTracker++;
		this.roomIn = room;
		this.takeable = true;
		
		room.getInventory().add(this);
	}
}
