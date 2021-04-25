

public class Character {
    protected String name;
    protected String pronounString;
    protected enum pronoun{M, F, NB};
    protected String raceString;
    protected enum race{Human, Elf, Orc};
    protected String areaString;
    protected enum area{Land, Sea, Space};
    protected String areaRace;
    protected boolean standing;
    protected boolean sitting;
    protected boolean prone;
    protected int str;
    protected int dex;
    protected int end;
    protected int mnd;
    protected int cha;
    protected int luc;
    protected Room currentRoom;

    public Character(){
        
    }

    public String getName(){
        return this.name;
    }

    //public String getPronoun() {
        
    //}

    public int getStr(){
        return this.str;
    }

    public int getDex(){
        return this.dex;
    }

    public int getCon(){
        return this.end;
    }

    public int getMnd(){
        return this.mnd;
    }

    public int getCha(){
        return this.cha;
    }

    public void setStr(int newStr){
        this.str = newStr;
    }

    public void setDex(int newDex){
        this.str = newDex;
    }

    public void setEnd(int newEnd){
        this.end = newEnd;
    }

    public void setMnd(int newMnd){
        this.mnd = newMnd;
    }

    public void setCha(int newCha){
        this.cha = newCha;
    }

    public void look(Room currentRoom, String inputString){
        int count = 0;
        if (inputString.equals("look")){
        System.out.println("You look around a bit.");
        System.out.println("The room seems to be of type " + currentRoom.getTerrainType() + ".");
        for (int i = 0; i < currentRoom.doors.length; i++){
            System.out.println("There is a door to the " + currentRoom.doors[i].getDoorDir());
        }
        return;
        }
        
        if(currentRoom.getDoorsNum() == 1 && inputString.equals("look door")){
            System.out.println("There is a door here.");
            if(currentRoom.doors[0].getOpened()){
                System.out.println("The door is open.");
            }
            else {
                System.out.println("The door is closed.");
            }
        }
        else if (currentRoom.getDoorsNum() > 1 && inputString.equals("look door")){
            System.out.println("Which door would you like to look at?");
            return;
        }

        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("n")){
            for(Door door : currentRoom.doors){
                if(door.getDoorDir().equals("north") && door.getOpened()){
                    System.out.println("The door to the north is open.");
                    count++;
                }
                else if(door.getDoorDir().equals("north") && !door.getOpened()){
                    System.out.println("The door to the north is closed.");
                    count++;
                }
                
            }
            if(count == 0){
                System.out.println("There is no door in that direction.");
            }
            return;
        }
        else if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("e") ){
            for(Door door : currentRoom.doors){
                if(door.getDoorDir().equals("east") && door.getOpened()){
                    System.out.println("The door to the east is open.");
                    count++;
                }
                else if(door.getDoorDir().equals("east") && !door.getOpened()){
                    System.out.println("The door to the east is closed.");
                    count++;
                }
                
            }
            if(count == 0){
                System.out.println("There is no door in that direction.");
            }
            return;
        }
        else if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("s")){
            for(Door door : currentRoom.doors){
                if(door.getDoorDir().equals("south") && door.getOpened()){
                    System.out.println("The door to the south is open.");
                    count++;
                }
                else if(door.getDoorDir().equals("south") && !door.getOpened()){
                    System.out.println("The door to the south is closed.");
                    count++;
                }
                
            }
            if (count == 0){
                System.out.println("There is no door in that direction.");
            }
            
            return;
        }
        else if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("w") ){
            for(Door door : currentRoom.doors){
                if(door.getDoorDir().equals("west") && door.getOpened()){
                    System.out.println("The door to the west is open.");
                    count++;
                }
                else if(door.getDoorDir().equals("west") && !door.getOpened()){
                    System.out.println("The door to the west is closed.");
                    count++;
                }
                
            }
            if (count == 0){
                System.out.println("There is no door in that direction.");
            }
            return;
        }
        else if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("ne")){
            for(Door door : currentRoom.doors){
                if(door.getDoorDir().equals("northeast") && door.getOpened()){
                    System.out.println("The door to the northeast is open.");
                    count++;
                }
                else if(door.getDoorDir().equals("northeast") && !door.getOpened()){
                    System.out.println("The door to the northeast is closed.");
                    count++;
                }
                
            }
            if (count == 0){
                System.out.println("There is no door in that direction.");
            }
            return;
        }
        
        else if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("se") ){
            for(Door door : currentRoom.doors){
                if(door.getDoorDir().equals("southeast") && door.getOpened()){
                    System.out.println("The door to the southeast is open.");
                    count++;
                }
                else if(door.getDoorDir().equals("southeast") && !door.getOpened()){
                    System.out.println("The door to the southeast is closed.");
                    count++;
                }
                
            }
            if (count == 0){
                System.out.println("There is no door in that direction.");
            }
            return;
        }
        
        else if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("sw") ){
            for(Door door : currentRoom.doors){
                if(door.getDoorDir().equals("southwest") && door.getOpened()){
                    System.out.println("The door to the southwest is open.");
                    count++;
                }
                else if(door.getDoorDir().equals("southwest") && !door.getOpened()){
                    System.out.println("The door to the southwest is closed.");
                    count++;
                }
                
            }
            if (count == 0){
                System.out.println("There is no door in that direction.");
            }
            return;
        }
        
        else if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("nw") ){
            for(Door door : currentRoom.doors){
                if(door.getDoorDir().equals("northwest") && door.getOpened()){
                    System.out.println("The door to the northwest is open.");
                    count++;
                }
                else if(door.getDoorDir().equals("northwest") && !door.getOpened()){
                    System.out.println("The door to the northwest is closed.");
                    count++;
                }
                
            }
            if (count == 0){
                System.out.println("There is no door in that direction.");
            }
            return;
        }
        else {
            System.out.println("There is no door in that direction.");
        }
    }

    public void open(Room currentRoom, String inputString) {
        //check if the door is open or closed
        //check if the door is locked
        //open door
        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("n")){
            for(Door door : currentRoom.doors){
            if(door.getDoorDir().equals("north") && door.getLocked()){
                System.out.println("The door to the north is locked.");
                return;
            }
            if(door.getDoorDir().equals("north") && door.getOpened()){
                System.out.println("The door to the north is already open.");
                return;
            }
            else if(door.getDoorDir().equals("north") && !door.getOpened()){
                System.out.println("You open the door to the north.");
                door.setOpened();
                return;
            }

            }
        }
        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("ne")){
            for(Door door : currentRoom.doors){
            if(door.getDoorDir().equals("northeast") && door.getLocked()){
                System.out.println("The door to the northeast is locked.");
                return;
            }
            if(door.getDoorDir().equals("northeast") && door.getOpened()){
                System.out.println("The door to the northeast is already open.");
                return;
            }
            else if(door.getDoorDir().equals("northeast") && !door.getOpened()){
                System.out.println("You open the door to the northeast.");
                door.setOpened();
                return;
            }

            }
        }
        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("e")){
            for(Door door : currentRoom.doors){
            if(door.getDoorDir().equals("east") && door.getLocked()){
                System.out.println("The door to the east is locked.");
                return;
            }
            if(door.getDoorDir().equals("east") && door.getOpened()){
                System.out.println("The door to the east is already open.");
                return;
            }
            else if(door.getDoorDir().equals("east") && !door.getOpened()){
                System.out.println("You open the door to the east.");
                door.setOpened();
                return;
            }

            }
        }
        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("se")){
            for(Door door : currentRoom.doors){
            if(door.getDoorDir().equals("southeast") && door.getLocked()){
                System.out.println("The door to the southeast is locked.");
                return;
            }
            if(door.getDoorDir().equals("southeast") && door.getOpened()){
                System.out.println("The door to the southeast is already open.");
                return;
            }
            else if(door.getDoorDir().equals("southeast") && !door.getOpened()){
                System.out.println("You open the door to the southeast.");
                door.setOpened();
                return;
            }

            }
        }
        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("s")){
            for(Door door : currentRoom.doors){
            if(door.getDoorDir().equals("south") && door.getLocked()){
                System.out.println("The door to the south is locked.");
                return;
            }
            if(door.getDoorDir().equals("south") && door.getOpened()){
                System.out.println("The door to the south is already open.");
                return;
            }
            else if(door.getDoorDir().equals("south") && !door.getOpened()){
                System.out.println("You open the door to the south.");
                door.setOpened();
                return;
            }

            }
        }
        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("sw")){
            for(Door door : currentRoom.doors){
            if(door.getDoorDir().equals("southwest") && door.getLocked()){
                System.out.println("The door to the southwest is locked.");
                return;
            }
            if(door.getDoorDir().equals("southwest") && door.getOpened()){
                System.out.println("The door to the southwest is already open.");
                return;
            }
            else if(door.getDoorDir().equals("southwest") && !door.getOpened()){
                System.out.println("You open the door to the southwest.");
                door.setOpened();
                return;
            }

            }
        }
        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("w")){
            for(Door door : currentRoom.doors){
            if(door.getDoorDir().equals("west") && door.getLocked()){
                System.out.println("The door to the west is locked.");
                return;
            }
            if(door.getDoorDir().equals("west") && door.getOpened()){
                System.out.println("The door to the west is already open.");
                return;
            }
            else if(door.getDoorDir().equals("west") && !door.getOpened()){
                System.out.println("You open the door to the west.");
                door.setOpened();
                return;
            }

            }
        }
        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("nw")){
            for(Door door : currentRoom.doors){
            if(door.getDoorDir().equals("northwest") && door.getLocked()){
                System.out.println("The door to the northwest is locked.");
                return;
            }
            if(door.getDoorDir().equals("northwest") && door.getOpened()){
                System.out.println("The door to the northwest is already open.");
                return;
            }
            else if(door.getDoorDir().equals("northwest") && !door.getOpened()){
                System.out.println("You open the door to the north.");
                door.setOpened();
                return;
            }

            }
        }

    }

    public void move(Room currentRoom, String inputString){
        if (inputString.equals("n")){
                if(currentRoom.getHasN()){
                	currentRoom = currentRoom.getnRoom();
                    System.out.println("You move to the north.");
                }
        }
        
        if (inputString.equals("ne")){
            if(currentRoom.getHasNE()){
            	currentRoom = currentRoom.getNeRoom();
                System.out.println("You move to the northeast.");
            }
    }
        
        if (inputString.equals("e")){
            if(currentRoom.getHasE()){
            	currentRoom = currentRoom.geteRoom();
                System.out.println("You move to the east.");
            }
    }
        
        if (inputString.equals("se")){
            if(currentRoom.getHasSE()){
            	currentRoom = currentRoom.getSeRoom();
                System.out.println("You move to the southeast.");
            }
    }
        
        if (inputString.equals("s")){
            if(currentRoom.getHasS()){
            	currentRoom = currentRoom.getsRoom();
                System.out.println("You move to the south.");
            }
    }
        
        if (inputString.equals("sw")){
            if(currentRoom.getHasSW()){
            	currentRoom = currentRoom.getSwRoom();
                System.out.println("You move to the southwest.");
            }
    }
        
        if (inputString.equals("w")){
            if(currentRoom.getHasW()){
            	currentRoom = currentRoom.getwRoom();
                System.out.println("You move to the west.");
            }
    }
        
        if (inputString.equals("nw")){
            if(currentRoom.getHasNW()){
            	currentRoom = currentRoom.getNwRoom();
                System.out.println("You move to the northwest.");
            }
    }
        
        if (inputString.equals("u")){
            if(currentRoom.getHasU()){
            	currentRoom = currentRoom.getuRoom();
                System.out.println("You move up.");
            }
    }
        
        if (inputString.equals("d")){
            if(currentRoom.getHasD()){
            	currentRoom = currentRoom.getdRoom();
                System.out.println("You move down.");
            }
    }

    }
    

    public void closeDoor(Door door){
        door.setClosed();
        System.out.println("You close the door.");
    }

    public void setCurrentRoom(Room newRoom) {
    	this.currentRoom = newRoom;
    }
    
    
}
