package OOP.ec22551.MP;
/*
    Room Layout:
    
        Floor 1:
        Room 1 = Room_ec22551.java
        Room 2 = Room_ec22553.java
        Room 3 = Room_ec22771.java
        Room 4 = Room_ec22859.java

        Floor 816:
        Room 5 = Room_ec22551.java
        Room 6 = Room_ec22551.java
        Room 7 = Room_ec22551.java
        Room 8 = Room_ec22551.java

    House blueprint key:

        B -> BIG BASEMENT
        G -> Ground floor foyer
        L -> 1st floor lobby
        R -> Room
        BIG -> Floor 816 lobby

    House blueprint:

        Floor -1 (BIG BASEMENT):
        ______________
        |            |
        |     B      |
        |            |
        ______________

        Floor 0 (Ground floor):
        ______________
        |            |
        |     G      |
        |            |
        ______________
    
        Floor 1 (1st floor):
        ______________
        |    R1      |
        | R2  L  R3  |
        |    R4      |
        ______________

        Floor 816 (BIG floor)
        ______________
        |    R5      |
        | R6 BIG R7  |
        |    R8      |
        ______________
*/

import java.util.Random;
import java.util.ArrayList;

class House_ec22551 extends House
{
    public Direction visit (Visitor myVisitor, Direction d)
    {
        // initialising the rooms
        // 2 floors have rooms
        // floor 1 has rooms 1,2,3,4
        // floor 816 has rooms 5,6,7,8

        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.add(new Room_ec22551());
        rooms.add(new Room_ec22553());
        rooms.add(new Room_ec22551());
        rooms.add(new Room_ec22859());
        rooms.add(new Room_ec22551());
        rooms.add(new Room_ec22551());
        rooms.add(new Room_ec22551());
        rooms.add(new Room_ec22551());
        
        // initialise some BIG variables
        char currentFloor = '0';
        boolean leftHouse = false;

        // introduce visitor who has just entered the BIG HOUSE
        introduction(myVisitor);

        // house navigation process
        while(!leftHouse)
        {
            leftHouse = foyer(myVisitor, d, rooms, currentFloor);
        }

        //leaving process
        {
            return d;
        }
    }

    private void introduction(Visitor myVisitor)
    {
        myVisitor.updateFloor("G");
        myVisitor.updateMinimap("foyer");
        myVisitor.updateRoom("Entrance");
        myVisitor.updateBackground("Entrance");

        // introduce the user to the BIG HOUSE
        myVisitor.tell("WELCOME TO THE BIG HOUSE!!");
        myVisitor.tell("Here we break all the rules");

        // greet every visitor to the BIG HOUSE with 6 gold pieces
        myVisitor.tell("*********************************************");
        myVisitor.tell("Take this... you'll need it");
        myVisitor.giveGold(6);
        return;
    }

    private Boolean foyer(Visitor myVisitor, Direction d, ArrayList<Room> rooms, char currentFloor)
    {
        myVisitor.updateMinimap("foyer");
        myVisitor.updateFloor("G");
        myVisitor.updateRoom("Foyer");
        myVisitor.updateBackground("foyer");

        char[] foyerChoices = {'1','2','3','4'};
        currentFloor = '0';

        myVisitor.tell("*********************************************");
        myVisitor.tell("You are now in the Foyer and have 3 options");
        myVisitor.tell("1: Take the stairs up to the 1st floor");
        myVisitor.tell("2: Take the stairs down to the BIG BASEMENT");
        myVisitor.tell("3: Take your chances with the damaged elevator (costs 2 gold to try)");
        myVisitor.tell("4: Eat the BIG Chocolate Bar™ on the table next to you");
        
        char foyerChoice = myVisitor.getChoice("So which one is it, BIG traveller? (1,2,3,4)", foyerChoices);



        if (foyerChoice == '1')
        {
            stairs(myVisitor, d, rooms, currentFloor, '1');
        }
        else if (foyerChoice == '2')
        {
            stairs(myVisitor, d, rooms, currentFloor, 'B');
        }
        else if (foyerChoice == '3')
        {
            elevator(myVisitor, d, rooms, currentFloor);
        }
        else if (foyerChoice == '4')
        {
            myVisitor.tell("*you dont feel so good*");
            myVisitor.tell("*you feel BIG");
            myVisitor.tell("until next time... BIG ONE");
            myVisitor.tell("*********************************************");
            return true;
        }
        
        return false;
    }

