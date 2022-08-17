package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.powers.BloodLettingPower;
import theDefiler.powers.OneToOnePower;

import static theDefiler.DefilerMod.makeID;

public class BloodLetting extends AbstractDefilerCard {
    public final static String ID = makeID(BloodLetting.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 0;
    private static final int GOLD_COST = 30;
    private static final int UPGRADED_GOLD_COST = 10;

    public BloodLetting() {
        super(ID, COST, GOLD_COST, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        power(new BloodLettingPower(p, 1), 1);
    }

    public void upp() {
        upBgc(UPGRADED_GOLD_COST);
    }
}
