package theDefiler.powers;

import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.OnReceivePowerPower;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theDefiler.DefilerMod;

public class SouvenirShopPower extends AbstractEasyPower implements OnReceivePowerPower {
    // intellij stuff Example, buff, false
    private static final String SIMPLE_NAME = SouvenirShopPower.class.getSimpleName();
    public static final String POWER_ID = DefilerMod.makeID(SIMPLE_NAME);
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String LOC_NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public SouvenirShopPower(AbstractCreature owner, int drawAmount, int blockAmount) {
        super(SIMPLE_NAME, PowerType.BUFF, false, owner, blockAmount);
        name = LOC_NAME;
        isTwoAmount = true;

        amount = drawAmount;
        this.amount2 = blockAmount;
        canGoNegative2 = true;
        updateDescription();
    }

    // THIS IS IMPORTANT!
    // You need to have this for it to stack the second amount properly
    @Override
    public boolean onReceivePower(AbstractPower pow, AbstractCreature target, AbstractCreature source) {
        if (pow instanceof SouvenirShopPower && target == owner) {
            amount += pow.amount;
            amount2 += ((SouvenirShopPower) pow).amount2;
        }
        return true;
    }

    @Override
    public void onCardDraw(AbstractCard card) {
        if (card.color == AbstractCard.CardColor.COLORLESS && !this.owner.hasPower("No Draw")) {
            this.flash();
            this.addToBot(new DrawCardAction(this.owner, this.amount));
        }
    }

    @Override
    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.color == AbstractCard.CardColor.COLORLESS) {
            if (Settings.FAST_MODE) {
                this.addToBot(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, this.amount2, true));
            } else {
                this.addToBot(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, this.amount2));
            }

        this.flash();
        }
    }

    @Override
    public void updateDescription() {
        if (amount > 1)
            description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1] + DESCRIPTIONS[2] + amount2 + DESCRIPTIONS[3];
        else
            description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1] + amount2 + DESCRIPTIONS[3];
    }
}