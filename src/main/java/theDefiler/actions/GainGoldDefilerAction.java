package theDefiler.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;

public class GainGoldDefilerAction extends AbstractGameAction {
    public GainGoldDefilerAction(int amount) {
        this.amount = amount;
    }

    public void update() {
        AbstractDungeon.player.gainGold(this.amount);
        for(int i = 0; i < this.amount; ++i) {
            AbstractDungeon.effectList.add(new GainPennyEffect(this.source, this.target.hb.cX, this.target.hb.cY, this.source.hb.cX, this.source.hb.cY, true));
        }
        this.isDone = true;
    }
}