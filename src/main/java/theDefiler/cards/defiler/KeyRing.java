package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class KeyRing extends AbstractDefilerCard {
    public final static String ID = makeID(KeyRing.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;
    private static final int GOLD_COST = 15;
    private static final int UPGRADED_GOLD_COST = 5;

    public KeyRing() {
        super(ID, COST, GOLD_COST, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 13;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m);
        if (Settings.hasRubyKey)
            draw();
        if (Settings.hasEmeraldKey)
            draw();
        if (Settings.hasSapphireKey)
            draw();
    }

    public void upp() {
        upBgc(UPGRADED_GOLD_COST);
    }
}
