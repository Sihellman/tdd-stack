package edu.htc.blitstein.caih313.tddstack.engine;

import edu.htc.blitstein.caih313.tddstack.IStackable;
import java.util.Scanner;

import edu.htc.blitstein.caih313.tddstack.resource.campus.Faculty;
import edu.htc.blitstein.caih313.tddstack.resource.campus.Student;
import edu.htc.blitstein.caih313.tddstack.resource.room.ComputerLab;
import edu.htc.blitstein.caih313.tddstack.resource.room.LectureRoom;

public class TddStack implements IStackable {
    static int DEFAULT_DEPTH = 100;
    int stackDepth;
    private int currentNumber;
    private IStackable[] storage;
    private IStackable obj;
    TddStack(int stackDepth){
        this.stackDepth = stackDepth;
        currentNumber = -1;
        storage = new IStackable[stackDepth];

    }
    public TddStack(){
        this(DEFAULT_DEPTH);
    }
    public boolean isEmpty(){
        return currentNumber == -1;

    }
    public int getCurrentNumber(){
        return currentNumber;
    }
    public IStackable[] getStorage(){
        return storage;
    }
    public boolean isFull(){
        return currentNumber == storage.length - 1;

    }
    public void push(IStackable obj){
        if (currentNumber < storage.length -1) {
            currentNumber++;
            storage[currentNumber] = obj;

        }
    }

    public IStackable pop(){

        if (currentNumber == -1){
            return null;
        }
        else{
            obj = storage[currentNumber];
            storage[currentNumber] = null;
            currentNumber--;
            return obj;
        }



    }
    public String toString(){
        return obj + " ";
    }




    public static void main(String[] args) {
        TddStack obj = null;
        IStackable stackObject = null;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("how many objects do you want to enter? press -1 if you don't know");
        int num = keyboard.nextInt();
        if(num == -1){
            obj = new TddStack();
        }
        else if (num > -1) {
            obj = new TddStack(num);
        }
        else {
            System.exit(0);
        }
        while(true){
            System.out.println("do you want to add an object?");
            String ans = keyboard.next();
            if ((ans.equalsIgnoreCase("yes")) && (!obj.isFull())){


                    System.out.println("enter f for faculty, s for student, " +
                            "c for computer lab, l for lecture room");
                    ans = keyboard.next();
                    if (ans.equals("f")){
                        System.out.println("enter name");
                        ans = keyboard.next();
                        stackObject = new Faculty(ans);
                    }
                    else if (ans.equals("s")){
                        System.out.println("enter name");
                        ans = keyboard.next();
                        stackObject = new Student(ans);
                    }
                    else if (ans.equals("c")){
                        System.out.println("enter type");
                        ans = keyboard.next();
                        stackObject = new ComputerLab(ans);
                    }
                    else if (ans.equals("l")){
                        System.out.println("enter number");
                        int number = keyboard.nextInt();
                        stackObject = new LectureRoom(number);
                    }
                    obj.push(stackObject);



            }
            else if ((obj.isFull()) && (ans.equalsIgnoreCase("yes"))){
                System.out.println("no more room. would you like to pop?");
                ans = keyboard.next();
                if (ans.equalsIgnoreCase("yes")){

                    System.out.println("you popped " + obj.pop());
                }
                else{
                    for (int i = 0; i < obj.storage.length; i++){
                        System.out.println(obj.storage[i]);
                    }
                    System.exit(0);
                }
            }
            else {
                System.out.println("do you want to pop?");
                ans = keyboard.next();
                if (ans.equalsIgnoreCase("yes")){
                    if (obj.isEmpty()){
                        for (int i = 0; i < obj.storage.length; i++){
                            System.out.println("null");
                        }
                        System.exit(0);
                    }
                    else{
                        System.out.println("you popped " + obj.pop());
                    }
                }
                else {
                    if (!obj.isEmpty()) {
                        for (int i = 0; i < obj.storage.length; i++) {
                            System.out.println(obj.storage[i]);

                        }
                    }
                    System.exit(0);
                }

            }
        }

    }
}
