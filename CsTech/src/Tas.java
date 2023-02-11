//Dorukhan Altuntas
public class Tas {

	private int value;               //Puan degeri
	private String type;             //Tas tipi
	private String color;            //Tas Rengi
	private boolean isgal=false;     // O kareyi bir tasin isgal edip etmedigi bilgisi (en basta isgal edilmemis olarak assign ettim)
	
	
	public Tas(String type, String color,int value) { //Constructor
		this.type = type;
		this.color = color;
		this.value = value;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public boolean isIsgal() {
		return isgal;
	}


	public void setIsgal(boolean isgal) {
		this.isgal = isgal;
	}
	
}
