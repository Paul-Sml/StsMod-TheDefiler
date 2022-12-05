package theDefiler.cards.defiler;

import basemod.helpers.TooltipInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rewards.RewardItem;
import theDefiler.actions.DefilerDigAction;
import theDefiler.cards.AbstractDefilerCard;

import java.util.Arrays;
import java.util.List;

import static theDefiler.DefilerMod.makeID;

public class PowerBelt extends AbstractDefilerCard {
    public final static String ID = makeID(PowerBelt.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 0;
    private static final int MAXHP_COST = 1;

    public PowerBelt() {
        super(ID, COST, -1, MAXHP_COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 5;
        isInnate = true;
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DefilerDigAction(magicNumber, c -> c.type == CardType.POWER));
    }

    public void upp() {
        upgradeMagicNumber(3);
    }

    public List<TooltipInfo> getCustomTooltips() {
        UIStrings strings = CardCrawlGame.languagePack.getUIString("thedefilermod:Dig");
        return Arrays.asList(new TooltipInfo(strings.TEXT[0], strings.TEXT[1] + magicNumber + strings.TEXT[2] + cardStrings.EXTENDED_DESCRIPTION[0] + strings.TEXT[3]
        ));
    }
}
