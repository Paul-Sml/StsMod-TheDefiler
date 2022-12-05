package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ThornsPower;
import theDefiler.actions.GainMaxhpAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;
import static theDefiler.util.Wiz.*;

public class Brambles extends AbstractDefilerCard {
    public final static String ID = makeID(Brambles.class.getSimpleName());

    private static final int COST = 1;

    public Brambles() {
        super(ID, COST, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new GainMaxhpAction(magicNumber));
        applyToSelf(new ThornsPower(p, 3));
        for (AbstractMonster q : AbstractDungeon.getMonsters().monsters) {
            applyToEnemy(q, new ThornsPower(q, 3));
        }
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}
