import java.util.BitSet;

public class Eratosthenes {
    public static BitSet bits; //You should work on this BitSet

    public static int numberOfPrime(int n){
        bits = new BitSet(n);
        bits.flip(2, n); // marque true de 2 à n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (bits.get(i)) { //si marqué prime
                for (int j = 2 * i; j < n; j += i) {
                    bits.set(j, false); //pas prime
                }
            }
        }
        return bits.cardinality(); //renvoie le nombre de true dans bits
    }
}
