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
    private static final String SIMPLE_NAME = "ExampleTwoAmount";
    public static final String POWER_ID = DefilerMod.makeID(SIMPLE_NAME);
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String LOC_NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public FastRunningShoesPower(AbstractCreature owner, int amount, boolean upgraded) {
        super(SIMPLE_NAME, PowerType.BUFF, false, owner, amount);
        name = LOC_NAME;
        isTwoAmount = true;
        if (this.amount != 5 && upgraded)
            this.amount = 5;
        else
            this.amount = 4;

        this.amount2 = amount;
        canGoNegative2 = true;
        updateDescription();
    }

    // THIS IS IMPORTANT!
    // You need to have this for it to stack the second amount properly
    @Override
    public boolean onReceivePower(AbstractPower pow, AbstractCreature target, AbstractCreature source) {
        if (pow instanceof FastRunningShoesPower && target == owner)
            amount2 += ((FastRunningShoesPower)pow).amount2;
        return true;
    }

    public void atEndOfTurnPreEndTurnCards(boolean isPlayer) {
        this.flash();
        if (AbstractDungeon.player.currentBlock <= amount)
            this.addToBot(new GainBlockAction(this.owner, this.owner, this.amount2));
    }

    @Override
    public void updateDescription() {
        description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1] + amount2 + DESCRIPTIONS[2];
    }
}