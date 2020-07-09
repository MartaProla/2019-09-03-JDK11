package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {
	private FoodDao dao;
	private Graph<String,DefaultWeightedEdge>grafo;
	List<String>vertici;
	
	public Model() {
		dao=new FoodDao();
	}
	public String  creaGrafo(int x) {
		vertici=dao.tipoDiPorzione(x);
		this.grafo=new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		for(String s: vertici) {
			this.grafo.addVertex(s);
		}
		
		List<InfoArco>archi=this.dao.getArchi();
		for(InfoArco i:archi) {
			if(this.grafo.vertexSet().contains(i.getV1())&& this.grafo.vertexSet().contains(i.getV2())){
				Graphs.addEdgeWithVertices(this.grafo, i.getV1(), i.getV2(),i.getPeso());
			}
			
		}
		return String.format("Grafo creato %d vertici %d archi",this.grafo.vertexSet().size(),this.grafo.edgeSet().size());
		
	}
	public List<String>getVerticiGrafo(){
		return this.vertici;
	}
	public List<Adiacente>porzioneAdiacenti(String porzione){
		List<String>vicini=Graphs.neighborListOf(this.grafo,porzione);
		List<Adiacente>result=new ArrayList<>();
		for(String v: vicini) {
			double peso=this.grafo.getEdgeWeight(this.grafo.getEdge(porzione, v));
			result.add(new Adiacente(v,peso));
		}
		return result;
	}
	
	
}
