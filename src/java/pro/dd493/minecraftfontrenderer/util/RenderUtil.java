package pro.dd493.minecraftfontrenderer.util;

import lombok.experimental.UtilityClass;

import java.awt.*;

import static org.lwjgl.opengl.GL11.glColor4d;

@UtilityClass
public class RenderUtil {
    public void colour(final double red, final double green, final double blue, final double alpha) {
        glColor4d(red, green, blue, alpha);
    }

    public void colour(Color colour) {
        if (colour == null)
            colour = Color.white;
        colour(colour.getRed() / 255f, colour.getGreen() / 255f, colour.getBlue() / 255f, colour.getAlpha() / 255f);
    }
}
