package theDefiler.patch;


import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.saveAndContinue.SaveFile;
import theDefiler.DefilerMod;

import java.util.ArrayList;

@SpirePatch2(clz = AbstractDungeon.class, method = "nextRoomTransition", paramtypez = {SaveFile.class})
public class IgnorePathResetPatch {
    @SpirePostfixPatch
    public static void spireLocationsOnEnterRoom() {
        if (AbstractDungeon.nextRoom != null) {
            AbstractRoom room = AbstractDungeon.nextRoom.getRoom();
            if (room != null) {
                DefilerMod.canIgnorePath = false;
            }
        }
    }
}