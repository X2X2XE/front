package domain;


public class RepliesVO {
	private long rno;
	private int pno;
	private String replier;
	private String reply;
	private String reg_at;
	private String mod_at;
	
	public RepliesVO() {}

	// post
	public RepliesVO(int pno, String replier, String reply) {
		this.pno = pno;
		this.replier = replier;
		this.reply = reply;
	}
	//list
	public RepliesVO(long rno, int pno, String replier, String reply, String reg_at, String mod_at) {
		this.rno = rno;
		this.pno = pno;
		this.replier = replier;
		this.reply = reply;
		this.mod_at = mod_at;
	}
	// modify
	public RepliesVO(long rno, String reply) {
		this.rno = rno;
		this.reply = reply;
	}

	public long getRno() {
		return rno;
	}

	public void setRno(long rno) {
		this.rno = rno;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getReplier() {
		return replier;
	}

	public void setReplier(String replier) {
		this.replier = replier;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getReg_at() {
		return reg_at;
	}

	public void setReg_at(String reg_at) {
		this.reg_at = reg_at;
	}

	public String getMod_at() {
		return mod_at;
	}

	public void setMod_at(String mod_at) {
		this.mod_at = mod_at;
	}
	
	
	
	
	
	
	
}
