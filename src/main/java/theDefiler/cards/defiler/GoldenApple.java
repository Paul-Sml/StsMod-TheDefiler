package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.GainMaxhpAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class GoldenApple extends AbstractDefilerCard {
    public final static String ID = makeID(GoldenApple.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 2;
    private static final int GOLD_COST = 25;

    public GoldenApple() {
        super(ID, COST, GOLD_COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 16;
        magicNumber = baseMagicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        block();
        atb(new GainMaxhpAction(magicNumber));
    }

    public void upp() {
        upgradeBlock(7);
    }
}
