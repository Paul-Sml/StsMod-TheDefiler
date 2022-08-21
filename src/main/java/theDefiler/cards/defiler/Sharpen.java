package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.powers.DivineStormPower;
import theDefiler.powers.SharpenPower;

import static theDefiler.DefilerMod.makeID;

public class Sharpen extends AbstractDefilerCard {
    public final static String ID = makeID(Sharpen.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public Sharpen() {
        super(ID, COST, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        power(new SharpenPower(p, magicNumber), magicNumber);
    }

    public void upp() {
        upMagic(1);
    }
}
