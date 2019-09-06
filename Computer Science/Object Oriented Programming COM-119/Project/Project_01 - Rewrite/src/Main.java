import java.util.Arrays;
import java.util.ArrayList;
import processing.core.PApplet;

/*This main class handles the rendering of the game, the IO, the action machine for menu switching
* and general logic affecting multiple classes*/

public class Main extends PApplet {

    //region Data
    //region final data/constants
    //Static class containing key codes
    private static class Key {
        final static int ARROW_DOWN = 40;
        final static int ARROW_UP = 38;
        final static int ARROW_LEFT = 37;
        final static int ARROW_RIGHT = 39;
        final static int W = 87;
        final static int A = 65;
        final static int S = 83;
        final static int D = 68;
        final static int ENTER = 10;

        private Key() {
        }
    }

    //Static class with standard text sizes
    private static class TextSize {
        final static int SMALL = 20;
        final static int MEDIUM = 25;
        final static int LARGE = 45;
        final static int TITLE = 60;

        private TextSize() {
        }
    }

    //region Constants for the window
    final private static int WIDTH = 1280;                      //min: 400
    final private static int HEIGHT = 720;                      //min: 400
    final private static int FRAME_RATE = 30;                   //fixed frame rate of the game
    final private static boolean FULL_SCREEN = false;           //if the game is in full currentScreen mode
    //endregion

    //region Colors and line constants for drawing
    final private static int COLOR_FOOD = 0xffff0000;           //Red
    final private static int COLOR_LINE = 0xff000000;           //Black
    final private static int COLOR_TEXT = 0xffffffff;           //White
    final private static int COLOR_SNAKE = 0xffffffff;          //White
    final private static int COLOR_BACKGROUND = 0xff888888;     //Grey
    final private static int STROKE_WEIGHT = 1;                 //standard line thickness
    final private static int STROKE_WEIGHT_GRID = 2;            //standard line weight for game grid
    final private static int STROKE_WEIGHT_BORDER = 4;          //line weight of the grid border
    final private static int RADIUS_SNAKE_BODY = 10;            //the corner radius of snake body parts
    //endregion

    //region Attributes for the levels/difficulties
    final private static int LEVEL_START = 5;                   //the initial level
    final private static int LEVEL_MAX = 10;                    //max level
    final private static int LEVEL_MIN = 1;                     //min level
    final private static int LEVEL_COUNT = LEVEL_MAX - LEVEL_MIN + 1;//number of levels
    //endregion

    //region Attributes for the game
    //the list of difficulties by amount of frames between moves
    final private static int[] FRAME_INTERVALS = {20, 18, 15, 13, 11, 9, 7, 4, 2, 1};
    final private static boolean IGNORE_WALLS = true;          //if the snake hits the wall, it comes out on the other side
    //endregion
    //endregion

    //region variables
    private static int frameDelay = 0;                          //frames the snake does not move in game - speed
    private static int frameCounter = 0;                        //counts the frames to keep track of them
    private static int animationFactor = 1;                     //which way the animation moves
    private static float animatedStrokeWeight = 4;              //the animated stroke weight

    private static int level = LEVEL_START;                     //the level of difficulty of the game
    private static int score, maxScore;                         //score of the game, maximum possible score
    private static Screen.Action action = Screen.Action.MAIN_MENU; //the action of the currentScreen (current currentScreen)

    //region object references
    private static Screen currentScreen;                               //the current currentScreen
    private static Snake snake;                                 //the snake
    private static Food food;                                   //the food of the snake
    //endregion
    //endregion
    //endregion

    //region main three Processing methods
    @Override
    public void settings() {
        if (FULL_SCREEN) {
            fullScreen();
        } else {
            size(WIDTH, HEIGHT);
        }
    }

    @Override
    public void setup() {
        surface.setTitle("Snake Field");
        background(COLOR_BACKGROUND);
        frameRate(FRAME_RATE);
        Screen.setScreenDimensions(width, height);
    }

