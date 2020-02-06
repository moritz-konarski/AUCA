import java.util.ArrayList;

/*  This class is the parent class to all more specialized screen classes
  it contains buttons and text classes as well as standard yPositions, standard button texts,
  and values that can be used to describe different states of the program
  it is an abstract class because it is just a blueprint that needs modification before is useful*/

abstract class Screen {

    //region Data
    //static variables
    private static int screenWidth, screenHeight;               //screenWidth and screenHeight of all screens
    private static int[] buttonDimensions;          //dimensions all buttons have

    //instance variables
    //the state of the program as well as the next screen the user is expected to go to
    private Action clickAction, nextScreen;
    private ArrayList<Text> textList;               //arraylist containing all buttonText elements on a screen
    private ArrayList<Button> buttonList;           //arraylist containing all buttons on a screen

    //states of the program
    enum Action {
        NONE,
        MAIN_MENU,
        LEVEL_SELECT,
        GAME,
        LEADER_BOARD,
        GAME_OVER,
        RESET_HIGH_SCORES,
        EXIT
    }

    //types of buttonText, used to give buttonText right size
    enum TextType {
        SMALL,
        MEDIUM,
        LARGE,
        TITLE
    }

    //class with a list of standard texts for buttons
    final static class ButtonText {
        final static String MAIN_MENU = "MAIN MENU";
        final static String PLAY = "PLAY";
        final static String LEADER_BOARD = "LEADER BOARD";
        final static String RESET_HIGH_SCORES = "RESET HS";
        final static String EXIT = "EXIT";
    }
    //endregion

    //Constructor, initializes the instance variables, sets the next screen
    protected Screen(Action nextScreen) {
        this.nextScreen = nextScreen;
        buttonList = new ArrayList<>();
        textList = new ArrayList<>();
        clickAction = Action.NONE;
    }

    //region instance behavior
    void addButton(int xPosition, int yPosition, String text, Action associatedAction) {
        buttonList.add(new Button(xPosition, yPosition, buttonDimensions, text, associatedAction));
    }

    //goes to the next, preset screen, does not need button press
    void goToNextScreen() {
        clickAction = nextScreen;
    }

    void addText(int x, int y, String text, TextType type) {
        textList.add(new Text(x, y, text, type));
    }

    void removeText(String regex) {
        textList.removeIf(x -> x.text.matches(regex));
    }

    //check if a button was clicked
    void checkForButtonClick(int mouseX, int mouseY) {
        for (Button button : buttonList) {
            if (button.hasMouseOver(mouseX, mouseY)) {
                clickAction = button.getAction();
            }
        }
    }
    //endregion

    //region instance getters
    boolean buttonWasClicked() {
        return clickAction != Action.NONE;
    }

    //return the action that a button press is associated with
    Action getClickAction() {
        Action temp = clickAction;
        clickAction = Action.NONE;
        return temp;
    }

    //return an array list of all buttons of a screen
    ArrayList<Button> getButtonList() {
        return new ArrayList<>(buttonList);
    }

    //returns an array list of all the buttons of a screen
    ArrayList<Text> getTextList() {
        return new ArrayList<>(textList);
    }
    //endregion

    //region static getters
    static int getScreenWidth() {
        return screenWidth;
    }

    //get the screenHeight of the screen
    static int getScreenHeight() {
        return screenHeight;
    }

    static int getFractionOfHeight(double fractionOfScreen) {
        return (int) (fractionOfScreen * screenHeight);
    }

    //get get the center of the screenWidth
    static int getHalfWidth() {
        return screenWidth / 2;
    }
    //endregion

    //region static setters
    //set the screenWidth of the screen
    static void setScreenDimensions(int newWidth, int newHeight) {
        screenWidth = newWidth;
        screenHeight = newHeight;
        //compute the dimensions of the buttons
        int buttonWidth = (int) (screenWidth / 6.4f);
        int buttonHeight = (int) (screenHeight / 18f);
        if (buttonHeight < 40 || buttonWidth < 200) {
            buttonHeight = 40;
            buttonWidth = 200;
        }
        buttonDimensions = new int[]{buttonWidth, buttonHeight};
    }
    //endregion

    class Button {

        //region instance data
        private int x, y;
        private int[] dimensions;
        private Text buttonText;
        private Action buttonAction;
        //endregion

        //Constructor
        Button(int x, int y, int[] dimensions, String buttonText, Action buttonAction) {
            this.x = x;
            this.y = y;
            this.dimensions = dimensions.clone();
            this.buttonText = new Text(x, y, buttonText, TextType.SMALL);
            this.buttonAction = buttonAction;
        }

        //region instance getters
        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        int getWidth() {
            return dimensions[0];
        }

        int getHeight() {
            return dimensions[1];
        }

        Text getButtonText() {
            return buttonText;
        }

        Action getAction() {
            return buttonAction;
        }
        //endregion

        //region instance behavior
        //returns true if the mouse coordinates match where the button is
        boolean hasMouseOver(int mouseX, int mouseY) {
            return (mouseX >= x - dimensions[0] / 2f && mouseY >= y - dimensions[1] / 2f &&
                    mouseX <= x + dimensions[0] / 2f && mouseY <= y + dimensions[1] / 2f);

        }
        //endregion
    }

    class Text {

        //region instance data
        private int x, y;
        private String text;
        private TextType type;
        //endregion

        //Constructor
        Text(int x, int y, String text, TextType type) {
            this.x = x;
            this.y = y;
            this.text = text;
            this.type = type;
        }

        //region instance getters
        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        String getText() {
            return text;
        }

        TextType getTextType() {
            return type;
        }
        //endregion
    }
}
