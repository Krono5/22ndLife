package boundary.modules.terrain;

import boundary.core.kernel.Camera;
import boundary.core.scene.GameObject;
import boundary.core.shaders.Shader;
import boundary.core.utils.ResourceLoader;

public class TerrainShader extends Shader {

	private static TerrainShader instance = null;
	
	public static TerrainShader getInstance() {
		
		if(instance == null) {
			
			instance = new TerrainShader();
		}
		return instance;
	}
	
	protected TerrainShader() {
		
		super();
		
		addVertexShader(ResourceLoader.loadShader("shaders/terrain/terrain_VS.glsl"));
		addTessellationControlShader(ResourceLoader.loadShader("shaders/terrain/terrain_TC.glsl"));
		addTessellationEvaluationShader(ResourceLoader.loadShader("shaders/terrain/terrain_TE.glsl"));
		addGeometryShader(ResourceLoader.loadShader("shaders/terrain/terrain_GS.glsl"));
		addFragmentShader(ResourceLoader.loadShader("shaders/terrain/terrain_FS.glsl"));
		
		compileShader();
		
		addUniform("localMatrix");
		addUniform("worldMatrix");
		addUniform("m_ViewProjection");
	}
	
	public void updateUniforms(GameObject object) {
		
		setUniform("m_ViewProjection", Camera.getInstance().getViewProjectionMatrix());
		setUniform("localMatrix", object.getLocalTransform().getWorldMatrix());
		setUniform("worldMatrix", object.getWorldTransform().getWorldMatrix());
	}
}