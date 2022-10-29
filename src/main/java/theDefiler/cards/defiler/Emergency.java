package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.DefilerDigAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class Emergency extends AbstractDefilerCard {
    public final static String ID = makeID(Emergency.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public Emergency() {
        super(ID, COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 4;
        baseBlock = 9;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dig(magicNumber, c -> c.baseBlock > -1);
        block();
    }

    public void upp() {
        uDesc();
    }
}
