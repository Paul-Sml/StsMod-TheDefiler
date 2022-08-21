package theDefiler.powers;

import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import theDefiler.DefilerMod;

public class NoBlockDefilerPower extends AbstractEasyPower {

    public static final String POWER_ID = DefilerMod.makeID(NoBlockDefilerPower.class.getSimpleName());
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public NoBlockDefilerPower(AbstractCreature owner) {
        super(NAME, PowerType.DEBUFF, false, owner, -1);
        this.loadRegion("noBlock");
    }

    public void atEndOfRound() {
        this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));
    }

    public float modifyBlockLast(float blockAmount) {
        return 0.0F;
    }

    public void updateDescription() {
        description = DESCRIPTIONS[0];
    }
}
