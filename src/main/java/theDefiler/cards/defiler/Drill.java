package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.DefilerDigAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class Drill extends AbstractDefilerCard {
    public final static String ID = makeID(Drill.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public Drill() {
        super(ID, COST, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        magicNumber = baseMagicNumber = 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DefilerDigAction(magicNumber, c -> c.type != CardType.STATUS));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}
