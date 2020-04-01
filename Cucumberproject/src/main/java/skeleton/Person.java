package skeleton;

public class Person {
private int distance;
private String message;

	public void SetDistance(Integer distance) {
		// TODO Auto-generated method stub
		
		if(distance>0 && distance<30)
		{
			this.distance=distance;
			}
		
	}
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		
		if(distance>0 && distance<30) {
		this.message=message;
		}
		else
		{
			this.message=null;
			
		}
		
	}
	
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}
	

}
