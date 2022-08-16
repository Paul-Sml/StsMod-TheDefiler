package theDefiler.cards.cardvars;

import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.cards.AbstractCard;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class Revival extends DynamicVariable {

    @Override
    public String key() {
        return makeID("R");
    }

    @Override
    public boolean isModified(AbstractCard abstractCard) {
        if (abstractCard instanceof AbstractDefilerCard) {
            return ((AbstractDefilerCard) abstractCard).revival != ((AbstractDefilerCard) abstractCard).baseRevival;
        }
        return false;
    }

    @Override
    public int value(AbstractCard abstractCard) {
        if (abstractCard instanceof AbstractDefilerCard) {
            return ((AbstractDefilerCard) abstractCard).revival;
        }
        return -1;
    }

    @Override
    public int baseValue(AbstractCard abstractCard) {
        if (abstractCard instanceof AbstractDefilerCard) {
            return ((AbstractDefilerCard) abstractCard).baseRevival;
        }
        return -1;
    }

    @Override
    public boolean upgraded(AbstractCard abstractCard) {
        if (abstractCard instanceof AbstractDefilerCard) {
            return ((AbstractDefilerCard) abstractCard).upgradedRevival;
        }
        return false;
    }

}
