import chap02.PasswordStrength;
import chap02.PasswordStrengthMeter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class passwordStrengthMeterTest {

    private PasswordStrengthMeter psm = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = psm.meter(password);
        assertEquals(expStr, result);
    }

    @Test
    public void 모든규칙을충족하는경우() {
/*      //assertStrength()로 리팩토링
        PasswordStrength result = psm.meter("ab1!@Add");
        assertEquals(PasswordStrength.STRONG, result);
*/
        assertStrength("ab1!@Add", PasswordStrength.STRONG);
    }

    @Test
    public void 길이만8글자미만이고나머지조건은충족하는경우() {
        assertStrength("ab12!@A",PasswordStrength.NORMAL);
    }

    @Test
    public void 숫자를포함하지않고나머지조건은충족하는경우() {
        assertStrength("abbb!@Add",PasswordStrength.NORMAL);
    }

    @Test
    void 입력이Null일경우() {
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    void 입력이빈문자열일경우() {
        assertStrength("",PasswordStrength.INVALID);
    }

    @Test
    void 대문자를포함하지않고나머지조건을충족하는경우() {
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    @Test
    void 길이가8글자이상이상조건만충족하는경우() {
        assertStrength("abcdfghi", PasswordStrength.WEAK);
    }

    @Test
    void 숫자포함조건만충족하는경우() {
        assertStrength("12345", PasswordStrength.WEAK);
    }

    @Test
    void 대문자포함조건만충족하는경우() {
        assertStrength("DDD", PasswordStrength.WEAK);
    }

    @Test
    void 아무조건도충족하지않는경우() {
        assertStrength("abc", PasswordStrength.WEAK);
    }
}
