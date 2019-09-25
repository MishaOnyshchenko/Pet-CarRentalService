package com.epam.rd.spring2019.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class HelloNameTag extends TagSupport {
    private String name;

    @Override
    public int doStartTag() throws JspException {
        try {
            if (name == null) {
                pageContext.getOut().write("Hello visitor!");
            } else {
                pageContext.getOut().write(name + ", you are welcome!");
            }
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

    @Override
    public void release() {
        super.release();
        this.name = "NoName";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}