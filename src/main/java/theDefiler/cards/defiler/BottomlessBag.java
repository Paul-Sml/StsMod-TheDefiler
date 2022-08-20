package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.GainGoldDefilerAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class BottomlessBag extends AbstractDefilerCard {
    public final static String ID = makeID(BottomlessBag.class.getSimpleName());

    private static final int COST = 0;

    public BottomlessBag() {
        super(ID, COST, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 20;
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new GainGoldDefilerAction(magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(10);
    }
}
