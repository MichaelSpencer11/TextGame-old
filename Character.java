import java.util.Scanner;

public class Character {
    private String name;
    private String pronounString;
    private enum pronoun{M, F, NB};
    private enum race{LandHuman, SeaHuman, SpaceHuman, LandElf, SeaElf, SpaceElf, LandOrc, SeaOrc, SpaceOrc};
    private int str;
    private int dex;
    private int end;
    private int mnd;
    private int cha;

    public Character(){
        Scanner conScanner = new Scanner(System.in);
        System.out.println("What is your name?");
        this.name = conScanner.nextLine();
        System.out.println("What is your preferred nomenclature?(M, F, NB)?");
        switch(conScanner.nextLine()) {
            case "M": 
            pronounString = pronoun.M.toString();
            case "F":
            pronounString = pronoun.M.toString();
            case "NB":
            pronounString = pronoun.NB.toString();
        }

    }

    public String getName(){
        return this.name;
    }

    public String getPronoun() {
        
    }

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
    }


}
