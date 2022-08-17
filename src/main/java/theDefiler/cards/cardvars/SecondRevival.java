package theDefiler.cards.cardvars;

import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.cards.AbstractCard;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class SecondRevival extends DynamicVariable {

    @Override
    public String key() {
        return makeID("r2");
    }

    @Override
    public boolean isModified(AbstractCard abstractCard) {
        if (abstractCard instanceof AbstractDefilerCard) {
            return ((AbstractDefilerCard) abstractCard).secondRevival != ((AbstractDefilerCard) abstractCard).baseSecondRevival;
        }
        return false;
    }

    @Override
    public int value(AbstractCard abstractCard) {
        if (abstractCard instanceof AbstractDefilerCard) {
            return ((AbstractDefilerCard) abstractCard).secondRevival;
        }
        return -1;
    }

    @Override
    public int baseValue(AbstractCard abstractCard) {
        if (abstractCard instanceof AbstractDefilerCard) {
            return ((AbstractDefilerCard) abstractCard).baseSecondRevival;
        }
        return -1;
    }

    @Override
    public boolean upgraded(AbstractCard abstractCard) {
        if (abstractCard instanceof AbstractDefilerCard) {
            return ((AbstractDefilerCard) abstractCard).upgradedSecondRevival;
        }
        return false;
    }

}