    private void elevator(Visitor myVisitor, Direction d, ArrayList<Room> rooms, char currentFloor)
    {
        myVisitor.updateMinimap("elevator");
        myVisitor.updateFloor("G");
        myVisitor.updateRoom("Elevator");
        myVisitor.updateBackground("elevator");

        // introduce the user to the elevator interface and tell them their current floor
        myVisitor.tell("*********************************************");
        myVisitor.tell("WELCOME TO THE (slightly damaged) ELEVATOR");
        myVisitor.tell("*eerie elevator music starts playing*");
        myVisitor.takeGold(2);
        myVisitor.tell("*2 gold deducted*");
        myVisitor.tell("You are on floor " + currentFloor);

        // give user choice of rooms
        char[] elevatorChoices = {'1','2','3','4'};
        myVisitor.tell("1: BIG BASEMENT");
        myVisitor.tell("2: Ground floor foyer");
        myVisitor.tell("3: Floor 1 lobby");
        myVisitor.tell("4: ??????????????????????????");
        char elevatorChoice = myVisitor.getChoice("Which floor would you like to go to?:", elevatorChoices);

        // BIG BASEMENT
        if (elevatorChoice == '1')
        {
            myVisitor.tell("*you pushed B*");

            if (elevatorChoice == currentFloor)
            {
                myVisitor.tell("*you realise you are already on B and leave the elevator 2 gold poorer*");
                basement(myVisitor, d, rooms, currentFloor);
            }
            
            else
            {
                myVisitor.tell("...............");
                myVisitor.tell("*DING*");
                myVisitor.tell("*you have arrived at floor -1*");
                basement(myVisitor, d, rooms, currentFloor);
            }
            
        }

        // Ground floor foyer
        else if (elevatorChoice == '2')
        {
            myVisitor.tell("*you pushed 0*");

            if (elevatorChoice == currentFloor)
            {
                myVisitor.tell("*you realise you are already on 0 and leave the elevator 2 gold poorer*");
                foyer(myVisitor, d, rooms, currentFloor);
            }

            else
            {
                myVisitor.tell("...............");
                myVisitor.tell("*DING*");
                myVisitor.tell("*you have arrived at floor 0*");
                foyer(myVisitor, d, rooms, currentFloor);
            }
        }

        // Floor 1
        else if (elevatorChoice == '3')
        {
            myVisitor.tell("*you pushed 1*");

            if (elevatorChoice == currentFloor)
            {
                myVisitor.tell("*you realise you are already on 1 and leave the elevator 2 gold poorer*");
                floor1(myVisitor, d, rooms, currentFloor);
            }

            else
            {
                myVisitor.tell("...............");
                myVisitor.tell("*DING*");
                myVisitor.tell("*you have arrived at floor 1*");
                floor1(myVisitor, d, rooms, currentFloor);
            }
        }

        // Floor 816
        else if (elevatorChoice == '4')
        {
            myVisitor.tell("*you pushed ?*");

            if (elevatorChoice == currentFloor)
            {
                myVisitor.tell("*you realise you are already on ????? and leave the elevator 2 gold poorer*");
                floor816(myVisitor, d, rooms, currentFloor);
            }

            else
            {
                myVisitor.tell("?????????????????????");
                myVisitor.tell("?????????????????????");
                myVisitor.tell("?????????????????????");
                myVisitor.tell("?????????????????????");
                
                // randomly grant access to floor 816
                Random random = new Random();
                int roll816 = 1 + random.nextInt(100);

                if (roll816 > 50)
                {
                    myVisitor.tell("*the elevator shakes VIOLENTLY*");
                    myVisitor.tell("...");
                    myVisitor.tell("...");
                    myVisitor.tell("...");
                    myVisitor.tell("*DING*");
                    myVisitor.tell("*you have arrived*");
                    myVisitor.tell("*you leave the elevator confused*");
                    floor816(myVisitor, d, rooms, currentFloor);
                }
                else
                {
                    myVisitor.tell("*CRACK*");
                    myVisitor.tell("*the elevator stops working*");
                    myVisitor.tell("*you leave the elevator confused*");

                    if (currentFloor == 'B')
                    {
                        basement(myVisitor, d, rooms, currentFloor);
                    }
                    if (currentFloor == 'G')
                    {
                        foyer(myVisitor, d, rooms, currentFloor);
                    }
                    if (currentFloor == '1')
                    {
                        floor1(myVisitor, d, rooms, currentFloor);
                    }
                }
            }
        }
        return;
    }

