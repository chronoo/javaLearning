package basic;

/**
 * AsciiCharSequence
 */
public class AsciiCharSequence implements CharSequence {
    private byte[] chars;

    public AsciiCharSequence(byte[] chars) {
        this.chars = chars.clone();
    }

    @Override
    public int length() {
        return chars.length;
    }

    @Override
    public char charAt(int index) {
        return (char) chars[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] subChars = new byte[end - start];
        for (int i = 0; i < end - start; i++) {
            subChars[i] = chars[start + i];
        }
        CharSequence result = new AsciiCharSequence(subChars);
        return result;
    }

    @Override
    public String toString() {
        return new String(chars);
    }
}