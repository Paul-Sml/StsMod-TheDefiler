package theDefiler.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.GetAllInBattleInstances;
import com.megacrit.cardcrawl.localization.UIStrings;
import theDefiler.DefilerMod;
import theDefiler.DomisdrawCampfireOption;
import theDefiler.cards.AbstractDefilerCard;

import java.util.Iterator;

public class BornAgainAction extends AbstractGameAction {
    private AbstractPlayer p;
    private boolean chooseAny;

    public BornAgainAction() {
        this.p = AbstractDungeon.player;
        this.duration = Settings.ACTION_DUR_FAST;
        this.actionType = ActionType.CARD_MANIPULATION;
    }

    public void update() {
            AbstractPlayer p = AbstractDungeon.player;

            for (AbstractCard c : p.drawPile.group) {
                if (c instanceof AbstractDefilerCard) {
                    ((AbstractDefilerCard) c).revival = ((AbstractDefilerCard) c).baseRevival;
                    ((AbstractDefilerCard) c).secondRevival = ((AbstractDefilerCard) c).baseSecondRevival;
                }
            }
            for (AbstractCard c : p.discardPile.group) {
                if (c instanceof AbstractDefilerCard) {
                    ((AbstractDefilerCard) c).revival = ((AbstractDefilerCard) c).baseRevival;
                    ((AbstractDefilerCard) c).secondRevival = ((AbstractDefilerCard) c).baseSecondRevival;
                }
            }
            for (AbstractCard c : p.exhaustPile.group) {
                if (c instanceof AbstractDefilerCard) {
                    ((AbstractDefilerCard) c).revival = ((AbstractDefilerCard) c).baseRevival;
                    ((AbstractDefilerCard) c).secondRevival = ((AbstractDefilerCard) c).baseSecondRevival;
                }
            }
            for (AbstractCard c : p.hand.group) {
                if (c instanceof AbstractDefilerCard) {
                    ((AbstractDefilerCard) c).revival = ((AbstractDefilerCard) c).baseRevival;
                    ((AbstractDefilerCard) c).secondRevival = ((AbstractDefilerCard) c).baseSecondRevival;
                }
            }
            this.isDone = true;
            this.tickDuration();
    }
}
