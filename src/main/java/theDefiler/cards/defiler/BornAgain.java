package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.BornAgainAction;
import theDefiler.actions.EntombAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class BornAgain extends AbstractDefilerCard {
    public final static String ID = makeID(BornAgain.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public BornAgain() {
        super(ID, COST, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        this.exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new BornAgainAction());
    }

    public void upp() {
        selfRetain = true;
        uDesc();
    }
}
