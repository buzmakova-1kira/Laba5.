package fractions;

import java.util.Objects;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.numerator = numerator;
        this.denominator = denominator;

        // Обработка отрицательного знаменателя
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
    }

    public double getRealValue() {
        return (double) numerator / denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.denominator = denominator;
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Fraction fraction = (Fraction) obj;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}