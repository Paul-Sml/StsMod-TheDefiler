package theDefiler.relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import theDefiler.TheDefiler;

import static theDefiler.DefilerMod.makeID;

public class IroncladsBlood extends AbstractEasyRelic {
    public static final String ID = makeID(IroncladsBlood.class.getSimpleName());

    public IroncladsBlood() {
        super(ID, RelicTier.RARE, LandingSound.MAGICAL, TheDefiler.Enums.DEFILER_COLOR);
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
