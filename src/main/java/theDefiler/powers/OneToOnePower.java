package theDefiler.powers;

import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import theDefiler.DefilerMod;

public class OneToOnePower extends AbstractEasyPower {

    public static final String POWER_ID = DefilerMod.makeID(OneToOnePower.class.getSimpleName());
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public OneToOnePower(AbstractCreature owner) {
        super(NAME, PowerType.BUFF, false, owner, -1);
    }

    @Override
    public float atDamageFinalReceive(float damage, DamageInfo.DamageType type) {
        if (type == DamageInfo.DamageType.THORNS)
            return 0;
        return super.atDamageFinalReceive(damage, type);
    }

    public void updateDescription() {
        description = DESCRIPTIONS[0];
    }
}
