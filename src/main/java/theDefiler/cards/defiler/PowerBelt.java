package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rewards.RewardItem;
import theDefiler.actions.DefilerDigAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class PowerBelt extends AbstractDefilerCard {
    public final static String ID = makeID(PowerBelt.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 0;
    private static final int MAXHP_COST = 1;

    public PowerBelt() {
        super(ID, COST, 0, MAXHP_COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 5;
        isInnate = true;
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DefilerDigAction(magicNumber, c -> c.type == CardType.POWER));
    }

    public void upp() {
        upgradeMagicNumber(3);
    }
}
