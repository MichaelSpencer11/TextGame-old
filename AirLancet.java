package textgame;

public class AirLancet extends Weapon {
	public AirLancet() {
		this.type = "Dirk";
		this.battlePower = 76;
		this.hitRate = 180;
		this.equipableBy.setThief(true);
		this.equipableBy.setWhiteMage(true);
		this.equipableBy.setBlackMage(true);
		this.description = "Wind-elemental";
		this.canThrow = true;
		this.canUseSwdtech = false;
		this.canUseRunic = true;
		this.canUse2Handed = true;
		this.element = "Wind";
		this.specialEffect = null;
		
		
	}
	
}
