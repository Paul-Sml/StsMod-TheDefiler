package theDefiler.cards.defiler;

import basemod.helpers.TooltipInfo;
import com.evacipated.cardcrawl.mod.stslib.cards.interfaces.OnObtainCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ModHelper;
import com.megacrit.cardcrawl.helpers.input.InputHelper;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rewards.RewardItem;
import com.megacrit.cardcrawl.rooms.*;
import theDefiler.actions.DefilerDigAction;
import theDefiler.cards.AbstractDefilerCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static theDefiler.DefilerMod.makeID;

public class ClingClang extends AbstractDefilerCard implements OnObtainCard {
    public final static String ID = makeID(ClingClang.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 0;
    private static final int GOLD_COST = 5;

    public ClingClang() {
        super(ID, COST, GOLD_COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DefilerDigAction(magicNumber, c -> c.upgraded));
    }

    public void onObtainCard() {
        InputHelper.justClickedLeft = false;
        AbstractDungeon.combatRewardScreen.rewards = new ArrayList(AbstractDungeon.getCurrRoom().rewards);
        if ((AbstractDungeon.getCurrRoom().event == null || AbstractDungeon.getCurrRoom().event != null && !AbstractDungeon.getCurrRoom().event.noCardsInRewards) && !(AbstractDungeon.getCurrRoom() instanceof TreasureRoom) && !(AbstractDungeon.getCurrRoom() instanceof RestRoom)) {
            RewardItem cardReward;
            {
                cardReward = new RewardItem();
                if (cardReward.cards.size() > 0) {
                    AbstractDungeon.combatRewardScreen.rewards.add(cardReward);
                }

                if (AbstractDungeon.getCurrRoom() instanceof MonsterRoom && AbstractDungeon.player.hasRelic("Prayer Wheel") && !(AbstractDungeon.getCurrRoom() instanceof MonsterRoomElite) && !(AbstractDungeon.getCurrRoom() instanceof MonsterRoomBoss)) {
                    cardReward = new RewardItem();
                    if (cardReward.cards.size() > 0) {
                        AbstractDungeon.combatRewardScreen.rewards.add(cardReward);
                    }
                }
            }
        }
    }

    public void upp() {
        upgradeMagicNumber(2);
        uDesc();
    }

    public List<TooltipInfo> getCustomTooltips() {
        UIStrings strings = CardCrawlGame.languagePack.getUIString("thedefilermod:Dig");
        return Arrays.asList(new TooltipInfo(strings.TEXT[0], strings.TEXT[1] + magicNumber + strings.TEXT[2] + cardStrings.EXTENDED_DESCRIPTION[0] + strings.TEXT[3]
        ));
    }
}
