package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.DefilerDigAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class EvilShadow extends AbstractDefilerCard {
    public final static String ID = makeID(EvilShadow.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public EvilShadow() {
        super(ID, COST, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        magicNumber = baseMagicNumber = 6;
        baseDamage = 7;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!upgraded)
            atb(new DefilerDigAction(magicNumber, c -> c.costForTurn == 2));
        else
            atb(new DefilerDigAction(magicNumber, c -> c.costForTurn >= 2));
        dmg(m);
    }

    public void upp() {
        upMagic(2);
        uDesc();
    }
}
