package com.company.math.DiscMath;

import java.util.ArrayList;

public class Set {
    private ArrayList<String> data;
    private String name;
    private int size;

    public Set(String name) {
        this.data = new ArrayList<>();
        this.name = name;
    }

    public Set(String name, Set copy) {
        this.data = new ArrayList<>();
        for(int i = 0; i<copy.getSize();i++){
            this.data.add(copy.get(i));
        }
        this.name = name;
    }

    public String get(int i) {
        return data.get(i);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return this.data.size();
    }

    public void add(String string){
        if(!data.contains(string))
        this.data.add(string);
    }

    public void remove(String string){
        this.data.remove(string);
    }

    public void remove(int index){
        this.data.remove(index);
    }

    public void print() {
        System.out.print(this.name+" = {");
        for(int i = 0;i < this.data.size();i++){
            System.out.print(data.get(i));
            if(i+1!=this.data.size()){
                System.out.print(",");
            }
        }
        System.out.print("}\n");
    }

    public boolean contains(String s) {
        return this.data.contains(s);
    }
}
