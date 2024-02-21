package chapter3.item12;

import static java.util.Comparator.comparingInt;

import java.util.Comparator;
import org.junit.Test;

public class PhoneNumber {
    public final Short areaCode;
    public final Short prefix;
    public final Short lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode);
        this.prefix = rangeCheck(prefix);
        this.lineNum = rangeCheck(lineNum);
    }

    public short rangeCheck(int integer) {
        if(integer <= Short.MAX_VALUE && integer >= Short.MIN_VALUE) {
            return (short) integer;
        }

        throw new IllegalStateException();
    }

    /**
     * 전화번호의 문자열 표현을 반환한다.
     * xxx-yyy-zzzz 와 같은 형식으로 반환된다.
     * 만일, 각 자리 숫자의 갯수보다 적은 숫자를 넣게 되면 그 공간은 0으로 채워진다.
     */
    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }

    public int compareTo(PhoneNumber pn) {
        int result = Short.compare(areaCode, pn.areaCode); // 가장 중요한 필드
        if (result == 0) {
            result = Short.compare(prefix, pn.prefix); // 두 번째로 중요한 필드
            if (result == 0) {
                result = Short.compare(lineNum, pn.lineNum); // 세 번째로 중요한 필드
            }
        }
        return result;
    }

    //비교자 생성 메서드를 활용한 비교자
    private static final Comparator<PhoneNumber> COMPARATOR =
            comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparingInt(pn -> pn.prefix)
                    .thenComparingInt(pn -> pn.lineNum);

    public int compareTo(PhoneNumber pn){
        return COMPARATOR.compare(this, pn);
    }
}

//@Test
//public void toStringTest() {
//    PhoneNumber myPhoneNumber = new PhoneNumber(10, 1111, 1111);
//    System.out.println("myPhoneNumber: " + myPhoneNumber); // 출력: 010-1111-1111
//}
