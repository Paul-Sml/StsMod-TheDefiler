package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.powers.DivineStormPower;
import theDefiler.powers.PinataPower;

import static theDefiler.DefilerMod.makeID;

public class DivineStorm extends AbstractDefilerCard {
    public final static String ID = makeID(DivineStorm.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 0;
    private static final int MAXHP_COST = 1;

    public DivineStorm() {
        super(ID, COST, -1, MAXHP_COST, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        power(new DivineStormPower(p, magicNumber), magicNumber);
    }

    public void upp() {
        upMagic(2);
    }
}
