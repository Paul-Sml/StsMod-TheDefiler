package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ReboundPower;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class Yoyo extends AbstractDefilerCard {
    public final static String ID = makeID(Yoyo.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 0;
    private static final int GOLD_COST = 5;

    public Yoyo() {
        super(ID, COST, GOLD_COST, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m);
        atb(new ApplyPowerAction(p, p, new ReboundPower(p), 1));
    }

    public void upp() {
        upgradeDamage(3);
    }
}
