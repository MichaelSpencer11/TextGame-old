package textgame.jobs;

import java.util.ArrayList;
import textgame.spells.*;
import textgame.techniques.*;

public abstract class Job {


	public int level;
	protected int hp;
	protected int maxHp;
	protected int mp;
	protected int maxMp;
	protected int exp;
	protected int maxExp;
	protected int vigor;
	protected int speed;
	protected int stamina;
	protected int magicPower;
	protected int battlePower;
	protected int defense;
	protected int magicDefense;
	protected int mBlock;
	protected int evade;
	protected ArrayList<Spell> spells;
	protected ArrayList<Technique> techniques;


	public void addHp(int hp){
		this.hp += hp;
		if (this.hp > maxHp){
			this.hp = maxHp;
		}
	}

	public void addMp(int mp){
		this.mp += mp;
		if (this.mp > maxMp){
			this.mp = maxMp;
		}
	}

	public void addExp(int exp){
		this.exp += exp;
		if(exp >= maxExp){
			new LevelUp(this, exp, maxExp);
		}
	}

	public void applyDamage(int damage){
		this.hp = this.hp - damage;
	}

	public int getLevel(){return level;}
	public void setLevel(int newLevel){level = newLevel;}
	public int getHp(){return hp;}
	public void setHp(int newHp){this.hp = newHp;}
	public int getMaxHp(){return maxHp;}
	public abstract void setMaxHp(int newLevel);
	public abstract void setMaxMp(int newLevel);
	public void setMaxExp(int newLevel){
		maxExp = (newLevel * newLevel) * 100;
	}
	public int getMp(){return mp;}
	public void setMp(int newMp){mp = newMp;}
	public int getMaxMp(){return maxMp;}
	public int getExp(){return exp;}
	public int getMaxExp(){return maxExp;}
	public int getVigor(){return vigor;}
	public int getSpeed(){return speed;}
	public int getStamina(){return stamina;}
	public int getMagicPower(){return magicPower;}
	public int getBattlePower(){return battlePower;}
	public int getDefense(){return defense;}
	public int getMagicDefense(){return magicDefense;}
	public int getMBlock(){return mBlock;}
	public int getEvade(){return evade;}
	public ArrayList<Spell> getSpells(){return spells;}
}


