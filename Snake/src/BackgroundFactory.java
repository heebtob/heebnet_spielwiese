import java.awt.Color;


public class BackgroundFactory {

	public static IGameComponent create(String name, int posx, int posy, int sidelength, Color color, boolean isDeadly) {
		IGameComponent component = null;
		if (name.equals("StandardTile")) {
			component = new Kachel(posx,posy,sidelength,color,isDeadly);
		}
		return component;
	}
}
