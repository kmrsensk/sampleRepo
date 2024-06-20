// BMI計算、体型判定
package model;

public class HealthCheckLogic {
	public void excute(Health health) {
		double weight = health.getWeight();
		double height = health.getHeight();
		double bmi = weight / Math.pow((height / 100.0), 2.0);
		health.setBmi(bmi);
		String type;
		if (bmi < 18.5) {
			type = "瘦せ型";
		}else if (bmi >= 25) {
			type = "肥満";
		}else if (bmi <25 && bmi >= 18.5) {
			type = "普通";
		}else {
			type = "BMIの計算ができませんでした。";
		}
		health.setBodyType(type);
	}
}
