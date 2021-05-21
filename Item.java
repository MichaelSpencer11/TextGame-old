
//there are items in the game, here are some attributes and stuff
public class Item {
		protected int itemId;
		protected static int itemTracker;
		protected String itemName;
		protected String description;
		protected String desc2;
		protected Room roomIn;
		protected boolean equipped;
		protected boolean plural;
		protected boolean takeable;
		
		public Item() {
			
		}
		
		public Item(String name, boolean plural, String description, String desc2, Room room) {
			this.itemName = name;
			this.plural = plural;
			this.description = description;
			this.desc2 = desc2;
			this.itemId = itemTracker++;
			this.roomIn = room;
			this.takeable = true;
			
			room.getInventory().add(this);
			
			
		}
		
		public String getItemName() {
			return itemName;
		}
		
		public String getDescription() {
			return this.description;
		}
		
		public String getDesc2() {
			return this.desc2;
		}
		
		public String typeToString(){
			return this.getClass().toString().substring(6);
		}
	}
