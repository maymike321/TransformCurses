import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.random.Random;

@SpirePatch(
        clz=AbstractDungeon.class,
        method="returnTrulyRandomCardFromAvailable",
        paramtypez={
                AbstractCard.class,
                Random.class
        }
)
public class AbstractDungeon_returnTrulyRandomCardFromAvailable {
    private static AbstractCard.CardColor actualColor;
    public static void Prefix(AbstractCard card, Random rng) {
        if (TransformCurses.enabled) {
            actualColor = card.color;
            card.color = card.color == AbstractCard.CardColor.CURSE ? AbstractDungeon.player.getCardColor() : card.color;
        }
    }

    public static void Postfix(AbstractCard card, Random rng) {
        if (TransformCurses.enabled) {
            card.color = actualColor;
            actualColor = null;
        }
    }
}
