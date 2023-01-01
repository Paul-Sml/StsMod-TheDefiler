package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.actions.utility.DiscardToHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rewards.RewardItem;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
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
    private static boolean DUP = true;

    public Starfish() {
        super(ID, COST, GOLD_COST, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 9;
        exhaust = true;
        DUP = true;
    }

    public Starfish(boolean dup) {
        super(ID, COST, GOLD_COST, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 9;
        exhaust = true;
        DUP = dup;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m);
    }

    public void dug() {
        AbstractCard t = this;
        atb(new AbstractGameAction() {
            @Override
            public void update() {
                for (AbstractCard c : AbstractDungeon.player.drawPile.group) {
                    if (c.cardID.equals(Starfish.ID) && c != t) {
                        addToTop(new SpecificNonChosenDrawPileToHandAction(c));
                    }
                }
                for (AbstractCard c : AbstractDungeon.player.discardPile.group) {
                    if (c.cardID.equals(Starfish.ID) && c != t) {
                        addToTop(new SpecificNonChosenDiscardPileToHandAction(c));
                    }
                }
                this.isDone = true;
            }
        });
    }

    public void drafted() {
        if (DUP)
            AbstractDungeon.effectsQueue.add(new ShowCardAndObtainEffect(new Starfish(false), (float) Settings.WIDTH / 2.0F, (float)Settings.HEIGHT / 2.0F));
    }

    public void upp() {
        upgradeDamage(3);
    }
}
