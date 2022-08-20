package theDefiler.relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theDefiler.TheDefiler;

import static theDefiler.DefilerMod.makeID;

public class GoldenShovel extends AbstractEasyRelic {
    public static final String ID = makeID(GoldenShovel.class.getSimpleName());
    public final int GOLD_AMOUNT = 40;

    public GoldenShovel() {
        super(ID, RelicTier.STARTER, LandingSound.CLINK, TheDefiler.Enums.DEFILER_COLOR);
    }

    public void onVictory() {
        this.flash();
        AbstractPlayer p = AbstractDungeon.player;
        this.addToTop(new RelicAboveCreatureAction(p, this));
        p.gainGold(GOLD_AMOUNT);
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + GOLD_AMOUNT + DESCRIPTIONS[1];
    }
}
