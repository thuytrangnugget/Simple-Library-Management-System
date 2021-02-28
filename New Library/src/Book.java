/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class Book implements Comparable<Book>{
    public String bcode;
    public String title;
    public double price;
    public int quantity;
    //state = 0: not given to the reader
    //state = 1: still at reader, not given back
    //state = 2: given back to the library
    public int state;

    public Book() {
    }

    public Book(String bcode, String title, double price, int quantity) {
        this.bcode = bcode;
        this.title = title;
        this.price = price;
        this.state = 0;
        this.quantity = quantity;
    }
    
    public boolean equals(Object node) {
        return title.equals(((Book) node).title);
    }
    
    public int compareTo(Book t) {
        return this.bcode.compareTo(t.bcode);
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    
}

