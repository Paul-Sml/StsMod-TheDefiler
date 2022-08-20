package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.DefilerDigAction;
import theDefiler.actions.FuryGashAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class TakeMyMoney extends AbstractDefilerCard {
    public final static String ID = makeID(TakeMyMoney.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public TakeMyMoney() {
        super(ID, COST, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        magicNumber = baseMagicNumber = 4; //Dig amount
        baseDamage = 9;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DefilerDigAction(magicNumber, c -> c instanceof AbstractDefilerCard && ((AbstractDefilerCard)c).goldCost > 1));
        dmg(m);
    }

    public void upp() {
        upgradeMagicNumber(2);
        upgradeDamage(2);
    }
}
