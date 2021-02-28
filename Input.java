import java.util.Scanner;

public class Input{

    Scanner scanner = new Scanner(System.in);
    Player thisPlayer;
    
    public void input(){
        while(true){
            
            switch (scanner.nextLine()){
            case "look":
            thisPlayer.look(thisPlayer.currentRoom);
            break;
            case "look door":
            thisPlayer.look(thisPlayer.currentRoom, thisPlayer.currentRoom.doors);
            case "exit":
            System.exit(0);
            break;
            
            
        }

    }
    }


    public Input(Player player){
        this.thisPlayer = player;
    }
    
}
