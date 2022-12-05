package theDefiler.cards.defiler;

import basemod.helpers.TooltipInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.DefilerDigAction;
import theDefiler.actions.ZombieHandAction;
import theDefiler.cards.AbstractDefilerCard;

import java.util.Arrays;
import java.util.List;

import static theDefiler.DefilerMod.makeID;

public class ZombieHand extends AbstractDefilerCard {
    public final static String ID = makeID(ZombieHand.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 0;

    public ZombieHand() {
        super(ID, COST, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        magicNumber = baseMagicNumber = 5;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new ZombieHandAction(magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(5);
    }

    public List<TooltipInfo> getCustomTooltips() {
        UIStrings strings = CardCrawlGame.languagePack.getUIString("thedefilermod:Dig");
        return Arrays.asList(new TooltipInfo(strings.TEXT[0], strings.TEXT[1] + magicNumber + strings.TEXT[2] + cardStrings.EXTENDED_DESCRIPTION[0] + strings.TEXT[3]
        ));
    }
}
