package theDefiler.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import theDefiler.DefilerMod;
import theDefiler.actions.GainMaxhpAction;

public class BloodLettingPower extends AbstractEasyPower {

    public static final String POWER_ID = DefilerMod.makeID(BloodLettingPower.class.getSimpleName());
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public BloodLettingPower(AbstractCreature owner, int amount) {
        super(NAME, PowerType.BUFF, false, owner, amount);
    }

    @Override
    public int onLoseHp(int damageAmount) {
        if (AbstractDungeon.player.currentHealth > 0) {
            this.addToTop(new GainMaxhpAction(amount));
        }
        return super.onLoseHp(damageAmount);
    }

    public void updateDescription() {
        description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }
}
