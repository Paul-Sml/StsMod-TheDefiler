package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.BlankTombstoneAction;
import theDefiler.actions.DefilerDigAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class BlankTombstone extends AbstractDefilerCard {
    public final static String ID = makeID(BlankTombstone.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public BlankTombstone() {
        super(ID, COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 4;
        baseBlock = 6;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DefilerDigAction(magicNumber, c -> c.color == CardColor.COLORLESS));
        atb(new BlankTombstoneAction());
        block();
    }

    public void upp() {
        upgradeMagicNumber(2);
        upgradeBlock(2);
    }
}
