package textgame.items;

import textgame.Item;
import textgame.Character;

public class Tincture extends Item {
    private int healingAmount = 50;
    private boolean empty = false;
    public Tincture(){
        this.itemName = "Tincture";
        this.dropRate = 85;
        
    }

    public void applyEffect(Character player) {
        player.getJob().addMp(healingAmount);
        if(player.getJob().getMp() > player.getJob().getMaxMp()){
            player.getJob().setMp(player.getJob().getMaxMp());
        }
        this.empty = true;
        System.out.println("You apply the Tincture to " + player.getName() + ".");
        System.out.println("MP: " + player.getJob().getMp() + "/" + player.getJob().getMaxMp());

    }
}
