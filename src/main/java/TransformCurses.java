import basemod.*;
import basemod.interfaces.PostInitializeSubscriber;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.FontHelper;

import java.util.function.Consumer;

@SpireInitializer
public class TransformCurses implements PostInitializeSubscriber {
    public TransformCurses() {
        BaseMod.subscribe(this);
    }

    public static void initialize() {
        new TransformCurses();  // Calls constructor, which subscribes this to base mod
    }

    public static boolean enabled = true;
    @Override
    public void receivePostInitialize() {
        ModPanel settingsPanel = new ModPanel();
        ModLabeledToggleButton modActive = new ModLabeledToggleButton("Activate Transform Curses",
                350f, 750f, Settings.CREAM_COLOR, FontHelper.buttonLabelFont, enabled, settingsPanel,
                (me) -> {},
                (me) -> {
                    enabled = me.enabled;
                }
        );

        Texture modBadge = new Texture("TransformCursesModIcon.png");
        modBadge.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        settingsPanel.addUIElement(modActive);
        BaseMod.registerModBadge(modBadge, "Transform Curses", "para, strand", "Curses now transform into normal cards instead of other curses.", settingsPanel);
    }
}
