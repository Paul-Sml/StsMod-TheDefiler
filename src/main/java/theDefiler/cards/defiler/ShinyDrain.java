package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.ShinyDrainAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class ShinyDrain extends AbstractDefilerCard {
    public final static String ID = makeID(ShinyDrain.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 2;

    public ShinyDrain() {
        super(ID, COST, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 14;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new ShinyDrainAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn)));
    }

    public void upp() {
        upgradeDamage(4);
    }
}
