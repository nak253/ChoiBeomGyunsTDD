package chap02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String str) {

        if (str == null || str.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        int count = getMetCriteriaCount(str);

        if (count == 1) return PasswordStrength.WEAK;
        if (count == 2) return PasswordStrength.NORMAL;
        if (count == 3) return PasswordStrength.STRONG;

        return PasswordStrength.WEAK;
    }

    private int getMetCriteriaCount(String str) {
        int count = 0;

        if ( str.length() >= 8) count ++;
        if (isContainsNum(str)) count ++;
        if (isContainsUpperCase(str)) count ++;
        return count;
    }

    private boolean isContainsUpperCase(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean isContainsNum(String str) {
        for (char c : str.toCharArray()) {
            if (('0' <= c && c <= '9')) {
                return true;
            }
        }
        return false;
    }
}
