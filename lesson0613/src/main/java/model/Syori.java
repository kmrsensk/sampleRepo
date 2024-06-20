package model;

public class Syori extends Health{
	private String errorMsg;
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Boolean syoriMsg(){
		String error = "";
		if (getHeight() <= 0) {
			error += "身長の値がおかしいです。<br>身長："+ getHeight() + "<br>";
		}
		if(getWeight() <= 0) {
			error += "体重の値がおかしいです。<br>体重："+ getWeight() + "<br>";
		}
		if(error.length() != 0) {
			setErrorMsg(error);
			return false;
		}else {
			return true;
		}
	}
}