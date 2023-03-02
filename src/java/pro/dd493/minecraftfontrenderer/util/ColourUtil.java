package pro.dd493.minecraftfontrenderer.util;

import lombok.experimental.UtilityClass;

import java.awt.*;

@UtilityClass
public class ColourUtil {
    public Color multiply(final Color color, final float factor) {
        return new Color(
                (int) MathUtil.clamp(color.getRed() * factor, 0, 255),
                (int) MathUtil.clamp(color.getGreen() * factor, 0, 255),
                (int) MathUtil.clamp(color.getBlue() * factor, 0, 255),
                color.getAlpha()
        );
    }

    public Color alpha(final Color colour, final int alpha) {
        return new Color(colour.getRed(), colour.getGreen(), colour.getBlue(), (int) MathUtil.clamp(alpha, 0, 255));
    }
}
