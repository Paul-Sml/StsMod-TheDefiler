package theDefiler.cards;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.blights.AbstractBlight;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import theDefiler.actions.DefilerDigAction;
import theDefiler.actions.GainMaxhpAction;

import java.util.Iterator;
import java.util.function.Predicate;

import static theDefiler.util.Wiz.addtb;

public abstract class AbstractDefilerCard extends AbstractEasyCard {

    public int goldCost;
    public int goldCostForTurn;
    public boolean isGoldCostModified;
    public boolean isGoldCostModifiedForTurn;
    public boolean upgradedGoldCost;

    public int maxhpCost;
    public int maxhpCostForTurn;
    public boolean isMaxhpCostModified;
    public boolean isMaxhpCostModifiedForTurn;
    public boolean upgradedMaxhpCost;

    public int revival = -1;
    public int baseRevival = -1;
    public boolean upgradedRevival;
    public int secondRevival = -1;
    public int baseSecondRevival = -1;
    public boolean upgradedSecondRevival;

    public AbstractDefilerCard(String cardID, int cost, CardType type, CardRarity rarity, CardTarget target) {
        this(cardID, cost, -1, -1, type, rarity, target);
    }

    public AbstractDefilerCard(String cardID, int cost, CardType type, CardRarity rarity, CardTarget target, CardColor color) {
        super(cardID, cost, type, rarity, target, color);
    }

    public AbstractDefilerCard(String cardID, int cost, int goldCost, CardType type, CardRarity rarity, CardTarget target) {
        this(cardID, cost, goldCost, -1, type, rarity, target);
    }

    public AbstractDefilerCard(String cardID, int cost, int goldCost, int maxhpCost, CardType type, CardRarity rarity, CardTarget target) {
        super(cardID, cost, type, rarity, target);
        this.isGoldCostModified = false;
        this.isGoldCostModifiedForTurn = false;
        this.upgradedGoldCost = false;
        this.goldCost = goldCost;
        this.goldCostForTurn = goldCost;

        this.isMaxhpCostModified = false;
        this.isMaxhpCostModifiedForTurn = false;
        this.upgradedMaxhpCost = false;
        this.maxhpCost = maxhpCost;
        this.maxhpCostForTurn = maxhpCost;
    }

    public AbstractDefilerCard(String cardID, int cost, int goldCost, int maxhpCost, CardType type, CardRarity rarity, CardTarget target, CardColor color) {
        super(cardID, cost, type, rarity, target, color);
        this.isGoldCostModified = false;
        this.isGoldCostModifiedForTurn = false;
        this.upgradedGoldCost = false;
        this.goldCost = goldCost;
        this.goldCostForTurn = goldCost;

        this.isMaxhpCostModified = false;
        this.isMaxhpCostModifiedForTurn = false;
        this.upgradedMaxhpCost = false;
        this.maxhpCost = maxhpCost;
        this.maxhpCostForTurn = maxhpCost;
    }

    @Override
    public void displayUpgrades() {
        super.displayUpgrades();

        if (this.upgradedGoldCost) {
            this.isGoldCostModified = true;
        }
        if (this.upgradedMaxhpCost) {
            this.isMaxhpCostModified = true;
        }
        /*if (this.upgradedRevival) {

        }*/
    }

    protected void atb(AbstractGameAction action) {
        addtb(action);
    }