    private void stairs(Visitor myVisitor, Direction d, ArrayList<Room> rooms, char currentFloor, char desiredFloor)
    {
        myVisitor.updateMinimap("stairs");
        // introduce the user to the stairs
        myVisitor.updateFloor(String.valueOf(currentFloor));
        myVisitor.updateRoom("Stairs");
        myVisitor.updateBackground("stairs");


        // going down to B
        if (desiredFloor == 'B')
        {
            myVisitor.tell("*you decided to take the stairs down to the BIG BASEMENT");
            myVisitor.tell("well done for taking the stairs and getting some exercise, have some gold");
            myVisitor.giveGold(3);
            basement(myVisitor, d, rooms, currentFloor);
        }

        // going up to 1
        if (desiredFloor == '1')
        {
            myVisitor.tell("*you decided to take the stairs up to floor 1");
            myVisitor.tell("well done for taking the stairs and getting some exercise, have some gold");
            myVisitor.giveGold(6);
            floor1(myVisitor, d, rooms, currentFloor);
        }

        return;
    }

    private void basement(Visitor myVisitor, Direction d, ArrayList<Room> rooms, char currentFloor)
    {
        myVisitor.updateMinimap("basement");
        currentFloor = 'B';
        myVisitor.updateFloor("B");
        myVisitor.updateRoom("Basement");
        myVisitor.updateBackground("basement");

        // introduce the user to the BIG BASEMENT
        Random random = new Random();
        int rollBasement = 1 + random.nextInt(100);

        if (rollBasement > 50)
        {
            myVisitor.updateFloor("B");
            myVisitor.updateRoom("DA BIG BALLER");
            myVisitor.tell("*you feel the presence of a BALLER*");
            myVisitor.tell("I AM THE BIG BALLER");
            myVisitor.tell("IF YOU GUESS MY NUMBER FROM 1-10 I WILL GIVE YOU GOLD");
            myVisitor.tell("YOU GOTTA PAY TO PLAY AND NO YOU DO NOT HAVE A CHOICE");
            myVisitor.tell("DONT EVEN TELL ME YOUR GUESS... I READ MINDS");

            int rollBaller = 1 + random.nextInt(10);

            if (rollBaller > 5)
            {
                myVisitor.tell("HAVE MONEY");
                myVisitor.giveGold(4);
            }
            else
            {
                myVisitor.tell("NO MONEY FOR YOU, GIMME YOUR MONEY");
                myVisitor.takeGold(4);
            }
        }
        else
        {
            myVisitor.updateFloor("B");
            myVisitor.updateRoom("DA BIG BUSINESSMAN");
            myVisitor.tell("*you feel the presence of a BUSINESSMAN*");
            myVisitor.tell("I AM THE BIG BUSINESSMAN");
            myVisitor.tell("I SELL A MASSIVE SWORD");
            myVisitor.tell("IT COSTS 4 GOLD");

            char[] businessChoices = {'1','2'};
            char businessChoice = myVisitor.getChoice("(1)BUY MY SWORD (2)BE A LAME", businessChoices);
            
            if (businessChoice == '1')
            {
                Item massiveSword = new Item("massiveSword");
                myVisitor.giveItem(massiveSword);
                myVisitor.takeGold(4);
                myVisitor.tell("pleasure doing BUSINESS with you");
            }
            else if (businessChoice == '2')
            {
                myVisitor.tell("you a lame");
                myVisitor.tell("LEAVE MY STORE");
            }
        }
        return;
    }

