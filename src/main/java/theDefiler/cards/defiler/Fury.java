package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.DefilerDigAction;
import theDefiler.actions.FuryGashAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class Fury extends AbstractDefilerCard {
    public final static String ID = makeID(Fury.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public Fury() {
        super(ID, COST, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        magicNumber = baseMagicNumber = 4; //Dig amount
        secondMagic = baseSecondMagic = 4; //dmg+ amount
        baseDamage = 9;;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DefilerDigAction(magicNumber, c -> c.cardID.equals(Fury.ID)));
        dmg(m);
        atb(new MakeTempCardInDiscardAction(this.makeStatEquivalentCopy(), false));
    }

    @Override
    public void dug() {
        atb(new FuryGashAction(this, secondMagic));
    }

    public void upp() {
        upgradeMagicNumber(2);
    }
}
