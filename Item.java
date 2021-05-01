
public class Item {
		protected int itemId;
		protected static int itemTracker;
		protected String itemName;
		protected String description;
		protected String desc2;
		protected Room roomIn;
		
		public Item() {
			
		}
		
		public Item(String name, String description, String desc2, Room room) {
			this.itemName = name;
			this.description = description;
			this.desc2 = desc2;
			this.itemId = itemTracker++;
			this.roomIn = room;
			
			
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
