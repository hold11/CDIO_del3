package models;

/**
 * Created by AndersWOlsen on 29-11-2016.
 */
public class TestDiceCup extends DiceCup{
    public TestDiceCup () { super(); }

    @Override
    protected void initDice() {
        for (int i = 0; i < this.diceCount; i++)
            this.dice.add(new TestDie(faceCount));

        System.out.println("init dice");
    }

    public void roll(int[] results) {
        this.results.clear();

        for (int result : results)
            this.results.add(result);
    }
}
