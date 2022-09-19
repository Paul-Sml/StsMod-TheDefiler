package theDefiler.cards.defiler;

import basemod.AutoAdd;
import com.evacipated.cardcrawl.mod.stslib.cards.interfaces.SpawnModificationCard;
import com.megacrit.cardcrawl.blights.AbstractBlight;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.powers.DomisdrawsCrossPower;
import theDefiler.powers.GoldSkinPower;

import java.util.ArrayList;
import java.util.Iterator;

import static theDefiler.DefilerMod.makeID;

@AutoAdd.Ignore
public class GoldSkin extends AbstractDefilerCard implements SpawnModificationCard {
    public final static String ID = makeID(GoldSkin.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 3;
    private static final int UPGRADED_COST = 2;

    public GoldSkin() {
        super(ID, COST, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        power(new GoldSkinPower(p, magicNumber), magicNumber);
    }

    public void applyPowers() {

        if (EnergyPanel.totalCount > this.costForTurn) {

        }
        if (EnergyPanel.totalCount < this.costForTurn) {
            this.goldCostForTurn = (this.costForTurn - EnergyPanel.totalCount) * 25;
            this.costForTurn = EnergyPanel.totalCount;
        }
    }

    public void upp() {
        upgradeBaseCost(UPGRADED_COST);
    }

    /*@Override
    public boolean hasEnoughEnergy() {
        if (AbstractDungeon.actionManager.turnHasEnded) {
            this.cantUseMessage = TEXT[9];
            return false;
        } else {
            Iterator var1 = AbstractDungeon.player.powers.iterator();

            AbstractPower p;
            do {
                if (!var1.hasNext()) {
                    if (AbstractDungeon.player.hasPower("Entangled") && this.type == AbstractCard.CardType.ATTACK) {
                        this.cantUseMessage = TEXT[10];
                        return false;
                    }

                    var1 = AbstractDungeon.player.relics.iterator();

                    AbstractRelic r;
                    do {
                        if (!var1.hasNext()) {
                            var1 = AbstractDungeon.player.blights.iterator();

                            AbstractBlight b;
                            do {
                                if (!var1.hasNext()) {
                                    var1 = AbstractDungeon.player.hand.group.iterator();

                                    AbstractCard c;
                                    do {
                                        if (!var1.hasNext()) {
                                            if (EnergyPanel.totalCount + (AbstractDungeon.player.gold / 25.0F) < this.costForTurn && !this.freeToPlay() && !this.isInAutoplay) {
                                                this.cantUseMessage = TEXT[11];
                                                return false;
                                            }
                                            if (this.goldCostForTurn > 0 && AbstractDungeon.player.gold < this.goldCostForTurn && !this.freeToPlay() && !this.isInAutoplay) {
                                                this.cantUseMessage = "Not enough golds NL TODO : REMOVE HARCODE";
                                                return false;
                                            }
                                            if (this.maxhpCostForTurn > 0 && AbstractDungeon.player.maxHealth < this.maxhpCostForTurn && !this.freeToPlay() && !this.isInAutoplay) {
                                                this.cantUseMessage = "Not enough Max HP NL TODO : REMOVE HARCODE";
                                                return false;
                                            }

                                            return true;
                                        }

                                        c = (AbstractCard)var1.next();
                                    } while(c.canPlay(this));

                                    return false;
                                }

                                b = (AbstractBlight)var1.next();
                            } while(b.canPlay(this));

                            return false;
                        }

                        r = (AbstractRelic)var1.next();
                    } while(r.canPlay(this));

                    return false;
                }

                p = (AbstractPower)var1.next();
            } while(p.canPlayCard(this));

            this.cantUseMessage = TEXT[13];
            return false;
        }
    }*/

}
