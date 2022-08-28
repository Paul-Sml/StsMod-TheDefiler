package theDefiler.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;

public class GainGoldDefilerAction extends AbstractGameAction {
    public GainGoldDefilerAction(int amount) {
        this.amount = amount;
        target = null;
    }
    public GainGoldDefilerAction(int amount, AbstractCreature target) {
        this.amount = amount;
        this.target = target;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        p.gainGold(this.amount);
        if (target==null) {
            for (int i = 0; i < this.amount; ++i) {
                AbstractDungeon.effectList.add(new GainPennyEffect(p, p.hb.cX, p.hb.cY, p.hb.cX, p.hb.cY, true));
            }
        } else {
            for (int i = 0; i < this.amount; ++i) {
                AbstractDungeon.effectList.add(new GainPennyEffect(target.hb.cX, target.hb.cY));
            }
        }
        this.isDone = true;
    }
}