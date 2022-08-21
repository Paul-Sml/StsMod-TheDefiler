package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.colorless.Apparition;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BlurPower;
import theDefiler.actions.EntombAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class Ghosts extends AbstractDefilerCard {
    public final static String ID = makeID(Ghosts.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 0;
    private static final int MAXHP_COST = 0;

    public Ghosts() {
        super(ID, COST, 0, MAXHP_COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
        baseBlock = 8;
        cardsToPreview = new Apparition();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        block();
        power(new BlurPower(p, magicNumber), magicNumber);
        atb(new AbstractGameAction() {
            @Override
            public void update() {
                AbstractCard card = p.drawPile.getTopCard();
                p.drawPile.moveToExhaustPile(card);
            }
        });
    }

    public void dug() {
        AbstractCard c = this;
        atb(new AbstractGameAction() {
            @Override
            public void update() {
                AbstractDungeon.player.hand.moveToExhaustPile(c);
            }
        });
        atb(new MakeTempCardInHandAction(cardsToPreview.makeCopy()));
    }

    public void upp() {
        upgradeBlock(3);
    }
}
