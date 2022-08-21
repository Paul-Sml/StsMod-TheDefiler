package theDefiler.potions;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.potions.AbstractPotion;
import com.megacrit.cardcrawl.relics.SacredBark;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;
import theDefiler.DefilerMod;

import static theDefiler.DefilerMod.characterColor;


public class LiquidGold extends AbstractPotion {

    public static final String POTION_ID = DefilerMod.makeID(LiquidGold.class.getSimpleName());
    private static final PotionStrings potionStrings = CardCrawlGame.languagePack.getPotionString(POTION_ID);

    public static final String NAME = potionStrings.NAME;
    public static final String[] DESCRIPTIONS = potionStrings.DESCRIPTIONS;

    public LiquidGold() {
        super(NAME, POTION_ID, PotionRarity.RARE, PotionSize.SPHERE, PotionColor.ELIXIR);
        this.labOutlineColor = characterColor;

        initializeData();

        isThrown = false;
        this.targetRequired = false;

        tips.add(new PowerTip(name, description));

    }

    public void initializeData() {
        potency = getPotency();

        if (potency == 1) {
            this.description = DESCRIPTIONS[0];
        } else {
            this.description = DESCRIPTIONS[1] + potency + DESCRIPTIONS[2];
        }
    }

    @Override
    public void use(AbstractCreature target) {
        AbstractPlayer p = AbstractDungeon.player;
        int hp = p.maxHealth;
        p.gainGold(potency * hp);
        /*for(int i = 0; i < this.potency * hp; ++i) {
            AbstractDungeon.effectList.add(new GainPennyEffect(this.source, this.target.hb.cX, this.target.hb.cY, this.source.hb.cX, this.source.hb.cY, true));
        }*/
    }

    @Override
    public AbstractPotion makeCopy() {
        return new LiquidGold();
    }

    public int getPotency(final int potency) {
        return 1;
    }
}