package theDefiler.cards.defiler;

import basemod.helpers.TooltipInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;
import theDefiler.actions.DefilerDigAction;
import theDefiler.actions.GainGoldDefilerAction;
import theDefiler.cards.AbstractDefilerCard;

import java.util.Arrays;
import java.util.List;

import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.rareCardPool;
import static theDefiler.DefilerMod.makeID;

public class GoldHoarding extends AbstractDefilerCard {
    public final static String ID = makeID(GoldHoarding.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public GoldHoarding() {
        super(ID, COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 6;
        secondMagic = baseSecondMagic = 35;
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DefilerDigAction(magicNumber, c -> c.rarity == CardRarity.RARE));
        atb(new GainGoldDefilerAction(secondMagic));
    }

    @Override
    public void onRemoveFromMasterDeck() {
        AbstractCard c = rareCardPool.getRandomCard(false).makeCopy();
        if (upgraded)
            c.upgrade();
        AbstractDungeon.effectsQueue.add(new ShowCardAndObtainEffect(c, (float) Settings.WIDTH / 1.5F, (float)Settings.HEIGHT / 2.0F));
    }

    public void upp() {
        upgradeMagicNumber(2);
        upSecondMagic(10);
        uDesc();
    }

    public List<TooltipInfo> getCustomTooltips() {
        UIStrings strings = CardCrawlGame.languagePack.getUIString("thedefilermod:Dig");
        return Arrays.asList(new TooltipInfo(strings.TEXT[0], strings.TEXT[1] + magicNumber + strings.TEXT[2] + cardStrings.EXTENDED_DESCRIPTION[0] + strings.TEXT[3]
        ));
    }
}
