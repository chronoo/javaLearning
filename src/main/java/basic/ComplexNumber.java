package basic;

/**
 * ComplexNumber
 */
public class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals = false;
        if (this == obj) {
            isEquals = true;
        } else if (obj instanceof ComplexNumber) {
            ComplexNumber num = (ComplexNumber) obj;
            if (re == num.re && im == num.im) {
                isEquals = true;
            }
        }
        
        return isEquals;
    }

    @Override
    public int hashCode() {
        int hash = Double.hashCode(re) + Double.hashCode(im);
        return hash;
    }
}