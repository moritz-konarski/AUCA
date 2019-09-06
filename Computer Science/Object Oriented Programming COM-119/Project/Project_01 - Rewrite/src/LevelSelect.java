/*The user can select the level of the game in terms of speed*/

// TODO: show a snake moving to illustrate the speed/level

class LevelSelect extends Screen {

    //static texts
    final private static String TITLE = "SELECT LEVEL";
    final private static String TEXT = "arrow up - increase level\narrow down- decrease level";

    //constructor
    LevelSelect() {
        //set game screen as the next screen
        super(Action.GAME);
        //Buttons--------------------------------------------------------------------------------------------
        //Go to game
        addButton(getHalfWidth(), getFractionOfHeight(0.5), ButtonText.PLAY, Action.GAME);
        //Go to main meny
        addButton(getHalfWidth(), getFractionOfHeight(0.625), ButtonText.MAIN_MENU, Action.MAIN_MENU);
        //Text-----------------------------------------------------------------------------------------------
        //Add title
        addText(getHalfWidth(), getFractionOfHeight(0.1875), TITLE, TextType.TITLE);
        //Add info
        addText(getHalfWidth(), getFractionOfHeight(0.8125), TEXT, TextType.MEDIUM);
        //Update the level text
        updateLevelText(0);
    }

    //update the text displaying the level
    void updateLevelText(int level) {
        //remove the previous entry if it exists
        removeText("\\d+");
        //add the updated text
        addText(getHalfWidth(), getFractionOfHeight(0.375), String.format("%d", level), TextType.LARGE);
    }
}
