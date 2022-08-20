package theDefiler.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;
import com.megacrit.cardcrawl.vfx.combat.FlyingOrbEffect;

import java.util.Iterator;

public class DNAExtractionAction extends AbstractGameAction {
    public int[] damage;

    public DNAExtractionAction(AbstractCreature source, int[] amount, DamageInfo.DamageType type, AttackEffect effect) {
        this.setValues((AbstractCreature)null, source, amount[0]);
        this.damage = amount;
        this.actionType = ActionType.DAMAGE;
        this.damageType = type;
        this.attackEffect = effect;
        this.duration = Settings.ACTION_DUR_FAST;
    }

    public void update() {
        int paintAmount = 0;

        this.source.damage(new DamageInfo(this.source, 1, DamageInfo.DamageType.THORNS));
        if (this.source.lastDamageTaken > 0)
            paintAmount++;

        Iterator var5 = AbstractDungeon.player.powers.iterator();

        while(var5.hasNext()) {
            AbstractPower p = (AbstractPower)var5.next();
            p.onDamageAllEnemies(this.damage);
        }

        int i;

        for(i = 0; i < AbstractDungeon.getCurrRoom().monsters.monsters.size(); ++i) {
            AbstractMonster target = (AbstractMonster)AbstractDungeon.getCurrRoom().monsters.monsters.get(i);
            if (!target.isDying && target.currentHealth > 0 && !target.isEscaping) {
                target.damage(new DamageInfo(this.source, this.damage[i], this.damageType));
                if (target.lastDamageTaken > 0) {
                    paintAmount ++;

                    for(int j = 0; j < target.lastDamageTaken / 2 && j < 10; ++j) {
                        this.addToBot(new VFXAction(new FlyingOrbEffect(target.hb.cX, target.hb.cY)));
                    }
                }
            }
        }
        if (paintAmount > 0){
            AbstractDungeon.player.gainGold(paintAmount * 5);
            for(int j = 0; j < paintAmount * 5; ++j) {
                AbstractDungeon.effectList.add(new GainPennyEffect(this.source, this.target.hb.cX, this.target.hb.cY, this.source.hb.cX, this.source.hb.cY, true));
            }
        }



        this.tickDuration();
        this.isDone = true;
    }
}
