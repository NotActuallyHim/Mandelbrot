package MathObjects;

public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    public Complex() {
        this.real = 0;
        this.imaginary = 0;
    }

    public double getReal() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public Complex add(Complex that) {
        return new Complex(this.real + that.real, this.imaginary + that.imaginary);
    }

    public Complex add(double realNum) {
        return this.add(new Complex(realNum));
    }

    public Complex subtract(Complex that) {
        return new Complex(this.real - that.real, this.imaginary - that.imaginary);
    }

    public Complex subtract(double realNum) {
        return this.subtract(new Complex(realNum));
    }

    public Complex multiply(Complex that) {
        double real = this.real * that.real - this.imaginary * that.imaginary;
        double imaginary = this.real * that.imaginary + this.imaginary * that.real;
        return new Complex(real, imaginary);
    }

    public Complex multiply(double realNum) {
        return this.multiply(new Complex(realNum));
    }

    public Complex divide(Complex that) {
        double real = (this.real * that.real + this.imaginary * that.imaginary)
                / (that.real * that.real + that.imaginary * that.imaginary);
        double imaginary = (this.imaginary * that.real - this.real * that.imaginary)
                / (that.real * that.real + that.imaginary * that.imaginary);
        return new Complex(real, imaginary);
    }

    public Complex divide(double realNum) {
        return this.divide(new Complex(realNum));
    }

    public Complex square() {
        double real = this.real * this.real - this.imaginary * this.imaginary;
        double imaginary = 2 * this.real * this.imaginary;
        return new Complex(real, imaginary);
    }

    public boolean equals(Complex that) {
        return this.real == that.real && this.imaginary == that.imaginary;
    }

    public double abs() {
        return Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
    }

    public String toString() {
        return String.format("%.3f + %.3fi", this.real, this.imaginary);
    }
}
