package textgame.jobs;

public class WhiteMage extends Job {

    public WhiteMage() {
		this.level = 1;
		setMaxHp(level);
		setMaxExp(level);
		setMaxMp(level);
		this.vigor = 26;
		this.speed = 34;
		this.stamina = 22;
		this.magicPower = 44;
		this.battlePower = 11;
		this.defense = 35;
		this.magicDefense = 35;
		this.mBlock = 9;
		this.evade = 13;
		
	}

	public void setMaxHp(int newLevel){
		maxHp = (int)Math.floor((.18 + (newLevel / 12.0)) * 100 );
		hp = maxHp;
	}

	public void setMaxMp(int newLevel){
		maxMp = (int)Math.floor((.2 + (newLevel / 15.0)) * 100 );
		mp = maxMp;
	}
}
