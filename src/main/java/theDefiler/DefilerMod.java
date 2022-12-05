package theDefiler;

import basemod.AutoAdd;
import basemod.BaseMod;
import basemod.helpers.RelicType;
import basemod.interfaces.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.evacipated.cardcrawl.mod.stslib.Keyword;
import com.evacipated.cardcrawl.mod.stslib.patches.CenterGridCardSelectScreen;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.*;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import com.megacrit.cardcrawl.vfx.cardManip.PurgeCardEffect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.JsonUtils;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.cards.AbstractEasyCard;
import theDefiler.cards.cardvars.*;
import theDefiler.potions.LiquidGold;
import theDefiler.relics.AbstractEasyRelic;
import theDefiler.util.TexLoader;

import java.nio.charset.StandardCharsets;

@SuppressWarnings({"unused", "WeakerAccess"})
@SpireInitializer
public class DefilerMod implements
        EditCardsSubscriber,
        EditRelicsSubscriber,
        EditStringsSubscriber,
        EditKeywordsSubscriber,
        EditCharactersSubscriber,
        PostUpdateSubscriber
        {

    public static final String modID = "thedefilermod";

    public static String makeID(String idText) {
        return modID + ":" + idText;
    }


    public static boolean canIgnorePath = false;
    public static boolean choosingRemoveCard = false;



    // This makes debugging so much easier
    public static Logger logger = LogManager.getLogger(DefilerMod.class.getName());

    public static Color characterColor = new Color(MathUtils.random(), MathUtils.random(), MathUtils.random(), 1); // This should be changed eventually

    public static final String SHOULDER1 = modID + "Resources/images/char/mainChar/shoulder.png";
    public static final String SHOULDER2 = modID + "Resources/images/char/mainChar/shoulder2.png";
    public static final String CORPSE = modID + "Resources/images/char/mainChar/corpse.png";
    private static final String ATTACK_S_ART = modID + "Resources/images/512/attack.png";
    private static final String SKILL_S_ART = modID + "Resources/images/512/skill.png";
    private static final String POWER_S_ART = modID + "Resources/images/512/power.png";
    private static final String CARD_ENERGY_S = modID + "Resources/images/512/energy.png";
    private static final String TEXT_ENERGY = modID + "Resources/images/512/text_energy.png";
    private static final String ATTACK_L_ART = modID + "Resources/images/1024/attack.png";
    private static final String SKILL_L_ART = modID + "Resources/images/1024/skill.png";
    private static final String POWER_L_ART = modID + "Resources/images/1024/power.png";
    private static final String CARD_ENERGY_L = modID + "Resources/images/1024/energy.png";
    private static final String CHARSELECT_BUTTON = modID + "Resources/images/charSelect/charButton.png";
    private static final String CHARSELECT_PORTRAIT = modID + "Resources/images/charSelect/charBG.png";
//    public static Texture burnButton;
    //public static Texture burnButton = ImageMaster.loadImage("thedefilermodResources/images/ui/DomisdrawCampfireOption.png");;

    public DefilerMod() {
        BaseMod.subscribe(this);

        BaseMod.addColor(TheDefiler.Enums.DEFILER_COLOR, characterColor, characterColor, characterColor,
                characterColor, characterColor, characterColor, characterColor,
                ATTACK_S_ART, SKILL_S_ART, POWER_S_ART, CARD_ENERGY_S,
                ATTACK_L_ART, SKILL_L_ART, POWER_L_ART,
                CARD_ENERGY_L, TEXT_ENERGY);
    }

    public static String makePath(String resourcePath) {
        return modID + "Resources/" + resourcePath;
    }

    public static String makeImagePath(String resourcePath) {
        return modID + "Resources/images/" + resourcePath;
    }

    public static String makeRelicPath(String resourcePath) {
        return modID + "Resources/images/relics/" + resourcePath;
    }

    public static String makePowerPath(String resourcePath) {
        return modID + "Resources/images/powers/" + resourcePath;
    }

    public static String makeCardPath(String resourcePath) {
        return modID + "Resources/images/cards/" + resourcePath;
    }

    public static void initialize() {
        DefilerMod thismod = new DefilerMod();
        System.out.println(makeImagePath("ui/DomisdrawCampfireOption.png"));
        System.out.println("thedefilermodResources/images/ui/DomisdrawCampfireOption.png");
//        burnButton = TexLoader.getTexture(makeImagePath("ui/DomisdrawCampfireOption.png"));
    }

    @Override
    public void receiveEditCharacters() {
        BaseMod.addCharacter(new TheDefiler(TheDefiler.characterStrings.NAMES[1], TheDefiler.Enums.THE_DEFILER),
                CHARSELECT_BUTTON, CHARSELECT_PORTRAIT, TheDefiler.Enums.THE_DEFILER);
        receiveEditPotions();
    }

    public void receiveEditPotions() {
        BaseMod.addPotion(LiquidGold.class, Color.GOLD.cpy(), Color.YELLOW.cpy(), null, LiquidGold.POTION_ID, TheDefiler.Enums.THE_DEFILER);
    }

    @Override
    public void receiveEditRelics() {
        new AutoAdd(modID)
                .packageFilter(AbstractEasyRelic.class)
                .any(AbstractEasyRelic.class, (info, relic) -> {
                    if (relic.color == null) {
                        BaseMod.addRelic(relic, RelicType.SHARED);
                    } else {
                        BaseMod.addRelicToCustomPool(relic, relic.color);
                    }
                    if (!info.seen) {
                        UnlockTracker.markRelicAsSeen(relic.relicId);
                    }
                });
    }

    @Override
    public void receiveEditCards() {
        BaseMod.addDynamicVariable(new SecondMagicNumber());
        BaseMod.addDynamicVariable(new SecondDamage());
        BaseMod.addDynamicVariable(new Revival());
        BaseMod.addDynamicVariable(new SecondRevival());
        BaseMod.addDynamicVariable(new GoldCost());
        new AutoAdd(modID)
                .packageFilter(AbstractEasyCard.class)
                .packageFilter(AbstractDefilerCard.class)
                .setDefaultSeen(true)
                .cards();
    }


    @Override
    public void receiveEditStrings() {
        BaseMod.loadCustomStringsFile(CharacterStrings.class, modID + "Resources/localization/eng/Charstrings.json");

        BaseMod.loadCustomStringsFile(CardStrings.class, modID + "Resources/localization/eng/Cardstrings.json");

        BaseMod.loadCustomStringsFile(PotionStrings.class, modID + "Resources/localization/eng/Potionstrings.json");

        BaseMod.loadCustomStringsFile(PowerStrings.class, modID + "Resources/localization/eng/Powerstrings.json");

        BaseMod.loadCustomStringsFile(RelicStrings.class, modID + "Resources/localization/eng/Relicstrings.json");

        BaseMod.loadCustomStringsFile(UIStrings.class, modID + "Resources/localization/eng/UIstrings.json");
    }

    @Override
    public void receiveEditKeywords() {
        Gson gson = new Gson();
        String json = Gdx.files.internal(modID + "Resources/localization/eng/Keywordstrings.json").readString(String.valueOf(StandardCharsets.UTF_8));
        com.evacipated.cardcrawl.mod.stslib.Keyword[] keywords = gson.fromJson(json, com.evacipated.cardcrawl.mod.stslib.Keyword[].class);

        if (keywords != null) {
            for (Keyword keyword : keywords) {
                BaseMod.addKeyword(modID, keyword.PROPER_NAME, keyword.NAMES, keyword.DESCRIPTION);
            }
        }
    }


    @Override
    public void receivePostUpdate() {
        if (choosingRemoveCard && AbstractDungeon.gridSelectScreen.selectedCards.size() == 1) {
            AbstractCard card = AbstractDungeon.gridSelectScreen.selectedCards.get(0);
            card.untip();// 73
            card.unhover();// 74
            AbstractDungeon.topLevelEffects.add(new PurgeCardEffect(card, (float) Settings.WIDTH / 2, (float) Settings.HEIGHT / 2.0F));// 75
            AbstractDungeon.player.masterDeck.removeCard(card);// 78
            choosingRemoveCard = false;
            CenterGridCardSelectScreen.centerGridSelect = false;
            AbstractDungeon.getCurrRoom().phase = AbstractRoom.RoomPhase.COMPLETE;
            AbstractDungeon.gridSelectScreen.selectedCards.clear();
        }
    }
}
