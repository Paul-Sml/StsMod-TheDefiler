package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class ManaCoin extends AbstractDefilerCard {
    public final static String ID = makeID(ManaCoin.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 0;
    private static final int GOLD_COST = 5;
    private static final int UPGRADED_GOLD_COST = 10;

    public ManaCoin() {
        super(ID, COST, GOLD_COST, CardType.SKILL, CardRarity.RARE, CardTarget.ENEMY);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new GainEnergyAction(1));
        if (upgraded)
            atb(new GainEnergyAction(1));
    }

    public void upp() {
        upBgc(UPGRADED_GOLD_COST);
        uDesc();
    }
}
