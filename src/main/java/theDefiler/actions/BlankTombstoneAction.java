package theDefiler.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;
import java.util.Iterator;

public class BlankTombstoneAction extends AbstractGameAction {

    public BlankTombstoneAction() {
        this.setValues(AbstractDungeon.player, AbstractDungeon.player);
        this.actionType = ActionType.EXHAUST;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        System.out.println(p.hand.size());

        ArrayList<AbstractCard> cardsToExhaust = new ArrayList();
        Iterator var2 = AbstractDungeon.player.hand.group.iterator();

        AbstractCard c;
        while(var2.hasNext()) {
            c = (AbstractCard)var2.next();
            if (c.type == AbstractCard.CardType.STATUS) {
                cardsToExhaust.add(c);
            }
        }

        System.out.println("-");
        System.out.println(cardsToExhaust.size());
        System.out.println("-");

        var2 = cardsToExhaust.iterator();

        while(var2.hasNext()) {
            c = (AbstractCard)var2.next();
            this.addToTop(new ExhaustSpecificCardAction(c, AbstractDungeon.player.hand));
        }

        System.out.println(p.hand.size());

        this.isDone = true;
    }
}
