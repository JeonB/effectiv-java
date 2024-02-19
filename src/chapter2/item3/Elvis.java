package chapter2.item3;

public class Elvis {
    // 3-1 public static final 필드 방식의 싱글턴
    public static final Elvis INSTANCE = new Elvis();
    private Elvis(){...}
        
    // 3-2 정적 팩터리 방식의 싱글턴
    private static final Elvis INSTANCE = new Elvis();
    private Elvis(){...}
    public static Elvis getInstance(){return INSTANCE;}
    
    // 싱글턴임을 보장해주는 readResolve 메서드
    private Object readResolve(){
        // 진짜 Elvis를 반환하고, 가짜 가비지 컬렉터에 맡긴다.
        return INSTANCE;
    }

    // 3-3 열거 타입 방식의 싱글턴 - 바람직한 방법
    public enum Elvis{
        INSTANCE;
        public void leaveTheBuilding(){...}
    }
}
