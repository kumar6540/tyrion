package bill.DTO;

public class Creditcard {
	
	private Integer first;
	private Integer second;
	private Integer third;
	private Integer fourth;
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getSecond() {
		return second;
	}
	public void setSecond(Integer second) {
		this.second = second;
	}
	public Integer getThird() {
		return third;
	}
	public void setThird(Integer third) {
		this.third = third;
	}
	public Integer getFourth() {
		return fourth;
	}
	public void setFourth(Integer fourth) {
		this.fourth = fourth;
	}
	@Override
	public String toString() {
		return getFirst()+"-"+getSecond()+"-"+getThird()+"-"+getFourth();
	}
	
	

}
