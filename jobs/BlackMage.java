package textgame.jobs;

import textgame.spells.*;

public class BlackMage extends Job {

    public BlackMage() {
		this.level = 1;
		setMaxHp(level);
		setMaxExp(level);
		setMaxMp(level);
		this.vigor = 28;
		this.speed = 33;
		this.stamina = 28;
		this.magicPower = 45;
		this.battlePower = 14;
		this.defense = 36;
		this.magicDefense = 40;
		this.mBlock = 7;
		this.evade = 14;
		//this.spells.add(new Fire());	
	}

	public void setMaxHp(int newLevel){
		maxHp = (int)Math.floor((.2 + (newLevel / 12.0)) * 100 );
		hp = maxHp;
	}

	public void setMaxMp(int newLevel){
		maxMp = (int)Math.floor((.2 + (newLevel / 14.0)) * 100 );
		mp = maxMp;
	}

	
}
