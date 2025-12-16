package fractions;

public class CachedFraction extends Fraction {
    private Double cachedRealValue;
    private boolean isCacheValid;

    public CachedFraction(int numerator, int denominator) {
        super(numerator, denominator);
        this.isCacheValid = false;
    }

    @Override
    public double getRealValue() {
        if (!isCacheValid) {
            cachedRealValue = super.getRealValue();
            isCacheValid = true;
        }
        return cachedRealValue;
    }


    @Override
    public void setNumerator(int numerator) {
        super.setNumerator(numerator);
        invalidateCache();
    }

    @Override
    public void setDenominator(int denominator) {
        super.setDenominator(denominator);
        invalidateCache();
    }

    private void invalidateCache() {
        isCacheValid = false;
        cachedRealValue = null;
    }
}