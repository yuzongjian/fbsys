package com.buoy.exception;

/**
 * 自定义异常
 * @author Howard
 * 2017年4月1日
 */
public class ExceptionResultInfo extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// 系统统一使用的结果类，包括了 提示信息类型和信息内容
   /* private ResultInfo resultInfo;
    public ExceptionResultInfo(ResultInfo resultInfo) {
        super(resultInfo.getMessage());
        this.resultInfo = resultInfo;
    }
    public ResultInfo getResultInfo() {
        return resultInfo;
    }
    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }
    
    */
	/*public static final int TYPE_RESULT_FAIL = 0;//失败
    public static final int TYPE_RESULT_SUCCESS = 1;//成功
    public static final int TYPE_RESULT_WARN = 2;//警告
    public static final int TYPE_RESULT_INFO = 3;//提示信息
*/  private int type;
    private String message;
    private String url = null;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ExceptionResultInfo(int type, String message) {
		super();
		this.type = type;
		this.message = message;
	}
	
	public ExceptionResultInfo(int type, String message, String url) {
		super();
		this.type = type;
		this.message = message;
		this.url = url;
	}
	public ExceptionResultInfo() {
		super();
	}
    
    

}
