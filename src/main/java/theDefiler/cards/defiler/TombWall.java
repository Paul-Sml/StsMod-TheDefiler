package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.DefilerDigAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class TombWall extends AbstractDefilerCard {
    public final static String ID = makeID(TombWall.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 2;

    public TombWall() {
        super(ID, COST, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        magicNumber = baseMagicNumber = 2;
        baseBlock = 14;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DefilerDigAction(magicNumber, c -> c.costForTurn == 1));
        block();
    }

    public void upp() {
        upgradeMagicNumber(1);
        upgradeBlock(3);
    }
}
