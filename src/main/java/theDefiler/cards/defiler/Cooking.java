package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theDefiler.actions.EasyXCostAction;
import theDefiler.actions.GainMaxhpAction;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.cards.AbstractEasyCard;

import static theDefiler.DefilerMod.makeID;
import static theDefiler.util.Wiz.addtb;
import static theDefiler.util.Wiz.applyToSelfTop;

public class Cooking extends AbstractDefilerCard {
    public final static String ID = makeID("Cooking");
    // intellij stuff attack, enemy, rare, , , , , 0, 1

    public Cooking() {
        super(ID, -1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = 0;
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addtb(new EasyXCostAction(this, (effect, params) -> {
            addToTop(new GainMaxhpAction(effect));
            return true;
        }, magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(1);
        uDesc();
    }
}