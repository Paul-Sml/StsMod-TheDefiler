package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;
import theDefiler.actions.DefilerDigAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class CallForHelp extends AbstractDefilerCard {
    public final static String ID = makeID(CallForHelp.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public CallForHelp() {
        super(ID, COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 8;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        boolean thisTurn = false;
        for (AbstractMonster q : AbstractDungeon.getCurrRoom().monsters.monsters) {
            if (q.getIntentBaseDmg() >= 0) {
                thisTurn = true;
                break;
            }
        }
        if (thisTurn)
            block();
        else
            atb(new ApplyPowerAction(p, p, new NextTurnBlockPower(p, this.block), this.block));
    }

    public void upp() {
        upgradeBlock(3);
    }
}
