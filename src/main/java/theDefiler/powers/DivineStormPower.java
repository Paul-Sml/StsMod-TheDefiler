package theDefiler.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.vfx.combat.LightningEffect;
import theDefiler.DefilerMod;

public class DivineStormPower extends AbstractEasyPower {

    public static final String POWER_ID = DefilerMod.makeID(DivineStormPower.class.getSimpleName());
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public DivineStormPower(AbstractCreature owner, int amount) {
        super(NAME, PowerType.BUFF, false, owner, amount);
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        AbstractCreature m = AbstractDungeon.getRandomMonster();
        if (m != null) {
            flash();
            float speedTime = 0.2F;
            if (Settings.FAST_MODE) {
                speedTime = 0.0F;
            }
            this.addToTop(new DamageAction(m, new DamageInfo(m, amount, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.NONE, true));
            this.addToTop(new VFXAction(new LightningEffect(m.drawX, m.drawY), speedTime));
        }
    }

    public void updateDescription() {
        description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }
}
