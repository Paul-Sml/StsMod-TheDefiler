package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.DefilerDigAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class Meditation extends AbstractDefilerCard {
    public final static String ID = makeID(Meditation.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 2;

    public Meditation() {
        super(ID, COST, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        baseBlock = 12;
        revival = baseRevival = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        block();
        revival();
    }

    public void upp() {
        upgradeRevival(1);
        upgradeBlock(2);
    }
}
