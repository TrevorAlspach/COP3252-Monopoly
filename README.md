# Monopoly Game Project for COP3252
## By: Trever Alspach, Kaitlin Tran, and Benjamin Zech

### Game instructions

- Requires 2-4 players
- Each player starts off with $1500
- Players begin at the “Go” space and move clockwise around the board (contains 40 spaces)
- Wild cards
  - If a player lands on a chance or community chest space, they must draw a chance/community card from the deck and follow directions.
- Jail
  - Players in jail cannot play until they pay $50 bail.
- Owning property
  - If a player lands on an unowned property, they have the choice to buy it using money.
  - If a player lands on an owned property, they owe the owner of the property rent money.
- Monopoly
  - If a player owns every property of a single color, they have a monopoly. Rent is doubled.
  - Players that own monopolies can build houses and hotels on properties to increase rent.
- If you run out of money, you’re out. Winner is the last player standing

### Interface

- In the start window, choose the number of players (2-4) by clicking on the corresponding button.

<img src="https://user-images.githubusercontent.com/54950007/144667836-8a8e2941-d794-4c9b-bf54-434e70414cc6.png" width="50%" height="50%"/>

- The main window opens up with the requested number of players.
  - Player 1 is represented by the car icon.
<img src="src/main/resources/com/monopoly/cop3252monopoly/images/monopoly_car.png" width="30%" height="30%"/>
  - Player 2 is represented by the hat icon.
<img src="https://user-images.githubusercontent.com/54950007/144681584-4f9cc62b-c57a-4d1f-9e9b-bf00855e5cc1.png" width="30%" height="30%"/>
  - Player 3 is represented by the ship icon.
<img src="src/main/resources/com/monopoly/cop3252monopoly/images/monopoly_ship.png" width="30%" height="30%"/>
  - Player 4 is represented by the dog icon.
<img src="https://user-images.githubusercontent.com/54950007/144681437-9c0abfa2-5186-4962-b39f-7723dcbfeee5.png" width="30%" height="30%"/>

- Players are presented with 3 actions in the sidebar on the left side of the window: Roll Dice, View Properties, and Next Turn.

<img src="https://user-images.githubusercontent.com/54950007/144680273-695e5ad5-0b2f-46ee-96cd-ee3e58a156dc.png"/>

- Starting with Player 1, roll 2 dice to move spaces by using the “Roll Dice” button. The sum of the dice roll will be how many spaces a player moves, an action that is performed automatically.
  - If you roll doubles, you can roll again.
  - If you roll doubles 3 times, you go to jail.
  - When a player has used up all of their available dice rolls for their turn, the "Roll Dice" button no longer works.
- If you land on an unowned space, you will be prompted with the question to buy the property.
  - Select “yes” in the Buy Options menu in the bottom left corner of the window means you pay the price displayed on the board and own the property. You can view how much money and how many properties you and the other players have in the sidebar on the right side of the window.
    - You can view your own properties in a separate window with the “View Properties” button.
      - You can buy houses and hotels in this window once you own a monopoly of properties.

<img src="https://user-images.githubusercontent.com/54950007/144682201-da935a70-4f68-444a-9144-3c481e9d7625.png" width="70%" height="70%"/>

- If you land on an owned space, you automatically pay rent to the owner.
- If you are in jail when your turn begins, you will automatically pay the $50 bail.
- If you land on a chance or community chest space, the effects of the card (moving spacing, losing/gaining money) will automatically take place.
- If you are done with your turn, click the “Next Turn” button. 
  - This button does not work until the current player has used up all of their dice rolls. That way, no player's turn is skipped.
- Any player that loses all of their money will be automatically kicked out of the game, and all of their properties will reset to being unowned.
  - The ejected player's turn will be skipped when the "Next Turn" button is clicked for the remainder of the game.  
- A listView at the bottom of the main window shows each action taking place, including moving positions, drawing cards, paying rent, and buying properties, etc.

### Implementation

- Due to the usage of JavaFX, and creating this project as a Gradle, creating a runnable jar is insanely difficult
- In order to run, clone this github repository and run the application. All three of us used IntelliJ for this project. If the application window is too large to fit on your screen, the computer monitor's configuration can be changed in your computer's settings to fit the entire window.
- The powerpoint for the group presentation is available in the repository as COP3252 Monopoly Presentation.pptx.


- If you have troubles finding the path for our code files, they can be found via this path: https://github.com/TrevorAlspach/COP3252-Monopoly/tree/master/src/main/java/com/monopoly/cop3252monopoly

### Credits

#### Trevor Alspach

- Created Monopoly application
- Implemented UI with MVC architecture
  - Created FXML files for display windows
    - main-window.fxml
    - start-screen.fxml
    - view-properties.fxml
  - Created window controllers
     - MainWindowController.java 
     - StartWindowController.java
     - ViewPropertiesController.java
- Created Property.java model
- Wrote methods to:
  - Open Start window with player options
  - Initialize board, game pieces, properties, chance/community card decks, number of players
  - Perform logic when players land on property board spaces
  - Update game details when players buy property or choose not to buy property
  - Connect property names to space numbers
  - Update player positions, money balance, and properties owned in the GUI
  - Display information on game activity in listView
  - Open View Properties window
    - Display properties as cards in View Properties window if they are owned by current player
    - Update game details and display when a player buys a house
- Translated project into runnable jar file

#### Kaitlin Tran

- Created Dice.java model
- Uploaded images of Monopoly board, community chest cards, chance cards, and dice sides for use in GUI
- Placed game piece graphics onto designated board positions to appear when a player moves across the board
- Implemented graphics when "Roll Dice" button is clicked so that images of correct dice side appear on the board when dice are virtually "rolled".
- Placed house and hotel graphics onto designated board positions to appear when a player buys houses or hotels
- Created property card graphics for display in View Properties window
- Documented and formatted details on gameplay and interface in README.md file

#### Benjamin Zech

- Created the following models:
  - Player.java
  - ChanceCard.java
  - CommunityCard.java
  - ChanceCardsDeck.java
  - CommunityCardsDeck.java
- Wrote logic for landing on board spaces that are ***not*** properties (chance cards, go to jail, taxes, etc.)
- Wrote methods for the logic of all 16 Chance cards and 16 Community Chest cards
- Wrote logic for kicking a player out of the game

[Monopoly Board Reference](https://www.amazon.com/Hasbro-00009-482-Monopoly-Board/dp/B00CV5PN2W)

[Board Reference Image](SampleMonopolyBoard.jpg)

[Chance and Community Chest Cards References](https://www.monopolyland.com/list-monopoly-chance-community-chest-cards/)

[Monopoly Template for Photoshop](https://bradfrost.com/blog/post/monopoly-photoshop-template/)
