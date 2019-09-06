/*The main screen of the program. It connects to all other screens.*/

class MainMenu extends Screen {

    final private static String TITLE = "S N A K E";
    final private static String NAME = "Moritz Konarski";

    MainMenu() {
        //set level select as next screen
        super(Action.LEVEL_SELECT);
        int xPos = getHalfWidth();
        //Buttons--------------------------------------------------------------------------------------------
        //Go to level selection
        addButton(xPos, getFractionOfHeight(0.375), ButtonText.PLAY, Action.LEVEL_SELECT);
        //Go to leader board
        addButton(xPos, getFractionOfHeight(0.5), ButtonText.LEADER_BOARD, Action.LEADER_BOARD);
        //Exit game
        addButton(xPos, getFractionOfHeight(0.625), ButtonText.EXIT, Action.EXIT);
        //Text-----------------------------------------------------------------------------------------------
        //Add title
        addText(xPos, getFractionOfHeight(0.1875), TITLE, TextType.TITLE);
        //Add name of creator (me)
        addText(xPos, getFractionOfHeight(0.8125), NAME, TextType.MEDIUM);
    }
}
