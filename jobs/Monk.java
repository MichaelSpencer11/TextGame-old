package textgame.jobs;

public class Monk extends Job {

    public Monk() {
		this.level = 1;
		setMaxHp(level);
		setMaxExp(level);
		this.mp = 23;
		this.vigor = 47;
		this.speed = 37;
		this.stamina = 39;
		this.magicPower = 28;
		this.battlePower = 26;
		this.defense = 42;
		this.magicDefense = 21;
		this.mBlock = 4;
		this.evade = 12;
	}

	public void setMaxHp(int newLevel){
		maxHp = (int)Math.floor((.28 + (newLevel / 8.0)) * 100 );
		hp = maxHp;
	}

	public void setMaxMp(int newLevel){
		maxMp = (int)Math.floor((.18 + (newLevel / 23.0)) * 100 );
		mp = maxMp;
	}
}
