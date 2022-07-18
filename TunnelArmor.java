package textgame;

public class TunnelArmor extends Monster {
	public TunnelArmor() {
		
		
		this.level = 16;
		this.hp = 1300;
		this.mp = 900;
		this.xp = 0;
		this.gp = 250;
		this.battlePower = 10;
		this.hitRate = 100;
		this.magicPower = 15;
		this.speed = 40;
		this.stamina = 2;
		this.defense = 29;
		this.magicDefense = 145;
		this.evade = 0;
		this.MBlock = 0;
		
		//Initialize drops for TunnelArmor
		final Weapon airLancet = new AirLancet();
		this.stolenItems.add(airLancet);
	}
}
