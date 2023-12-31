package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.IGenerateGameMap;
import fr.univartois.butinfo.r304.flatcraft.model.dimension.CaseFactory;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;

public class GenerateGameMap implements IGenerateGameMap {

	private int hauteur;
	private int largeur;
	private SimpleGameMap gameMap;

	public GenerateGameMap(int hauteur,int largeur) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.gameMap = new SimpleGameMap(hauteur, largeur, hauteur/2);
	}
	
	@Override
	public SimpleGameMap returnMapCreate(ISpriteStore sprite ) {
		CellFactory cell = CaseFactory.getInstance();
		for(int i = 0; i<largeur; i++) {
			for(int y=0; y< hauteur; y++) {
				if(y>hauteur/2) {
					gameMap.setAt(y, i, cell.createSubSoil());
				}
				if(y==hauteur/2) {
					gameMap.setAt(y, i, cell.createSoilSurface());
				}
				if(y<hauteur/2) {
					gameMap.setAt(y, i, cell.createSky(y,i));
				}
			}
		}
		return gameMap;
	}
	
}
