package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.powers.PinataPower;

import static theDefiler.DefilerMod.makeID;

public class Pinata extends AbstractDefilerCard {
    public final static String ID = makeID(Pinata.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public Pinata() {
        super(ID, COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 13;
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        block();
        power(new PinataPower(p, 1), 1);
    }

    public void upp() {
        upgradeBlock(4);
    }
}
