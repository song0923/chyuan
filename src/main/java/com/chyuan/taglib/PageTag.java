package com.chyuan.taglib;

import org.apache.commons.lang.StringUtils;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PageTag extends TagSupport {
    private static final long serialVersionUID = 1L;
    private String pageParam = "page";
    private int curPage = 1; // 当前页面
    private int pageSize = 10;// 显示多少页码
    private int total;// 数据总条数
    private String forwardUrl;// 跳转页面

    public int doStartTag() throws JspException {
        String bar = "";
        try {
            bar += "<div class=\"list_info\">\n";
            bar += getNavigatorBar();
            // 输出结束标记
            bar += "</div>";
            pageContext.getOut().write(bar);
            return SKIP_BODY;
        } catch (IOException ioe) {
            throw new JspException(ioe.getMessage());
        }
    }
    
	@SuppressWarnings("unchecked")
	private String getNavigatorBar() {
    	double totalPage = Math.ceil(total * 1.0 / pageSize);
    	String pageInfo = "共&nbsp;&nbsp;" + total + "&nbsp;&nbsp;条记录";
        String prevText = "";
        String curPageInfo = "第&nbsp;&nbsp;" + curPage + "/" + (int)totalPage + "&nbsp;&nbsp;页";
        String nextText = "";
        Map<String, String[]> paramsMap = pageContext.getRequest().getParameterMap();
        HashMap<String, String[]> prevMap = new HashMap<String, String[]>(paramsMap);
        prevMap.put(pageParam, new String[] { String.valueOf(curPage - 1) });
        HashMap<String, String[]> nextMap = new HashMap<String, String[]>(paramsMap);
        nextMap.put(pageParam, new String[] { String.valueOf(curPage + 1) });
        HashMap<String, String[]> firstMap = new HashMap<String, String[]>(paramsMap);
        firstMap.put(pageParam, new String[] { String.valueOf(1) });
        HashMap<String, String[]> lastMap = new HashMap<String, String[]>(paramsMap);
        lastMap.put(pageParam, new String[] { String.valueOf((int)totalPage) });
        
        if(totalPage <= 1){
        	prevText = "<span class=\"disabled\" >&nbsp;&lt;&lt;&nbsp;</span><span class=\"disabled\" >&nbsp;&lt;&nbsp;</span>";
        	nextText = "<span class=\"disabled\" >&nbsp;&gt;&nbsp;</span><span class=\"disabled\" >&nbsp;&gt;&gt;&nbsp;</span>";
        }
        if(totalPage > 1){
        	if(curPage == 1){
        		prevText = "<span class=\"disabled\" >&nbsp;&lt;&lt;&nbsp;</span><span class=\"disabled\" >&nbsp;&lt;&nbsp;</span>";
        		nextText = "<a href=\"" + getUri(forwardUrl, nextMap) + "\">&nbsp;&gt;&nbsp;</a><a href=\"" + getUri(forwardUrl, lastMap) + "\">&nbsp;&gt;&gt;&nbsp;</a>";
        	}
        	if(curPage > 1 && curPage < totalPage){
        		prevText = "<a href=\"" + getUri(forwardUrl, firstMap) + "\">&nbsp;&lt;&lt;&nbsp;</a><a href=\"" + getUri(forwardUrl, prevMap) + "\">&nbsp;&lt;&nbsp;</a>";
        		nextText = "<a href=\"" + getUri(forwardUrl, nextMap) + "\">&nbsp;&gt;&nbsp;</a><a href=\"" + getUri(forwardUrl, lastMap) + "\">&nbsp;&gt;&gt;&nbsp;</a>";
        	}
        	if(curPage == totalPage){
        		prevText = "<a href=\"" + getUri(forwardUrl, firstMap) + "\">&nbsp;&lt;&lt;&nbsp;</a><a href=\"" + getUri(forwardUrl, prevMap) + "\">&nbsp;&lt;&nbsp;</a>";
            	nextText = "<span class=\"disabled\" >&nbsp;&gt;&nbsp;</span><span class=\"disabled\" >&nbsp;&gt;&gt;&nbsp;</span>";
        	}
        }
        return pageInfo + "&nbsp;" + prevText + "&nbsp;" + curPageInfo + "&nbsp;" + nextText;
    }

    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    public String getUri(String forwardUrl, Map<String, String[]> paramsMap) {
        boolean hasQuestionMark = false;
        if (forwardUrl.contains("?")) {
            hasQuestionMark = true;
        }
        String param = "";
        for (Iterator<String> iter = paramsMap.keySet().iterator(); iter.hasNext();) {
            String key = (String) iter.next();
            String value = ((String[]) paramsMap.get(key))[0];
            try {
                value = URLEncoder.encode(value, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (param.trim().length() == 0) {
                if (hasQuestionMark) {
                    param = "&" + key + "=" + value;
                } else {
                    param = "?" + key + "=" + value;
                }
            } else {
                param = param + "&" + key + "=" + value;
            }
        }
        if (StringUtils.isNotBlank(param)) {
            forwardUrl = forwardUrl + param;
        }
        return forwardUrl;
    }

    public String getPageParam() {
        return pageParam;
    }

    public void setPageParam(String pageParam) {
        this.pageParam = pageParam;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getForwardUrl() {
        return forwardUrl;
    }

    public void setForwardUrl(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
