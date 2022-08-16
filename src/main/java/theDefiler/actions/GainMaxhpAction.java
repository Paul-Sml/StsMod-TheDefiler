package theDefiler.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class GainMaxhpAction extends AbstractGameAction {
    public GainMaxhpAction(int amount) {
        this.amount = amount;
    }

    public void update() {
        AbstractDungeon.player.increaseMaxHp(amount, true);
        this.isDone = true;
    }
}