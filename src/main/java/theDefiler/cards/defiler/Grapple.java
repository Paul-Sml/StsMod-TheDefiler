package theDefiler.cards.defiler;

import basemod.helpers.TooltipInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.DefilerDigAction;
import theDefiler.cards.AbstractDefilerCard;

import java.util.Arrays;
import java.util.List;

import static theDefiler.DefilerMod.makeID;

public class Grapple extends AbstractDefilerCard {
    public final static String ID = makeID(Grapple.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;
    private static final int MAXHP_COST = 1;

    public Grapple() {
        super(ID, COST, -1, MAXHP_COST, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 11;
        magicNumber = baseMagicNumber = 5;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DefilerDigAction(magicNumber, c -> c.costForTurn == 0 || c.freeToPlayOnce));
        dmg(m);
    }

    public void upp() {
        upgradeDamage(2);
        upgradeMagicNumber(2);
    }

    public List<TooltipInfo> getCustomTooltips() {
        UIStrings strings = CardCrawlGame.languagePack.getUIString("thedefilermod:Dig");
        return Arrays.asList(new TooltipInfo(strings.TEXT[0], strings.TEXT[1] + magicNumber + strings.TEXT[2] + cardStrings.EXTENDED_DESCRIPTION[0] + strings.TEXT[3]
        ));
    }
}
