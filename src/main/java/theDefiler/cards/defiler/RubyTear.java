package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class RubyTear extends AbstractDefilerCard {
    public final static String ID = makeID(RubyTear.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;
    private static final int GOLD_COST = 20;

    public RubyTear() {
        super(ID, COST, GOLD_COST, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 6;
        revival = baseRevival = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new GainEnergyAction(1));
        dmg(m);
        revival();
        if (revival == 0 || secondRevival == 0) {
            atb(new AbstractGameAction() {
                @Override
                public void update() {
                    updateCost(-cost);
                    updateGoldCost(-goldCost);
                    isDone = true;
                }
            });

        }
    }

    public void upp() {
        secondRevival = baseSecondRevival = 1;
        uDesc();
    }
}
