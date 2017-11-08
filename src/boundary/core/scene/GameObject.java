package boundary.core.scene;

import java.util.HashMap;

import boundary.core.math.Transform;

public class GameObject {

	private HashMap<String, Component> components;
	private Transform transform;
	
	public GameObject() {
		components = new HashMap<String, Component>();
		transform = new Transform();
	}
	
	public void input() {
		
		for(String key : components.keySet()) {
			components.get(key).input();
		}
	}
	
	public void update() {
		
		for(String key : components.keySet()) {
			components.get(key).update();
		}
	}
	
	public void render() {
		
		for(String key : components.keySet()) {
			components.get(key).render();
		}
	}
	
	public void addComponent(String key, Component component) {
		component.setParent(this);
		components.put(key, component);
	}

	public HashMap<String, Component> getComponents() {
		return components;
	}

	public void setComponents(HashMap<String, Component> components) {
		this.components = components;
	}

	public Transform getTransform() {
		return transform;
	}

	public void setTransform(Transform transform) {
		this.transform = transform;
	}
	
}
