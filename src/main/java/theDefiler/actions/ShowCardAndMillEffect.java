package theDefiler.actions;

import basemod.BaseMod;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import theDefiler.cards.AbstractDefilerCard;

public class ShowCardAndMillEffect extends AbstractGameEffect {

    public static final float DURATION = Settings.ACTION_DUR_MED;

    private AbstractCard card;
    private CardGroup groupToGoTo;

    public ShowCardAndMillEffect(AbstractCard card, CardGroup groupToGoTo) {
        duration = startingDuration = DURATION;
        this.card = card;
        this.groupToGoTo = groupToGoTo;
        card.target_x = 100 + (int)(Math.random() * 200);
        card.target_y = 100 + (int)(Math.random() * 200);
        card.drawScale = 0.1f;
        card.targetDrawScale = 0.6f;
    }

    @Override
    public void update() {
        if (duration == startingDuration) {
            CardCrawlGame.sound.play("CARD_REJECT");
//            AbstractDungeon.player.drawPile.removeCard(card);
//            AbstractDungeon.player.discardPile.addToTop(card);
        }
        duration -= Gdx.graphics.getDeltaTime();
        card.update();
        if (duration < 0.0F) {
            isDone = true;

            if(groupToGoTo == AbstractDungeon.player.hand)
            {
                if(AbstractDungeon.player.hand.size() >= BaseMod.MAX_HAND_SIZE)
                {
                    groupToGoTo = AbstractDungeon.player.discardPile;
                    AbstractDungeon.player.discardPile.addToTop(card);
                }
                else
                {
                    AbstractDungeon.player.hand.addToTop(card);
                    AbstractDungeon.player.hand.refreshHandLayout();
                    AbstractDungeon.player.hand.applyPowers();
                    if (card instanceof AbstractDefilerCard) {
                        ((AbstractDefilerCard)card).dug();
                    }
                    PostRebound(card);
                }
            }
            if(groupToGoTo == AbstractDungeon.player.discardPile)
            {
                card.shrink();
                AbstractDungeon.getCurrRoom().souls.discard(card, true);
            }
        }
    }

    private void PostRebound(AbstractCard card)
    {

    }

    @Override
    public void render(SpriteBatch sb) {
        if (!isDone)
            card.render(sb);
    }

    @Override
    public void dispose() {

    }
}