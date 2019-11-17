import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.random.Random;

@SpirePatch(
        clz= AbstractDungeon.class,
        method="transformCard",
        paramtypez={
                AbstractCard.class,
                boolean.class,
                Random.class
        }
)
public class AbstractDungeon_transformCard {
        public static void Prefix(AbstractCard card, boolean autoUpgrade, Random rng) {
                if (TransformCurses.enabled) {
                        card.color = card.color == AbstractCard.CardColor.CURSE ? AbstractDungeon.player.getCardColor() : card.color;
                }
        }
}