    protected void power(AbstractPower powerToApply) {
        atb(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, powerToApply));
    }
    protected void power(AbstractPower powerToApply, AbstractCreature target) {
        atb(new ApplyPowerAction(target, AbstractDungeon.player, powerToApply));
    }
    protected void power(AbstractPower powerToApply, int amount) {
        atb(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, powerToApply, amount));
    }
    protected void power(AbstractPower powerToApply, AbstractCreature target, int amount) {
        atb(new ApplyPowerAction(target, AbstractDungeon.player, powerToApply, amount));
    }

    protected void dmg(AbstractMonster monster) {
        dmg(monster, AbstractGameAction.AttackEffect.NONE);
    }

    protected void draw() {
        atb(new DrawCardAction(1));
    }

    protected void draw(int drawAmount) {
        atb(new DrawCardAction(drawAmount));
    }

    protected void dig(int numCards, Predicate<AbstractCard> digCondition) {
        atb(new DefilerDigAction(numCards, digCondition));
    }

    @Override
    public void upp() {}

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

    }

    protected void revival() {
        if (revival > 0) {
            revival--;
            atb(new GainMaxhpAction(1));
        }
        if (secondRevival > 0) {
            secondRevival--;
            atb(new GainMaxhpAction(1));
        }
    }

    protected void upgradeRevival(int amount) {
        baseRevival += amount;
        revival = baseRevival;
        upgradedRevival = true;
    }
    protected void upgradeSecondRevival(int amount) {
        baseSecondRevival += amount;
        secondRevival = baseSecondRevival;
        upgradedSecondRevival = true;
    }

    protected void upgradeBaseGoldCost(int newBaseGoldCost) {
        int diff = this.goldCostForTurn - this.goldCost;
        this.goldCost = newBaseGoldCost;
        if (this.goldCostForTurn > 0) {
            this.goldCostForTurn = this.goldCost + diff;
        }

        if (this.goldCostForTurn < 0) {
            this.goldCostForTurn = 0;
        }

        this.upgradedGoldCost = true;
    }

    protected void upgradeBaseMaxhpCost(int newBaseMaxhpCost) {
        int diff = this.maxhpCostForTurn - this.maxhpCost;
        this.maxhpCost = newBaseMaxhpCost;
        if (this.maxhpCostForTurn > 0) {
            this.maxhpCostForTurn = this.maxhpCost + diff;
        }

        if (this.maxhpCostForTurn < 0) {
            this.maxhpCostForTurn = 0;
        }

        this.upgradedMaxhpCost = true;
    }

    protected void upBgc (int newBaseGoldCost) {
        upgradeBaseGoldCost(newBaseGoldCost);
    }

    protected void upMhp (int newBaseMaxhpCost) {
        upgradeBaseMaxhpCost(newBaseMaxhpCost);
    }

    public void updateGoldCost(int amt) {
        int tmpCost = this.goldCost;
        int diff = this.goldCost - this.goldCostForTurn;
        tmpCost += amt;
        if (tmpCost < 0) {
            tmpCost = 0;
        }

        if (tmpCost != this.goldCost) {
            this.isGoldCostModified = true;
            this.goldCost = tmpCost;
            this.goldCostForTurn = this.goldCost - diff;
            if (this.goldCostForTurn < 0) {
                this.goldCostForTurn = 0;
            }
        }
    }

    public void updateMaxhpCost(int amt) {
        int tmpCost = this.maxhpCost;
        int diff = this.maxhpCost - this.maxhpCostForTurn;
        tmpCost += amt;
        if (tmpCost < 0) {
            tmpCost = 0;
        }

        if (tmpCost != this.maxhpCost) {
            this.isMaxhpCostModified = true;
            this.maxhpCost = tmpCost;
            this.maxhpCostForTurn = this.maxhpCost - diff;
            if (this.maxhpCostForTurn < 0) {
                this.maxhpCostForTurn = 0;
            }
        }
    }

    @Override
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
                                            if (EnergyPanel.totalCount < this.costForTurn && !this.freeToPlay() && !this.isInAutoplay) {
                                                this.cantUseMessage = TEXT[11];
                                                return false;
                                            }
                                            if (this.goldCostForTurn > 0 && AbstractDungeon.player.gold < this.goldCostForTurn) {
                                                this.cantUseMessage = "Not enough golds NL TODO : REMOVE HARCODE";
                                                return false;
                                            }
                                            if (this.maxhpCostForTurn > 0 && AbstractDungeon.player.maxHealth < this.maxhpCostForTurn) {
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
    }

    /*private void renderGoldCost(SpriteBatch sb) {
        if (this.cost > -2 && !this.isLocked && this.isSeen) {

            Color costColor = Color.WHITE.cpy();

            costColor.a = this.transparency;
            String text = this.getGoldCost();
            BitmapFont font = this.getEnergyFont();
            if ((this.type != AbstractCard.CardType.STATUS || this.cardID.equals("Slimed")) && (this.color != AbstractCard.CardColor.CURSE || this.cardID.equals("Pride"))) {
                FontHelper.renderRotatedText(sb, font, text, this.current_x, this.current_y, -132.0F * this.drawScale * Settings.scale, 288.0F * this.drawScale * Settings.scale, this.angle, false, costColor);
            }
        }
    }

    private String getGoldCost() {
        return this.freeToPlay() ? "0" : Integer.toString(this.goldCostForTurn);
    }

    private String getMaxhpCost() {
        return this.freeToPlay() ? "0" : Integer.toString(this.maxhpCostForTurn);
    }*/

    private BitmapFont getEnergyFont() {
        FontHelper.cardEnergyFont_L.getData().setScale(this.drawScale);
        return FontHelper.cardEnergyFont_L;
    }

    public void setGoldCostForTurn(int amt) {
        if (this.goldCostForTurn >= 0) {
            this.goldCostForTurn = amt;
            if (this.goldCostForTurn < 0) {
                this.goldCostForTurn = 0;
            }

            if (this.goldCostForTurn != this.goldCost) {
                this.isGoldCostModifiedForTurn = true;
            }
        }
    }
    public void setMaxhpCostForTurn(int amt) {
        if (this.maxhpCostForTurn >= 0) {
            this.maxhpCostForTurn = amt;
            if (this.maxhpCostForTurn < 0) {
                this.maxhpCostForTurn = 0;
            }

            if (this.maxhpCostForTurn != this.maxhpCost) {
                this.isMaxhpCostModifiedForTurn = true;
            }
        }
    }

    @Override
    public AbstractCard makeStatEquivalentCopy() {
        AbstractCard card = super.makeStatEquivalentCopy();

        AbstractDefilerCard c = (AbstractDefilerCard)card;

        c.goldCost = this.goldCost;
        c.goldCostForTurn = this.goldCostForTurn;
        c.isGoldCostModified = this.isGoldCostModified;
        c.isGoldCostModifiedForTurn = this.isGoldCostModifiedForTurn;

        c.maxhpCost = this.maxhpCost;
        c.maxhpCostForTurn = this.maxhpCostForTurn;
        c.isMaxhpCostModified = this.isMaxhpCostModified;
        c.isMaxhpCostModifiedForTurn = this.isMaxhpCostModifiedForTurn;

        c.revival = this.revival;
        c.secondRevival = this.secondRevival;

        return c;
    }

    @Override
    public void resetAttributes() {
        super.resetAttributes();
        this.goldCostForTurn = this.goldCost;
        this.isGoldCostModifiedForTurn = false;
        this.maxhpCostForTurn = this.maxhpCost;
        this.isMaxhpCostModifiedForTurn = false;
        revival = baseRevival;
        secondRevival = baseSecondRevival;
    }

    public void dug() {}

    public void drafted() {}

}

