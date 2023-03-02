package pro.dd493.minecraftfontrenderer.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MathUtil {
    public float clamp(final float value, final float min, final float max) {
        return Math.max(min, Math.min(max, value));
    }

    public double clamp(final double value, final double min, final double max) {
        return Math.max(min, Math.min(max, value));
    }
}
