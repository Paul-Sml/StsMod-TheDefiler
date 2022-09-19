package theDefiler.powers;

import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.OnReceivePowerPower;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theDefiler.DefilerMod;

import static theDefiler.util.Wiz.adp;
import static theDefiler.util.Wiz.applyToSelf;

public class FastRunningShoesPower extends AbstractEasyPower implements OnReceivePowerPower {
    // intellij stuff Example, buff, false
    private static final String SIMPLE_NAME = FastRunningShoesPower.class.getSimpleName();
    public static final String POWER_ID = DefilerMod.makeID(SIMPLE_NAME);
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String LOC_NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    private static boolean upg = false;

    public FastRunningShoesPower(AbstractCreature owner, int amount, boolean upgraded) {
        super(SIMPLE_NAME, PowerType.BUFF, false, owner, amount);
        name = LOC_NAME;
        isTwoAmount = true;
        if (this.amount2 != 5 && upgraded)
            this.amount2 = 5;
        else
            this.amount2 = 4;

        if (upgraded)
            upg = true;

//        this.amount2 = amount;
        canGoNegative2 = true;
        updateDescription();
    }

    // THIS IS IMPORTANT!
    // You need to have this for it to stack the second amount properly
    @Override
    public boolean onReceivePower(AbstractPower pow, AbstractCreature target, AbstractCreature source) {
//        if (pow instanceof FastRunningShoesPower && target == owner)
//            amount += ((FastRunningShoesPower)pow).amount;

        if (this.amount2 != 5 && upg)
            this.amount2 = 5;

        return true;
    }

    public void atEndOfTurnPreEndTurnCards(boolean isPlayer) {
        if (AbstractDungeon.player.currentBlock <= amount2) {
            this.flash();
            this.addToBot(new GainBlockAction(this.owner, this.owner, this.amount));
        }
    }

    @Override
    public void updateDescription() {
        description = DESCRIPTIONS[0] + amount2 + DESCRIPTIONS[1] + amount + DESCRIPTIONS[2];
    }
}