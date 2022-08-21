package theDefiler.patch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.*;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.relics.BottledFlame;
import com.megacrit.cardcrawl.relics.BottledLightning;
import com.megacrit.cardcrawl.relics.BottledTornado;
import com.megacrit.cardcrawl.relics.DeadBranch;
import com.megacrit.cardcrawl.rooms.CampfireUI;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;
import com.megacrit.cardcrawl.ui.campfire.RestOption;
import com.megacrit.cardcrawl.ui.campfire.SmithOption;

import com.evacipated.cardcrawl.modthespire.lib.*;
import java.util.*;

import basemod.*;
import basemod.abstracts.CustomBottleRelic;

import com.megacrit.cardcrawl.core.*;
import theDefiler.DomisdrawCampfireOption;
import theDefiler.cards.defiler.DomisdrawsBow;
import theDefiler.cards.defiler.DomisdrawsCross;
import theDefiler.cards.defiler.DomisdrawsSpear;

@SpirePatch(cls = "com.megacrit.cardcrawl.rooms.CampfireUI", method = "initializeButtons")
public class DomisdrawPatch
{
    private static boolean checkDeck (String id) {
        for(AbstractCard c : AbstractDungeon.player.masterDeck.group) {
            if (c.cardID.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static void Postfix(final Object meObj) {

        if (checkDeck(DomisdrawsSpear.ID) && checkDeck(DomisdrawsBow.ID) && checkDeck(DomisdrawsCross.ID)) {
            final CampfireUI campfire = (CampfireUI)meObj;
            try {
                final ArrayList<AbstractCampfireOption> campfireButtons = (ArrayList<AbstractCampfireOption>)ReflectionHacks.getPrivate((Object)campfire, (Class)CampfireUI.class, "buttons");
                final AbstractCampfireOption button = new DomisdrawCampfireOption();
                campfireButtons.add(button);
                float x = 950.f;
                float y = 990.0f - (270.0f * (float)((campfireButtons.size() + 1) / 2));
                if (campfireButtons.size() % 2 == 0) {
                    x = 1110.0f;
                    campfireButtons.get(campfireButtons.size() - 2).setPosition(800.0f * Settings.scale, y * Settings.scale);
                }
                campfireButtons.get(campfireButtons.size() - 1).setPosition(x * Settings.scale, y * Settings.scale);
            }
            catch (SecurityException | IllegalArgumentException ex2) {
                //final RuntimeException ex;
                //final RuntimeException e = ex;
                //e.printStackTrace();
            }
        }
    }
}
