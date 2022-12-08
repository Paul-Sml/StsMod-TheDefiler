package theDefiler.cards.defiler;

import basemod.helpers.TooltipInfo;
import com.evacipated.cardcrawl.mod.stslib.cards.interfaces.SpawnModificationCard;
import com.megacrit.cardcrawl.actions.common.RemoveAllBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;
import theDefiler.cards.AbstractDefilerCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static theDefiler.DefilerMod.makeID;
import static theDefiler.TheDefiler.Enums.DEFILER_COLOR;

public class DomisdrawsBow extends AbstractDefilerCard implements SpawnModificationCard {
    public final static String ID = makeID(DomisdrawsBow.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public DomisdrawsBow() {
        super(ID, COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 13;
        magicNumber = baseMagicNumber = 5;
        cardsToPreview = new BowsScorch();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dig(magicNumber, c -> c.color != DEFILER_COLOR);
        block();
    }

    public void drafted() {
        AbstractDungeon.effectsQueue.add(new ShowCardAndObtainEffect(cardsToPreview.makeCopy(), (float) Settings.WIDTH / 2.0F, (float)Settings.HEIGHT / 2.0F));
    }

    @Override
    public boolean canSpawn(ArrayList<AbstractCard> currentRewardCards) {
        return AbstractDungeon.actNum == 2;
    }

    public void upp() {
        upgradeBlock(3);
        upMagic(3);
    }

    public List<TooltipInfo> getCustomTooltips() {
        UIStrings strings = CardCrawlGame.languagePack.getUIString("thedefilermod:Dig");
        return Arrays.asList(new TooltipInfo(strings.TEXT[0], strings.TEXT[1] + magicNumber + strings.TEXT[2] + cardStrings.EXTENDED_DESCRIPTION[0] + strings.TEXT[3]
        ));
    }
}
