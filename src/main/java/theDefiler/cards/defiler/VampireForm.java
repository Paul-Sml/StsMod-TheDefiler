package theDefiler.cards.defiler;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.UpgradeBaseCardsAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

@AutoAdd.Ignore
public class VampireForm extends AbstractDefilerCard {
    public final static String ID = makeID(VampireForm.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 3;

    public VampireForm() {
        super(ID, COST, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new UpgradeBaseCardsAction());
    }

    public void upp() {
        isInnate = true;
        uDesc();
    }
}
