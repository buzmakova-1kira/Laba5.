import java.util.Objects;

class Fraction {
    private int numerator;
    private int denominator;
    private Double cachedRealValue;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
    }

    // Получение вещественного значения
    public double getRealValue() {
        if (cachedRealValue == null) {
            cachedRealValue = (double) numerator / denominator;
        }
        return cachedRealValue;
    }

    // Установка числителя
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        cachedRealValue = null;
        if (denominator < 0) {
            this.numerator = -numerator;
            denominator = -denominator;
        }
    }

    // Установка знаменателя
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.denominator = denominator;
        cachedRealValue = null; // сброс кэша
        if (denominator < 0) {
            numerator = -numerator;
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

    // Сравнение дробей
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
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