package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.powers.OneToOnePower;
import theDefiler.powers.SouvenirShopPower;

import static theDefiler.DefilerMod.makeID;

public class SouvenirShop extends AbstractDefilerCard {
    public final static String ID = makeID(SouvenirShop.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;
    private static final int GOLD_COST = 10;

    public SouvenirShop() {
        super(ID, COST, GOLD_COST, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
        secondMagic = baseSecondMagic = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        power(new SouvenirShopPower(p, magicNumber, secondMagic));
    }

    public void upp() {
        upgradeMagicNumber(1);
        upgradeSecondMagic(1);
        uDesc();
    }
}
