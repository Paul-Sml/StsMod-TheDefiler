package theDefiler.cards.defiler;

import com.evacipated.cardcrawl.mod.stslib.cards.interfaces.SpawnModificationCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Burn;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.random.Random;
import theDefiler.cards.AbstractDefilerCard;

import java.util.ArrayList;

import static theDefiler.DefilerMod.makeID;

public class CrossDisease extends AbstractDefilerCard implements SpawnModificationCard {
    public final static String ID = makeID(CrossDisease.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = -2;

    public CrossDisease() {
        super(ID, COST, CardType.CURSE, CardRarity.CURSE, CardTarget.NONE);
        //cardsToPreview = new DomisdrawsCross();
    }

    @Override
    public void onRemoveFromMasterDeck() {
        AbstractPlayer p = AbstractDungeon.player;
        for(AbstractCard c : p.masterDeck.group) {
            p.masterDeck.removeCard(DomisdrawsCross.ID);
            break;
        }
    }

    public void use(AbstractPlayer p, AbstractMonster m) {}

    public static <T> T getRandomItem(ArrayList<T> list, Random rng) {
        return list.isEmpty() ? null : list.get(rng.random(list.size() - 1));
    }

    @Override
    public boolean canSpawn(ArrayList<AbstractCard> currentRewardCards) {
        return false;
    }

    public void triggerWhenDrawn() {
        AbstractCard cota = this;

        if (this.timesUpgraded == 0)
            addToBot(new AbstractGameAction() {
                @Override
                public void update() {
                    ArrayList<AbstractCard> cardsToExhaust = new ArrayList();

                    for (AbstractCard c : AbstractDungeon.player.hand.group) {
                        if (c != cota) {
                            cardsToExhaust.add(c);
                        }
                    }

                    if (!cardsToExhaust.isEmpty())
                        this.addToTop(new ExhaustSpecificCardAction(getRandomItem(cardsToExhaust, AbstractDungeon.cardRandomRng), AbstractDungeon.player.hand));

                    this.isDone = true;
                }
            });
    }

    public void upp() {}
}
