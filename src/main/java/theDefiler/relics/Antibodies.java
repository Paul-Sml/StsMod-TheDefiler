package theDefiler.relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import theDefiler.TheDefiler;
import theDefiler.actions.GainMaxhpAction;

import static theDefiler.DefilerMod.makeID;

public class Antibodies extends AbstractEasyRelic {
    public static final String ID = makeID(Antibodies.class.getSimpleName());

    public Antibodies() {
        super(ID, RelicTier.SPECIAL, LandingSound.FLAT, TheDefiler.Enums.DEFILER_COLOR);
        setCounter(1);
    }

    public void onVictory() {
        this.flash();
        this.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
        AbstractPlayer p = AbstractDungeon.player;
        if (p.currentHealth > 0) {
            AbstractDungeon.player.increaseMaxHp(counter, true);
        }

    }

    @Override
    public void setCounter(int counter) {
        super.setCounter(counter);
        tips.clear();
        description = getUpdatedDescription();
        tips.add(new PowerTip(this.name, this.description));
        initializeTips();
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + counter + DESCRIPTIONS[1];
    }
}
