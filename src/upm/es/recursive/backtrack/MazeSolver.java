package upm.es.recursive.backtrack;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;



public class MazeSolver {
	
	private String[] maze; //(y,x)
	private char wall;
	private Coordinate start;
	private Coordinate end;
	private List<Coordinate> path;
	private Set<Coordinate> visited;
	
	
	public MazeSolver(String[] maze, char wall, Coordinate start, Coordinate end) {
		super();
		this.maze = maze;
		this.wall = wall;
		this.start = start;
		this.end = end;
		this.path = new ArrayList<Coordinate>();
		this.visited = new HashSet<Coordinate>();
	}
	
	private boolean walk(Coordinate current) {
		//Caso Base
		path.add(current);
		//Estoy fuera?
		if(current.getX() >= maze[0].length()// La X se sale por a derecha
			|| current.getX()<0	
			|| current.getY() >= maze.length
			|| current.getY() < 0
				) {
			path.remove(current);
			return false;
		}
		//estoy en un muro?
		if(maze[current.getY()].charAt(current.getX()) == wall) {
			path.remove(current);
			return false;
		}
		if(current.equals(end)) {
			return true;
		}
		//He estado antes?
		if(visited.contains(current)) {
			path.remove(current);
			return false;
		}
		
		//Paso recursivo up,right,down,left
		this.visited.add(current);
		Coordinate up = new Coordinate(current.getX(),current.getY()-1);
		Coordinate right = new Coordinate(current.getX()+1,current.getY());
		Coordinate ddown = new Coordinate(current.getX(),current.getY()+1);
		Coordinate left = new Coordinate(current.getX()-1,current.getY());
		Coordinate toVisit[] = new Coordinate[4];
		toVisit[0] = up;
		toVisit[1] = right;
		toVisit[2] = ddown;
		toVisit[3] = left;
		for(Coordinate next : toVisit) {
			if(this.walk(next)) {
				return true;
			}
		}
		return false;
		
	}
	public List<Coordinate> solve(){
		this.walk(start);
		return path;
	}
	
	
	
}
