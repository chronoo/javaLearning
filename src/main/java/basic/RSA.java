package basic;

import java.math.*;

/**
 * класс (де)шифрования RSA с фиксированными параметрами
 */
public class RSA {
    private static int p = 3557;
    private static int q = 2579;
    private static BigInteger  n = BigInteger.valueOf(p * q);
    private static int e = 3;
    private static int d = RSA.getModularMultiplicativeInverse(n);

    /**
     * Шифрует число по алгоритму RSA
     * @param number - исходное число
     * @return - зашифрованное число
     */
    public static BigInteger getEncriptedNumber(BigInteger number) {
        BigInteger encriptedNumber = number.pow(e).remainder(n);
        return encriptedNumber;
    }

    /**
     * Расшифровывает число по алгоритму RSA
     * @param encriptedNumber - зашифрованное число
     * @return - дешифрованное число
     */
    public static BigInteger getDecryptedNumber(BigInteger encriptedNumber) {
        BigInteger decryptedNumber = encriptedNumber.pow(d).remainder(n);
        // BigInteger decryptedNumber = encriptedNumber.modPow(encriptedNumber, d);
        return decryptedNumber;
    }

    private static int getModularMultiplicativeInverse(BigInteger n) {
        // заглушка вместо применения расширенного алгоритма Евклида
	    int d = 6111579;
	    return d;
	}
}