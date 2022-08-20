package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.DefilerDigAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class TombDigging extends AbstractDefilerCard {
    public final static String ID = makeID(TombDigging.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public TombDigging() {
        super(ID, COST, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF, CardColor.COLORLESS);
        magicNumber = baseMagicNumber = 3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DefilerDigAction(magicNumber, c -> c.rarity != CardRarity.BASIC));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}
