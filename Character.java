public class Character {
    private int str;
    private int dex;
    private int con;
    private int int;
    private int wis;
    private int cha;

    public Character(){

    }

    public int GetStr(){
        return this.str;
    }

    public int GetDex(){
        return this.dex;
    }

    public int GetCon(){
        return this.con;
    }

    public int GetInt(){
        return this.int;
    }

    public int GetWis(){
        return this.wis;
    }

    public int GetCha(){
        return this.cha;
    }

    public int SetStr(int newStr){
        this.str = newStr;
    }

    public int SetDex(int newDex){
        this.str = newDex;
    }

    public int SetCon(int newCon){
        this.con = newCon;
    }

    public int SetInt(int newInt){
        this.int = newInt;
    }

    public int SetWis(int newWis){
        this.wis = newWis;
    }

    public int SetCha(int newCha){
        this.cha = newCha;
    }

}
