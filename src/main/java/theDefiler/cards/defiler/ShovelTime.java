package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class ShovelTime extends AbstractDefilerCard {
    public final static String ID = makeID(ShovelTime.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public ShovelTime() {
        super(ID, COST, CardType.ATTACK, CardRarity.BASIC, CardTarget.ENEMY);
        baseDamage = 7;
        baseBlock = 3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        block();
        dmg(m);
    }

    public void upp() {
        upgradeDamage(2);
        upgradeBlock(1);
    }
}
