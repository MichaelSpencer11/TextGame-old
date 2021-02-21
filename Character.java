

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

    public void setInte(int newMnd){
        this.mnd = newMnd;
    }

    public void setCha(int newCha){
        this.cha = newCha;
    }

    public void Look(){
        System.out.println("You look around a bit.");
        System.out.println("The room seems to be " + currentRoom.getTerrainType());
    }

    public void openDoor(Door door) {
        door.setOpened();
        System.out.println("You open the door.");
    }

    public void closeDoor(Door door){
        door.setClosed();
        System.out.println("You close the door.");
    }
    
}
