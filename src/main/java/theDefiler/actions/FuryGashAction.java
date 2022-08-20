package theDefiler.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.GetAllInBattleInstances;
import theDefiler.cards.defiler.Fury;

import java.util.ArrayList;
import java.util.Iterator;

public class FuryGashAction extends AbstractGameAction {
    private AbstractCard card;

    public FuryGashAction(AbstractCard card, int amount) {
        this.card = card;
        this.amount = amount;
    }

    public void update() {
        AbstractCard var10000 = this.card;
        var10000.baseDamage += this.amount;
        this.card.applyPowers();
        ArrayList<AbstractCard> cardsToBuff = new ArrayList<AbstractCard>();
        Iterator var1 = AbstractDungeon.player.discardPile.group.iterator();

        AbstractCard c;
        while (var1.hasNext()) {
            c = (AbstractCard) var1.next();
            if (c.cardID.equals(Fury.ID)) {
                if (!cardsToBuff.contains(c))
                    cardsToBuff.add(c);
            }
        }

        var1 = AbstractDungeon.player.drawPile.group.iterator();

        while (var1.hasNext()) {
            c = (AbstractCard) var1.next();
            if (c.cardID.equals(Fury.ID)) {
                if (!cardsToBuff.contains(c))
                    cardsToBuff.add(c);
            }
        }

        var1 = AbstractDungeon.player.hand.group.iterator();

        while (var1.hasNext()) {
            c = (AbstractCard) var1.next();
            if (c.cardID.equals(Fury.ID)) {
                if (!cardsToBuff.contains(c))
                    cardsToBuff.add(c);
            }
        }

        for (AbstractCard abstractCard : cardsToBuff) {
            abstractCard.baseDamage += this.amount;
            abstractCard.applyPowers();
        }

        this.isDone = true;
    }
}
