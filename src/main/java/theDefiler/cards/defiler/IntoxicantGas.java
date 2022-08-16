package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.DefilerDigAction;
import theDefiler.actions.FuryGashAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class IntoxicantGas extends AbstractDefilerCard {
    public final static String ID = makeID(IntoxicantGas.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public IntoxicantGas() {
        super(ID, COST, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 8;;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m);
    }

    @Override
    public void dug() {
        applyPowers();
        allDmg(AbstractGameAction.AttackEffect.NONE);
    }

    public void upp() {
        upgradeDamage(3);
    }
}
