package com.hsinghsu.test.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {  
	  
    private static final long serialVersionUID = 8013816027944871760L;  
    private String username;// ��¼�û���  
    private String password;// ��¼����  
    private String prePage;// ��¼ǰҳ��  
  
    public String execute() throws Exception {  
          
        if (null != username && null != password && username.equals("hsing") && password.equals("hsu")) {  
  
            ActionContext ctx = ActionContext.getContext();  
            Map<String, Object> session = ctx.getSession();  
              
            //�����û���Ϣsession  
            session.put("user", getUsername());  
  
            // ��ȡ��ת����½����֮ǰ��ҳ���ַ�����������ṩ  
            prePage = (String) session.get("prePage");  
  
            // ���session�е�����  
            session.remove("prePage");  
  
            if (null == prePage) {  
                return "usercenter";// ������������ת����½ҳ��ģ�ֱ�ӷ��ʵĵ�½ҳ��  
            } else {  
                return SUCCESS;// ����������ת����½��¼ǰҳ��  
            }  
  
        } else {  
            return INPUT;  
        }  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
  
    public String getUsername() {  
        return this.username;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
    public String getPassword() {  
        return this.password;  
    }  
  
    public String getPrePage() {  
        return prePage;  
    }  
  
    public void setPrePage(String prePage) {  
        this.prePage = prePage;  
    }  
}  