    private void floor1(Visitor myVisitor, Direction d, ArrayList<Room> rooms, char currentFloor)
    {
        myVisitor.updateMinimap("stairs");
        myVisitor.updateFloor("1");
        myVisitor.updateRoom("Foyer");
        myVisitor.updateBackground("stairs");

        // floor 1 methods (navigate rooms)
        currentFloor = '1';
        // return using stairs down to foyer
        myVisitor.tell("*********************************************");
        myVisitor.tell("Welcome to floor 1");
        myVisitor.tell("1: Room 1 (NORTH)");
        myVisitor.tell("2: Room 2 (WEST)");
        myVisitor.tell("3: Room 3 (EAST)");
        myVisitor.tell("4: Room 4 (SOUTH)");

        char[] directionChoices = {'1','2','3','4','5'};
        char directionChoice = myVisitor.getChoice("So which one is it, BIG traveller?", directionChoices);
        
        if (directionChoice == '1')
        {
            d = Direction.TO_NORTH;
        }
        else if (directionChoice == '2')
        {
            d = Direction.TO_WEST;
        }
        else if (directionChoice == '3')
        {
            d = Direction.TO_EAST;
        }
        else if (directionChoice == '4')
        {
            d = Direction.TO_SOUTH;
        }
        else if (directionChoice == '5')
        {
            return;
        }

        boolean leaveFloor = false;

        while(! leaveFloor)
        {
            char[] leaveChoices = {'1','2'};
            char leaveChoice = myVisitor.getChoice("(1) Stay on this floor (2) Leave this floor", leaveChoices);
            
            if (leaveChoice == '2')
            {
                leaveFloor = true;
                myVisitor.tell("*you chose to leave and go to the ground floor foyer*");
                return;
            }
            
            else
            {
                if(d == Direction.TO_NORTH)
                {
                    myVisitor.tell("*you chose to go NORTH to Room 1*");
                    myVisitor.updateRoom("Room 1");
                    myVisitor.updateMinimap("room1");
                    myVisitor.updateBackground("room1");
                    d = rooms.get(0).visit(myVisitor,d);

                }
                else if(d == Direction.TO_WEST)
                {
                    myVisitor.tell("*you chose to go WEST to Room 2*");
                    myVisitor.updateRoom("Room 2");
                    myVisitor.updateMinimap("room2");
                    myVisitor.updateBackground("room2");
                    d = rooms.get(1).visit(myVisitor,d);
                }
                else if(d == Direction.TO_EAST)
                {
                    myVisitor.tell("*you chose to go EAST to Room 3*");
                    myVisitor.updateRoom("Room 3");
                    myVisitor.updateMinimap("room3");
                    myVisitor.updateBackground("room3");
                    d = rooms.get(2).visit(myVisitor,d);
                }
                else if(d == Direction.TO_SOUTH)
                {
                    myVisitor.tell("*you chose to go SOUTH to Room 4*");
                    myVisitor.updateRoom("Room 4");
                    d = rooms.get(3).visit(myVisitor,d);
                }
            }
        }
    }

    private void floor816(Visitor myVisitor, Direction d, ArrayList<Room> rooms, char currentFloor)
    {
        myVisitor.updateMinimap("816");
        myVisitor.updateFloor("?????????????????");
        myVisitor.updateRoom("DA BIG ROOM");
        myVisitor.updateBackground("816");
        // floor 816 methods (navigate rooms)
        currentFloor = '?';
        // return using stairs down to foyer
        myVisitor.tell("*********************************************");
        myVisitor.tell("Welcome to 816");
        myVisitor.tell("DA BIG ROOM");
        myVisitor.tell("1: Room 5 (NORTH)");
        myVisitor.tell("2: Room 6 (WEST)");
        myVisitor.tell("3: Room 7 (EAST)");
        myVisitor.tell("4: Room 8 (SOUTH)");
        myVisitor.tell("5: Leave to where you came from");
        myVisitor.tell("By the way every room is BIG here");
        myVisitor.tell("You'll know what that means soon");

        char[] directionChoices = {'1','2','3','4','5'};
        char directionChoice = myVisitor.getChoice("So which one is it, BIG traveller?", directionChoices);
        
        if (directionChoice == '1')
        {
            d = Direction.TO_NORTH;
        }
        else if (directionChoice == '2')
        {
            d = Direction.TO_WEST;
        }
        else if (directionChoice == '3')
        {
            d = Direction.TO_EAST;
        }
        else if (directionChoice == '4')
        {
            d = Direction.TO_SOUTH;
        }
        else if (directionChoice == '5')
        {
            return;
        }

        boolean leaveFloor = false;

        while(! leaveFloor)
        {
            char[] leaveChoices = {'1','2'};
            char leaveChoice = myVisitor.getChoice("(1) Stay on this floor (2) Leave this floor", leaveChoices);
            
            if (leaveChoice == '2')
            {
                leaveFloor = true;
                myVisitor.tell("*you chose to leave and go to the ground floor foyer*");
                return;
            }
            
            else
            {
                if(d == Direction.TO_NORTH)
                {
                    myVisitor.tell("*you chose to go NORTH to Room 5*");
                    myVisitor.updateRoom("Room 5");
                    d = rooms.get(4).visit(myVisitor,d);
                }
                else if(d == Direction.TO_WEST)
                {
                    myVisitor.tell("*you chose to go WEST to Room 6*");
                    myVisitor.updateRoom("Room 6");
                    d = rooms.get(5).visit(myVisitor,d);
                }
                else if(d == Direction.TO_EAST)
                {
                    myVisitor.tell("*you chose to go EAST to Room 7*");
                    myVisitor.updateRoom("Room 7");
                    d = rooms.get(6).visit(myVisitor,d);
                }
                else if(d == Direction.TO_SOUTH)
                {
                    myVisitor.tell("*you chose to go SOUTH to Room 8*");
                    myVisitor.updateRoom("Room 8");
                    d = rooms.get(7).visit(myVisitor,d);
                }
            }
        }
    }
}
