package textgame.jobs;

import java.util.Random;
import textgame.Item;
import textgame.jobs.Job;
import textgame.Monster;
import textgame.Player;

public class Thief extends Job {
	public Thief() {
		this.level = 1;
		setMaxExp(level);
		setMaxHp(level);
		this.hp = maxHp;
		setMaxMp(level);
		this.vigor = 37;
		this.speed = 40;
		this.stamina = 31;
		this.magicPower = 28;
		this.battlePower = 14;
		this.defense = 38;
		this.magicDefense = 23;
		this.mBlock = 2;
		this.evade = 15;
	}
	
	public void steal(Monster monster, Player player) {
		Random r = new Random();
		int selected = r.nextInt(monster.getStolenItems().size());
		Item stolen = monster.getStolenItems().get(selected);
		monster.getStolenItems().remove(selected);
		player.getInventory().add(stolen);
		
	}

	public void setMaxHp(int newLevel){
		maxHp = (int)Math.floor((.2 + (newLevel / 10.0) ) * 100);
		hp = maxHp;
	}

	public void setMaxMp(int newLevel){
		maxMp = (int)Math.floor((.17 + (newLevel / 22.0)) * 100 );
		mp = maxMp;
	}

}
