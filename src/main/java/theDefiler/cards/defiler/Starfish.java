package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.actions.utility.DiscardToHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rewards.RewardItem;
import theDefiler.actions.DefilerDigAction;
import theDefiler.actions.SpecificNonChosenDiscardPileToHandAction;
import theDefiler.actions.SpecificNonChosenDrawPileToHandAction;
import theDefiler.cards.AbstractDefilerCard;

import java.util.Iterator;

import static theDefiler.DefilerMod.makeID;

public class Starfish extends AbstractDefilerCard {
    public final static String ID = makeID(Starfish.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 0;
    private static final int GOLD_COST = 5;

    public Starfish() {
        super(ID, COST, GOLD_COST, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 10;
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m);
    }

    public void dug() {
        atb(new AbstractGameAction() {
            @Override
            public void update() {
                for (AbstractCard c : AbstractDungeon.player.drawPile.group) {
                    if (c.cardID.equals(Starfish.ID)) {
                        atb(new SpecificNonChosenDrawPileToHandAction(c));
                    }
                }
                for (AbstractCard c : AbstractDungeon.player.discardPile.group) {
                    if (c.cardID.equals(Starfish.ID)) {
                        atb(new SpecificNonChosenDiscardPileToHandAction(c));
                    }
                }
                this.isDone = true;
            }
        });
    }

    public void drafted() {
        atb(new AddCardToDeckAction(this.makeCopy()));
    }

    public void upp() {
        upgradeDamage(2);
    }
}
