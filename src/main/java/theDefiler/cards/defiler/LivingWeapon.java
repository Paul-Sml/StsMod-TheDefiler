package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class LivingWeapon extends AbstractDefilerCard {
    public final static String ID = makeID(LivingWeapon.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;
    private static final int MAXHP_COST = 1;
    private static final int GOLD_COST = 25;

    public LivingWeapon() {
        super(ID, COST, GOLD_COST, MAXHP_COST, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 25;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m);
    }

    public void upp() {
        upgradeDamage(10);
    }
}
