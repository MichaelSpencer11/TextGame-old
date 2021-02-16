public class Character {
    private int str;
    private int dex;
    private int con;
    private int mnd;
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

    public int GetMnd(){
        return this.mnd;
    }

    public int GetCha(){
        return this.cha;
    }

    public void SetStr(int newStr){
        this.str = newStr;
    }

    public void SetDex(int newDex){
        this.str = newDex;
    }

    public void SetCon(int newCon){
        this.con = newCon;
    }

    public void SetInte(int newMnd){
        this.mnd = newMnd;
    }

    public void SetCha(int newCha){
        this.cha = newCha;
    }

    public void Look(){
        
    }

}
