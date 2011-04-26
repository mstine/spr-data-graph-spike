package org.stjude.srm.datagraph;

import org.springframework.data.graph.annotation.NodeEntity;
import org.springframework.data.graph.neo4j.annotation.Indexed;

@NodeEntity
public class Attribute<T> {

	@Indexed
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
			
}
