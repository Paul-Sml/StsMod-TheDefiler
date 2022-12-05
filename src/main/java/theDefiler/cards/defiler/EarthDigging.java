package theDefiler.cards.defiler;

import basemod.BaseMod;
import basemod.helpers.TooltipInfo;
import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;
import theDefiler.actions.DefilerDigAction;
import theDefiler.cards.AbstractDefilerCard;

import java.util.Arrays;
import java.util.List;

import static theDefiler.DefilerMod.makeID;

public class EarthDigging extends AbstractDefilerCard {
    public final static String ID = makeID(EarthDigging.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public EarthDigging() {
        super(ID, COST, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        magicNumber = baseMagicNumber = 3;
        cardsToPreview = new TombDigging();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DefilerDigAction(magicNumber, c -> c.rarity == CardRarity.BASIC));
    }

    @Override
    public void onRemoveFromMasterDeck() {
        AbstractDungeon.effectList.add(new ShowCardAndObtainEffect(cardsToPreview.makeStatEquivalentCopy(), (float) Settings.WIDTH / 2.0F, (float)Settings.HEIGHT / 2.0F));
    }

    public void upp() {
        upgradeMagicNumber(1);
        cardsToPreview.upgrade();
        uDesc();
    }

    public List<TooltipInfo> getCustomTooltips() {
        UIStrings strings = CardCrawlGame.languagePack.getUIString("thedefilermod:Dig");
        return Arrays.asList(new TooltipInfo(strings.TEXT[0], strings.TEXT[1] + magicNumber + strings.TEXT[2] + cardStrings.EXTENDED_DESCRIPTION[0] + strings.TEXT[3]
        ));
    }
}
