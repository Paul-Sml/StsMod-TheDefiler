package theDefiler.cards.defiler;

import com.evacipated.cardcrawl.mod.stslib.cards.interfaces.SpawnModificationCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.powers.DomisdrawsCrossPower;

import java.util.ArrayList;

import static theDefiler.DefilerMod.makeID;

public class DomisdrawsCross extends AbstractDefilerCard implements SpawnModificationCard {
    public final static String ID = makeID(DomisdrawsCross.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public DomisdrawsCross() {
        super(ID, COST, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
        cardsToPreview = new CrossDisease();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        power(new DomisdrawsCrossPower(p, magicNumber), magicNumber);
    }

    public void drafted() {
        AbstractDungeon.effectsQueue.add(new ShowCardAndObtainEffect(cardsToPreview.makeCopy(), (float) Settings.WIDTH / 2.0F, (float)Settings.HEIGHT / 2.0F));
    }

    @Override
    public boolean canSpawn(ArrayList<AbstractCard> currentRewardCards) {
        return AbstractDungeon.actNum == 3;
    }

    public void upp() {
        upMagic(1);
        uDesc();
    }
}
