# DDMinecraftFontRenderer
A custom Minecraft font renderer based upon an old font renderer.

## Usage
```java
// Creating a font manager
FontManager fontManager = new FontManager("Client/fonts"); // Create a new font manager, this will get the fonts out of the folder "fonts" in "Client in /assets/minecraft/
FontRenderer font = fontManager.getFont("Arial", 20); // Get a font with the name "Arial" and a size of 20

// Drawing a string
font.drawString("Hello World!", 0, 0, Color.White); // Draw a string at 0, 0 with the color white

// Drawing a string with a shadow
font.drawStringWithShadow("Hello World!", 0, 0, Color.White); // Draw a string at 0, 0 with the color white and a shadow

// Getting the width of a string
font.getWidth("Hello World!");

// Getting the height of a string
font.getHeight("Hello World!"); // or font.getHeight();

// This supports Minecraft's colour codes so anything like this will work
font.drawString("Hello §cWorld!", 0, 0, Color.White);

// You can also use the Minecraft colour codes in the shadow
font.drawStringWithShadow("Hello §cWorld!", 0, 0, Color.White);

// It also has a few "random" functions which are just used by Minecraft
// and can be useful when implementing it into something stuff, one of these is:
// listFormattedStringToWidth
```