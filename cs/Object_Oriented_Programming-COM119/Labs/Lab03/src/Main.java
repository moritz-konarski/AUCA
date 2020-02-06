public class Main {
    public static void main(String[] args) {
        System.out.println("Calculator of Rational Numbers");
        String operator;
        do {
            try {
                Rational r1 = getRational("1st");
                operator = getOperator();
                Rational r2 = getRational("2nd");
                executeCommand(operator, r1, r2);
            } catch (DivisionByZeroException e) {
                System.err.printf("An error occurred: %s%n", e.getMessage());
            } catch (EndOfFileException e) {
                System.err.printf("%s%n", e.getMessage());
                System.exit(0);
            }
        } while (true);
    }

    private static void executeCommand(String operator, Rational r1, Rational r2) throws DivisionByZeroException {
        if (operator.matches("[-+*/]")) {
            Rational result = new Rational();
            switch (operator) {
                //addition
                case "+":
                    result = r1.add(r2);
                    break;
                //subtraction
                case "-":
                    result = r1.sub(r2);
                    break;
                //multiplication
                case "*":
                    result = r1.mul(r2);
                    break;
                //division
                case "/":
                    result = r1.div(r2);
                    break;
            }
            System.out.printf("Result: %s %s %s = %s%n", r1.toString(), operator, r2.toString(), result.toString());
        } else {
            int compared;
            boolean expression = false;
            compared = r1.compareTo(r2);
            switch (operator) {
                case ">":
                    expression = compared > 0;
                    break;
                case "<":
                    expression = compared < 0;
                    break;
                case "=":
                    expression = compared == 0;
                    break;
                case "!=":
                    expression = compared != 0;
                    break;
                case "<=":
                    expression = compared != 1;
                    break;
                case ">=":
                    expression = compared != -1;
                    break;
            }
            System.out.printf("Result: %s %s %s is %b%n", r1.toString(), operator, r2.toString(), expression);
        }
    }

    private static Rational getRational(String nRational) throws EndOfFileException {
        boolean error;
        Input scanner = new Input();
        Rational input = new Rational();
        do {
            try {
                error = false;
                System.out.printf("Enter %s rational (Ctrl-Z to exit): ", nRational);
                input = Rational.parse(scanner.readNext());
            } catch (DenominatorZeroException | NotARationalException exception) {
                System.err.printf("An error occurred: %s%n", exception.getMessage());
                error = true;
            }
        } while (error);
        return input;
    }

    private static boolean operatorValid(String operator) {
        final String[] operatorArray = {"+", "-", "*", "/", "<", ">", "=", "!=", "<=", ">="};
        boolean contained = false;
        for (String operation : operatorArray) {
            if (operation.equals(operator)) {
                contained = true;
                break;
            }
        }
        if (!contained) {
            System.err.println("Invalid Operator. Try:");
            for (String operation : operatorArray) {
                System.err.printf("- \"%s\"%n", operation);
            }
        }
        System.out.print("");
        return contained;
    }

    private static String getOperator() throws EndOfFileException {
        Input scanner = new Input();
        System.out.print("Enter operator: ");
        String operator = scanner.readNext();
        while (!operatorValid(operator)) {
            System.out.print("Enter operator: ");
            operator = scanner.readNext();
        }
        return operator;
    }
}
