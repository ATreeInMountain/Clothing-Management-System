package mms.pojo;

public class Cloth {
	private int clno;
	private String clname;
	private String clseasonal;
	private String clmode;
	private double clprice;
	
	public int getClno() {
		return clno;
	}
	public void setClno(int clno) {
		this.clno = clno;
	}
	public String getClname() {
		return clname;
	}
	public void setClname(String clname) {
		this.clname = clname;
	}
	public String getClseasonal() {
		return clseasonal;
	}
	public void setClseasonal(String clseasonal) {
		this.clseasonal = clseasonal;
	}
	public String getClmode() {
		return clmode;
	}
	public void setClmode(String clmode) {
		this.clmode = clmode;
	}
	public double getClprice() {
		return clprice;
	}
	public void setClprice(double clprice) {
		this.clprice = clprice;
	}
	public Cloth() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cloth(int clno, String clname, String clseasonal, String clmode, double clprice) {
		super();
		this.clno = clno;
		this.clname = clname;
		this.clseasonal = clseasonal;
		this.clmode = clmode;
		this.clprice = clprice;
	}
	@Override
	public String toString() {
		return "Cloth [clno=" + clno + ", clname=" + clname + ", clseasonal=" + clseasonal + ", clmode=" + clmode
				+ ", clprice=" + clprice + "]";
	}
}
