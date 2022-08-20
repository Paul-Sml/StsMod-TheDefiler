package theDefiler.powers;

import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.OnLoseBlockPower;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import theDefiler.DefilerMod;
import theDefiler.actions.GainGoldDefilerAction;

public class PinataPower extends AbstractEasyPower implements OnLoseBlockPower {

    public static final String POWER_ID = DefilerMod.makeID(PinataPower.class.getSimpleName());
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public PinataPower(AbstractCreature owner, int amount) {
        super(NAME, PowerType.BUFF, false, owner, amount);
    }

    @Override
    public int onLoseBlock(DamageInfo info, int damageAmount) {
        flash();
        int z = this.owner.currentBlock;
        if (damageAmount <= z)
            this.addToTop(new GainGoldDefilerAction(damageAmount * amount));
        else
            this.addToTop(new GainGoldDefilerAction(z * amount));
        return damageAmount;
    }

    @Override
    public void atStartOfTurn() {
        this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));
    }

    public void updateDescription() {
        if (amount <= 1)
            description = DESCRIPTIONS[0];
        else {
            description = DESCRIPTIONS[1] + amount + DESCRIPTIONS[2];
        }
    }
}
