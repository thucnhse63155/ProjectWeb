/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author MY_PC
 */
public class Dog {

    protected String name;
    protected String id;
    protected int yob;
    protected double weight;

    public Dog(String name, String id, int yob, double weight) {
        this.name = name;
        this.id = id;
        this.yob = yob;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void showDetailed() {
        String msg = String.format("|%-15s|%5s|%4d|%4.1f", name, id, yob, weight);
        System.out.println(msg);
    }
}
