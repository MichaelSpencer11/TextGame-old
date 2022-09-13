package textgame;

import java.util.ArrayList;

import textgame.battle.BattleMenu;
import textgame.util.Random;
import textgame.battle.Battle;

public class Monster {
	protected String name;
	protected int level;
	protected int hp;
	protected int mp;
	protected int xp;
	protected int gp;
	protected int battlePower;
	protected int vigor = Random.roll(56,63);
	protected int vigor2 = vigor * 2;
	protected int hitRate;
	protected int magicPower;
	protected int speed;
	protected int stamina;
	protected int defense;
	protected int magicDefense;
	protected int evade;
	protected int MBlock;
	protected int blockValue = (255 - this.getMBlock() * 2) + 1;
	protected ArrayList<Item> stolenItems;
	protected ArrayList<Item> drops;
	protected Room roomIn;
	protected String description;
	protected int atbGauge = 0;
	protected Character target;
	protected boolean protect;
	protected boolean berserked;
	protected int critChance = Random.roll(1,32);

	public String typeToString() {
		return this.getClass().toString().substring(24);
	}

	public void incrementATBGauge() {
		this.atbGauge += (96 * (speed + 20)) / 16;
    }

	public void startCounter(Battle battleContext){
			while(battleContext.getPlayer().getHp() > 0){
				World.setTimeout(() -> incrementATBGauge(), this.getSpeed() );
				if(this.atbGauge >= 65536 ){
					new BattleMenu(this, battleContext);
				}
			}
		
	}

	public void attack() {

	}

	public void applyDamage(int damage){
		this.hp = this.hp - damage;
	}

	public String getName () {return name;}
	public int getLevel () {return level;}
	public int getHp () {return hp;}
	public int getMp () {return mp;}
	public int getXp () {return xp;}
	public int getGp () {return gp;}
	public int getBattlePower () {return battlePower;}
	public int getHitRate () {return hitRate;}
	public int getMagicPower () {return magicPower;}
	public int getSpeed () {return speed;}
	public int getStamina () {return stamina;}
	public int getDefense () {return defense;}
	public int getMagicDefense () {return magicDefense;}
	public int getEvade () {return evade;}
	public boolean getProtect(){return protect;}
	public int getMBlock () {return MBlock;}
	public int getBlockValue(){return blockValue;}
	public ArrayList<Item> getStolenItems () {return stolenItems;}
	public ArrayList<Item> getDrops () {return drops;}
	public String getDescription() {return description;}
	public boolean getBerserked() {return berserked;}
	public int getCritChance() {return critChance;}
	public int getVigor2() {return vigor2;}

	
}
