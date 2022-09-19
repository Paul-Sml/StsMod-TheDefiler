package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class ScorchingHand extends AbstractDefilerCard {
    public final static String ID = makeID(ScorchingHand.class.getSimpleName());

    private static final int COST = 1;
    private static final int MAXHP_COST = 1;

    public ScorchingHand() {
        super(ID, COST, -1, MAXHP_COST, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ENEMY, CardColor.COLORLESS);
        baseDamage = 23;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m);
    }

    public void upp() {
        upgradeDamage(6);
    }
}
