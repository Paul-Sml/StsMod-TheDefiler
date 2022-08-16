package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.DefilerDigAction;
import theDefiler.actions.EntombAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class Entomb extends AbstractDefilerCard {
    public final static String ID = makeID(Entomb.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public Entomb() {
        super(ID, COST, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
        baseBlock = 8;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        block();
        atb(new EntombAction(false));
    }

    public void upp() {
        upgradeBlock(3);
    }
}
