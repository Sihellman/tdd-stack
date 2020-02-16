package edu.htc.blitstein.caih313.tddstack.resource.room;

import edu.htc.blitstein.caih313.tddstack.IStackable;

public class LectureRoom implements IStackable {
    public int num;
    public LectureRoom(){
        num = 1;
    }
    public LectureRoom(int num){
        this.num = num;
    }
    public String toString(){
        return num + "";
    }
}
