package theDefiler.cards.defiler;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.localization.LocalizedStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.vfx.cardManip.PurgeCardEffect;
import theDefiler.DefilerMod;
import theDefiler.cards.AbstractDefilerCard;

import java.util.Iterator;

import static com.megacrit.cardcrawl.events.AbstractEvent.logMetricCardRemoval;
import static theDefiler.DefilerMod.makeID;

public class Quicksands extends AbstractDefilerCard {
    public final static String ID = makeID(Quicksands.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public Quicksands() {
        super(ID, COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 7;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        block();
    }

    @Override
    public void onRemoveFromMasterDeck() {
        DefilerMod.choosingRemoveCard = true;
        if (AbstractDungeon.isScreenUp) {
            AbstractDungeon.dynamicBanner.hide();
            AbstractDungeon.overlayMenu.cancelButton.hide();
            AbstractDungeon.previousScreen = AbstractDungeon.screen;
        }

        AbstractDungeon.getCurrRoom().phase = AbstractRoom.RoomPhase.INCOMPLETE;
        CardGroup tmp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);

        for (AbstractCard card : AbstractDungeon.player.masterDeck.getPurgeableCards().group) {
            tmp.addToTop(card);
        }

        if (tmp.group.isEmpty()) {
            DefilerMod.choosingRemoveCard = false;
        } else {
            AbstractDungeon.gridSelectScreen.open(AbstractDungeon.player.masterDeck.getPurgeableCards(), 1, "TEXT[1]", false, false, false, true);
        }
    }


    public void upp() {
        upgradeBlock(4);
    }
}
