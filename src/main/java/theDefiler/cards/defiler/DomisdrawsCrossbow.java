package theDefiler.cards.defiler;

import basemod.AutoAdd;
import basemod.patches.com.megacrit.cardcrawl.screens.compendium.CardLibraryScreen.NoCompendium;
import com.evacipated.cardcrawl.mod.stslib.cards.interfaces.SpawnModificationCard;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
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

public class DomisdrawsCrossbow extends AbstractDefilerCard implements SpawnModificationCard {
    public final static String ID = makeID(DomisdrawsCrossbow.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public DomisdrawsCrossbow() {
        super(ID, COST, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 19;
        baseBlock = 12;
        magicNumber = baseMagicNumber = 5;
        secondMagic = baseSecondDamage = 1;
        setLocked();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dig(magicNumber, c -> c.rarity == CardRarity.RARE);
        block();
        atb(new RemoveAllBlockAction(m, p));
        dmg(m);
        this.addToBot(new MakeTempCardInDiscardAction(this.makeStatEquivalentCopy(), secondMagic));
    }

    @Override
    public boolean canSpawn(ArrayList<AbstractCard> currentRewardCards) {
        return false;
    }

    public void upp() {
        upMagic(3);
        upgradeDamage(5);
        upgradeBlock(3);
        upSecondMagic(1);
    }
}
