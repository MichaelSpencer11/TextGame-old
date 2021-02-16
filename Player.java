

public class Player extends Character{
    public Player() {
        this.prone = true;
        this.sitting = false;
        this.standing = false;
        Scanner conScanner = new Scanner(System.in);
        do
        System.out.println("What is your preferred nomenclature?(M, F, NB)?");
        switch(conScanner.nextLine()) {
            case "M": 
            this.pronounString = pronoun.M.toString();
            break;
            case "F":
            this.pronounString = pronoun.M.toString();
            break;
            case "NB":
            this.pronounString = pronoun.NB.toString();
            break;
            default:
            System.out.println("Please enter either M, F, or NB.");
        }
        while(pronounString != null || !pronounString.equals("") );

        do
        System.out.println("You look down at your body. What does your body look like? (1-3)");
        System.out.println("1. It looks human.");
        System.out.println("2. It looks elven.");
        System.out.println("3. It looks orcish.");
        switch(conScanner.nextLine()) {
            case "1":
            this.raceString = race.Human.toString();
            break;
            case "2":
            this.raceString = race.Elven.toString();
            break;
            case "3":
            this.raceString = race.Orc.toString();
            break;
            default:
            System.out.println("Please tell me how your body looks. (1, 2, or 3)");
        }
        while(this.raceString != null);

        do
        System.out.println("You you begin to daydream and have visions of another place. What are you doing? ");
        System.out.println("1. Hiking through snowy mountains.");
        System.out.println("2. Rigging up the main mast on a sailing ship.");
        System.out.println("3. Calibrating the gravity aboard a space station.");
        switch(conScanner.nextLine()) {
            case "1":
            this.areaString = area.Land.toString();
            break;
            case "2":
            this.areaString = area.Sea.toString();
            break;
            case "3":
            this.areaString = area.Space.toString();
            default:
            System.out.println("Please enter 1, 2, or 3.");

        }
        while(this.areaString == null || this.areaString.equals(""));

        do
        System.out.println("You are lying down in a bed. Would you like to try to stand up? Type 'stand' to stand up.");
        if (conScanner.nextLine().equals("stand")){
            System.out.println("You stand up.");
            this.lying = false;
            this.standing = true;
        }
        while(!this.standing);

        do
        System.out.println("Now, how difficult was it to stand up?");
        System.out.println("1. Very hard.");
        System.out.println("2. Hard.");
        System.out.println("3. Fine.");
        System.out.println("4. Easy.");
        System.out.println("5. Very easy.");

        switch(conScanner.nextLine()){
            case "1":
            this.str = 8;
            break;
            case "2":
            this.str = 9;
            break;
            case "3": 
            this.str = 10;
            break;
            case "4":
            this.str = 11;
            break;
            case "5":
            this.str = 12;
            default:
            System.out.println("Please tell me how difficult it was to get up(1-5).");
        }
        while (this.str != null);

        System.out.println("There is a desk with a chair and a piece of paper and pen on it.");
        do
        System.out.println("Try to remember your name. If you can remember your name, try to write it on the paper.");
        this.name = conScanner.nextLine();
        System.out.println("Great job. How difficult was it to write your name?");
        System.out.println("1. Very hard.");
        System.out.println("2. Hard.");
        System.out.println("3. Fine.");
        System.out.println("4. Easy.");
        System.out.println("5. Very easy.");

        switch(conScanner.nextLine()){
            case "1":
            this.dex = 8;
            break;
            case "2":
            this.dex = 9;
            break;
            case "3":
            this.dex = 10;
            break;
            case "4": 
            this.dex = 11;
            break;
            case "5":
            this.dex = 12;
            default:
            System.out.println("Please tell me how hard it was to write your name.(1-3)");
        
        }
        while(this.dex != null);

        
        
        
    }
}
