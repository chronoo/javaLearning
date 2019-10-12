package basic;

import java.math.*;

/**
 * Класс, шифрующий демонстрирующий (де)шифровку числа по RSA (пример из Википедии)
 * Дешифровка работает медленно, потому что в BigInteger нет возведения в степень по модулю
 */
public class BigIntUsing 
{
    public static void main( String[] args )
    {
        BigInteger source = BigInteger.valueOf(111111);
        BigInteger encriptedNumber = RSA.getEncriptedNumber(source);
        System.out.println(encriptedNumber);

        BigInteger decriptedNumber = RSA.getDecryptedNumber(encriptedNumber);
        System.out.println(decriptedNumber);
    }
}
