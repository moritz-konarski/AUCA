/*The screen that shows up once you finish the game
 * has buttons LEADER BOARD and MAIN_MENU MENU*/

class GameOver extends Screen {

    //final strings and templates
    final private static String TITLE = "G A M E  O V E R";
    final private static String NEW_HIGH_SCORE = "N E W  H I G H  S C O R E";
    final private static String TOP_SCORE = "T O P  S C O R E";
    final private static String MESSAGE = "SCORE: %d    LEVEL: %d";
    final private static String REMOVE_REGEX = "SCORE:.*";
    //the horizontal middle of the screen
    private int xPos;

    GameOver(int score, int level) {
        //set the next screen to be the main menu
        super(Action.MAIN_MENU);
        xPos = getHalfWidth();
        //add main menu button
        addButton(xPos, getFractionOfHeight(0.5), ButtonText.MAIN_MENU, Action.MAIN_MENU);
        //add button to go to leader board
        addButton(xPos, getFractionOfHeight(0.625), ButtonText.LEADER_BOARD, Action.LEADER_BOARD);
        //add button to exit the game
        addButton(xPos, getFractionOfHeight(0.75), ButtonText.EXIT, Action.EXIT);
        //add the title of the screen
        addText(xPos, getFractionOfHeight(0.1875), TITLE, TextType.TITLE);
        //update the score display
        updateScore(score, level);
    }

    private void updateScore(int score, int level) {
        //remove the old piece of text
        removeText(REMOVE_REGEX);
        //get the new score text
        String output = String.format(MESSAGE, score, level);
        //add the new text
        addText(xPos, getFractionOfHeight(0.375), output, TextType.MEDIUM);
    }

    void setTitleToHighScore() {
        //remove the title
        removeText(TITLE);
        //add new high score message
        addText(xPos, getFractionOfHeight(0.25), NEW_HIGH_SCORE, TextType.TITLE);
    }

    void setTitleToMaxScore() {
        //remove the title
        removeText(TITLE);
        removeText(NEW_HIGH_SCORE);
        //add new high score message
        addText(xPos, getFractionOfHeight(0.25), TOP_SCORE, TextType.TITLE);
    }
}
