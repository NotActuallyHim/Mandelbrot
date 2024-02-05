package MathObjects;
public class Rational {
    private int numerator;
    private int denominator;

    // constructors
    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Rational(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        if(denominator == 0){
            throw new IllegalArgumentException("Cannot divide by zero");
        } else {
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
        }
    }

    /**
     * simplify calls getGCD to get the greatest number that the numerator and
     * denominator have in common and then divides both of them by it to get the
     * simplest form of the rational number
     */
    private void simplify() {
        int GCD = getGCD(this.numerator, this.denominator);
        this.denominator /= GCD;
        this.numerator /= GCD;
    }

    /**
     * get GCD gets the greatest common denominator from the two numbers using
     * recursion and the logic from euclids method
     * 
     * @param num1 is the first number that will be compared
     * @param num2 is the second number that will be compared ot the first
     * @return int is the greatest common denominator between the two supplied
     *         numbers
     */
    private static int getGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return getGCD(num2, num1 % num2);
    }

    // Converts to String
    @Override
    public String toString() {
        return String.format("%d/%d", this.numerator, this.denominator);
    }

    /**
     * to Double converts the numerator of the rational number into a double and
     * then divides it by the denominator
     * 
     * @return returns the double that is equivilant to the rational number
     */
    public double toDouble() {
        return (this.numerator * 1.0) / this.denominator;
    }

    /**
     * negate takes the current Rational object and makes the value that it holds
     * negative
     * 
     * @return returns a new Rational object where the rational number is the
     *         negative
     */
    public Rational negate() {
        return new Rational(this.numerator * -1, this.denominator);
    }

    /**
     * invert makes the reciprical of the rational number in the current object
     * 
     * @return returns a new Rational object that holds the reciprical of the
     *         previous object
     */
    public Rational invert() {
        return new Rational(this.denominator, this.numerator);
    }

    /**
     * the add method adds the values of the two rational numbers in the objects
     * together and creates a new rational number that is in its simplified form by
     * multipying the other fraction be its denominator and vise versa so they have
     * a common denominator and then the numerators are added and put over the
     * common denominator
     * 
     * @param that is the other Rational object that will be added the current
     *             object
     * @return returns a new object that is the sum of both rational numbers in its
     *         simplest form
     */
    public Rational add(Rational that) {
        int tempNumerator, tempDenominator;
        tempNumerator = this.numerator * that.denominator + that.numerator * this.denominator;
        tempDenominator = this.denominator * that.denominator;
        return new Rational(tempNumerator, tempDenominator);
    }

    /**
     * The subtract method subtracts the two rational numbers by multiplying the
     * numerator and denominator by the denominator of the current object and vise
     * versa in order to make a common denomintor then it subracts the numerators of
     * the two objects
     * 
     * @param that is the other Rational number that will be subtracted from this
     *             Rational Number
     * @return Returns a simplified Rational number
     */
    public Rational subtract(Rational that) {
        int tempNumerator, tempDenominator;
        tempNumerator = this.numerator * that.denominator - that.numerator * this.denominator;
        tempDenominator = this.denominator * that.denominator;
        return new Rational(tempNumerator, tempDenominator);
    }

    /**
     * the multiply method multiplies the numerators of the two fractions together
     * and then doing the same with the denominators and then putting the new
     * numerator over the new denominator
     * 
     * @param that is the other object that will be multiplied with the current
     *             object
     * @return returns a new Rational number that is the product of the two Rational
     *         objects
     */
    public Rational multiply(Rational that) {
        int tempNumerator, tempDenominator;
        tempNumerator = this.numerator * that.numerator;
        tempDenominator = this.denominator * that.denominator;
        return new Rational(tempNumerator, tempDenominator);
    }

    /**
     * the divide mthod multipies this Rational object by the Riciprical of the
     * other Rational object to get the quotient of the two Rational objects
     * 
     * @param that is the other Rational object that will be dividing this Rational
     *             object
     * @return the simplified quotient of the two Rational objects
     */
    public Rational divide(Rational that) {
        int tempNumerator, tempDenominator;
        tempDenominator = this.denominator * that.numerator;
        tempNumerator = this.numerator * that.denominator;
        return new Rational(tempNumerator, tempDenominator);
    }

    public boolean equals(Rational that){
        return this.numerator == that.numerator && this.denominator == that.denominator;
    }

}
