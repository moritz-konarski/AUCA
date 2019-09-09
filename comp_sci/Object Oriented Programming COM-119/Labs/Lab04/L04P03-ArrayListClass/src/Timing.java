class Timing {
    private double time;
    private long startTime;
    private long endTime;

    Timing() {
        time = 0;
        endTime = 0;
        startTime = 0;
    }

    void startTimer() {
        startTime = System.nanoTime();
    }

    void stopTimer() {
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000.0;
    }

    double getTime() {
        return time;
    }
}
