class Rational {
    //variables######################################################
    private int numerator, denominator;

    //constructor for user input#####################################
    private Rational(int num, int denom) throws DenominatorZeroException {
        if (denom == 0) {
            throw new DenominatorZeroException();
        }
        this.numerator = num;
        this.denominator = denom;
        this.reduce();
    }

    //constructor without denomZero exception########################
    private Rational(int num, int denom, boolean exception) {
        this.numerator = num;
        this.denominator = denom;
        this.reduce();
    }

    //a general constructor for the result###########################
    Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    //methods########################################################
    //reducing the fraction as much as possible
    private void reduce() {
        int gcd = gcd(this.numerator, this.denominator);
        this.denominator /= gcd;
        this.numerator /= gcd;
        if (this.denominator < 0 && this.numerator >= 0) {
            this.denominator *= -1;
            this.numerator *= -1;
        }
        if (this.denominator < 0 && this.numerator < 0) {
            this.denominator *= -1;
            this.numerator *= -1;
        }
    }

    //method using euclidean algorithm to find gcd
    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    //behavior#######################################################
    //addition
    Rational add(Rational other) {
        int newDenominator = this.denominator * other.denominator;
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        return new Rational(newNumerator, newDenominator, false);
    }

    //subtraction
    Rational sub(Rational other) {
        int newDenominator = this.denominator * other.denominator;
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        return new Rational(newNumerator, newDenominator, false);
    }

    //multiplication
    Rational mul(Rational other) {
        int newDenominator = this.denominator * other.denominator;
        int newNumerator = this.numerator * other.numerator;
        return new Rational(newNumerator, newDenominator, false);
    }

    //division
    Rational div(Rational other) throws DivisionByZeroException {
        if (other.numerator == 0) {
            throw new DivisionByZeroException();
        }
        int newDenominator = this.denominator * other.numerator;
        int newNumerator = this.numerator * other.denominator;
        return new Rational(newNumerator, newDenominator, false);
    }

    //outputting to a string
    public String toString() {
        if (this.numerator < 0 || this.denominator < 0)
            return String.format("-(%d/%d)", Math.abs(this.numerator), Math.abs(this.denominator));
        else
            return String.format("%d/%d", this.numerator, this.denominator);
    }

    //comparing to another number
    int compareTo(Rational other) {
        int numeratorA = this.numerator * other.denominator;
        int numeratorB = this.denominator * other.numerator;
        return Integer.compare(numeratorA, numeratorB);
    }

    //parse a rational from text
    static Rational parse(String input) throws NotARationalException, DenominatorZeroException {
        if (!input.matches("[\\d|-]+\\d*/[\\d|-]+\\d*"))
            throw new NotARationalException();
        String[] parts = input.split("/");
        int denominator = Integer.parseInt(parts[1]);
        int numerator = Integer.parseInt(parts[0]);
        return new Rational(numerator, denominator);
    }
}
