package upm.es.recursive.backtrack;

import java.util.Objects;

public class Coordinate {
	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass()) // si no son la misma clase tiene que ser false
			return false;
		Coordinate other = (Coordinate) obj; //casting -> force a convertir obj a la bonne classe parce que je sais que obj et un Coordinate
		return ((this.x == other.x) && (this.y == other.y));
	}

	@Override
	public String toString() {
		return "[" +x + y+"]";
	}
	
	

}
