package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.GainMaxhpAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class BloodBag extends AbstractDefilerCard {
    public final static String ID = makeID(BloodBag.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;
    private static final int GOLD_COST = 20;

    public BloodBag() {
        super(ID, COST, GOLD_COST, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new GainMaxhpAction(magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}
