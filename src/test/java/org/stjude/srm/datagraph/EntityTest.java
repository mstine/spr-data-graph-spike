package org.stjude.srm.datagraph;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class EntityTest {
	
	@Test
	public void explore() {
		
		Entity entity = new Entity();
		entity.setType(Entity.Type.ORDER);
		entity.persist();
		
		String typeProperty = (String) entity.getEntityState().getPersistentState().getProperty("type");
		Assert.assertEquals(Entity.Type.ORDER.toString(), typeProperty);
		
	}
	
	
	@Test
	public void exploreAddingStringAttribute() {
		
		Entity entity = new Entity();
		entity.setType(Entity.Type.SUBJECT);
		entity.persist();
		
		Attribute<String> sampleType = new Attribute<String>();
		sampleType.setValue("DNA");
		sampleType.persist();
		entity.addAttribute(sampleType);
		
		Assert.assertEquals(1, entity.getAttributes().size());
	}

}
