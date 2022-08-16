package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class Worms extends AbstractDefilerCard {
    public final static String ID = makeID(Worms.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 0;

    public Worms() {
        super(ID, COST, CardType.ATTACK, CardRarity.BASIC, CardTarget.ENEMY);
        baseDamage = 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m);
    }

    public void upp() {
        upgradeDamage(2);
    }
}
