package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.colorless.HandOfGreed;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class Temptation extends AbstractDefilerCard {
    public final static String ID = makeID(Temptation.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;
    private static final int GOLD_COST = 5;

    public Temptation() {
        super(ID, COST, GOLD_COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        cardsToPreview = new HandOfGreed();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (AbstractDungeon.player.currentBlock == 0) {
            AbstractCard card = cardsToPreview.makeCopy();
            card.freeToPlayOnce = true;

            this.addToBot(new MakeTempCardInDrawPileAction(card, 1, true, true));
        }
    }

    public void upp() {
        uDesc();
        cardsToPreview.upgrade();
    }
}
