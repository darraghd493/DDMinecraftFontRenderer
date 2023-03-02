package pro.dd493.minecraftfontrenderer;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/*
 * Custom font manager for the font renderer.
 *
 * @author darraghd493
 */
public class FontManager {
    public static final Logger logger = LogManager.getFormatterLogger("Minecraft Font Renderer");

    private final Map<String, FontRenderer> fonts;
    private final FontRenderer defaultFont;
    private final String domain;

    public FontRenderer getFont(final String name, final int size) {
        final String key = String.format("%s %s", name, size);

        if (this.fonts.containsKey(key)) {
            return this.fonts.get(key);
        } else {
            try {
                try {
                    final InputStream inputStream = this.getClass().getResourceAsStream(String.format("/assets/minecraft/%s/fonts/%s.ttf", domain, name));
                    this.generateFont(name, inputStream, size);
                    logger.info("Generated font " + name + " with size " + size + "!");

                    return this.fonts.get(key);
                } catch (final IOException | FontFormatException e) {
                    e.printStackTrace();
                    logger.error("Failed to generate font " + key + "!");
                }
            } catch (final NumberFormatException e) {
                logger.error("Could not generate " + key + "!");
            }
        }

        return this.defaultFont;
    }

    private void generateFont(final String name, final InputStream inputStream, final int size) throws IOException, FontFormatException {
        Font font = Font.createFont(0, inputStream);
        font = font.deriveFont(Font.PLAIN, (float) size);
        this.fonts.put(String.format("%s %s", name, size), new FontRenderer(font));
    }

    public FontManager(final String domain) {
        logger.info("Initializing font manager");
        logger.info("Generating default font");

        this.domain = domain;

        this.defaultFont = new FontRenderer(new Font("Arial", Font.PLAIN, 18));
        this.fonts = new HashMap<>();

        logger.info("Font manager initialized successfully");
    }

    public String find(final FontRenderer fontRenderer) {
        for (final Map.Entry<String, FontRenderer> entry : this.fonts.entrySet())
            if (entry.getValue().equals(fontRenderer)) return entry.getKey();
        return null;
    }

    public TruePair<String, Integer> unparse(final String string) {
        // Split the string into spaces
        // Join all but the last element with spaces
        // The last element is the size
        // The rest is the name

        final String[] split = string.split(" ");
        final String name = String.join(" ", split).substring(0, string.length() - split[split.length - 1].length() - 1);
        final int size = Integer.parseInt(split[split.length - 1]);
        return new TruePair<>(name, size);
    }

    @Data
    @AllArgsConstructor
    public class TruePair<T, D> {
        private T first;
        private D second;
    }
}
