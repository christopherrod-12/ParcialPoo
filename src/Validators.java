import java.time.LocalDate;
import java.time.Period;

public class Validators {

    public boolean isAdult(int year, int month, int day) {
        LocalDate birth = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        Period p = Period.between(birth, now);
        return p.getYears() >= 18;
    }

    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0) return false;
        int r = (int) Math.sqrt(n);
        for (int i = 3; i <= r; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public boolean isPerfect(int n) {
        if (n < 2) return n == 1;
        int sum = 1;
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                sum += i;
                int other = n / i;
                if (other != i) sum += other;
            }
        }
        return sum == n;
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        String cleaned = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(rev);
    }

    public boolean isCapicua(String s) {
        String cleaned = s.replaceAll("[^0-9]", "");
        return new StringBuilder(cleaned).reverse().toString().equals(cleaned);
    }
}
