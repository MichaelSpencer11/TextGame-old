package textgame.jobs;

public class RedMage extends Job {

    public RedMage() {
		this.level = 1;
		setMaxHp(level);
		setMaxExp(level);
		setMaxMp(level);
		this.vigor = 34;
		this.speed = 34;
		this.stamina = 31;
		this.magicPower = 38;
		this.battlePower = 20;
		this.defense = 40;
		this.magicDefense = 40;
		this.mBlock = 9;
		this.evade = 14;
		
	}

	public void setMaxHp(int newLevel){
		maxHp = (int)Math.floor((.24 + (newLevel / 9.0)) * 100 );
		hp = maxHp;
	}

	public void setMaxMp(int newLevel){
		maxMp = (int)Math.floor((.2 + (newLevel / 16.0)) * 100 );
		mp = maxMp;
	}
}
