package textgame;

import java.util.ArrayList;
import java.util.Scanner;
import textgame.battle.Battle;

//this is where all the commands live. 
//there is an instance of the player so you can call the player's methods
public class Input{

    Scanner scanner = new Scanner(System.in);
    Character thisPlayer;

    public Input(Character player){
        this.thisPlayer = player;
        this.thisPlayer.currentRoom = player.currentRoom;
    }
    public void input(){
        
        System.out.println(ConsoleColors.CYAN + "Hello, welcome. Please 'look' or 'l' to look around the room. 'Take' some items and 'equip', 'unequip', and 'drop' them. Type 'help' to get some." + ConsoleColors.RESET );

        while(true){
            
            System.out.print(ConsoleColors.GREEN + ">>>" + ConsoleColors.RESET);
            String inputString = scanner.nextLine();
            try {
            if(inputString.equals("")){
                continue;
            }
            //there is a problem with the order of the input calls
            //if they are in the wrong order, the wrong method will get called
            //if more conflicts happen later, we can use some intermediate
            //routing for these method calls
            else if (inputString.length() > 3 && inputString.substring(0,4).equals("look")){
                thisPlayer.look(inputString);
            }
            else if(inputString.equals("l")) {
            	thisPlayer.look(inputString);
            }
            else if(inputString.equals("status")){
                thisPlayer.status();
            }
            else if(inputString.equals("party list")){
                System.out.println(inputString);
                thisPlayer.currentParty.listMembers();
            }
            else if(inputString.equals("battle")){
                new Battle(thisPlayer, thisPlayer.getTarget(), thisPlayer.getCurrentRoom());
            }
            else if(inputString.substring(0, 3).equals("use")){
                thisPlayer.use(inputString, thisPlayer);
            }
            else if (inputString.length() > 3 && inputString.substring(0,4).equals("exit")){
                System.exit(0);
            }
            else if(inputString.length() > 3 && inputString.substring(0,12).equals("party create")){
                Party.createParty(inputString.substring(13), thisPlayer);
            }
            else if(inputString.length() > 3 && inputString.substring(0, 9).equals("party add")){
                thisPlayer.currentParty.addMember(inputString.substring(10));
            }
            
            else if (inputString.length() > 3 && inputString.substring(0,thisPlayer.familiar.getName().length()).toLowerCase().equals(thisPlayer.familiar.getName().toLowerCase())){
                thisPlayer.familiar.buddyRequest(inputString);
            }
            else if(inputString.length() > 3 && inputString.substring(0,4).equals("wake")) {
            	thisPlayer.wake();
            }
            else if(inputString.length() > 3 && inputString.substring(0,4).equals("open")){
                thisPlayer.open(inputString);
            }
            else if(inputString.length() > 3 && inputString.substring(0,5).equals("close")){
                thisPlayer.closeDoor(inputString);
            }
            else if(inputString.length() > 3 && inputString.substring(0,4).equals("call")){
                thisPlayer.familiar.goToPlayer();
            }
            else if(inputString.length() > 3 && inputString.substring(0,4).equals("take")) {
            	thisPlayer.take(inputString);
            }
            else if(inputString.length() > 3 && inputString.substring(0).equals("lie in bed")){
            	thisPlayer.lieInBed();
            }
            else if(inputString.length() > 3 && inputString.substring(0,4).equals("help")) {
            	thisPlayer.help(inputString);
            }
            else if(inputString.equals("stand")) {
            	thisPlayer.stand();
            }
            else if(inputString.length() > 3 && inputString.substring(0,6).equals("target")){
                thisPlayer.target(inputString.substring(7));
            }
            else if(inputString.equals("targeting")){
                System.out.println(thisPlayer.target.name);
            }
            else if(inputString.length() > 3 && inputString.substring(0,4).equals("talk")) {
            	thisPlayer.talk(inputString);
            }
            else if (inputString.length() > 3 && inputString.substring(0,5).equals("think")) {
            	thisPlayer.think(inputString);
            }
            else if (inputString.length() > 3 && inputString.substring(0,5).equals("sleep")) {
            	thisPlayer.sleep();
            }
            else if(inputString.length() > 3 && inputString.substring(0,8).equals("lie down")) {
            	thisPlayer.lieDown();
            }
            else if(inputString.length() > 3 && inputString.substring(0,5).equals("equip")) {
            	thisPlayer.equip(inputString);
            }
            else if(inputString.length() > 3 && inputString.substring(0,7).equals("unequip")) {
            	thisPlayer.unequip(inputString);
            }
            else if(inputString.length() > 3 && inputString.substring(0,4).equals("drop")) {
            	thisPlayer.drop(inputString);
            }
            else if(inputString.length() > 3 && inputString.substring(0,4).equals("give")) {
            	thisPlayer.give(inputString);
            }
            else if(inputString.length() > 3 && inputString.substring(0,9).equals("follow me")) {
            	thisPlayer.followMe(inputString);
            }
            else if(inputString.length() > 3 && inputString.substring(0,11).equals("unfollow me")) {
            	thisPlayer.unFollowMe(inputString);
            }
            else if (inputString.equals("sit")) {
            	thisPlayer.sit();
            }
            else if(inputString.equals("n")){
                thisPlayer.move(inputString);
            }
            else if(inputString.equals("ne")){
                thisPlayer.move(inputString);
            }
            else if(inputString.equals("e")){
                thisPlayer.move(inputString);
            }
            else if(inputString.equals("se")){
                thisPlayer.move(inputString);
            }
            else if(inputString.equals("s")){
                thisPlayer.move(inputString);
            }
            else if(inputString.equals("sw")){
                thisPlayer.move(inputString);
            }
            else if(inputString.equals("w")){
                thisPlayer.move(inputString);
            }
            else if(inputString.equals("nw")){
                thisPlayer.move(inputString);
            }
            else if(inputString.equals("u")){
                thisPlayer.move(inputString);
            }
            else if(inputString.equals("d")){
                thisPlayer.move(inputString);
            }
            else if(inputString.equals("i") || inputString.equals("inv")){
                thisPlayer.printInv();
            }
            else continue;
            } catch (Exception e) {
            	System.out.println(ConsoleColors.RED + "That didn't work, please try that again. Type 'help' for a list of commands." + ConsoleColors.RESET);
            	continue;
            }
            
        }

    }
    


    
    
}