    @Override
    public void draw() {
        switch (action) {
            case MAIN_MENU:
                if (!(currentScreen instanceof MainMenu)) {
                    currentScreen = new MainMenu();
                }
                action = checkForButtonPress(currentScreen, action);
                break;
            case LEVEL_SELECT:
                if (!(currentScreen instanceof LevelSelect)) {
                    currentScreen = new LevelSelect();
                    ((LevelSelect) currentScreen).updateLevelText(level);
                }
                if (currentScreen.buttonWasClicked()) {
                    action = currentScreen.getClickAction();
                    frameDelay = FRAME_INTERVALS[level - 1];
                }
                break;
            case GAME:
                if (!(currentScreen instanceof Field)) {
                    currentScreen = new Field(level);
                    Integer[] initialSnakePosition = ((Field) currentScreen).getCenterOfField();
                    int rows = ((Field) currentScreen).getRows();
                    int cols = ((Field) currentScreen).getCols();
                    snake = new Snake(initialSnakePosition, rows, cols, IGNORE_WALLS);
                    food = new Food(getFreeSquares(currentScreen, snake));
                    score = 0;
                }
                if (++frameCounter % frameDelay == 0) {
                    snake.move();
                    frameCounter = 0;
                    if (snakeHasFood(snake, food)) {
                        snake.grow();
                        score++;
                        ((Field) currentScreen).updateScoreText(score);
                        food = new Food(getFreeSquares(currentScreen, snake));
                    }
                }
                if (currentScreen.buttonWasClicked() || snake.isDead()) {
                    action = Screen.Action.GAME_OVER;
                    maxScore = ((Field) currentScreen).getMaxScore();
                    snake = null;
                }
                break;
            case GAME_OVER:
                if (!(currentScreen instanceof GameOver)) {
                    currentScreen = new GameOver(score, level);
                    //create a leader board to check if there is a new high score
                    LeaderBoard leaderBoard = new LeaderBoard();
                    if (leaderBoard.isNewHighScore(score, level)) {
                        ((GameOver) currentScreen).setTitleToHighScore();
                        leaderBoard.writeNewHighScore(score, level);
                    }
                    //if the player has max score, set appropriate text
                    if (score == maxScore - 1) {
                        ((GameOver) currentScreen).setTitleToMaxScore();
                    }
                }
                action = checkForButtonPress(currentScreen, action);
                break;
            case LEADER_BOARD:
                if (!(currentScreen instanceof LeaderBoard)) {
                    currentScreen = new LeaderBoard();
                }
                action = checkForButtonPress(currentScreen, action);
                break;
            case RESET_HIGH_SCORES:
                ((LeaderBoard) currentScreen).resetHighScores();
                ((LeaderBoard) currentScreen).readAllHighScores();
                ((LeaderBoard) currentScreen).updateText();
                action = Screen.Action.LEADER_BOARD;
                break;
            case EXIT:
                exit();
                break;
            default:
                action = Screen.Action.MAIN_MENU;
                break;
        }
        drawScreen(currentScreen, action, snake, food);
    }
    //endregion

    //region draw methods for the different elements
    private void drawScreen(Screen currentScreen, Screen.Action action, Snake snake, Food food) {
        background(COLOR_BACKGROUND);
        drawButtons(currentScreen);
        drawAllTexts(currentScreen);
        switch (action) {
            case GAME:
                drawField(currentScreen);
                drawFood(food, currentScreen);
                drawSnake(snake);
                break;
            case LEADER_BOARD:
                drawTable(currentScreen);
                break;
        }
    }

    private void drawButtons(Screen currentScreen) {
        for (Screen.Button button : currentScreen.getButtonList()) {
            stroke(COLOR_LINE);
            strokeWeight(STROKE_WEIGHT);
            fill(COLOR_BACKGROUND);
            rectMode(CENTER);
            rect(button.getX(), button.getY(), button.getWidth(), button.getHeight());
            drawText(button.getButtonText());
        }
    }

    private void drawAllTexts(Screen currentScreen) {
        for (Screen.Text text : currentScreen.getTextList()) {
            drawText(text);
        }
    }

    private void drawText(Screen.Text text) {
        fill(COLOR_TEXT);
        switch (text.getTextType()) {
            case SMALL:
                textSize(TextSize.SMALL);
                break;
            case MEDIUM:
                textSize(TextSize.MEDIUM);
                break;
            case LARGE:
                textSize(TextSize.LARGE);
                break;
            case TITLE:
                textSize(TextSize.TITLE);
                break;
        }
        textAlign(CENTER, CENTER);
        text(text.getText(), text.getX(), text.getY());
    }

    private void drawField(Screen currentScreen) {
        if (currentScreen instanceof Field) {
            stroke(COLOR_LINE);
            strokeWeight(STROKE_WEIGHT_GRID);
            int xOffset = ((Field) currentScreen).getXOffset();
            int yOffset = ((Field) currentScreen).getYOffset();
            int squareSideLength = ((Field) currentScreen).getSideLength();
            int rows = ((Field) currentScreen).getRows();
            int cols = ((Field) currentScreen).getCols();
            //horizontal grid lines
            for (int i = 0; i <= rows; i++) {
                line(xOffset, yOffset + i * squareSideLength, width - xOffset, yOffset + i * squareSideLength);
            }
            //vertical grid lines
            for (int i = 0; i <= cols; i++) {
                line(xOffset + i * squareSideLength, yOffset, xOffset + i * squareSideLength, height - yOffset);
            }
            //thick outline
            noFill();
            rectMode(NORMAL);
            //animate the outline in case walls are ignored to signify that
            if (IGNORE_WALLS) {
                animationFactor = (animatedStrokeWeight < 0.3 || animatedStrokeWeight > 5) ? -animationFactor : animationFactor;
                animatedStrokeWeight += animationFactor / 5f;
                strokeWeight(animatedStrokeWeight);
            } else {
                strokeWeight(STROKE_WEIGHT_BORDER);
            }
            rect(xOffset, yOffset, width - xOffset, height - yOffset);
        }
    }

