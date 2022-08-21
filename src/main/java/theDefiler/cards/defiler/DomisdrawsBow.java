package theDefiler.cards.defiler;

import com.evacipated.cardcrawl.mod.stslib.cards.interfaces.SpawnModificationCard;
import com.megacrit.cardcrawl.actions.common.RemoveAllBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;
import theDefiler.cards.AbstractDefilerCard;

import java.util.ArrayList;

import static theDefiler.DefilerMod.makeID;

public class DomisdrawsBow extends AbstractDefilerCard implements SpawnModificationCard {
    public final static String ID = makeID(DomisdrawsBow.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public DomisdrawsBow() {
        super(ID, COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 12;
        magicNumber = baseMagicNumber = 5;
        cardsToPreview = new BowsScorch();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dig(magicNumber, c -> c.rarity == CardRarity.RARE);
        block();
    }

    public void drafted() {
        AbstractDungeon.effectList.add(new ShowCardAndObtainEffect(cardsToPreview.makeCopy(), (float) Settings.WIDTH / 2.0F, (float)Settings.HEIGHT / 2.0F));
    }

    @Override
    public boolean canSpawn(ArrayList<AbstractCard> currentRewardCards) {
        return AbstractDungeon.actNum == 2;
    }

    public void upp() {
        upgradeBlock(3);
        upMagic(3);
    }
}
