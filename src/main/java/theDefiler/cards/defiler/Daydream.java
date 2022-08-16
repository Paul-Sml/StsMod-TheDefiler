package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.unique.NightmareAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class Daydream extends AbstractDefilerCard {
    public final static String ID = makeID(Daydream.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public Daydream() {
        super(ID, COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new NightmareAction(p, p, magicNumber));
    }

    public void dug() {
        freeToPlayOnce = true;
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}