    private void drawFood(Food food, Screen currentScreen) {
        if (food != null && currentScreen instanceof Field) {
            strokeWeight(STROKE_WEIGHT);
            stroke(COLOR_LINE);
            fill(COLOR_FOOD);
            ellipseMode(CENTER);
            int sideLength = ((Field) currentScreen).getSideLength();
            int xOffset = ((Field) currentScreen).getXOffset();
            int yOffset = ((Field) currentScreen).getYOffset();
            ellipse(food.getX() * sideLength + sideLength / 2 + xOffset, food.getY() * sideLength + sideLength / 2 + yOffset,
                    sideLength, sideLength);
        }
    }

    private void drawSnake(Snake snake) {
        if (snake != null) {
            rectMode(NORMAL);
            fill(COLOR_SNAKE);
            strokeWeight(STROKE_WEIGHT);
            stroke(COLOR_LINE);
            int xOffset = ((Field) currentScreen).getXOffset();
            int yOffset = ((Field) currentScreen).getYOffset();
            ArrayList<Integer[]> bodyPosition = snake.getPosition();
            int sideLength = ((Field) currentScreen).getSideLength();
            int x, y;
            for (Integer[] bodyPartPosition : bodyPosition) {
                x = bodyPartPosition[0] * sideLength + xOffset;
                y = bodyPartPosition[1] * sideLength + yOffset;
                rect(x, y, x + sideLength, y + sideLength, RADIUS_SNAKE_BODY);
            }
        }
    }

    private void drawTable(Screen currentScreen) {
        if (currentScreen instanceof LeaderBoard) {
            strokeWeight(STROKE_WEIGHT);
            int yOffset = ((LeaderBoard) currentScreen).getyOffset();
            int heightStep = ((LeaderBoard) currentScreen).getHeightStep();
            int y = (int) (1.5 * heightStep) + yOffset;
            for (int i = 0; i < LEVEL_COUNT; i++) {
                line(width / 4, y, 3 * width / 4, y);
                y += heightStep;
            }
        }
    }
    //endregion

    //region IO processing
    //On mouse click
    @Override
    public void mousePressed() {
        if (mouseButton == LEFT) {
            currentScreen.checkForButtonClick(mouseX, mouseY);
        }
    }

    private Screen.Action checkForButtonPress(Screen currentScreen, Screen.Action action) {
        if (currentScreen.buttonWasClicked()) {
            action = currentScreen.getClickAction();
        }
        return action;
    }

    @Override
    public void keyPressed() {
        //change the direction of the snake
        if (currentScreen instanceof Field && snake != null) {
            switch (keyCode) {
                case Key.ARROW_DOWN:
                case Key.S:
                    snake.goDown();
                    break;
                case Key.ARROW_UP:
                case Key.W:
                    snake.goUp();
                    break;
                case Key.ARROW_LEFT:
                case Key.A:
                    snake.goLeft();
                    break;
                case Key.ARROW_RIGHT:
                case Key.D:
                    snake.goRight();
                    break;
            }
            //change the level of difficulty
        } else if (currentScreen instanceof LevelSelect) {
            switch (keyCode) {
                case Key.ARROW_DOWN:
                case Key.S:
                    if (level > LEVEL_MIN) {
                        ((LevelSelect) currentScreen).updateLevelText(--level);
                    }
                    break;
                case Key.ARROW_UP:
                case Key.W:
                    if (level < LEVEL_MAX) {
                        ((LevelSelect) currentScreen).updateLevelText(++level);
                    }
                    break;
            }
        }
        //move to the next currentScreen, unless we are in the game
        if (!(currentScreen instanceof Field) && keyCode == Key.ENTER) {
            currentScreen.goToNextScreen();
        }
    }
    //endregion

    //region utility functions
    //check if the snake has food at the moment
    private boolean snakeHasFood(Snake snake, Food food) {
        Integer[] head = snake.getHeadPosition();
        return head[0] == food.getX() && head[1] == food.getY();
    }

    //create a list of all free squares on the field where food can spawn
    private ArrayList<Integer[]> getFreeSquares(Screen currentScreen, Snake snake) {

        ArrayList<Integer[]> allowablePoints = new ArrayList<>();
        ArrayList<Integer[]> snakePosition = snake.getPosition();

        for (int i = 0; i < ((Field) currentScreen).getRows(); i++) {
            for (int j = 0; j < ((Field) currentScreen).getCols(); j++) {
                allowablePoints.add(new Integer[]{i, j});
            }
        }
        for (Integer[] snakePart : snakePosition) {
            allowablePoints.removeIf(x -> Arrays.equals(x, snakePart));
        }
        return allowablePoints;
    }
    //endregion

    //region getter
    //get the number of levels of difficulty
    static int getLevels() {
        return LEVEL_COUNT;
    }
    //endregion

    //region main method
    public static void main(String[] args) {
        PApplet.main("Main");
    }
    //endregion
}
