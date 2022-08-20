package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class DevilsPact extends AbstractDefilerCard {
    public final static String ID = makeID(DevilsPact.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = -2;

    public DevilsPact() {
        super(ID, COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 125;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {}

    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        this.cantUseMessage = cardStrings.EXTENDED_DESCRIPTION[0];
        return false;
    }

    @Override
    public void triggerWhenDrawn() {
        AbstractDungeon.player.loseGold(1);
    }

    @Override
    public void drafted() {
        AbstractDungeon.player.gainGold(magicNumber);
    }

    @Override
    public boolean canUpgrade() {
        if (AbstractDungeon.player.masterDeck.contains(this))
            return false;
        return true;
    }

    public void upp() {
        upMagic(25);
    }
}
