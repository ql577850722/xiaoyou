package xiaoyou.bean;

public class ActivityContent {

	private int u_id;
	private String u_name;
	private int acid;
	private String aname;
	private String astarttime;
	private String aadd;
	private String atype;
	private double aexpend;
	private String acity;
	private int aperson;
	private String adate;
	private String acontent;
	private String aphoto;
	private int astatus;
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public int getAcid() {
		return acid;
	}
	public void setAcid(int acid) {
		this.acid = acid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAstarttime() {
		return astarttime;
	}
	public void setAstarttime(String astarttime) {
		this.astarttime = astarttime;
	}
	public String getAadd() {
		return aadd;
	}
	public void setAadd(String aadd) {
		this.aadd = aadd;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	public double getAexpend() {
		return aexpend;
	}
	public void setAexpend(double aexpend) {
		this.aexpend = aexpend;
	}
	public String getAcity() {
		return acity;
	}
	public void setAcity(String acity) {
		this.acity = acity;
	}
	public int getAperson() {
		return aperson;
	}
	public void setAperson(int aperson) {
		this.aperson = aperson;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public String getAphoto() {
		return aphoto;
	}
	public void setAphoto(String aphoto) {
		this.aphoto = aphoto;
	}
	public int getAstatus() {
		return astatus;
	}
	public void setAstatus(int astatus) {
		this.astatus = astatus;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aadd == null) ? 0 : aadd.hashCode());
		result = prime * result + acid;
		result = prime * result + ((acity == null) ? 0 : acity.hashCode());
		result = prime * result
				+ ((acontent == null) ? 0 : acontent.hashCode());
		result = prime * result + ((adate == null) ? 0 : adate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(aexpend);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((aname == null) ? 0 : aname.hashCode());
		result = prime * result + aperson;
		result = prime * result + ((aphoto == null) ? 0 : aphoto.hashCode());
		result = prime * result
				+ ((astarttime == null) ? 0 : astarttime.hashCode());
		result = prime * result + astatus;
		result = prime * result + ((atype == null) ? 0 : atype.hashCode());
		result = prime * result + u_id;
		result = prime * result + ((u_name == null) ? 0 : u_name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivityContent other = (ActivityContent) obj;
		if (aadd == null) {
			if (other.aadd != null)
				return false;
		} else if (!aadd.equals(other.aadd))
			return false;
		if (acid != other.acid)
			return false;
		if (acity == null) {
			if (other.acity != null)
				return false;
		} else if (!acity.equals(other.acity))
			return false;
		if (acontent == null) {
			if (other.acontent != null)
				return false;
		} else if (!acontent.equals(other.acontent))
			return false;
		if (adate == null) {
			if (other.adate != null)
				return false;
		} else if (!adate.equals(other.adate))
			return false;
		if (Double.doubleToLongBits(aexpend) != Double
				.doubleToLongBits(other.aexpend))
			return false;
		if (aname == null) {
			if (other.aname != null)
				return false;
		} else if (!aname.equals(other.aname))
			return false;
		if (aperson != other.aperson)
			return false;
		if (aphoto == null) {
			if (other.aphoto != null)
				return false;
		} else if (!aphoto.equals(other.aphoto))
			return false;
		if (astarttime == null) {
			if (other.astarttime != null)
				return false;
		} else if (!astarttime.equals(other.astarttime))
			return false;
		if (astatus != other.astatus)
			return false;
		if (atype == null) {
			if (other.atype != null)
				return false;
		} else if (!atype.equals(other.atype))
			return false;
		if (u_id != other.u_id)
			return false;
		if (u_name == null) {
			if (other.u_name != null)
				return false;
		} else if (!u_name.equals(other.u_name))
			return false;
		return true;
	}
	public ActivityContent(int u_id, String u_name, int acid, String aname,
			String astarttime, String aadd, String atype, double aexpend,
			String acity, int aperson, String adate, String acontent,
			String aphoto, int astatus) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.acid = acid;
		this.aname = aname;
		this.astarttime = astarttime;
		this.aadd = aadd;
		this.atype = atype;
		this.aexpend = aexpend;
		this.acity = acity;
		this.aperson = aperson;
		this.adate = adate;
		this.acontent = acontent;
		this.aphoto = aphoto;
		this.astatus = astatus;
	}
	@Override
	public String toString() {
		return "a [u_id=" + u_id + ", u_name=" + u_name + ", acid=" + acid
				+ ", aname=" + aname + ", astarttime=" + astarttime + ", aadd="
				+ aadd + ", atype=" + atype + ", aexpend=" + aexpend
				+ ", acity=" + acity + ", aperson=" + aperson + ", adate="
				+ adate + ", acontent=" + acontent + ", aphoto=" + aphoto
				+ ", astatus=" + astatus + "]";
	}
	
	public ActivityContent() {
		super();
		// TODO Auto-generated constructor stub
	}
}
