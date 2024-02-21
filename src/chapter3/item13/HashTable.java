package chapter3.item13;


public class HashTable implements java.lang.Cloneable {
    private Entry[] buckets = ...;
    private static class Entry{
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Entry deepCopy(){
//            return new Entry(key, value, next == null ? null: next.deepCopy()); 스택 오버플로 위험이 있음
            Entry result = new Entry(key, value, next);
            for (Entry p = result; p.next != null; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);

            }
            return result;
        }
    }
    //잘못된 clone 메서드 - 가변 상태를 공유한다
    @Override
    public HashTable clone(){
        try{
            HashTable result = (HashTable) super.clone();
            result.buckets = buckets.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // 복잡한 가변 상태를 갖는 클래스용 재귀적 clone 메서드
    @Override
    public HashTable clone(){
        try{
            HashTable result = (HashTable) super.clone();
            result.buckets = new Entry[buckets.length];
            for(int i = 0 ; i<buckets.length; i++)
                if (buckets[i] != null) {
                    result.buckets[i] = buckets[i].deepCopy();
                }
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
