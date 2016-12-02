package models;

/**
 * Created by AndersWOlsen on 29-11-2016.
 */
public class TestDie extends Die{
    public TestDie() { super(); }
    public TestDie(int faceCount) { super(faceCount); }

    public void roll(int result) {
        this.result = result;
    }
}
