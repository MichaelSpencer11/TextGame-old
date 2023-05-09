package textgame.jobs;

public class Warrior extends Job {
	
    public Warrior() {
		this.level = 1;
		setMaxHp(level);
		this.hp = maxHp;
		setMaxExp(level);
		setMaxMp(level);
		this.vigor = 50;
		this.speed = 28;
		this.stamina = 33;
		this.magicPower = 25;
		this.battlePower = 25;
		this.defense = 48;
		this.magicDefense = 30;
		this.mBlock = 1;
		this.evade = 6;
	}

	public void setMaxHp(int newLevel){
		maxHp = (int)Math.floor((.3 + (newLevel / 7.0)) * 100 );
		hp = maxHp;
	}

	public void setMaxMp(int newLevel){
		maxMp = (int)Math.floor((.16 + (newLevel / 25.0)) * 100 );
		mp = maxMp;
	}
}
