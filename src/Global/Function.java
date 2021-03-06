package Global;

import Core.GameStarter;
import Managers.FontManager;
import ObjectUtil.TrackablePanel;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;

public class Function {
    public static void drawImage(Graphics2D g, int key, int x, int y){
        g.drawImage(getImage(key), null, x, y);
    }

    public static String getPairStr(double d1, double d2){
        return String.format("(%.3f,%.3f)", d1, d2);
    }
    public static String getPairStr(int i1, int i2){
        return String.format("(%d,%d)", i1, i2);
    }
    public static int getGeneralLogSize(){
        return GameStarter.frameManager.logPanel.getLogSize();
    }
    public static void setFontSize(Graphics2D g, float size){
        g.setFont(FontManager.getFont(size));
    }

    public static void playSound(int key){
        GameStarter.soundManager.playSoundTrack(key);
    }

    public static void movePanel(TrackablePanel tpanel){
        GameStarter.frameManager.movePanel(tpanel);
    }

    public static Point convertToInteger(double x, double y){
        return new Point((int)x, (int)y);
    }

    public static BufferedImage getImage(int key){
        return GameStarter.imageManager.getImage(key);
    }

    public static Point getConvertedPosition(double x, double y){
        return new Point((int)x, (int)(Constant.RESOLUTION.height - y));
    }

    public static String getMousePosAsString(){
        return String.format("(%3d,%3d)", Variables.mousePos.x, Variables.mousePos.y);
    }

    public static String getMouseCoordPosAsString(){
        return String.format("(%3d,%3d)", Variables.mousePos.x, Constant.RESOLUTION.height - Variables.mousePos.y);
    }

    public static String getElapsedTimeAsString(){
        long elapsed = System.nanoTime() - Constant.gameStartTimestamp;
        return String.format("%.2fs", (double)elapsed/1000000000);
    }

    public static void drawCenteredString(Graphics2D g, String str, int x, int y, float size){
        FontRenderContext frc = g.getFontRenderContext();
        g.setFont(FontManager.getFont(size));
        GlyphVector gv = g.getFont().createGlyphVector(frc, str);
        Rectangle bound = gv.getPixelBounds(null, x, y);

        int nx = x - bound.width/2;
        g.drawString(str, nx, y);
    }

    public static int getFontWidth(Graphics2D g, String str, float size) {
        return g.getFontMetrics(FontManager.getFont(size)).stringWidth(str);
    }
}
