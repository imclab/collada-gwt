package com.floorplanner.collada.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;

public class DaeMesh extends DaeElement {
	private Map<String, DaeSource> sources;
	private DaeSource vertices;
	private Vector<DaePrimitive> primitives;
	private String verticesID;
	
	public DaeMesh(DaeDocument document) {
		super(document);
	}
	
	public DaeMesh(DaeDocument document, Node node) {
		super(document, node);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		
		if (sources != null) {
			sources.clear();
			sources = null;
		}
		
		if (primitives != null) {
			for (DaePrimitive primitive: primitives) {
				primitive.destroy();
			}
			primitives.clear();
			primitives = null;
		}
		
		vertices = null;
		verticesID = null;
	}
	
	@Override
	public void read(Node node) {
		super.read(node);
		
		sources = new HashMap<String, DaeSource>();
		primitives = new Vector<DaePrimitive>();
		vertices = null;
		verticesID = null;
		
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node child = list.item(i);
			String nodeName = child.getNodeName();
			if (nodeName.compareTo("source") == 0) {
				readSource(readAttribute(child, "id"));
			} else if (nodeName.compareTo("vertices") == 0) {
				readVertices(child);
			} else if (nodeName.compareTo("triangles") == 0) {
				primitives.add(new DaeTriangles(getDocument(), child, this));
			}
		}
	}
	
	private DaeSource readSource(String id) {
		if (id != null) {
			DaeSource source = getDocument().getSourceByID(id);
			if (source != null && source.getID() != null) {
				if (sources.get(id) == null) {
					sources.put(source.getID(), source);
				}
				return source;
			}
		} 
		return null;
	}
	
	private void readVertices(Node node) {
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node child = list.item(i);
			String nodeName = child.getNodeName();
			if (nodeName.compareTo("input") == 0) {
				DaeInput input = new DaeInput(getDocument(), child);
				if (input.getSemantic().compareTo("POSITION") == 0) {
					vertices = readSource(input.getSource());
					verticesID = readAttribute(node, "id");
				}
			}
		}
	}
	
	public Vector<DaePrimitive> getPrimitives() {
		return primitives;
	}
	
	public Map<String, DaeSource> getSources() {
		return sources;
	}
	
	public DaeSource getVertices() {
		return vertices;
	}
	
	public String getVerticesID() {
		return verticesID;
	}
}
