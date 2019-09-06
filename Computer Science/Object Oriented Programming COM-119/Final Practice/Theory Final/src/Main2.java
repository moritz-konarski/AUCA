public class Main2 {
    public static void main(String[] args) {
        final int Limit = 10_014;

        long startTime = System.nanoTime();
        {
            String result = "";
            for (int i = 0, c = 0; i < Limit; i++, c = (c + 1) % ('z' - 'a' + 1)) {
                result += (char) ('a' + c);
            }
            System.out.println(result);
        }
        long firstTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        {
            StringBuilder result = new StringBuilder();
            for (int i = 0, c = 0; i < Limit; i++, c = (c + 1) % ('z' - 'a' + 1)) {
                result.append('a' + c);
            }
            System.out.println(result);
        }
        long secondTime = System.nanoTime() - startTime;

        System.out.println(firstTime > secondTime);
    }
}
