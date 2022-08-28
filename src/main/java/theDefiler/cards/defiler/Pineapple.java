package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class Pineapple extends AbstractDefilerCard {
    public final static String ID = makeID(Pineapple.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;
    private static final int MAXHP_COST = 1;

    public Pineapple() {
        super(ID, COST, -1, MAXHP_COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 13;
        revival = baseRevival = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        block();
    }

    public void dug() {
        revival();
    }

    public void upp() {
        upgradeRevival(1);
    }
}
