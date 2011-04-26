package org.stjude.srm.datagraph;

import java.util.Set;

import org.springframework.data.graph.annotation.NodeEntity;
import org.springframework.data.graph.annotation.RelatedTo;
import org.springframework.data.graph.neo4j.annotation.Indexed;

@NodeEntity
public class Entity {

	public enum Type {
		ORDER, SUBJECT, TASK, DYNAMIC;
	}
	
	@Indexed
	private Type type;
	
	@RelatedTo(type = "HAS_ATTRIBUTE", elementClass = Attribute.class)
	private Set<Attribute<String>> attributes;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Set<Attribute<String>> getAttributes() {
		return attributes;
	}
	
	public void addAttribute(Attribute<String> attribute) {
		attributes.add(attribute);
	}
	
}
