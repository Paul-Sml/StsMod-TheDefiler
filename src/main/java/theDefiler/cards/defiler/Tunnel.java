package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.DefilerMod;
import theDefiler.actions.HuntingKnifeAction;
import theDefiler.actions.TunnelAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class Tunnel extends AbstractDefilerCard {
    public final static String ID = makeID(Tunnel.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 2;
    private static final int GOLD_COST = 10;
    private static final int UPGRADED_GOLD_COST = 5;

    public Tunnel() {
        super(ID, COST, GOLD_COST, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 15;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new TunnelAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn)));
    }

    public void drafted() {
        DefilerMod.canIgnorePath = true;
    }

    public void upp() {
        upgradeDamage(3);
        upBgc(UPGRADED_GOLD_COST);
    }
}
