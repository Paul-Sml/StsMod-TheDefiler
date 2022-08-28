package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theDefiler.actions.UpgradeBaseCardsAction;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.powers.OneToOnePower;

import static theDefiler.DefilerMod.makeID;

public class OneToOne extends AbstractDefilerCard {
    public final static String ID = makeID(OneToOne.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;
    private static final int MAXHP_COST = 2;

    public OneToOne() {
        super(ID, COST,-1 , MAXHP_COST, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        power(new OneToOnePower(p));
    }

    public void upp() {
        upMhp(1);
    }
}
