package chapter3.item11;

public class HashCode {
    //사용금지
//    @Override
//    public int hashCode(){return 42;}

    //전형적인 hashCode 메서드
    @Override
    public int hashCode(){
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }
}
