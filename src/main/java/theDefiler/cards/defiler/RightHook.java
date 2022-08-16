package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class RightHook extends AbstractDefilerCard {
    public final static String ID = makeID(RightHook.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;
    private static final int MAXHP_COST = 1;

    public RightHook() {
        super(ID, COST, 0, MAXHP_COST, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 14;
        cardToPreview.add(new LeftHook());
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m);
    }

    @Override
    public void dug() {
        atb(new MakeTempCardInHandAction(cardsToPreview));
    }

    public void upp() {
        upgradeDamage(4);
    }
}
