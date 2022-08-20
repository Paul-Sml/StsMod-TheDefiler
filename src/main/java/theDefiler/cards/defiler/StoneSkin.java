package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class StoneSkin extends AbstractDefilerCard {
    public final static String ID = makeID(StoneSkin.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 2;
    private static final int MAXHP_COST = 2;
    private static final int UPGRADED_MAXHP_COST = 1;

    public StoneSkin() {
        super(ID, COST, 0, MAXHP_COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 26;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        block();
    }

    public void upp() {
        upMhp(UPGRADED_MAXHP_COST);
    }
}
