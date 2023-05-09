package textgame.regions;

import textgame.Room;
import textgame.World;

public class TsiporimTown extends Region {

    public Room nLink;
    public Room alleyLink;

    public TsiporimTown(){}

    public TsiporimTown(World world){
        Room inFrontOfHome = new Room("town", "Peregrine street in front of home", "The street in front of your home. It extends to the east and terminates to the west with a view of the forest.", null,null,null,null,null,null,null,null,null,null );
        Room ParkNW = new Room("grass", "Park with a footpath", "A park with a footpath and trees defies the constant rain. You can see a pond to the southeast.", inFrontOfHome, null,null,null,null,null,null,null,null,null);
        Room ParkN = new Room("grass", "Park with a footpath", "A park with a footpath circles around a delicately surfaced pond. The rain jabbers the ground in sheety layers.", null,null,null,null,null,null, ParkNW, null,null,null );
        Room ParkNE = new Room("grass","Park with a footpath","The northeast corner of the park. There is a restroom here.",null,null,null,null,null,null,ParkN,null,null,null);
        Room ParkE = new Room("grass", "Park with a footpath", "The end of the park that runs along Main street.",ParkNE,null,null,null,null,null,null,ParkN,null,null);
        Room ParkSE = new Room("grass","Park with a footpath","The southeast section of the park. There is a new looking tennis court here.", ParkE,null,null,null,null,null,null,null,null,null);
        Room ParkS = new Room("grass", "Park with a footpath", "As the path curves around, you can see that there are less trees in this area.", null,ParkE,ParkSE,null,null,null,null,null,null,null);
        Room ParkSW = new Room("grass", "Park with a footpath","Southwest end of the park. There are more trees in this area.",null,null,ParkS,null,null,null,null,null,null,null);
        Room ParkW = new Room("grass","Park with a footpath","At his part of the park there is a little gazebo with some benches in it.",ParkNW,ParkN,null,null,ParkSW,null,null,null,null,null);
        Room ParkMiddle = new Room("grass","Park with a pond", "A pond is here and there are a few ducks coasting in the water and dipping their heads.",ParkN,ParkNE,ParkE,ParkSE,ParkS,ParkSW,ParkW,ParkNW,null,null);
        Room mainAndCityHall = new Room("town","Main street by City Hall", "At this part of Main street the City hall is to the east and the park to the west.", null,null,null,null,null,null,ParkE,null,null,null);
        Room mainAndPower = new Room("town","Main street at the power station", "Main street stretches southward and passes the poweer station at this point. The faint hum of generators can be heard.",null,null,null,null,mainAndCityHall,null,ParkNE,null,null,null);
        Room mainAndPeregrine = new Room("town", "Main and Peregrine Town Square","A roundabout is here connecting Main and Peregrine streets, with a small concrete area in the center for gatherings.",null,null,null,null,mainAndPower,null,null,null,null,null);
        Room mainAndGeneral = new Room("town", "Main street at the general store", "At this juncture of Main street the general store can be seen to the east.",null,null,null,null,mainAndPeregrine,null,null,null,null,null);
        Room mainAndSchool = new Room("town","Main street at school", "Main street passes by the school at this point. An alley goes to the west.",null,null,null,null,mainAndGeneral,null,null,null,null,null);
        Room mainAndBurgertime = new Room("town","Main and BurgerTime", "Main street passes by the burger shop, and the smell of cooked meat is in the air.",null,null,null,null,mainAndSchool,null,null,null,null,null);
        Room mainAndOsprey = new Room("town","Main and Osprey street", "Main street crosses by Osprey street. The smell of fresh burgers is present.", null,null,null,null,mainAndBurgertime,null,null,null,null,null);
        Room mainAndStork = new Room("town","Main and Stork streets", "Main street crosses by Stork street. The city hall is on the corner.",mainAndCityHall,null,null,null,null,null,ParkSE,null,null,null);
        Room storkAndCityHall = new Room("town","Stork street in front of city hall","Stork street passes by city hall here.",null,null,null,null,null,null,mainAndStork,null,null,null);
        Room storkAndPost = new Room("town","Stork street at the post office", "Stork street stretches to the east in front of the post office.",null,null,null,null,null,null,storkAndCityHall,null,null,null);
        Room cityHall = new Room("interior","City Hall", "The single room city has a counter and is well kept. Coming from the back is a low constant hum.",null,null,null,null,storkAndCityHall,null,null,null,null,null);
        Room powerStation = new Room("town","Power station", "The big power station equipment connects the town to other regions and keeps electricity on for residents.",null,null,null,null,null,null,mainAndPower,null,null,null );
        Room postOffice = new Room("interior","Post office","The post office has a simple office with a small warehouse in the back for shipping and receiving.", null,null,null,null,storkAndPost,null,null,null,null,null);
        Room eastPeregrine1 = new Room("town", "East Peregrine street", "Peregrine street goes to the east here and passes by the power station.",null,null,null,null,null,null,mainAndPeregrine,null,null,null);
        Room eastPeregrine2 = new Room("town", "East Peregrine street in front of drink shop", "East Peregrine street passes by the drink shop at this place.",null,null,null,null,null,null,eastPeregrine1,null,null,null);
        Room frontierCoffee = new Room("interior", "Frontier Coffee and Tea", "The shop is decked in colors and hues and smells of the earth.",eastPeregrine2,null,null,null,null,null,null,null,null,null);
        Room westPeregrine2 = new Room("town","West Peregrine street 2","West Peregrine street that passes by the north end of the park.", null,null,null,null,ParkN,null,inFrontOfHome,null,null,null);
        Room westPeregrine1 = new Room("town","West Peregrine street 1","Peregrine street that passes by the park",null,null,mainAndPeregrine,null,ParkNE,null,westPeregrine2,null,null,null);
        Room house2WPeregrine = new Room("town","House at 2 West Peregrine","Someone's house on West Peregrine Street.",null,null,null,null,westPeregrine2,null,null,null,null,null);
        Room house1WPeregrine = new Room("town","House at 1 West Peregrine street","A green house on West Peregrine street.",null,null,mainAndGeneral,null,westPeregrine1,null,null,null,null,null);
        Room generalStore = new Room("interior", "General Store", "The general store is neatly arranged with all kinds of products on the shelves.",null,null,null,null,eastPeregrine1,null,mainAndGeneral,null,null,null);
        Room anotherArtGallery = new Room("interior", "Another Art Gallery", "The art gallery has walls filled with paintings and the space is nicely apportioned with sculptures of various things.",null,null,null,null,eastPeregrine2,null,null,null,null,null);
        Room schoolEntrance = new Room("interior", "School entrance", "The main lobby of the local school. Pictures and trophies of student accomplishments line the walls of this processing room where records are created and administrative activities happen.",null,null,null,null,null,null,mainAndSchool,null,null,null);
        Room burgerTime = new Room("interior","BurgerTime","The burger shop in town, this place serves up a lot of burgers to feed people. Good prices too.",null,null,null,null,null,null,mainAndBurgertime,null,null,null);
        Room eastOsprey1 = new Room("town","East Osprey street 1", "East Osprey street goes in the eastern direction.",null,null,null,null,burgerTime,null,mainAndOsprey,null,null,null);
        Room westOsprey1 = new Room("town","West Osprey Street 1","A residential section of town. Homes line the street with gardens for front yards.",null,null,mainAndOsprey,null,null,null,null,null,null,null);
        Room westOsprey2 = new Room("town","West Osprey Street 2","A residential section of town. Homes line the street with gardens for front yards.",null,null,westOsprey1,null,null,null,null,null,null,null);
        Room westOsprey3 = new Room("town","West Osprey Street 3","A residential section of town. Homes line the street with gardens for front yards.",null,null,westOsprey2,null,null,null,null,null,null,null);
        Room house1WOsprey = new Room("town","House at 1 West Osprey street", "A pretty normal looking house with garage, front doors, windows, but a yard full of growing plants.",westOsprey1,null,mainAndBurgertime,null,null,null,null,null,null,null);
        Room house2WOsprey = new Room("town","House at 2 West Osprey street", "Pretty normal looking house except for the huge garden in the front lawn, but that's normal for here.",westOsprey2,null,null,null,null,null,null,null,null,null);
        Room bestFriendHouse = new Room("town","House at 3 West Osprey street", "The house of your best friend whoms't you grew up with since childhood.",westOsprey3,null,null,null,null,null,null,null,null,null);
        Room alley1 = new Room("town","Alley behind Peregrine and Osprey 1", "An alley behind Osprey and Peregrine streets. Some garbage cans can be found here behind the houses.", house1WOsprey,null,mainAndSchool,null,house1WPeregrine,null,null,null,null,null);
        Room alley2 = new Room("town","Alley behind Peregrine and Osprey 2", "An alley behind Osprey and Peregrine streets. A beehive has been made inside of a garbage can.", house2WOsprey,null,alley1,null,house2WPeregrine,null,null,null,null,null);
        Room alley3 = new Room("town","Alley behind Peregrine and Osprey 3", "An alley behind Osprey and Peregrine streets. A concrete barrier is at the west end of the alley.", bestFriendHouse,null,alley2,null,null,null,null,null,null,null);
        Room dirtPath1 = new Room("forest","A dirt path","A dirt path cuts through the forest and snakes to the east around trees and bushes.",null,null,alley3,null,null,null,null,null,null,null);
        Room dirtPath2 = new Room("forest","A dirt path", "There is a small wooden bridge over a brook flowing steadily leading the path deeper into the forest.",null,null,dirtPath1,null,null,null,null,null,null,null);
        Room dirtPath3 = new Room("forest","A dirt path", "The path turns southwest here and the trees get a little thicker.", null,null,dirtPath2,null,null,null,null,null,null,null);
        Room dirtPath4 = new Room("forest","A dirt path","The continues southwest. There is a fallen tree across the path.", null,dirtPath3,null,null,null,null,null,null,null,null);
        Room dirtPath5 = new Room("forest","A dirt path","The path contiues west here and the path gently slopes downward for a bit.",null,dirtPath4,null,null,null,null,null,null,null,null);
        Room dirtPath6 = new Room("forest","A dirt path","The path continues east-west and snakes around a few trees and sometimes splits.",null,null,dirtPath5,null,null,null,null,null,null,null);
        Room dirtPath7 = new Room("forest","A dirt path", "The path becomes faint here and overgrown with bushes. It seems like no one has been here in a while.",null,null,dirtPath6,null,null,null,null,null,null,null);
        Room dirtPath8 = new Room("forest","A dirt path","The path now widens and the trees grow a little more sparse at this point. The deep sound of water can be heard.",null,null,dirtPath7,null,null,null,null,null,null,null);
        Room riverBank = new Room("forest","A river bank", "A river gently moves from south to north and the occasional plop of fish jumping out of the water can be heard.",null,null,dirtPath8,null,null,null,null,null,null,null);
        

        nLink = inFrontOfHome;
        alleyLink = alley3;
    }

    public Room getNLink(){return nLink;}
    public Room getAlleyLink(){return alleyLink;}
}
