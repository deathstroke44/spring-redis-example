package com.techprimers.cache.springredisexample.model;

import java.util.ArrayList;

public class TableList {

    ArrayList<String> arrayList;

    public TableList() {
    }

    public TableList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }
}
