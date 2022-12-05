package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ThornsPower;
import theDefiler.actions.GainMaxhpAction;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.powers.BarbedWiresPower;

import static theDefiler.DefilerMod.makeID;
import static theDefiler.util.Wiz.applyToEnemy;
import static theDefiler.util.Wiz.applyToSelf;

public class BarbedWires extends AbstractDefilerCard {
    public final static String ID = makeID(BarbedWires.class.getSimpleName());

    private static final int COST = 2;

    public BarbedWires() {
        super(ID, COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ENEMY);
        magicNumber = baseMagicNumber = 8;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToEnemy(m, new ThornsPower(m, 2));
        applyToEnemy(m, new BarbedWiresPower(m, p, magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(2);
    }
}
