package theDefiler.actions;

import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import theDefiler.DefilerMod;

import java.util.ArrayList;
import java.util.Iterator;

public class ZombieHandAction extends AbstractGameAction {
    private AbstractPlayer p;
    private static final UIStrings uiStrings;
    public static final String[] TEXT;
    private AbstractPlayer player;
    private int numberOfCards;
    private boolean check = false;
    private String cardToGet;


    public ZombieHandAction(int digAmount) {
        this.p = AbstractDungeon.player;
        this.duration = Settings.ACTION_DUR_FAST;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.player = AbstractDungeon.player;
        numberOfCards = digAmount;
    }

    public void update() {

        if (!check) {
            System.out.println("entrée dans la boucle");
            if (!this.player.drawPile.isEmpty()) {
                AbstractCard c;
                Iterator var6;
                if (this.player.drawPile.size() == 1) {

                    cardToGet = player.drawPile.getTopCard().cardID;

                    dig(cardToGet);

                    this.isDone = true;
                } else {
                    CardGroup temp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
                    var6 = this.player.drawPile.group.iterator();

                    while(var6.hasNext()) {
                        c = (AbstractCard)var6.next();
                        temp.addToTop(c);
                    }

                    temp.sortAlphabetically(true);
                    temp.sortByRarityPlusStatusCardType(false);
                    AbstractDungeon.gridSelectScreen.open(temp, 1, TEXT[0], false);

                    check = true;

                    this.tickDuration();
                }
            } else {
                this.isDone = true;
            }
        } else {
            System.out.println("entrée dans le else");
            if (!AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {
                System.out.println("entrée dans l'action finale'");

                cardToGet = AbstractDungeon.gridSelectScreen.selectedCards.get(0).cardID;

                AbstractDungeon.gridSelectScreen.selectedCards.clear();
                AbstractDungeon.player.hand.refreshHandLayout();

                dig(cardToGet);
            }

            this.tickDuration();
        }
    }

    private void dig(String id) {
        addToTop(new DefilerDigAction(numberOfCards, c -> c.cardID.equals(id)));
    }

    static {
        uiStrings = CardCrawlGame.languagePack.getUIString(DefilerMod.makeID(ZombieHandAction.class.getSimpleName()));
        TEXT = uiStrings.TEXT;
    }
}
