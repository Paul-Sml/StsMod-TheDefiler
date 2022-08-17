package theDefiler.relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theDefiler.TheDefiler;
import theDefiler.actions.GainMaxhpAction;

import static theDefiler.DefilerMod.makeID;

public class Antibodies extends AbstractEasyRelic {
    public static final String ID = makeID("Antibodies");

    public Antibodies() {
        super(ID, RelicTier.SPECIAL, LandingSound.FLAT, TheDefiler.Enums.DEFILER_COLOR);
        this.counter = 1;
    }

    public void onVictory() {
        this.flash();
        this.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
        AbstractPlayer p = AbstractDungeon.player;
        if (p.currentHealth > 0) {
            addToTop(new GainMaxhpAction(this.counter));
        }

    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + counter + DESCRIPTIONS[1];
    }

}
