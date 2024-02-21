package chapter3.item13;

import chapter2.item7.Stack;
import chapter3.item12.PhoneNumber;

public class Cloneable {

    @Override
    public PhoneNumber clone(){
        try{
            return (PhoneNumber) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError(); //일어날 수 없는 일이다.
        }
    }


}
