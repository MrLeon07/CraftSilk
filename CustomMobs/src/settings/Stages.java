package settings;

public class Stages {

	private String StageName;
	private int CustomModel;
	public Stages(String StageName,int CustomModel) {
		this.setStageName(StageName);
		this.setCustomModel(CustomModel);
		
	}
	

	public String getStageName() {
		return StageName;
	}
	public void setStageName(String stageName) {
		StageName = stageName;
	}
	public int getCustomModel() {
		return CustomModel;
	}
	public void setCustomModel(int customModel) {
		CustomModel = customModel;
	}

}
