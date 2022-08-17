package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.DefilerDigAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class Parry extends AbstractDefilerCard {
    public final static String ID = makeID(Parry.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public Parry() {
        super(ID, COST, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 3;
        baseBlock = 7;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DefilerDigAction(magicNumber, c -> c.type == CardType.ATTACK));
        block();
    }

    public void upp() {
        upgradeMagicNumber(1);
        upgradeBlock(2);
    }
}
