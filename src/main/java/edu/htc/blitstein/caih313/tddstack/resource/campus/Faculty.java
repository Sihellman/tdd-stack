package edu.htc.blitstein.caih313.tddstack.resource.campus;

import edu.htc.blitstein.caih313.tddstack.IStackable;

public class Faculty implements IStackable {
    public String name;
    public Faculty(){
        name = "it";
    }
    public Faculty(String name){
        this.name = name;
    }
    public String toString(){
        return name;
    }
}
