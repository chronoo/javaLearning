package basic;

/**
 * Pair
 */
public class Pair<M,N> {
    private M first;
    private N second;
    private Pair(){}

    public M getFirst() {
        return first;
    }

    public static <M,N> Pair<M,N> of(M first, N second){
        Pair<M, N> result = new Pair<M, N>();
        result.first = first;
        result.second = second;
        return result;
    }
    
    public N getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) 
            return true;
        if (other == null)
            return false;
        if (getClass() != other.getClass())
            return false;
        if (other instanceof Pair) {
            Pair obj1 = (Pair) other;
            if (first == null && obj1.first == null && second == null && obj1.second == null)
                return true;
            if (first == null || second == null)
                return false;
            if (first.equals(obj1.getFirst()) && second.equals(obj1.getSecond())) {
                    return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int firstHash = (first == null ? 0 : first.hashCode());
        int secondHash = (second == null ? 0 : second.hashCode());
        return firstHash + secondHash;
    }
}