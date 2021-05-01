import java.util.Scanner;

public class Input{

    Scanner scanner = new Scanner(System.in);
    Player thisPlayer;
    
    public void input(){
        while(true){
            System.out.print(">>>");
            String inputString = scanner.nextLine();
            try {
            if(inputString.equals("")){
                continue;
            }
            else if (inputString.length() > 3 && inputString.substring(0,4).equals("look")){
                thisPlayer.look(thisPlayer.currentRoom, inputString);
            }
            else if(inputString.equals("l")) {
            	thisPlayer.look(thisPlayer.currentRoom, inputString);
            }
            else if (inputString.length() > 3 && inputString.substring(0,4).equals("exit")){
                System.exit(0);
            }
            else if(inputString.length() > 3 && inputString.substring(0,4).equals("open")){
                thisPlayer.open(thisPlayer.currentRoom, inputString);
            }
            else if(inputString.equals("stand")) {
            	thisPlayer.stand();
            }
            else if(inputString.length() > 3 && inputString.substring(0,4).equals("take")) {
            	thisPlayer.take(thisPlayer.currentRoom, inputString);
            }
            else if(inputString.length() > 3 && inputString.substring(0,5).equals("equip")) {
            	thisPlayer.equip(inputString);
            }
            else if(inputString.equals("n")){
                thisPlayer.move(thisPlayer.currentRoom, inputString);
            }
            else if(inputString.equals("ne")){
                thisPlayer.move(thisPlayer.currentRoom, inputString);
            }
            else if(inputString.equals("e")){
                thisPlayer.move(thisPlayer.currentRoom, inputString);
            }
            else if(inputString.equals("s")){
                thisPlayer.move(thisPlayer.currentRoom, inputString);
            }
            else if(inputString.equals("sw")){
                thisPlayer.move(thisPlayer.currentRoom, inputString);
            }
            else if(inputString.equals("w")){
                thisPlayer.move(thisPlayer.currentRoom, inputString);
            }
            else if(inputString.equals("nw")){
                thisPlayer.move(thisPlayer.currentRoom, inputString);
            }
            else if(inputString.equals("u")){
                thisPlayer.move(thisPlayer.currentRoom, inputString);
            }
            else if(inputString.equals("d")){
                thisPlayer.move(thisPlayer.currentRoom, inputString);
            }
            else if(inputString.equals("i")){
                thisPlayer.printInv();
            }
            else continue;
            } catch (StringIndexOutOfBoundsException e) {
            	System.out.println("That didn't work, please try that again.");
            	continue;
            }
            
        }

    }
    


    public Input(Player player){
        this.thisPlayer = player;
    }
    
}
