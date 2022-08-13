package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class CoinToss extends AbstractDefilerCard {
    public final static String ID = makeID(CoinToss.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 0;
    private static final int GOLD_COST = 15;
    private static final int UPGRADED_GOLD_COST = 10;

    public CoinToss() {
        super(ID, COST, GOLD_COST, CardType.ATTACK, CardRarity.BASIC, CardTarget.ENEMY);
        baseDamage = 8;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m);
    }

    public void upp() {
        upgradeDamage(2);
        upBgc(UPGRADED_GOLD_COST);
    }
}
